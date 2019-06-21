package effectiveJava;

import designPattern.chp3_createional_patterns.aSingleton35;
import thecompletereferenc.EnumDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.time.Instant;

import static thecompletereferenc.EnumDemo.A;
import static thecompletereferenc.EnumDemo.B;
import static thecompletereferenc.EnumDemo.C;

/**
 * 1. 用静态工厂方法替代构造器[static factory method] 类似抽象工厂，但是不用专门搞一个类来做这件事
 *
 * 优点：
 *  -有名称含义
 *  -不用每次调用必须创建新对象
 *  -返回子类对象或接口实现。同时这个具体的类不用对外暴露！
 *  -可以有静态工厂的参数动态决定要返回的对象【enumSet底层又RegularEnumSet和jumboEnumSet两个包私有类，对client不可见。通过
 *    个数是否大于64进行选择。 包级私有方便jdk后续升级，不影响调用方】
 *  -方法返回所属对象的类，可以当时不存在。【只认接口，子类也可以】
 *
 * 缺点：
 *  -不包含构造器会使其不能子类化【正好鼓励使用组合不用继承😒】
 *  -程序员很难发现这些方法
 */
@LanguagePoints(values = {ServiceLoader.class})
@SuppressWarnings("all")
public class Eff_1 {

    public Eff_1() throws IOException {
    }

    public static Boolean valueOf(boolean b) {
        return b? Boolean.TRUE: Boolean.FALSE;
    }

    /**
     * 静态工厂方法一些常用的命名规则
     */
    @LanguagePoints(" from 类型转换方法   单个参数")
    Date d = Date.from(Instant.now());

    @LanguagePoints("of 聚合方法， 多个参数。返回一个类实例，并把他们结合起来")
    Set<EnumDemo> sets = EnumSet.of(A, B, C);

    @LanguagePoints("valueOf 比from和of更反锁的一种替代方法")
    BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);

    @LanguagePoints("instance 或getInstance  可以方法带参数实现")
    aSingleton35 aSingleton = aSingleton35.instance();

    @LanguagePoints("create 或 newInstance 确保每次都生成新对象")
    Object array = Array.newInstance(BigInteger.class, 20);

    @LanguagePoints("getXXX ")
    FileStore fs = Files.getFileStore(Paths.get("/"));

    @LanguagePoints("newXXX")
    BufferedReader br = Files.newBufferedReader(Paths.get("/"));

    @LanguagePoints("type -  getXXX newType 的简版")
    List<Integer> list = Collections.list(null);
}
