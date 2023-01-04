package java_stl.Queue;

import java.time.LocalDateTime;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

    public void run(){
        Order order1 = new Order("Order1", 5, TimeUnit.SECONDS);
        Order order2 = new Order("Order2", 10, TimeUnit.SECONDS);
        Order order3 = new Order("Order3", 15, TimeUnit.SECONDS);
        Queue<Order> delayQueue = new DelayQueue<>();
        delayQueue.add(order1);
        delayQueue.add(order2);
        delayQueue.add(order3);

        System.out.println("开始时间：" + LocalDateTime.now());
        while(!delayQueue.isEmpty()){
            Order order = delayQueue.poll();
            if(order != null){
                System.out.println(order.name + ":" + LocalDateTime.now());
            }
        }
    }

}
