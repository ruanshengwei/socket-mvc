package com.github.ruanshengwei.socketmvc.server;

import java.io.OutputStream;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

public class SendMessageTask extends Thread {

    public OutputStream outputStream;

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run(){
        System.out.println("begin SendMessageTask");
//        for (int i=0;i<99;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                outputStream.write("successful".getBytes("UTF-8"));
//                outputStream.flush();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

}
