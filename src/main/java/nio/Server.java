package nio;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by shangzhidong on 2017/3/24.
 */
public class Server {
    private BlockingQueue<Call> queue = new LinkedBlockingDeque<Call>();
    private Queue<Call> responseCalls = new ConcurrentLinkedQueue<>();


    volatile boolean running = true;
    private Responder responer = null;

    private static int NIO_BUFFER_LIMTI = 64 * 1024;
    private   int handler = 10;

    class Reader extends Thread {
        Selector readSelector;
        boolean adding;

        Reader(int i) throws IOException {
            setName("Reader-" + i);
            this.readSelector = Selector.open();
            System.out.println("Starting Reader-"+i+"...");
        }

        @Override
        public void run() {
            while (running) {
                try {
                    readSelector.select();/**接收来自client的read事件*/
                    while (adding) {
                        synchronized (this) {
                            this.wait(1000);
                        }

                    }
                    Iterator<SelectionKey> it = readSelector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();
                        if (key.isValid()) {
                            if (key.isReadable()) {
                                doRead(key);
                            }
                        }
                    }
                } catch (Exception e) {

                }
            }
        }

        public void doRead(SelectionKey selectionKey) {
            Connection c =(Connection)selectionKey.attachment();
            if (c == null) {
                return;
            }
            int n;
            try {
                n = c.readAndProcess();
            } catch (IOException e) {
                System.out.println(e);
                n = -1;
            } catch (Exception e) {
                System.out.println(e);
                n = -1;
            }
            if (n == -1) {
                c.close();
            }

        }
        public SelectionKey regitsterChannel(SocketChannel channel)throws IOException {
            return channel.register(readSelector, SelectionKey.OP_READ);
        }

        public void startAdd() {
            adding =true;
            readSelector.wakeup();
        }

        public synchronized void finishAdd() {
            adding = false;
            this.notify();
        }
    }
    /**一个监听类,处理所有的连接请求*/
    class Listener extends Thread {
        Selector selector;//1个selector用来处理accept请求
        Reader[] readers; //10个reader 处理读输入数据的请求 多个handler处理reader到的请求，包含具体的业务。最终一个writer进行数据回写
        int robin;
        int readNum;
        Listener(int port)throws  IOException{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port),150);
            selector = Selector.open();
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            readNum = 10;
            readers = new Reader[readNum];
            for (int i = 0; i < readNum; i++) {
                readers[i]= new Reader(i);
                readers[i].start();
            }
        }

        public void run() {
            while (running) {
                try {
                    selector.select();
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();
                        if (key.isValid()) {
                            if (key.isAcceptable()) {
                                doAccept(key);
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        public void doAccept(SelectionKey selectionKey)throws IOException{
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
            SocketChannel socketChannel;
            while ((socketChannel = serverSocketChannel.accept()) != null) {
                try {
                    socketChannel.configureBlocking(false);
                    socketChannel.socket().setTcpNoDelay(true);
                    socketChannel.socket().setKeepAlive(true);

                } catch (IOException e) {
                    System.out.println(e);
                }
                Reader reader = getReader();
                try{
                    reader.startAdd();
                    SelectionKey readKey = reader.regitsterChannel(socketChannel);/**让reader只接收来自客户端的read事件*/
                    Connection c = new Connection(socketChannel);
                    readKey.attach(c);
                }finally {
                    reader.finishAdd();
                }
            }
        }
        public Reader getReader() {
            if (robin >= Integer.MAX_VALUE - 100) {
                robin =0;
            }
            return readers[(robin++) % readNum];
        }


    }

    class Connection {
        private SocketChannel channel;
        private ByteBuffer dataBufferLength;
        private ByteBuffer dataBuffer;
        private boolean skipHeader;

        public Connection(SocketChannel channel) {
            this.channel = channel;
            this.dataBufferLength = ByteBuffer.allocate(4);
        }

        public int readAndProcess() throws IOException {
            int count;
            if (!skipHeader) { /**第一次读的时候读取的是这一帧的数据size*/
                count = channelRead(channel, dataBufferLength);
                if (count < 0 || dataBufferLength.remaining() > 0) {
                    return count;
                }
            }
            skipHeader = true;
            if (dataBuffer == null) {
                dataBufferLength.flip();//limit 赋值到currentPosition  position置0
                int dataLength = dataBufferLength.getInt();//读4个字节  这个是header信息
                dataBuffer = ByteBuffer.allocate(dataLength);
            }
            count = channelRead(channel, dataBuffer);/**读到了消息*/
            if (count >= 0 && dataBuffer.remaining() == 0) {
                process();
            }
            return count;
        }
        public void process() {
            dataBuffer.flip();
            byte[]data = dataBuffer.array();
            Call call = new Call(this, data, responer);/**包装成一个请求，此时读到了数据,*/
            try {
                queue.put(call);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        public void close()  {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Responder extends Thread {
        Selector writeSelector;
        public Responder()throws IOException {
            writeSelector = Selector.open();
        }

        public void run() {
            while (running) {
                try {
                    registerWriters();
                    int n = writeSelector.select(1000);
                    if (n == 0) {
                        continue;
                    }
                    Iterator<SelectionKey> it = writeSelector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();
                        if (key.isValid() && key.isWritable()) {
                            doAsyncWrite(key);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        public void registerWriters()throws IOException {
            Iterator<Call> it = responseCalls.iterator();
            while (it.hasNext()) {
                Call call = it.next();
                it.remove();
                SelectionKey key = call.conn.channel.keyFor(writeSelector);
                try {
                    if (key == null) {
                        call.conn.channel.register(writeSelector, SelectionKey.OP_WRITE, call);
                    } else {
                        key.interestOps(SelectionKey.OP_WRITE);
                    }
                } catch (Exception e) {
                    System.out.println("the client went away");
                }
            }
        }

        public void registerForWrite(Call call) {
            responseCalls.add(call);
            writeSelector.wakeup();
        }
        private void doAsyncWrite(SelectionKey key)throws IOException {
            Call call = (Call) key.attachment();
            if (call.conn.channel != key.channel()) {
                throw new IOException("bad channel");
            }
            int numBytes = channelWrite(call.conn.channel, call.respons);
            if (numBytes < 0 || call.respons.remaining() == 0) {
                try {
                    key.interestOps(0);//处理完毕了，更改key的事件
                } catch (Exception e) {
                    System.out.println("Exception while changing ops:"+e);
                }
            }
        }

        private void doResponse(Call call) throws IOException {
            //if data not fully send,then register the channel for asyn writer
            if (!processResponse(call)) {
                registerForWrite(call);/**超过一次写的限制后就要分开几次写，这时候程序向写程序注册写事件，
                 同时程序就返回了。这个时候就开始慢慢的写了，然后handler开始处理别的请求*/
            }
        }
        private boolean processResponse(Call call)throws IOException {
            boolean error = true;
            try{
                int numBytes = channelWrite(call.conn.channel,call.respons);
                if (numBytes < 0) {
                    throw new IOException("error socket write");
                }
            }finally {
                if (error) {
                    call.conn.close();
                }
            }
            if (!call.respons.hasRemaining()) {
                call.done =true;
                return true;
            }
            return false;
        }
    }

    class Handler extends Thread{
        public Handler(int i) {
            setName("handler-" + i);
            System.out.println("Starting handler-"+i +"...");

        }
        public void  run() {
            while (running) {
                try{
                    Call call = queue.take();/**reader从connection读取数据，完成call*/
                    process(call);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }catch (IOException e ){
                    e.printStackTrace();
                }
            }
        }
        public void process(Call call)throws IOException{
            byte[]request = call.request;
            String mess = new String(request);
            System.out.println("received message:"+mess);
            //each channel write 2MB data for test
            int dataLength = 2*1024*1024;
            ByteBuffer buffer = ByteBuffer.allocate(4+dataLength);
            buffer.putInt(dataLength);//header
            writeDataForTest(buffer);
            buffer.flip();
            //上面是回填数据，独享io通道 。需要时间。开了一个线程处理.到下面的时候就只涉及写了
            call.respons = buffer;
            responer.doResponse(call);
        }

        public void writeDataForTest(ByteBuffer buffer) {
            int n = buffer.limit()-4;
            for (int i = 0; i < n; i++) {
                buffer.put((byte)0);
            }
        }


    }

    public int channelRead(ReadableByteChannel channel, ByteBuffer buffer) throws IOException {
        return buffer.remaining() <= NIO_BUFFER_LIMTI ? channel.read(buffer) : channelIO(channel, null, buffer);

    }

    public int channelWrite(WritableByteChannel channel, ByteBuffer buffer) throws IOException {
        return buffer.remaining() <= NIO_BUFFER_LIMTI ? channel.write(buffer) : channelIO(null, channel, buffer);
    }

    public int channelIO(ReadableByteChannel readCh, WritableByteChannel writeCh, ByteBuffer buffer) throws IOException {
        int initRemain = buffer.remaining();
        int originalLimit = buffer.limit();
        int ret =0;
        try {
            while (buffer.remaining() > 0) {
                int ioSize = Math.min(buffer.remaining(), NIO_BUFFER_LIMTI);
                buffer.limit(buffer.position() + ioSize);
                ret = readCh == null ? writeCh.write(buffer) : readCh.read(buffer);
                if (ret < ioSize) {
                    break;
                }
            }

        }finally {
            buffer.limit(originalLimit);
        }
        int byteRead = initRemain -buffer.remaining();
        return byteRead>0?byteRead:ret;
    }

    class Call {
        Connection conn;
        byte[]request;
        Responder responer;
        ByteBuffer respons;
        boolean done;

        public Call(Connection conn, byte[] request, Responder responder) {
            this.conn = conn;
            this.request = request;
            this.responer = responder;
        }
    }
    public void startHandler()  {
        for (int i = 0; i < handler; i++) {
            new Handler(i).start();
        }
    }
    public void start() throws IOException {
        for (int i = 0; i < handler; i++) {
            new Listener(10000).start();
            responer = new Responder();
            responer.start();
            startHandler();
            System.out.println("Server startup !!!");
        }
    }

    public static void main(String[] args)throws IOException{
        Server server = new Server();
        server.start();
    }

}
