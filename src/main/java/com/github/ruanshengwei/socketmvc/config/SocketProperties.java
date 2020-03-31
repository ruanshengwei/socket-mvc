package com.github.ruanshengwei.socketmvc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

@ConfigurationProperties(prefix = SocketProperties.SOCKET_PREFIX)
public class SocketProperties {

    public static final String SOCKET_PREFIX = "socket";

    /**
     * Socket serverPort
     */
    private int serverPort;

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
}
