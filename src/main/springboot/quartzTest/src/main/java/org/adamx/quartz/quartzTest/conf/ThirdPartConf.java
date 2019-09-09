package org.adamx.quartz.quartzTest.conf;

import javax.validation.constraints.NotNull;
import java.net.InetAddress;

/**
 * 当想要初始化第三方类的时候，可以使用@Bean
 * @author szd1007@github.com
 * @date 2018-12-11 21:10
 */
public class ThirdPartConf {
    private Long bigNumber;
    @NotNull
    private String uuid;
//    @NotNull
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
