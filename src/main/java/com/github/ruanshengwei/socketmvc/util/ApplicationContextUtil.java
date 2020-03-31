package com.github.ruanshengwei.socketmvc.util;

import org.springframework.context.ApplicationContext;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

public class ApplicationContextUtil {

    private static ApplicationContext applicationContext;


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;
    }
}
