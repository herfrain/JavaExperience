package design.observer.demo;

import java.util.ArrayList;
import java.util.List;

/*
 * 具体目标类，红绿灯
 * 灯的颜色：红，黄，绿
 * */
public class Light {
    String color = "Green";
    protected List<AbstractCar> observerList = new ArrayList<>();

    // 注册方法，新增一个观察者
    public void attach(AbstractCar observer){
        observerList.add(observer);
    }

    // 注销方法，删除一个观察者
    public void detach(AbstractCar observer){
        observerList.remove(observer);
    }

    // 目标发生变化，通知方法，通知所有观察者
    public void notifyAllObservers() {
        for(AbstractCar car : observerList){
            car.update();
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        this.notifyAllObservers();
    }
}
