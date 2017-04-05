package nio.thriftNio.process;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zm on 2017/4/4.
 *  rpc传递的参数
 */
public class RemoteReqeust  implements Serializable{
    private String className;
    private String methodName;
    private List<Para> paraList;

    public String getClassName() {
        return className;
    }

    public List<Para> getParaList() {
        return paraList;
    }

    public void setParaList(List<Para> paraList) {
        this.paraList = paraList;
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

    public static class Para implements Comparable<Para>{
       private int id=-1;
       private  PARATYPE type;
        private int intValue;
        private long LongValue;
        private String StringValue;
       private byte[]vlaue;//每个参数都会传递
       private String objName;//自定义对象类的全路径

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public long getLongValue() {
            return LongValue;
        }

        public void setLongValue(long longValue) {
            LongValue = longValue;
        }

        public String getStringValue() {
            return StringValue;
        }

        public void setStringValue(String stringValue) {
            StringValue = stringValue;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PARATYPE getType() {
            return type;
        }

        public void setType(PARATYPE type) {
            this.type = type;
        }

        public byte[] getVlaue() {
            return vlaue;
        }

        public int compareTo(Para o) {
            return id-o.getId();
        }

        public void setVlaue(byte[] vlaue) {
            this.vlaue = vlaue;
        }

        public String getObjName() {
            return objName;
        }

        public void setObjName(String objName) {
            this.objName = objName;
        }


    }

    public enum PARATYPE{
        INT,
        LONG,
        STRING,
        OBJECT
    }

}
