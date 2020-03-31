package com.github.ruanshengwei.socketmvc.config;

import com.github.ruanshengwei.socketmvc.annotation.SocketMapping;
import com.github.ruanshengwei.socketmvc.util.ApplicationContextUtil;
import com.github.ruanshengwei.socketmvc.annotation.SocketController;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Method;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */
public class SocketBeanRegistrar {

    public static void initSocketBean() {
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) ApplicationContextUtil.getApplicationContext();

        for (Class clazz : SocketScannerRegistrar.socketBeanClissList){
            SocketController controller = (SocketController) clazz.getAnnotation(SocketController.class);
            if (controller!=null){
                SocketMapping mapping = (SocketMapping) clazz.getAnnotation(SocketMapping.class);
                String path = mapping.path();
                Method[] clazzMethods = clazz.getMethods();
                for (Method method : clazzMethods){
                    SocketMapping socketMapping = method.getAnnotation(SocketMapping.class);
                    if (socketMapping!=null){
                        String methodPath = socketMapping.path();
                        SocketDispatcher.methodMap.put(path+methodPath,method);
                        SocketDispatcher.beanMap.put(path+methodPath, configurableApplicationContext.getBean(clazz));
                    }
                }
            }
        }

    }
}
