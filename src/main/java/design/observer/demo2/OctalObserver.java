package design.observer.demo2;

public class OctalObserver extends AbstractObserver {

    public OctalObserver(DecimalSubject subject) {
        super(subject);
    }

    @Override
    protected void update() {
        System.out.println(this.getClass().getName() + ":" + Integer.toOctalString(this.subject.getValue()));
    }
}
