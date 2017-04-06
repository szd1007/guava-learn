package nio.thriftNio.service.clientStub;

import nio.thriftNio.service.RPCTest;

/**
 * Created by shangzhidong on 2017/4/6.
 */
public class RpcTestStub implements RPCTest{

    /**可以自动生成，在client端使用，主要是为了获取参数*/
    public int add(int a, int b) {
        System.out.println("do nothing");
        return 0;
    }
}
