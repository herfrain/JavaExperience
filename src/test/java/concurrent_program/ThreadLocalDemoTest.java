package concurrent_program;

import concurrent_program.ThreadLocal_demo.ThreadLocalDemo;
import org.junit.jupiter.api.Test;

import java.util.Random;

class ThreadLocalDemoTest {

    @Test
    public void test() throws InterruptedException {
        ThreadLocalDemo obj = new ThreadLocalDemo();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

}