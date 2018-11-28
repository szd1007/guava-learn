package util;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shangzhidong on 2016/8/10.
 */
public class TimeUtil {
    private static final Logger logger = Logger.getLogger(TimeUtil.class);
    /**
     * 为每个线程创建一个局部变量副本，解决多线程调用问题
     */
    private static ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Long getTime(String time){
        Long timestamp = -1L;
        try {
            timestamp = sdf.get().parse(time.trim()).getTime();
        } catch (Exception e) {
            logger.error("parseTimeError:"+time);
            e.printStackTrace();

        }
        return timestamp;
    }
    public static String getTime(){
        String times =null;
        try {
            times = sdf.get().format(new Date());
        } catch (Exception e) {
            logger.error("parseTimeError:"+times);
            e.printStackTrace();

        }
        return times;
    }
    public static String getTime(long timestamps){
        String times =null;
        try {
            times = sdf.get().format(new Date(timestamps));
        } catch (Exception e) {
            logger.error("parseTimeError:"+times);
            e.printStackTrace();

        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(getTime());
    }
}
