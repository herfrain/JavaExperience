package java8_newFeatures;
/**
 * @author Herfrain
 * @date 2022/2/23 14:34
 * @description
 * Java8 Interface接口 新特性
 * 为方便接口修改，接口中可以有实现的方法体，包括静态方法和实例方法
 *  1、static 用来修饰静态方法，只能由接口调用，不能被子类继承、重写
 *  2、default 用来修饰实例方法，可以被this调用，能被子类继承、重写
 */
public interface InterfaceDemo1 {
    int a = 0; // 变量由public static final修饰，必须初始化
    void fun1(); // 方法由public abstract修饰，这个方法需要被实现

    // static修饰的静态方法
    static void sFun1(){
        System.out.println("InterfaceDemo1 static fun1");
    }
    static void sFun2(){
        System.out.println("InterfaceDemo1 static fun2");
    }

    // default修饰的实例方法
    default void dFun1(){
        System.out.println("InterfaceDemo1 default fun1");
    }
    default void dFun2(){
        System.out.println("InterfaceDemo1 default fun2");
    }

}