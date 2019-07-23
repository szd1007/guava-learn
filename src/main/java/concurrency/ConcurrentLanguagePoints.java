package concurrency;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


/**
 * java掌握知识点
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
@Repeatable(ConcurrentLanguagePointsContainer.class)
public @interface ConcurrentLanguagePoints {
    String[] value() default "";
    Class[] values() default Object.class;
}

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
@interface ConcurrentLanguagePointsContainer {
    ConcurrentLanguagePoints[] value() ;
}