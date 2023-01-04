package java_stl;


//泛型的用法
public class GenericTest {

	//类名后面加上<泛型名称>
	static class Generic<T>{
		T t;
	}

	//方法类型前面加上<泛型名称>
	public static <T> T fun(T t){
		return t;
	}

	//自己设计一个泛型的获取数组最小值的函数.并且这个方法只能接受Number的子类并且实现了Comparable接口。
	// 注意：Number并没有实现Comparable
	private static <T extends Number & Comparable<? super T>> T min(T[] values) {
		if (values == null || values.length == 0) return null;
		T min = values[0];
		for (int i = 1; i < values.length; i++) {
			if (min.compareTo(values[i]) > 0) min = values[i];
		}
		return min;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun("12421"));

		Generic<Integer> generic=new Generic<Integer>();
		generic.t=2;
	}

}
