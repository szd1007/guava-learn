package org.adamx.quartz.quartzTest.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.InetAddress;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-08 18:17
 */

@ConfigurationProperties("my.conf")
@Configuration
@PropertySource("classpath:custom.properties")
public class MyTypSafeConfig {

    private Long bigNumber;
    private String uuid;
    private InetAddress remoteAddress;

    public Long getBigNumber() {
        return bigNumber;
    }

    public void setBigNumber(Long bigNumber) {
        this.bigNumber = bigNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(InetAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    public String toString() {
        return "MyTypSafeConfig{" + "bigNumber=" + bigNumber + ", uuid='" + uuid + '\'' + ", remoteAddress=" + remoteAddress + '}';
    }
}
