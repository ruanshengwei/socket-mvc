package com.github.ruanshengwei.socketmvc.server;

import com.alibaba.fastjson.JSONObject;

import com.github.ruanshengwei.socketmvc.config.SocketDispatcher;
import com.github.ruanshengwei.socketmvc.config.SocketAutoConfiguration;
import com.github.ruanshengwei.socketmvc.support.RequestBody;

import java.io.InputStream;
import java.net.Socket;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

public class SocketTask {

    public static SocketDispatcher dispatcherSocket  = SocketAutoConfiguration.dispatcherSocket;

    public void run(final Socket socket) throws Exception{
        System.out.println("begin Task");
        InputStream inputStream = socket.getInputStream();

        SendMessageTask sendMessageTask= new SendMessageTask();
        sendMessageTask.outputStream = socket.getOutputStream();
        sendMessageTask.start();

        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }

        RequestBody requstBody = JSONObject.parseObject(sb.toString(), RequestBody.class);
        Object ret=new Object();
        ret = dispatcherSocket.dispatcher(requstBody);
        System.out.println(ret.toString());

        socket.getOutputStream().write(ret.toString().getBytes("UTF-8"));
        socket.close();
    }

}
