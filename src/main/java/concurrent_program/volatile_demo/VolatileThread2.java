package concurrent_program.volatile_demo;

public class VolatileThread2 implements Runnable{

    VolatileDemo volatileDemo;

    public VolatileThread2(VolatileDemo volatileDemo) {
        this.volatileDemo = volatileDemo;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + volatileDemo.toString());
            volatileDemo.B++;
        }

    }
}
