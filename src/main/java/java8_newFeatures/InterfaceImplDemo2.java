package java8_newFeatures;

/**
 * @author Herfrain
 * @date 2022/2/23 14:49
 * @description
 * 一个类实现两个接口InterfaceDemo1和InterfaceDemo2，这两个接口中分别实现了同名的default方法，则这个类需要重写该方法
 */
public class InterfaceImplDemo2 implements InterfaceDemo1, InterfaceDemo2{
    @Override
    public void fun1() { // InterfaceDemo1的方法

    }

    @Override
    public void fun1(String a) { // InterfaceDemo2的方法

    }

    // 必须重写同名的default方法，因为如果不重写，就不知道用哪个接口的方法了
    @Override
    public void dFun1() { // 两个接口中的同名实现方法
        System.out.println("InterfaceImplDemo2 dFun1" );
    }
}
