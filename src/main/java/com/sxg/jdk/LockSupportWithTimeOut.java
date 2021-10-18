package com.sxg.jdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author sxg
 * create in 2021/9/29
 */
public class LockSupportWithTimeOut {

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        new LockSupportWithTimeOut().test_timeOut_2();
    }

    /**
     * 此策略可以用于调用外部接口时设置超时时间
     */
    public void test_timeOut() {
        Monitor monitor = new Monitor();
        monitor.thread = Thread.currentThread();
        executorService.schedule(() -> {
            LockSupport.unpark(monitor.thread);
            System.out.println("唤醒线程");
        }, 3000, TimeUnit.MILLISECONDS);
        System.out.println("线程等待");
        LockSupport.park();
        System.out.println("线程启动");
    }

    /**
     * 线程中断也可以唤醒LockSupport.park
     */
    public void test_timeOut_2() {
        Monitor monitor = new Monitor();
        monitor.thread = Thread.currentThread();
        executorService.schedule(() -> {
            monitor.thread.interrupt();
            System.out.println("唤醒线程");
        }, 3000, TimeUnit.MILLISECONDS);
        System.out.println("线程等待");
        LockSupport.park();
        System.out.println("线程启动");
    }

    public void test_timeOut_3() {
        Monitor monitor = new Monitor();
        monitor.thread = Thread.currentThread();
        executorService.schedule(() -> {
            monitor.thread.interrupt();
            System.out.println("唤醒线程");
        }, 3000, TimeUnit.MILLISECONDS);
        System.out.println("线程等待");
        // blocker表示阻塞在哪个对象上，用于问题排查？
        LockSupport.park(this);
        System.out.println("线程启动");
    }

    public static class Monitor {
        Thread thread;
    }
}
