package nio.thriftNio.client;

import nio.thriftNio.service.RPCTest;
import nio.thriftNio.service.clientStub.RpcTestStub;

import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Created by shangzhidong on 2017/4/6.
 * 客户端运行代码，调用rpc方法
 */
public class CallDemo {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        RPCTest rpcTestInterface = new RpcTestStub();
        ProxyInstance proxyInstanceHandler = new ProxyInstance(client,"RPCTest");
        RPCTest test = (RPCTest) Proxy.newProxyInstance(rpcTestInterface.getClass().getClassLoader(),
                rpcTestInterface.getClass().getInterfaces(),proxyInstanceHandler);
        System.out.println("call add method");
        int result = test.add(345 ,3);
        System.out.println(result);

    }
}
