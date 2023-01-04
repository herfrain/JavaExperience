package concurrent_program.ReentrantLock_demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

class MyRunnableTest {

    @Test
    void run() {
        int threadNum = 20;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum); // 用来判断线程是否全部执行完毕
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        MyRunnable myRunnable = new MyRunnable(countDownLatch, reentrantLockDemo);
        for (int i = 0; i < threadNum; i++) {
            new Thread(myRunnable).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程运行完毕！");
        System.out.println(reentrantLockDemo.getCount());
    }
}