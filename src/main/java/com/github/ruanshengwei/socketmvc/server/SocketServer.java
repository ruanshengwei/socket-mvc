package com.github.ruanshengwei.socketmvc.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

public class SocketServer {

    public static void start(int serverPort)throws Exception{

        // 监听指定的端口
        int port = serverPort;
        ServerSocket server = new ServerSocket(port);
        // server将一直等待连接的到来
        System.out.println("SocketMVC-server将一直等待连接的到来:"+serverPort);

        while (true) {
            final Socket socket = server.accept();
            SocketExecutor.socketPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        new SocketTask().run(socket);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

