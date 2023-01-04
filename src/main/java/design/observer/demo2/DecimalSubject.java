package design.observer.demo2;

import java.util.ArrayList;
import java.util.List;

/*
* 十进制目标类
* */
public class DecimalSubject {
    private List<AbstractObserver> observerList;
    private int value;

    public DecimalSubject(){
        this.observerList = new ArrayList<>();
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        this.notifyAllObservers();
    }

    void attach(AbstractObserver observer){
        observerList.add(observer);
    }

    void detach(AbstractObserver observer){
        observerList.remove(observer);
    }

    private void notifyAllObservers(){
        for(AbstractObserver observer : observerList){
            observer.update();
        }
    }
}
