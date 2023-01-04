package java_stl;

import java.util.Vector;

/*
 * Vector
 * 1.可变长数组
 * 2.线程安全
 */

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//初始化 Vector<E> vector=new Vector<E>();
		Vector<String> vector=new Vector<String>();

		//在末尾插入 add(E e)
		vector.add("aaa");
		vector.add("bbb");
		vector.add("ccc");

		//在index处插入 add(int index,E e)
		vector.add(1,"ddd");
		System.out.println(vector.toString());

		//在index处设置（修改值） set(int index,E e)
		vector.set(1, "ccc");

		//根据值查询下标 indexOf(Object o)，返回第一个匹配的下标
		System.out.println(vector.indexOf("ccc"));

		//删除index位置的值 remove(int index)
		vector.remove(0);

		//删除对象o remove(Object o)
		vector.remove("ccc");

		//根据下标查询值 get(int index)
		for(int i=0;i<vector.size();i++){//size() 获取长度
			System.out.println(vector.get(i));
		}

		//foreach访问
		for(String str : vector){
			System.out.println(str);
		}

		//清空数组
		vector.clear();
		System.out.println(vector.size());
	}

}
