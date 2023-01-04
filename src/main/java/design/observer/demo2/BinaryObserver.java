package design.observer.demo2;

public class BinaryObserver extends AbstractObserver{

    public BinaryObserver(DecimalSubject subject) {
        super(subject);
    }

    @Override
    protected void update() {
        System.out.println(this.getClass().getName() + ":" + Integer.toBinaryString(this.subject.getValue()));
    }
}
