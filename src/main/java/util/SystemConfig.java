package util;


import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shangzhidong on 2016/8/5.
 * 促销jmq处理的相关配置
 */
public class SystemConfig {
    private static final Logger log = Logger.getLogger(SystemConfig.class);



    //促销jmq生产topic相关配置
    public static String jmq_producer_topic;
    public static String jmq_producer_app_name;
    public static String jmq_producer_user;
    public static String jmq_producer_password;
    public static String jmq_producer_broker_address;
    public static Integer jmq_producer_sendtimeout;

    public static Integer sendBatch;

    //导数监控
    public static String data_type;
    public static String job_name;

    static {
        InputStream in = null;
        Properties p = new Properties();

        try {
            in = SystemConfig.class.getClassLoader().getResourceAsStream("conf.properties");
            p.load(in);


            jmq_producer_topic = p.getProperty("jmq_producer_topic");
            jmq_producer_app_name = p.getProperty("jmq_producer_app_name");
            jmq_producer_user = p.getProperty("jmq_producer_user");
            jmq_producer_password = p.getProperty("jmq_producer_password");
            jmq_producer_broker_address = p.getProperty("jmq_producer_broker_address");
            jmq_producer_sendtimeout = Integer.valueOf(p.getProperty("jmq_producer_sendtimeout", "5000"));
            sendBatch = Integer.valueOf(p.getProperty("jmq_producer_sendbatch", "1000"));
            data_type = p.getProperty("data_type");
            job_name = p.getProperty("job_name");
        } catch (Exception e) {
            log.error("read config files error ",e);
        }

    }


}
