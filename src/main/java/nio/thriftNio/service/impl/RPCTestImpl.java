package nio.thriftNio.service.impl;

import nio.thriftNio.service.RPCTest;

/**
 * Created by zm on 2017/4/5.
 * rpc传递过来的接口名称，默认package路径，同时实现默认加上Impl后缀
 */
public class RPCTestImpl implements RPCTest{
    public int add(int a, int b) {
        System.out.println("rpc call from client:add("+a+","+b+")");
        return a+b;
    }
}
