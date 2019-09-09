package thecompletereferenc;

import org.junit.Test;

import javax.net.SocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author szd1007@github.com
 * @date 2018-12-28 09:37
 */
public class TCPiPTest {

    @Test
    public void testWhoIs() {
        int c;
        //todo 两种方式的差异?????，rpc框架使用本地socket连接远端
        //Create a socket connected to internic.net port 43.
        //直接连接到远程的socket，不是本地创建一个然后connect远端server
//        try (Socket s = new Socket("whois.internic.net", 43)) {
        try (Socket s = SocketFactory.getDefault().createSocket()) {
            InetSocketAddress server = new InetSocketAddress("whois.internic.net", 43);
            s.connect(server);
            //Obtain input and output streams.
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            //Construct a request string.
            String str = "OraclePressBooks.com";
            byte buf[] = str.getBytes();

            //Send request
            out.write(buf);

            //Read an display response.
            while ((c = in.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Obtain input and output streams.

    }

    @Test
    public void testHttpGet() {
        int c;
        try (Socket s = new Socket("www.baidu.com", 80)) {
//            try (Socket s = SocketFactory.getDefault().createSocket()) {
//                InetSocketAddress server = new InetSocketAddress("www.baidu.com", 80);
//            s.connect(server);
            //Obtain input and output streams.
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            //Construct a request string.
            String str = "GET /index.html HTTP/1.1\r\nHost:www.baidu.com\r\n\r\n";
            byte buf[] = str.getBytes();

            //Send request
            out.write(buf);

            //Read an display response.
            //假定每个byte可以代表一个字符。（中文是两个字节代表一个字符。使用这种方式会乱码)
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Obtain input and output streams.

    }


}
