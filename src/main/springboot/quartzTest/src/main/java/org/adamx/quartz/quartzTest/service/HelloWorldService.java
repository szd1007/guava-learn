/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.adamx.quartz.quartzTest.service;

import org.adamx.quartz.quartzTest.conf.DurationDataSizeConf;
import org.adamx.quartz.quartzTest.conf.MyTypSafeConfig;
import org.adamx.quartz.quartzTest.conf.YmlConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@PropertySource("classpath:custom.properties")
public class HelloWorldService {

	private final MyTypSafeConfig typSafeConfig;

	private final YmlConf ymlConf;

	private final DurationDataSizeConf durationConf;

	//使用数据库
//	@Autowired
//    private SfMapper sfMapper;

	@Value("${name:World}")
	private String name;

	@Value("${age:-1}")
	private Integer age;

	@Value("${my.uuid:-1}")
	private String uuid;

	@Value("${jdbc-url}")
    private String jdbcUrl;


    @Autowired
    public HelloWorldService(YmlConf ymlConf, MyTypSafeConfig typSafeConfig, DurationDataSizeConf durationConf) {
        this.ymlConf = ymlConf;
        this.typSafeConfig = typSafeConfig;
        this.durationConf = durationConf;
    }

    public String getHelloMessage() {
        System.out.println("typeSafeConfig " + typSafeConfig);
        System.out.println("ymlConf" + ymlConf);
        System.out.println("durationConf" + durationConf);
        return "Hello " + this.name + " age:" + age + " uuid:" + uuid + " jbcUrl: " + jdbcUrl;
    }

}
