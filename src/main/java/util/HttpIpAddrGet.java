package util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shangzhidong on 2017/9/19.
 */
public class HttpIpAddrGet {
    private static int HTTP_PORT = 9098;
    private static final String FILE_NAME = "ip.txt";
    public static void main(String[] args) throws IOException {
        if (args != null && args.length > 0) {
            HTTP_PORT = Integer.parseInt(args[0].trim());
        }
        ServerSocket socket = new ServerSocket(HTTP_PORT);
        System.out.println("Start socket listening on port " + HTTP_PORT);
        while (true) {
            Socket socket1 = socket.accept();
            String ip = socket1.getInetAddress().getHostName();
            System.out.println("accept from" + ip);
            FileUtil.writeContent(FILE_NAME, ip);
        }
    }
}
