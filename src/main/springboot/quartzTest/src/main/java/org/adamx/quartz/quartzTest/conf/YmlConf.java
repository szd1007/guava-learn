package org.adamx.quartz.quartzTest.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * //todo 暂时未生效
 * #自定义文件加载 https://blog.csdn.net/luckyrocks/article/details/79248016

 * @author szd1007@github.com
 * @date 2018-12-10 12:19
 */
@ConfigurationProperties("xx")
//@PropertySource("classpath:data.yml")
@Configuration
public class YmlConf {
    private List<String> servers = new ArrayList<>();

    public List<String> getServers() {
        return this.servers;
    }

    @Override
    public String toString() {
        return "YmlConf{" + "servers=" + servers + '}';
    }
}
