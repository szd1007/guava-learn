package org.adamx.quartz.quartzTest.controller;

import org.adamx.quartz.quartzTest.entity.User;
import org.adamx.quartz.quartzTest.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-10 14:55
 */
@RestController
public class ControllerDemo {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    public String test(String name) {
        return "hello " + name + "||" + helloWorldService.getHelloMessage();
    }

    /**
     * 直接返回对象就ok 不需要手动转gson
     * @return
     */
    @RequestMapping("/info")
    public User getInfo() {
        return new User("adam", 22);
    }
}

