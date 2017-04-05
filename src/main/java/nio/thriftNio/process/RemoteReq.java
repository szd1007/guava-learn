package nio.thriftNio.process;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zm on 2017/4/4.
 *  rpc传递的参数
 */
public class RemoteReq implements Serializable{
    private String className;
    private String methodName;
    private Object[] paras;/**传递的参数对象*/

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParas() {
        return paras;
    }

    public void setParas(Object[] paras) {
        this.paras = paras;
    }
}
