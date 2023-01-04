package concurrent_program;

import concurrent_program.ThreadPool_demo.ThreadPoolExecutorDemo;
import org.junit.jupiter.api.Test;

class ThreadPoolExecutorDemoTest {

    @Test
    void execute() {
        new ThreadPoolExecutorDemo().execute();
    }
}