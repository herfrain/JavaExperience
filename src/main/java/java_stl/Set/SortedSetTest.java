package java_stl.Set;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;


/*
 * SortedSet
 */

public class SortedSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//默认升序排序
		SortedSet<String> treeSet=new TreeSet<String>();
		treeSet.add("bbb");
		treeSet.add("aaa");
		treeSet.add("ddd");
		treeSet.add("ccc");
		System.out.println(treeSet.toString());

		//逆序排序
		SortedSet<Integer> treeSet2=new TreeSet<Integer>(new Comparator<Integer>() {//比较器

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}

		});
		for(int i=0;i<10;i++){
			treeSet2.add(i);
		}
		treeSet2.add(2);
		System.out.println(treeSet2);

		Integer[] arr=treeSet2.toArray(new Integer[0]);
		for(int i=0;i<10;i++){
			System.out.print(arr[i]+" ");
		}System.out.println();

	}

}
