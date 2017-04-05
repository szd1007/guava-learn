package nio.thriftNio.process;

/**
 * Created by zm on 2017/4/4.
 *
 */
public  abstract class TProcessor {

    public  abstract RemoteResult process(RemoteReqeust remoteReqeust)throws IllegalArgumentException;

}
