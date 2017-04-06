package nio.thriftNio.client;



import nio.thriftNio.service.RPCTest;

import javax.net.SocketFactory;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by shangzhidong on 2017/3/24.
 *
 */
public class Client {
    Socket socket;
    OutputStream out;
    InputStream in;

    public Client() throws IOException {
        socket = SocketFactory.getDefault().createSocket();
        socket.setTcpNoDelay(true);
        socket.setKeepAlive(true);
        InetSocketAddress server = new InetSocketAddress("localhost", 8888);
        socket.connect(server, 8888);
        out = socket.getOutputStream();
        in = socket.getInputStream();
    }


    public void send(String message) throws IOException {
        byte[] data = message.getBytes();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(data.length);
        dos.write(data);
        out.flush();
    }

    public void send(byte []data) throws IOException {

        System.out.println("send bytes :"+data.length);
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(data.length);
        dos.write(data);
        out.flush();

    }
    /**阻塞等待方法调用返回*/
    public byte[] receiveBlock(Client client) throws IOException {
        System.out.println("receive response block...");
        DataInputStream inputStream = new DataInputStream(client.in);
        int dataLength = inputStream.readInt();
        byte[] receive = new byte[dataLength];
        inputStream.readFully(receive);
        System.out.println("receive size:"+receive.length);
        return  receive;
    }



}
