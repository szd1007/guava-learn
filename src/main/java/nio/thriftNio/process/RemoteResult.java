package nio.thriftNio.process;

import java.io.Serializable;

/**
 * Created by zm on 2017/4/4.
 */
public class RemoteResult implements Serializable{
    private static final long serialVersionUID =4444876593439181431L;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RemoteResult{");
        sb.append("isSuccs=").append(isSuccs);
        sb.append('}');
        return sb.toString();
    }
}
