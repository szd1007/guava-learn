package org.adamx.quartz.quartzTest.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author szd1007@github.com
 * @date 2018-12-20 16:19
 */
@ConfigurationProperties("system")
@Configuration
@Validated
public class DurationDataSizeConf {

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sessionTimeout;

    @NotNull
    private Duration readTimeout;

//    private DataSize bufferSize;


    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public Duration getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    @Override
    public String toString() {
        return "DurationConf{" + "sessionTimeout=" + sessionTimeout.toMillis() + "ms, readTimeout=" + readTimeout.toMillis() + "ms}";
    }

}
