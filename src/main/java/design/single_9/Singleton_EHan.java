package design.single_9;

public class Singleton_EHan {

	//私有、静态、不可更改的变量，编译时就创建
	private static final Singleton_EHan singleton=new Singleton_EHan();

	//私有构造函数，确保其他类无法实例化此类
	private Singleton_EHan(){

	}

	//公共静态方法，让其他类能用类的方法来得到实例
	public static Singleton_EHan getSingleton(){
		return singleton;
	}
}
