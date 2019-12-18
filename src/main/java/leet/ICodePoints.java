package leet;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 需要掌握的算法
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
@Repeatable(ICodePointsContainer.class)
public @interface ICodePoints {
    String[] value() default "";
    Class[] values() default Object.class;
}

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
@interface ICodePointsContainer {
    ICodePoints[] value() ;
}