package designPattern.ChainofResponsibility;

/**
 * Created by shangzhidong on 2017/11/2.
 * 责任链模式
 */
public interface ProcessHandler {

    /**
     * 具体的处理逻辑
     * @param request
     */
    void process(RequestObj request) throws ProcessRequestException;

    /**
     * 停止操作，如果每个processor都维护一个自己的线程池的话，需要销毁线程池,
     * 同时如果processor中包含线程池的话，创建之后自己要start
     */
    void shutdown();

    public static class ProcessRequestException extends Exception {
        public ProcessRequestException(String  msg, Throwable t) {
            super(msg, t);
        }
    }
}
