package designPattern.ChainofResponsibility.imply;

import designPattern.ChainofResponsibility.ProcessHandler;
import designPattern.ChainofResponsibility.RequestObj;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shangzhidong on 2017/11/2.
 */
public class ProcessorA extends Thread implements ProcessHandler {

    LinkedBlockingQueue<RequestObj> taskList = new LinkedBlockingQueue<RequestObj>();
    ProcessHandler nextProcessor ;
    public ProcessorA(ProcessHandler nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
    public void process(RequestObj request) {
        System.out.println("a process");
        taskList.add(request);
    }

    @Override
    public void run() {
        while (true) {
            try {
                RequestObj request = taskList.take();
                //todo  process


                nextProcessor.process(request);

            } catch (ProcessRequestException e) {
                e.printStackTrace();
            } catch (Exception e) {

            }
        }
    }

    public void shutdown() {
        System.out.println("processA shutdown");
        nextProcessor.shutdown();
    }
}
