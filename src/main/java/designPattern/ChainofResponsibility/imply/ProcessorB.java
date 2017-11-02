package designPattern.ChainofResponsibility.imply;

import designPattern.ChainofResponsibility.ProcessHandler;
import designPattern.ChainofResponsibility.RequestObj;

/**
 * Created by shangzhidong on 2017/11/2.
 */
public class ProcessorB implements ProcessHandler {
    ProcessHandler nextProcessor;
    public ProcessorB(ProcessHandler nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
    public void process(RequestObj request) throws ProcessRequestException {
        System.out.println("b process");
        nextProcessor.process(request);
    }

    public void shutdown() {
        nextProcessor.shutdown();
    }
}
