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

import org.adamx.quartz.quartzTest.conf.MyTypSafeConfig;
import org.adamx.quartz.quartzTest.conf.YmlConf;
import org.adamx.quartz.quartzTest.mapper.SfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:custom.properties")
public class HelloWorldService {

	@Autowired
	private MyTypSafeConfig typSafeConfig;

	@Autowired
    private YmlConf ymlConf;

	//使用数据库
//	@Autowired
//    private SfMapper sfMapper;

	@Value("${name:World}")
	private String name;

	@Value("${age:-1}")
	private Integer age;

	@Value("${my.uuid:-1}")
	private String uuid;

	public String getHelloMessage() {
        System.out.println("typeSafeConfig " + typSafeConfig);
        System.out.println("ymlConf" + ymlConf);
        return "Hello " + this.name + " age:" + age + " uuid:"+uuid;
	}

}
