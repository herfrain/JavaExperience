package java_stl.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args){
        Deque<Integer> Q = new ArrayDeque<>();
        for(int i = 0; i < 10; i++){
            Q.offer(i);
        }
        Q.offer(null);
        Q.poll();
        Q.pollFirst();
        Q.pollLast();
        Q.offerLast(11);
        Q.offerFirst(12);
        System.out.println(Q);

        // 栈
        Q.push(13);
        System.out.println(Q);
        Q.pop();
        System.out.println(Q);
        Q.pop();
        System.out.println(Q);
    }
}
