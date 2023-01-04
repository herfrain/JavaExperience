package concurrent_program.ReentrantLock_demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    ReentrantLock reentrantLock = new ReentrantLock();
    private int MAX = 1000;
    private int count;

    public int getCount() {
        return count;
    }

    public void increase() {
        for (int i = 0; i < MAX; i++) count++;
    }

    public void increase1() {
        synchronized (this) {
            for (int i = 0; i < MAX; i++) count++;
        }
    }

    public void increase2() throws InterruptedException {
        reentrantLock.lock();
        try {
            for (int i = 0; i < MAX; i++) count++;
        } finally {
            Thread.sleep(1000);
            reentrantLock.unlock();
        }
    }

    public void increase3() throws InterruptedException {
        // 尝试获取锁，如果在规定时间内没有获取到，则线程会释放资源，不会无限等待
        while (reentrantLock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                for (int i = 0; i < MAX; i++) count++;
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
