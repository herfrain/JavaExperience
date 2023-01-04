package design.observer;

public class ConcreteSubject extends AbstractSubject{
    @Override
    public void update() {
        for(InterfaceObserver observer : observerList){
            observer.update();
        }
    }
}
