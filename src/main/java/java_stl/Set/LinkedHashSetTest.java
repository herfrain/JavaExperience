package java_stl.Set;

import java.util.LinkedHashSet;

/*
 *
 * LinkedHashSet
 * 1.用于遍历集合元素
 * 2.有序，指按插入顺序排序
 * 3.去重
 */

public class LinkedHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashSet<String> linkedHashSet=new LinkedHashSet<String>();
		linkedHashSet.add("ccc");
		linkedHashSet.add("a");
		linkedHashSet.add("cbc");
		linkedHashSet.add("ccc");
		System.out.println(linkedHashSet.toString());
	}

}
