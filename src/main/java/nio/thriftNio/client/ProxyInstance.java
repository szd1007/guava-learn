package nio.thriftNio.client;

import nio.thriftNio.SerializeUtil;
import nio.thriftNio.process.RemoteReq;
import nio.thriftNio.process.RemoteResult;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by shangzhidong on 2017/4/6.
 */
public class ProxyInstance  implements InvocationHandler{

    private Client client;
    private String className;
    public ProxyInstance(Client client,String className){
        this.client = client;
        this.className = className;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println("call method from client:"+methodName);
        RemoteReq remoteReq = new RemoteReq();
        remoteReq.setClassName(className);
        remoteReq.setMethodName(methodName);
        remoteReq.setParas(args);
        client.send(SerializeUtil.serialize(remoteReq));
        byte []receive = client.receiveBlock(client);
        RemoteResult result = (RemoteResult) SerializeUtil.unserialize(receive);
        System.out.println("call finished :"+result);
        return result.getObject();

    }
}
