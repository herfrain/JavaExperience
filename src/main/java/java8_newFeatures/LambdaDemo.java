package java8_newFeatures;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

/**
 * @author Herfrain
 * @date 2022/2/23 15:14
 * @description Lambda表达式
 * 新引入Lambda表达式，可作为函数的参数传递
 * Lambda表达式使代码更简洁，让java能支持简单的函数式编程
 * 语法格式：
 * (parameters) -> expression 或
 * (parameters) ->{ statements; }
 * <p>
 * 函数式接口：有且只有一个抽象方法，但可以有多个非抽象方法的接口（即只有一个方法需要重写实现）
 * 所有函数式接口都能用Lambda表达式
 */
public class LambdaDemo extends LambdaSuper {

    // Runnable接口
    public void test1() {
        // 不使用Lambda
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The runable now is using!");
            }
        }).start();

        // 使用lambda
        new Thread(() -> System.out.println("It's a lambda function!")).start();
    }

    // Comparator接口
    public void test2() {
        List<Integer> strings = Arrays.asList(1, 2, 3);

        // 不使用Lambda
        Collections.sort(strings, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // 使用Lambda
        Collections.sort(strings, (Integer o1, Integer o2) -> o1 - o2);
        // 分解开
        Comparator<Integer> comperator = (Integer o1, Integer o2) -> o1 - o2;
        Collections.sort(strings, comperator);
    }

    // Listener
    public void test3() {
        JButton button = new JButton();
        // 不使用Lambda
        button.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                e.getItem();
            }
        });

        // 使用Lambda
        button.addItemListener(e -> e.getItem());
    }

    // 集合迭代
    public void test4() {
        List<String> strings = Arrays.asList("1", "2", "3");
        // 传统foreach
        for (String s : strings) {
            System.out.println(s);
        }

        // Lambda foreach
        strings.forEach((s) -> System.out.println(s));
        // or
        strings.forEach(System.out::println);

        // map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    // 访问变量
    public void test5() {
        int i = 0;
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collections.sort(list, (Integer o1, Integer o2) -> o1 - i); // 默认i有final属性
//        i = 3; // 无法修改，会报错
    }

    // Java 8 允许使用 :: 关键字来传递方法或者构造函数引用，方法的返回值必须是functional-interface（函数式接口）
    public static LambdaInterface staticFun() {
        return null;
    }

    public LambdaInterface fun() {
        return null;
    }

    public void test6() {
        // 1.调用静态函数，返回类型必须是functional-interface
        LambdaInterface lambdaInterface = LambdaDemo::staticFun;
        System.out.println(lambdaInterface.toString());

        // 2.实例方法调用
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaInterface = lambdaDemo::fun;
        System.out.println(lambdaInterface.toString());

        // 3.超类上的方法调用
        lambdaInterface = super::superFun;
        System.out.println(lambdaInterface.toString());

        // 4. 构造方法调用
        lambdaInterface = LambdaSuper::new;
        System.out.println(lambdaInterface.toString());
    }
}
