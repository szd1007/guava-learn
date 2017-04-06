package nio.thriftNio.client;

import nio.thriftNio.service.RPCTest;

import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Created by shangzhidong on 2017/4/6.
 * 客户端运行代码，调用rpc方法
 */
public class CallDemo {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        ProxyInstance proxyInstanceHandler = new ProxyInstance(client,"RPCTest");
        RPCTest test = (RPCTest) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{RPCTest.class},proxyInstanceHandler);
        System.out.println("call add method");
        int result = test.add(345 ,3);
        System.out.println(result);

    }
}
