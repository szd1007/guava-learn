package thecompletereferenc;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {

    @Test
    public void testReflection() throws Exception{
        Class<?> c = Class.forName("thecompletereferenc.ReB");
        System.out.println("Constructors:");
        Constructor<?> constructors[]  = c.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(" " + constructors[i]);
        }

        System.out.println("Fields: ");
        //公共成员
//        Field fields[] = c.getFields();
        Field fields[] = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(" " + fields[i]);
        }

        //获取父类
//        c.getSuperclass()
        System.out.println("Methods:");
        //公共方法
        Method methods[] = c.getMethods();
        //当前类都所有方法
         methods = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(" " + methods[i]);
        }

        //获取public方法
        for (int i = 0; i < methods.length; i++) {
            int modifiers = methods[i].getModifiers();
            if (Modifier.isPublic(modifiers)) {
                System.out.println("public :::" + methods[i].getName());
            }
        }
    }
}