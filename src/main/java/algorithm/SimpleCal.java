package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class SimpleCal {

	static final int maxn=1000;

	static String splitStr[]=new String[maxn];//用空格分割，保存每个字符串
	static ArrayList<String> hzList=new ArrayList<String>();//后缀表达式，用String存
	static Stack<String> symbolStack=new Stack<String>();//操作符栈
	static Stack<Double> numberStack=new Stack<Double>();//操作数栈
	static Map<String, Integer> opMap=new HashMap<String, Integer>();//操作符优先级
	//初始化操作符优先级
	static {
		opMap.put("+", 1);
		opMap.put("-", 1);
		opMap.put("*", 2);
		opMap.put("/", 2);
	}
	static boolean error=false;//出现错误

	//中缀转后缀
	//1.如果是数字，则直接存入hzList
	//2.如果是操作符，则入栈
	//	a.入栈前，判断栈顶的优先级大小。
	//	b.如果该字符优先级较小或等于，则让其出栈（出栈直接存入hzList），直到遇到比它更小的
	//	c.如果该字符优先级较大，则直接入栈，结束
	static void change(String str){
		splitStr=str.split(" ");//每个数字或符号用空格分割
//		System.out.println(splitStr.length);
//		for(int i=0;i<splitStr.length;i++){
//			System.out.println(splitStr[i]);
//		}
		for(int i=0;i<splitStr.length;i++){
			char curChar=splitStr[i].charAt(0);
			if(curChar>='0'&&curChar<='9'){//如果是数字
				hzList.add(splitStr[i]);//放入队列
			}else{//如果是字符
				if(!symbolStack.isEmpty()){
					String top=symbolStack.peek();//栈顶元素
					while(opMap.get(splitStr[i])<=opMap.get(top)){
						hzList.add(symbolStack.pop());//出栈，存入后缀表达式队列
						if(symbolStack.isEmpty()) break;//如果为空则退出
						top=symbolStack.peek();
					}
				}
				symbolStack.push(splitStr[i]);//入栈
			}
		}
		//把符号栈全部出栈，并加入到后缀队列
		while(!symbolStack.isEmpty()){
			hzList.add(symbolStack.pop());
		}
	}

	//通过后缀表达式进行计算
	//1.如果是数字，则加入操作数栈
	//2.如果遇到操作符，则弹出对应的操作数，并进行计算，将结果入栈
	static void cal(){
		for(int i=0;i<hzList.size();i++){
			String curString=hzList.get(i);
			char curChar=curString.charAt(0);
			if(curChar>='0'&&curChar<='9'){//如果是数字
				double temp=stringToInt(curString);
				numberStack.push(temp);//将其加入操作数栈
			}else{
				symbolCal(curString);
			}
			if(error){
				return ;
			}
		}
	}

	//双目运算符计算
	static void symbolCal(String symbol){
		double a,b;//两个操作数
		a=numberStack.pop();
		b=numberStack.pop();
		double ans=-1.0;//结果
		switch (symbol) {
			case "+":
				ans=a+b;
				break;
			case "-":
				ans=b-a;//后出栈的-先出栈的
				break;
			case "*":
				ans=a*b;
				break;
			case "/":
				try {
					ans=b/a;
				} catch (Exception e) {
					// TODO: handle exception
					error=true;
					System.out.println("不能除0!");
				}
				break;
			default:
				break;
		}
		numberStack.push(ans);
	}

	//string->int
	static int stringToInt(String str){
		int tempInt=0;
		char tempC[]=str.toCharArray();//string转char[]
		for(int i=0;i<tempC.length;i++){//char转int
			tempInt=tempInt*10+tempC[i]-'0';
		}
		return tempInt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
//		System.out.println(str);

		change(str);
		for(int i=0;i<hzList.size();i++){
			System.out.print(hzList.get(i));
		}System.out.println();
		cal();

//		System.out.println(numberStack.size());
		if(!error)
			System.out.println(numberStack.pop());

		scanner.close();
	}

}

/*
 * 1 + 2 * 3
 * 7
 *
 * 1 + 3 * 5 / 4 * 8 / 9 * 6 * 2 / 3 / 7 + 3 * 8 / 2
 * 14.90
 *
 * 12 + 78 / 4 * 6 * 7 / 3 - 12 - 13 - 24 * 25 / 6
 * 160.00
 *
 * 985211 * 985 / 211
 * 4599207.75
 *
 * 2 / 3 * 4
 * 2.67
 */
