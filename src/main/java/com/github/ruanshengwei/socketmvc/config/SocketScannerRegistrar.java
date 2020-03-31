package com.github.ruanshengwei.socketmvc.config;

import com.github.ruanshengwei.socketmvc.annotation.SocketScan;
import com.github.ruanshengwei.socketmvc.util.ClassUtil;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

public class SocketScannerRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    public static List<Class<?>> socketBeanClissList =new LinkedList<Class<?>>();

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(SocketScan.class.getName()));
        String[] scanBasePackages = annoAttrs.getStringArray("value");
        try {
            for (String packages : scanBasePackages){
                for (Class clazz : ClassUtil.getClasses(packages)){
                    socketBeanClissList.add(clazz);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
