package com.github.ruanshengwei.socketmvc.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME )
@Component
public @interface SocketController{

    String path() default "";

}
