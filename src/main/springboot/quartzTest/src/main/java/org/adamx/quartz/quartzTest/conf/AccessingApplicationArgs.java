package org.adamx.quartz.quartzTest.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 23.7 Accessing Application Arguments
 * 读取run时提交的配置 args
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-14 20:43
 */
@Component
public class AccessingApplicationArgs {

    @Autowired
    @SuppressWarnings("all")
    public AccessingApplicationArgs(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        System.out.println(">>>> debug flag" + debug);

        System.out.println(">>>>" + files);

    }
}
