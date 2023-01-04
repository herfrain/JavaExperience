package concurrent_program.synchronized_demo;

/**
 * synchronized关键字解决的是多个线程之间访问资源的同步性
 * synchronized关键字可以保证被它修饰的方法或者代码块在任意时刻只能有一个线程执行
 * synchronized用法：
 * 1、修饰实例方法：给当前对象加锁
 * 2、修饰静态方法：给当前类加锁
 * 3、修饰代码块：synchronized(this|object) 给当前对象加锁，synchronized(类.class) 给当前类加锁
 */

public class SynchronizedDemo {

    public SynchronizedDemo() {

    }

    public synchronized void method1(){
        System.out.println("method1");
    }

    public static synchronized void method2(){
        System.out.println("method2");
    }

    public void method3(){
        // 对实例加锁
        synchronized (this){
            System.out.println("method3 对实例加锁");
        }

        // 对类加锁
        synchronized (this.getClass()){
            System.out.println("method3 对类加锁");
        }
    }

}
