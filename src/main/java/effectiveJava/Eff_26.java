package effectiveJava;

import com.google.common.collect.Lists;
import proxyCache.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 26. 不要使用原生态类型[兼容原有代码而存在| 移植兼容性]
 * @see thecompletereferenc.GenericTest
 */
public class Eff_26<T extends Eff_26.Parent> {

    @EfLanguagePoints("还有通配符的用法，只能的参数引用时使用")
    public static void main(String[] args) {
        List<String> objectsString = Lists.newArrayList();
        objectsString.add("sss");
        //直接添加出错,与unsafeAdd 使用原型类型不同
        //objects.add(new Object());
        unsafeAdd(objectsString,0L);
        List<Parent> parents =  Lists.newArrayList();
        parents.add(new Parent());
        parents.add(new Child());

        //..........................
        Eff_26<Child> e1 = new Eff_26<>();
        //只能是确定的类型，在生明时就已经指定
       // e1.test2(new Parent());

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        elementsInCommon(set1,set2);
    }
    @EfLanguagePoints("参数使用了原生类型，导致类型判断失效，程序编译仅仅是抛出unchecekd 异常，")
    private static void unsafeAdd(List objects, Long lo) {
        objects.add(lo);
    }
    //通配符使用
    @EfLanguagePoints(" 通配符表示的某种未知对象的一种集合，而lo是一个具体的Object类型，类型不匹配")
    private static void unsafeAdd2(List<?> objects, Object lo) {
//        objects.add(lo);
    }

    //使用通配符demo
    private static void elementsInCommon(Set<?> set1, Set<?> set2) {
        int result=0;
        for (Object x : set1) {
            if (set2.contains(x)) {
                result++;
            }
        }

        System.out.println(result);
    }



    public void test2(T obj) {
        List<T> list = Lists.newArrayList();
        list.add(obj);
    }

    static class Parent{}
    static class Child extends Parent{}
}
