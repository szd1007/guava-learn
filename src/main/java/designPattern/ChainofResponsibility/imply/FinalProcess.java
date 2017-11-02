package designPattern.ChainofResponsibility.imply;

import designPattern.ChainofResponsibility.ProcessHandler;
import designPattern.ChainofResponsibility.RequestObj;

/**
 * Created by shangzhidong on 2017/11/2.
 */
public class FinalProcess implements ProcessHandler{

    public void process(RequestObj request) throws ProcessRequestException {
        System.out.println("final process");
    }

    public void shutdown() {
        System.out.println("shutdown final");
    }
}
