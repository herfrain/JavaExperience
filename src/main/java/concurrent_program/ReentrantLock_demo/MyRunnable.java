package concurrent_program.ReentrantLock_demo;

import java.util.concurrent.CountDownLatch;

public class MyRunnable implements Runnable {
    CountDownLatch countDownLatch;
    ReentrantLockDemo reentrantLockDemo;

    public MyRunnable(CountDownLatch countDownLatch, ReentrantLockDemo reentrantLockDemo) {
        this.countDownLatch = countDownLatch;
        this.reentrantLockDemo = reentrantLockDemo;
    }

    @Override
    public void run() {
        try {
            reentrantLockDemo.increase2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " + reentrantLockDemo.getCount());
        countDownLatch.countDown();
    }
}
