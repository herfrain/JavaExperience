package design.proxy.dynamic_proxy_jdk;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 类加载器，用于加载代理对象
                target.getClass().getInterfaces(), // 被代理类实现的一些接口
                new ServiceInvocationHandler(target)); // 实现InvocationHandler接口的对象
    }
}
