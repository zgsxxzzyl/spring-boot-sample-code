package com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class LoggerQueue {
    //队列大小
    public static final int QUEUE_MAX_SIZE = 10000;
    private static volatile LoggerQueue alarmMessageQueue = new LoggerQueue();
    //阻塞队列
    private static volatile BlockingQueue<LoggerMessage> blockingQueue;

    static {
        blockingQueue = new ArrayBlockingQueue<LoggerMessage>(1000);
    }

    private LoggerQueue() {
    }

    public static synchronized LoggerQueue getInstance() {
        return alarmMessageQueue;
    }

    /**
     * 消息入队
     *
     * @param log
     * @return
     */
    public boolean push(LoggerMessage log) {
        System.out.println(alarmMessageQueue.hashCode() + "消息队列");
        System.out.println(Thread.currentThread().getName() + "====" + blockingQueue.hashCode());
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
            System.out.println(alarmMessageQueue.hashCode() + "消息队列");
            System.out.println(Thread.currentThread().getName() + "====" + blockingQueue.hashCode());
            result = this.blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}