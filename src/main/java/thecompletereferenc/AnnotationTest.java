package thecompletereferenc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-01 13:14
 */
public class AnnotationTest {

    //注解一个方法 annotate a method
    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth() {
        //.....
    }
}

//A simple annotation type.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {

    String str();

    int val();
}
