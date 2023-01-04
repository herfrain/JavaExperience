package java_stl.Set;

import java.util.HashSet;
import java.util.Iterator;

/*
 * HashSet
 * 1.自动去重
 * 2.无序，存储元素的顺序与存入时的顺序不同
 * 3.线程不安全
 * 4.允许插入null
 * 内部使用HashMap来实现
 */

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//HashSet<E> hashSet=new HashSet<E>();
		HashSet<String> hashSet=new HashSet<String>();

		//添加操作 add(E e) E指泛型，创建时候的类型
		hashSet.add("ccc");
		System.out.println(hashSet.add("aaa"));//如果插入成功，则返回true
		System.out.println(hashSet.add("aaa"));//如果set中已存在该值，则插入失败，返回false
		hashSet.add("bbb");
		hashSet.add("ccc");
		hashSet.add(null);
		System.out.println(hashSet.toString());//toString() 可打印出数组[..]


		//删除操作 remove(Object o)
		hashSet.remove("bbb");
		System.out.println(hashSet.contains("bbb"));//contains(Object o) 返回是否包含该元素

		//判断是否为空 isEmpty()
		System.out.println(hashSet.isEmpty());

		//获取长度 size()
		System.out.println(hashSet.size());

		//迭代器顺序访问 Iterator<E> iterator=hashSet.iterator();
		Iterator<String> iterator=hashSet.iterator();
		while(iterator.hasNext()){//返回是否还有下一个元素 hasNext()
			System.out.println(iterator.next());//返回下一个元素 next()
		}


		//foreach访问 （更加简便）
		for(String str : hashSet){
			System.out.println(str);
		}

		//清空
		hashSet.clear();
	}

}
