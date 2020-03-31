package com.github.ruanshengwei.socketmvc.annotation;

import com.github.ruanshengwei.socketmvc.config.SocketScannerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SocketScannerRegistrar.class)
public @interface SocketScan {

    String[] value() default {};
}
