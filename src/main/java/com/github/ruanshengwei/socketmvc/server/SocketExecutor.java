package com.github.ruanshengwei.socketmvc.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

public class SocketExecutor {

       public static BlockingQueue blockingQueue=new ArrayBlockingQueue<>(10);

       public static ThreadPoolExecutor socketPool = new ThreadPoolExecutor(5,20,20, TimeUnit.SECONDS,blockingQueue);

}
