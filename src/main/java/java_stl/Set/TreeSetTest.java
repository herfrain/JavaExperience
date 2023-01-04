package java_stl.Set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


/*
 * TreeSet
 * 1.数据结构是红黑树
 * 2.自然排序（可升序和降序）
 * 3.每添加一个对象就会进行一次排序
 */

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//默认升序排序
		TreeSet<String> treeSet=new TreeSet<String>();
		treeSet.add("bbb");
		treeSet.add("aaa");
		treeSet.add("ddd");
		treeSet.add("ccc");
		System.out.println(treeSet.toString());

		//逆序排序
		TreeSet<Integer> treeSet2=new TreeSet<Integer>(new Comparator<Integer>() {//比较器

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}

		});
		for(int i=0;i<10;i++){
			treeSet2.add(i);
		}
		System.out.println(treeSet2);

		Integer[] arr=treeSet2.toArray(new Integer[0]);
		for(int i=0;i<10;i++){
			System.out.print(arr[i]+" ");
		}System.out.println();


		//可重复，自动排序，Set
		Set<Integer> set=new TreeSet<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1.equals(o2)){
					if(o1==0) return 1;
					return o1;
				}else{
					return o1-o2;
				}
			}

		});

		for(int i=0;i<10;i++){
			set.add(i);
		}set.add(0);set.add(0);
		System.out.println(set);

	}

}
