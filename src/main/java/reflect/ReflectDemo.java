package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        // 获取CLass对象的方法
        // 1、已知类名，类名.class
        Class class1 = TargetObject.class;

        // 2、CLass.forname("类路径")
        Class class2 = Class.forName("reflect.TargetObject");

        // 3、实例对象.getClass()
        ReflectDemo demo = new ReflectDemo();
        Class class3 = demo.getClass();

        // 4、类加载器xxxClassLoader.loadClass()
        // 通过类加载器获取 Class 对象不会进行初始化，意味着不进行包括初始化等一系列步骤，静态代码块和静态对象不会得到执行
        Class class4 = ClassLoader.getSystemClassLoader().loadClass("reflect.TargetObject");

        // 反射的基本操作
        // 1、实例化对象
        TargetObject targetObject = (TargetObject) class1.getDeclaredConstructor().newInstance();

        // 2、获取类中的所有方法
        Method[] methods = class1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // 3、获取指定方法，并调用
        Method publicMethod = class1.getDeclaredMethod("publicMethod", String.class); // 函数名，参数类型...
        publicMethod.invoke(targetObject, "aaa");

        // 4、获取成员变量，并修改
        Field field = class1.getDeclaredField("value");
        // 为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(targetObject, "xxx"); // 修改参数
        System.out.println(targetObject);

        // 5、调用private方法
        Method privateMethod = class1.getDeclaredMethod("privateMethod");
        // 为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
