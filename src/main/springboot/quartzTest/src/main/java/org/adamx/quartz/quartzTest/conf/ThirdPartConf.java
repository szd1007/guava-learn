package org.adamx.quartz.quartzTest.conf;

import java.net.InetAddress;

/**
 * 当想要初始化第三方类的时候，可以使用@Bean
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-11 21:10
 */
public class ThirdPartConf {
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
        return "ThirdPartConf{" + "bigNumber=" + bigNumber + ", uuid='" + uuid + '\'' + ", remoteAddress=" + remoteAddress + '}';
    }
}
