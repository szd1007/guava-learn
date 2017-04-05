package nio.thriftNio.process;

import java.io.Serializable;

/**
 * Created by zm on 2017/4/4.
 */
public class RemoteResult implements Serializable{
    private boolean isSuccs=false;
    private Object object;

    public boolean isSuccs() {
        return isSuccs;
    }
    public RemoteResult(boolean isSuccs, Object o){
        this.isSuccs = isSuccs;
        this.object = o;
    }

    public void setIsSuccs(boolean isSuccs) {
        this.isSuccs = isSuccs;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
