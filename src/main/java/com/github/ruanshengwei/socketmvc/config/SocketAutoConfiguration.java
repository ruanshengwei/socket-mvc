package com.github.ruanshengwei.socketmvc.config;

import com.github.ruanshengwei.socketmvc.server.SocketServer;
import com.github.ruanshengwei.socketmvc.util.ApplicationContextUtil;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

@Configuration
@EnableConfigurationProperties(SocketProperties.class)
public class SocketAutoConfiguration {

    public static SocketDispatcher dispatcherSocket;
    private SocketProperties properties;

    public SocketAutoConfiguration(SocketProperties socketProperties, ConfigurableApplicationContext configurableApplicationContext) {

        try {
            properties = socketProperties;
            ApplicationContextUtil.setApplicationContext(configurableApplicationContext);
            initSockeBean();
            Thread beginThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        SocketServer.start(properties.getServerPort());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            beginThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private void initSockeBean() {

        SocketBeanRegistrar.initSocketBean();

    }

    @Bean
    public SocketDispatcher dispatcherSocket(){
        dispatcherSocket=new SocketDispatcher();
        return dispatcherSocket;
    }

    @Bean
    public SocketBeanRegistrar socketBeanRegistrar(){
        return new SocketBeanRegistrar();
    }

}
