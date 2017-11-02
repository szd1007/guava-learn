package designPattern.ChainofResponsibility.imply;

import designPattern.ChainofResponsibility.RequestObj;

/**
 * Created by shangzhidong on 2017/11/2.
 */
public class Test {
    public static void main(String[] args) {
        FinalProcess finalProcess = new FinalProcess();
        ProcessorB processorB = new ProcessorB(finalProcess);

        ProcessorA processorA = new ProcessorA(processorB);
        processorA.start();


        RequestObj requestObj  = new RequestObj();

        processorA.process(requestObj);
    }
}
