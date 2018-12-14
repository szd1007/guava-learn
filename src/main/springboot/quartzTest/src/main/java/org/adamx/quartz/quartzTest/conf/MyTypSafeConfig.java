package org.adamx.quartz.quartzTest.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.List;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-08 18:17
 */

@ConfigurationProperties("my.personal-conf")
@Configuration
//@PropertySource("classpath:custom.properties")
public class MyTypSafeConfig {

    private Long bigNumber;
    private List<String> uuid;
    private List<String> id;
    private InetAddress remoteAddress;

    public Long getBigNumber() {
        return bigNumber;
    }

    public void setBigNumber(Long bigNumber) {
        this.bigNumber = bigNumber;
    }

    public List<String> getUuid() {
        return uuid;
    }

    public void setUuid(List<String> uuid) {
        this.uuid = uuid;
    }

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }

    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(InetAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    public String toString() {
        return "MyTypSafeConfig{" + "bigNumber=" + bigNumber + ", uuid=" + uuid + ", id=" + id + ", remoteAddress=" + remoteAddress + '}';
    }
}
