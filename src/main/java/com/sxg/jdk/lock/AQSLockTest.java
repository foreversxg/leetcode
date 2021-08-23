package com.sxg.jdk.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sxg
 * create in 2021/8/21
 */
public class AQSLockTest {

    public static void main(String[] args) {
        new AQSLockTest().test();
    }

    public void test() {
        Lock lock = new ReentrantLock();
        lock.lock();
        System.out.println("233");
        lock.unlock();
    }

}
