package design.proxy.dynamic_proxy_cglib;

// CGLIB 动态代理 可以代理没有实现接口的类，它通过生成一个被代理类的子类来拦截被代理类的方法调用，因此不能代理声明为 final 类型的类和方法
public class Service {
    public void send(String msg){
        System.out.println("发送消息：" + msg);
    }
}
