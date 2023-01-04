package java_stl;

import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int maxn=1000;
		String string=new String("flakihadqua    ");
		String string2[]=new String[maxn];

		//输入
		Scanner scanner=new Scanner(System.in);
		String string3=scanner.nextLine();//读一行
		for(int i=0;i<string3.length();i++){
			System.out.print(string3.charAt(i));//获取第i个字符char charAt(i)
		}System.out.println();

		//字符串分割
		String splitString[]=splitString=string3.split(" ");//以空格分割字符串
		for(int i=0;i<splitString.length;i++){
			System.out.println(splitString[i]);
		}

		//基本类型转字符串 String.valueOf(基本类型)
		String numString=String.valueOf(121.412);
		System.out.println(numString);

		//截取字符串
		//1.substring(int begin) 截取从begin到最后
		//2.substring(int begin,int end) 截取[begin,end)
		String subString1=string.substring(2);
		String subString2=string.substring(0, 3);
		System.out.println(subString1);
		System.out.println(subString2);

		//替换字符并返回新的String对象，原来的不变  replace(oldChar, newChar)
		String replaceString=string.replace('a', 'b');
		System.out.println(replaceString);
		//替换字符串 replaceAll(String old,String new)
		System.out.println(string.replaceAll(" ", "aa"));

		//查找字符或字符串的位置
		//1.首次出现位置  indexOf()
		System.out.println(string.indexOf('a'));
		//2.最后出现的位置  lastIndexOf()
		System.out.println(string.lastIndexOf('a'));

		//字符串比较（可以用来比较两个大数）
		//1.从头开始比较字符的字典顺序，如果不相同，返回=前者字符-后者字符（即>0表示大于，<0表示等于）
		//2.如果都相同，则比较字符串长度，返回=前者长度-后者长度（0表示等于）
		System.out.println(string.compareTo("1"));

		//String转char[]
		string.toCharArray();


//		char c[][]=new char[5][5];
//		for(int i=0;i<5;i++){
//			for(int j=0;j<5;j++){
//				c[i][j]=scanner.next().charAt(0);
//			}
//		}
//		for(int i=0;i<5;i++){
//			for(int j=0;j<5;j++){
//				System.out.print(c[i][j]);
//			}System.out.println();
//		}

		//StringBuffer 速度快，线程安全
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<10;i++){
			stringBuffer.append(i+"");
		}

		System.out.println(stringBuffer.toString());
		//颠倒顺序
		stringBuffer.reverse();
		System.out.println(stringBuffer.toString());

		StringBuffer stringBuffer2=new StringBuffer(string);
		stringBuffer2.length();//长度
		stringBuffer2.insert(2, 'z');//插入
		stringBuffer2.deleteCharAt(0);//删除
		System.out.println(stringBuffer2.toString());


	}


}
/*
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
*/