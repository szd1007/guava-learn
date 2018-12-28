package thecompletereferenc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-27 13:32
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        System.out.println(">>>>>>>>>>>>");
        address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);
        System.out.println(">>>>>>>>>>>>");


        for (InetAddress address1 : InetAddress.getAllByName("www.baidu.com")) {
            System.out.println(address1);
        }
        System.out.println(">>");
        System.out.println(address.getHostName());
    }

}
