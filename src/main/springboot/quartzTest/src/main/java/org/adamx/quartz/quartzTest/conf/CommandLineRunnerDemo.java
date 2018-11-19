package org.adamx.quartz.quartzTest.conf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner or CommandLineRunner
 * 在SpringApplication 启动之后并且执行完run方法， 会运行这个接口实现类.
 * 多个实现如果要实现顺序执行
 * implement the org.springframework.core.Ordered interface or
 * use the org.springframework.core.annotation.Order annotation.
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-19 20:22
 */
@Component
@Order(1)
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunnerDemo run  after SpringApplication has started");
        System.out.println("CommandLineRunnerDemo run ^_^");

    }
}
