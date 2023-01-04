package design.observer;

import java.util.ArrayList;
import java.util.List;

/*
* 抽象目标类
* */
public abstract class AbstractSubject {
    // 观察者列表
    protected List<InterfaceObserver> observerList = new ArrayList<>();

    // 注册方法，新增一个观察者
    public void attach(InterfaceObserver observer){
        observerList.add(observer);
    }

    // 注销方法，删除一个观察者
    public void detach(InterfaceObserver observer){
        observerList.remove(observer);
    }

    // 目标发生变化，通知方法，通知所有观察者
    public abstract void update();
}
