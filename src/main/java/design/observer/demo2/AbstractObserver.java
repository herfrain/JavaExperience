package design.observer.demo2;
/*
* 进制抽象类
* */
public abstract class AbstractObserver {
    DecimalSubject subject ;
    public AbstractObserver(DecimalSubject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    protected abstract void update();
}
