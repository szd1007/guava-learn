package lambda;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {
        List<String> langs = Lists.newArrayList("Java", "Scala", "C", "Lisp");
        System.out.println(" start with J");
        filter(langs, str -> str.startsWith("J"));//predicate里只有一个接口方法  test 入参T 返回boolean

    }

    private static void filter(List<String> names, Predicate<String> condition) {
        Preconditions.checkNotNull(names);
        names.forEach(name->{
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        });
    }

}
