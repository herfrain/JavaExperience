package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class GetMaxInStack {


	static Stack<Integer> stack=new Stack<Integer>();//普通栈
	static Stack<Integer> maxStack=new Stack<Integer>();//保存所有出现过的当前最大值
	static int curMax;//保存当前栈中的最大值

	//入栈
	void push(int q){
		stack.push(q);
		if(stack.size()==1){//如果是第一个元素
			curMax=stack.peek();//设置当前最大值
			maxStack.push(curMax);//将最大值入栈
		}
		else{
			if(stack.peek()>=curMax){//如果遇到比当前最大值还大的
				curMax=stack.peek();//更新当前最大值
				maxStack.push(curMax);//将最大值入栈
			}
		}
	}

	//出栈
	int pop(){
		int temp=stack.pop();//要出栈的元素
		if(temp==curMax){//如果要出栈的元素是当前的最大值
			maxStack.pop();//同步出栈
			curMax=maxStack.peek();//更新当前最大值
		}
		return temp;
	}

	//获取栈中当前最大值,O(1)
	int getMax(){
		if(stack.size()==0){
			System.out.println("栈为空！");
			return new Integer(null);
		}
		return curMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMaxInStack test=new GetMaxInStack();
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] num=new int[n];
		for(int i=0;i<n;i++){
			int randNum=(int)(Math.random()*10);
			num[i]=randNum;
			test.push(randNum);
		}
		for(int i=0;i<n;i++){
			System.out.print(num[i]+" ");
		}System.out.println();

		int m=scanner.nextInt();
		for(int i=0;i<m;i++){
			test.pop();
			System.out.println(test.getMax());
		}

	}

}
