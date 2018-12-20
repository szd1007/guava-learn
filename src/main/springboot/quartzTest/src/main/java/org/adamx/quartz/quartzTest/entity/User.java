package org.adamx.quartz.quartzTest.entity;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-20 21:52
 */
public class User {

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
