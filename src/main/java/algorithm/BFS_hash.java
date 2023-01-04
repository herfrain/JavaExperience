package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;


public class BFS_hash {

	class Node{
		private int val;
		private Node next;
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}

	/**
	 * Return the length of the shortest path between root and target node.
	 */
	int BFS(Node root, Node target) {
		Queue<Node> queue=new LinkedList<BFS_hash.Node>();  // store all nodes which are waiting to be processed
		Set<Node> used=new HashSet<BFS_hash.Node>();     // store all the used nodes
		int step = 0;       // number of steps neeeded from root to current node
		// initialize
		queue.offer(root);
		used.add(root);
		// BFS
		while (!queue.isEmpty()) {
			step = step + 1;//图中，根结点到目的结点的距离
			// iterate the nodes which are already in the queue
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				Node cur = queue.peek();//队首元素
				used.add(cur);//设置已用
				if(cur==target){
					return step;
				}

				Node next=cur.getNext();//遍历队首元素的所有相联的元素
				while (next!=null) {
					if (!used.contains(next)) {//如果没有访问过
						queue.offer(next);//加入队列
						used.add(next);
					}
					next=next.getNext();
				}
				queue.poll();//出队
			}
		}
		return -1;          // there is no path from root to target
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
