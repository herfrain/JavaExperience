package java_stl;

/*
 *
 * 基本类型->包装类
 * byte->Byte
 * int->Integer
 * short->Short
 * long->Long
 * float->Float
 * Double->Double
 * boolean->Boolean
 * char->Character
 */

public class PackagingClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Byte byte1=new Byte((byte)1);
		Integer integer=new Integer(2);
		Short short1=new Short((short) 3);
		Long long1=new Long((long)4);
		Float float1=new Float(5.1f);
		Double double1=new Double(6.2d);
		Boolean boolean1=new Boolean(true);
		Character character=new Character('7');

		//字符串转为基本类型 , 包装类.parse包装类(String);
		System.out.println(Float.parseFloat("42.412"));
		//基本类型->包装类 , valueOf()或 new
		System.out.println(Float.valueOf(2.3f));
		//字符串转为包装类 , valueOf()或 new
		System.out.println(Float.valueOf("524.12"));

		//int最大值和最小值
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

		//int转二进制字符串
		System.out.println(Integer.toBinaryString(-3));

		System.out.println(integer.toString());

	}

}
