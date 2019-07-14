package effectiveJava;

import java.lang.annotation.*;
import java.util.EnumSet;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;


/**
 * java掌握知识点
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
@Repeatable(EfLanguagePointsContainer.class)
public @interface EfLanguagePoints {
    String[] value() default "";
    Class[] values() default Object.class;
}
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
@interface EfLanguagePointsContainer {
    EfLanguagePoints[] value() ;
}