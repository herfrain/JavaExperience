package design.single_9;

public class Singleton_LanHan {

    // 静态成员变量，在静态方法的变量
	// volatile 防止JVM的指令重排
    private volatile static Singleton_LanHan singleton = null;

    // 私有构造函数，确保其他类无法实例化此类
    private Singleton_LanHan() {

    }

    // 公共静态方法，让其他类能用类的方法来得到实例
    public static synchronized Singleton_LanHan getSingleton() { // 上锁防止并发出现问题
        if (singleton == null) {
            singleton = new Singleton_LanHan();
        }
        return singleton;
    }

    // 双重校验
    public static Singleton_LanHan getInstance() {
        if (singleton == null) {
            synchronized (Singleton_LanHan.class) {
                if (singleton == null) {
                    singleton = new Singleton_LanHan();
                }
            }
        }
        return singleton;
    }
}
