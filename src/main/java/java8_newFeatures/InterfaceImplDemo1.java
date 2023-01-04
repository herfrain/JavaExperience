package java8_newFeatures;

public class InterfaceImplDemo1 implements InterfaceDemo1 {
    @Override
    public void fun1() {
        System.out.println("InterfaceImplDemo1 fun1");
    }
    // 可以不实现default方法
}
