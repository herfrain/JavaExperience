package java_stl;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//常量
		double e=Math.E;//自然系数
		double pi=Math.PI;//pi

		//取绝对值
		System.out.println(Math.abs(-2.3));

		//取最大值，最小值
		System.out.println(Math.max(-2.3,3));
		System.out.println(Math.min(-2.3,3));

		//三角函数与反三角函数
		System.out.println(Math.cos(pi));
		System.out.println(Math.acos(-1));

		//取整
		System.out.println(Math.ceil(1.1));//取大于等于参数的最小整数
		System.out.println(Math.floor(1.5));//取小于等于参数的最大整数
		System.out.println(Math.rint(1.4));//取最接近参数的整数，如果两边同样接近，则取偶数
		System.out.println(Math.round(2.3));//四舍五入取整
		System.out.println(Math.round(2.5));//四舍五入取整

		//开根号
		System.out.println(Math.sqrt(2));

		//次方
		System.out.println(Math.pow(2, 2));

		System.out.println();
		//使用基本类型浮点数运算会导致精度缺失
		float a = 1.0f - 0.9f;
		float b = 0.9f - 0.8f;
		System.out.println(a);// 0.100000024
		System.out.println(b);// 0.099999964
		System.out.println(a == b);// false
		//为防止精度缺失，应使用BigDecimal进行（大）浮点数计算，
		BigDecimal a1=new BigDecimal("1.0");//通过String构造能保证精度
		BigDecimal a2=new BigDecimal("0.9");
		BigDecimal a3=new BigDecimal("0.8");
		BigDecimal r1=a1.subtract(a2);
		BigDecimal r2=a2.subtract(a3);
		System.out.println(r1);//0.1
		System.out.println(r2);//0.1
		System.out.println(r1.equals(r2));//true

		//超过long的整型 用 BigInteger （内部是用int[]来储存，并进行大数计算）
		BigInteger b1=new BigInteger("11524344131241242352342341231423412413");
		BigInteger b2=new BigInteger("11524344131241242352342341231423412413");

		BigInteger b3=b1.add(b2);
		System.out.println(b3);

		//随机数
		System.out.println(Math.random());//[0,1)
		int x=3;int y=10;
		System.out.println(Math.random()*(y-x+1)+x);//获取[x,y]内的随机数


	}

}
