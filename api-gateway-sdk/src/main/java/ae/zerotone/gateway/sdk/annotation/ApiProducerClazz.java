package ae.zerotone.gateway.sdk.annotation;


import java.lang.annotation.*;

/**
 * @description 网关API生产者自定义注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ApiProducerClazz {

    /** 接口名称 */
    String interfaceName() default "";

    /** 接口版本 */
    String interfaceVersion() default "";
}
