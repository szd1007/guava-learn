package nio.thriftNio;

/**
 * Created by zm on 2017/4/5.
 */import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class SerializeUtil {
    public static final String TAG = "SerializeUtil";

    /**
     * 序列化
     *
     * @param object
     * @return
     * @throws IOException
     */
    public static byte[] serialize(Object object) throws IOException {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static byte[] getFrameObjBuffer(ByteBuffer buffer){
        byte[]frameBuffer = buffer.array();
        byte[]objectBuffer = new byte[frameBuffer.length-4];
        System.arraycopy(frameBuffer,4,objectBuffer,0,objectBuffer.length);
        return objectBuffer;
    }
    public static ByteBuffer getFrameByteBuffer(byte []obj){
        byte []frameBuffer = new byte[obj.length+4];
        /**对象最前面写入这个对象的大小*/
        intToBytes(obj.length,frameBuffer);
        System.arraycopy(obj,0,frameBuffer,4,obj.length);
        return ByteBuffer.wrap(frameBuffer);
    }

    public static byte[]intToBytes(int i32,byte[]inoutTemp){
        inoutTemp[0] = (byte)(0xff & (i32 >> 24));
        inoutTemp[1] = (byte)(0xff & (i32 >> 16));
        inoutTemp[2] = (byte)(0xff & (i32 >> 8));
        inoutTemp[3] = (byte)(0xff & (i32));
        return inoutTemp;
    }
}
