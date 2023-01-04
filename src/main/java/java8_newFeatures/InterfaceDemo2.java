package java8_newFeatures;

public interface InterfaceDemo2 {
    void fun1(String a);

    static void sFun1(){
        System.out.println("InterfaceDemo2 static fun1");
    }

    default void dFun1(){
        System.out.println("InterfaceDemo2 default fun1");
    }
}
