package effectiveJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 使类和成员的可访问性最小化[对象封装 | 迪米特原则]

 */
public class Eff_15 {

    /**
     * 数组引用，导致内部数据可更改。
     */
    public static final Object[] VALUES = {null};

    /**
     * 返回一个不可修改的list封装，防止数据被篡改
     */
    public static final List<Object> VALUES_SAFE = Collections.unmodifiableList(Arrays.asList(VALUES));

    /**
     * 另外一种方法，使数组变成私有
     */
    public static Object[] values() {
        return VALUES.clone();
    }

}
