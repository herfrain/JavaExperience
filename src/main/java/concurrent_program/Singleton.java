package concurrent_program;

public class Singleton {
    // 单例成员变量
    // volatile 防止JVM的指令重排
    private volatile static Singleton uniqueInstance;

    // 私有构造方法
    private Singleton() {

    }

    // 获取单例对象
    public static Singleton getUniqueInstance() {
        // 先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            // 类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
