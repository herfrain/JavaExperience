package design.observer.demo;

/*
* 观察者类接口
* */
public abstract class AbstractCar {
    protected Light light;
    abstract void update();
}
