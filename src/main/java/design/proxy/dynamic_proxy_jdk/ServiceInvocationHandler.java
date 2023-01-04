package design.proxy.dynamic_proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceInvocationHandler implements InvocationHandler {

    private final Object service;

    public ServiceInvocationHandler(Object service){
        this.service = service;
    }

    /**
     * @author Herfrain
     * @date 2022/3/30 12:02
     * @description
     * @param proxy 动态生成的代理类
     * @param method 与代理类对象调用的方法相对应
     * @param args 当前 method 方法的参数
     * @return java.lang.Object
     * @throws
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before");
        Object res = method.invoke(service, args);
        System.out.println("after");
        return res;
    }
}
