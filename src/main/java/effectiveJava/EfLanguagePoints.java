package effectiveJava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.EnumSet;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;


/**
 * java掌握知识点
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
public @interface EfLanguagePoints {
    String[] value() default "";
    Class[] values() default Object.class;
}
