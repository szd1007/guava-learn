package thecompletereferenc;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-01 13:14
 */
public class AnnotationTest {

    //注解一个方法 annotate a method
    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth() {
        AnnotationTest test = new AnnotationTest();

        //obtain the annotation for this method
        //and display the value of the memebers.
        try {
            //First, get a class object that represents this class
            Class<?> c = test.getClass();
//            Class<?> c = test.getClass();
            //Now, get a Method object that represents this method
            Method m = c.getMethod("myMeth");
            //Next, get the annotation for this class.
            MyAnno anno = m.getAnnotation(MyAnno.class);
            for (Annotation annotation : c.getAnnotations()) {
                System.out.println("--"+annotation);
            }
            //Finally, display the values.
            System.out.println(anno.str() + " " + anno.val());

            System.out.println("+++++++++++++++++++++");
            //int.class 和 Integer.class 不是一个
//            m = c.getMethod("prameterTest",  new Class[]{int.class});
            m = c.getMethod("prameterTest",  int.class);
//            m = c.getMethod("prameterTest",  new Class[]{Integer.class});
            for (Annotation[] annotation : m.getParameterAnnotations()) {
                System.out.println("获取数组");
                System.out.println("--"+annotation[0]);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method not Found.");
        }
    }
    //有一个成员是value字段，其他字段有默认值。  value字段使用可以不用指定名称
    @SingleAn("sdfsd")
    public static void main(String[] args) {
        new AnnotationTest().thisTest();
        myMeth();

        //本地变量
        @MyAnno
        int a;
    }

    public void prameterTest(@MyAnno int a) {
        System.out.println(a);
    }
    private void thisTest( AnnotationTest this) {
        System.out.println("xxx");
    }
}

//A simple annotation type.
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.LOCAL_VARIABLE,ElementType.PARAMETER}) //数组
@interface MyAnno {

    String str() default "";

    // 默认值， 不显示指定的话就是这个值
    int val() default -1;
}

//single member
@Retention(RetentionPolicy.RUNTIME)
@interface SingleAn {
    String value() default "111";
    int bbb() default 1;
}
