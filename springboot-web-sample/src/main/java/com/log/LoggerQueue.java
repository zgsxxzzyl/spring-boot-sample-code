package com.log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LoggerQueue {
    //队列大小
    public static final int QUEUE_MAX_SIZE = 1;
    private static LoggerQueue alarmMessageQueue;
    //阻塞队列
    private BlockingQueue<LoggerMessage> blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

    private LoggerQueue() {
    }

    public static LoggerQueue getInstance() {
        //第一重判断
        if (alarmMessageQueue == null) {
            //锁定代码块
            synchronized (LoggerQueue.class) {
                //第二重判断
                if (alarmMessageQueue == null) {
                    alarmMessageQueue = new LoggerQueue(); //创建单例实例
                }
            }
        }
        return alarmMessageQueue;
    }

    /**
     * 消息入队
     *
     * @param log
     * @return
     */
    public boolean push(LoggerMessage log) {
        return this.blockingQueue.add(log);//队列满了就抛出异常，不阻塞
    }

    /**
     * 消息出队
     *
     * @return
     */
    public LoggerMessage poll() {
        LoggerMessage result = null;
        try {
            result = this.blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}