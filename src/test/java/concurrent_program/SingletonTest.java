package concurrent_program;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

class SingletonTest {

    // Singleton singleton = new Singleton(); 因为是私有构造函数，所以无法直接new来创建实例

    @Test
    void getUniqueInstance() {
        // 线程中需要使用Atomic原子类
        AtomicReference<Singleton> singleton1 = new AtomicReference<>();
        AtomicReference<Singleton> singleton2 = new AtomicReference<>();

        new Thread(() -> {
            singleton1.set(Singleton.getUniqueInstance());
        }, "线程1").start();

        new Thread(() -> {
            singleton2.set(Singleton.getUniqueInstance());
        }, "线程2").start();

        System.out.println(singleton1.get() == singleton2.get()); // true，两个实例是相等的
    }
}