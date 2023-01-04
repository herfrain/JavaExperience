package concurrent_program;


import concurrent_program.volatile_demo.VolatileDemo;
import concurrent_program.volatile_demo.VolatileThread1;
import concurrent_program.volatile_demo.VolatileThread2;
import org.junit.jupiter.api.Test;

class VolatileDemoTest {

    @Test
    public void test() throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();
        VolatileThread1 volatileThread1 = new VolatileThread1(volatileDemo);
        VolatileThread2 volatileThread2 = new VolatileThread2(volatileDemo);

        for(int i=0;i<10;i++){
            new Thread(volatileThread1).start();
            new Thread(volatileThread2).start();
        }
    }
}