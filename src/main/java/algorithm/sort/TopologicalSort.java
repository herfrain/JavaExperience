package algorithm.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 拓扑排序（用于检测有向图中是否存在环）
 * 需要的数据结构：
 * 1.结点（值，入度，从该结点出发到达的所有邻接结点列表）
 * 2.队列（保存入度为0的结点）
 * 3.含所有结点的列表
 * 步骤：
 * 1.遍历所有结点，把入度为0的结点加入队列
 * 2.队首结点出队并输出，删去所有从它出发的边，即遍历nextNodes中所有结点将入度减一，如果入度为0则入队
 * 3.重复步骤2，直到队列为空
 * 4.如果入过队的数目为结点总数，则说明拓扑排序成功，该图是有向无环图，否则是存在环的
 */

public class TopologicalSort {

	static class Node{
		int value;
		int inNum;
		List<Node> nextNodes=new ArrayList<>();
		public Node(int v){
			value=v;
		}
	}

	static List<Node> allNodes=new ArrayList<>();

	//拓扑排序
	static boolean topologicalSort(Node firstNode){//返回拓扑序列
		List<Node> topologicalList=new ArrayList<>();
		Queue<Node> queue=new LinkedList<>();
		for(int i=0;i<allNodes.size();i++){//步骤1
			if(allNodes.get(i).inNum==0){
				queue.offer(allNodes.get(i));
			}
		}

		while(!queue.isEmpty()){//步骤2，3
			Node node=queue.poll();
			topologicalList.add(node);
			for(int i=0;i<node.nextNodes.size();i++){
				Node nextNode=node.nextNodes.get(i);
				nextNode.inNum--;
				if(nextNode.inNum==0){
					queue.offer(nextNode);
				}
			}
		}

		if(topologicalList.size()==allNodes.size()){//步骤4
			System.out.println("拓扑排序成功，图中没有环");
			for(int i=0;i<topologicalList.size();i++){
				System.out.print(topologicalList.get(i).value+" ");
			}System.out.println();
			return true;
		}else{
			System.out.println("图中存在环");
			return false;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1->2->3->4->5->6->3
		Node firstNode=new Node(1);
		allNodes.add(firstNode);
		Node lastNode=firstNode;
		Node node_3=null;
		for(int i=2;i<=6;i++){
			Node node=new Node(i);
			allNodes.add(node);
			if(i==3) node_3=node;
			lastNode.nextNodes.add(node);
			node.inNum++;
			lastNode=node;
		}
		lastNode.nextNodes.add(node_3);
		node_3.inNum++;

		topologicalSort(firstNode);

	}

}
