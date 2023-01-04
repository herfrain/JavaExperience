package java_stl;

import java.util.Stack;

/*
 * Stack 继承 Vector
 * 1.自身可初始化
 * 2.栈操作
 * 	push 入栈
 * 	pop 出栈
 * 	peek 栈顶
 */

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<10;i++){
			stack.push(i);//入栈
		}

		for(int i=0;i<3;i++){
			System.out.println(stack.pop());//出栈
		}
		System.out.println(stack.toString());
		//获取栈顶元素
		System.out.println(stack.peek());
	}

}
