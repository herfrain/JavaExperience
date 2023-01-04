package concurrent_program.volatile_demo;

public class VolatileDemo{
    public volatile int A;
    public int B;

    public VolatileDemo() {
    }

    @Override
    public String toString() {
        return "VolatileDemo{" +
                "A=" + A +
                ", B=" + B +
                '}';
    }
}
