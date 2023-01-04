package java_stl.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue 接口
 * 1.用LinkedList构建
 * 2.允许有null
 * 3.三种重要操作
 * 	offer 入队
 *  poll 出队
 *  peek 获取队首元素
 */

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//LinkedList
		Queue<Integer> queue=new LinkedList<Integer>();
		for(int i=0;i<10;i++){
			queue.offer(i);//入队
		}
		queue.offer(null);
		queue.offer(null);
		System.out.println(queue.toString());
		//出队，返回出队的元素
		queue.poll();
		System.out.println(queue.toString());
		//获取队首元素
		System.out.println(queue.peek());
		//获取队尾元素
		System.out.println(((LinkedList<Integer>)queue).getLast());

		//ArrayDeque
		Queue<Integer> queue2=new ArrayDeque<Integer>();
		queue2.offer(1);
		queue2.offer(2);
		queue2.offer(3);
		System.out.println(queue2.poll());
		System.out.println(queue2.toString());

	}

}
