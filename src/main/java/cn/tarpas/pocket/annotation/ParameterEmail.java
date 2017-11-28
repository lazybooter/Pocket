package cn.tarpas.pocket.annotation;


import java.lang.annotation.*;

/**
 * @author leaflyhuang on 2015/11/16.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface ParameterEmail {
}
