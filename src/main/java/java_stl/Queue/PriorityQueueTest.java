package java_stl.Queue;

import java.util.PriorityQueue;

/*
 * PriorityQueue
 * 1.无界队列，不允许null值
 * 2.入队和出队时间复杂度都是O(logn)
 * 3.不遵循FIFO，每次出队的都是优先级最高的元素
 * 4.优先级队列的元素按照其自然顺序（升序）进行排序，或者根据构造队列时提供的 Comparator 进行排序
 */

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
		for(int i=0;i<10;i++){
			priorityQueue.add((int)(Math.random()*10));//随机[0,10)
		}
		System.out.println(priorityQueue.toString());
//		priorityQueue.
		for(int i=0;i<10;i++){
			System.out.print(priorityQueue.poll()+" ");//默认升序排序
		}System.out.println();

//		priorityQueue.
	}

}
