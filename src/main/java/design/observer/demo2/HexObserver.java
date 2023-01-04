package design.observer.demo2;

public class HexObserver extends AbstractObserver {

    public HexObserver(DecimalSubject subject) {
        super(subject);
    }

    @Override
    protected void update() {
        System.out.println(this.getClass().getName() + ":" + Integer.toHexString(this.subject.getValue()));
    }
}
