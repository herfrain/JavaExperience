package java_stl.List;

import java.lang.reflect.Array;
import java.util.*;

/*
 * ArrayList
 * 1.基于数组
 * 2.使用与vector差不多
 *
 * LinkedList
 * 1.双向链表
 * 2.栈操作
 */

public class ListTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /*
         * ArrayList
         */
        ArrayList<String> arrayList = new ArrayList<String>();
        //1.末尾插入
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        //2.index位置插入
        arrayList.add(0, "ddd");
        System.out.println(arrayList.toString());
        //3.修改index位置的值
        arrayList.set(1, "eee");
        System.out.println(arrayList.toString());
        //4.删除
        System.out.println(arrayList.remove(0));
//		arrayList.remove
        //5.截取范围[i,j)的值 subList(int i,int j)，返回List<E>
        List<String> subList = arrayList.subList(1, arrayList.size());
        System.out.println(subList.toString());
        subList.remove(0); // 操作subList会反映到原来的list中
		System.out.println(subList.toString());
		System.out.println(arrayList.toString());
//		ArrayList<String> castSubList = (ArrayList<String>)subList; // subList不能转换成ArrayList，会出错

        //6.遍历
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + ",");
        }
        System.out.println();
        for (String str : arrayList) {
            System.out.print(str + ",");
        }
        System.out.println();

        //7.转换为数组（需要指明返回类型，返回类型不能是基本类型）
        String[] list2string = arrayList.toArray(new String[0]);
        System.out.println(list2string);

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            arrayList2.add(i);
        }
        Integer[] integers = arrayList2.toArray(new Integer[0]);
        for (int i = 0; i < 10; i++) {
            System.out.print(integers[i]);
        }
        System.out.println();


        //8.排序
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o1.compareTo(o2);//大于0，则交换两者
            }

        });

        //是否包含某个元素
        System.out.println(arrayList.contains("bbb"));


        /*
         * LinkedList
         */
        //队列操作..............................
        LinkedList<String> linkedList = new LinkedList<String>();
        //1.头插
        linkedList.addFirst("222");
        linkedList.offerFirst("555");
        //2.尾插（入队）  add/addLast/offer/offerLast 相同
        linkedList.add("111");
        linkedList.addLast("333");
        linkedList.offer("444");
        linkedList.offerLast("666");
        System.out.println(linkedList.toString());
        //3.获取头元素
        System.out.println("获取头元素：" + linkedList.getFirst());
        //4.获取尾元素
        System.out.println("获取尾元素：" + linkedList.getLast());
        //5.删除头（出队），返回删除元素 remove/removeFirst
        System.out.println(linkedList.remove());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.removeFirst());
        //6.删除尾，返回删除元素 removeLast
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.toString());


        linkedList.clear();
        //栈操作...............................
        //1.入栈（即头插）
        linkedList.push("555");
        linkedList.push("666");
        linkedList.push("777");
        linkedList.push("888");
        //2.出栈
        System.out.println(linkedList.pop());
        System.out.println(linkedList.toString());

        //循环中的删除操作............................
        //1.不能在foreach中进行remove/add操作，remove元素应使用Iterator方式，如果并发操作则对Iterator加锁
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        //正例
        while (iterator.hasNext()) {
			String item = iterator.next();
			if ("2".equals(item))
				iterator.remove();
		}
//        list.removeIf("2"::equals); // 与上面同等作用
        System.out.println(list.toString());

        list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        //反例
        for (String item : list) {
            if ("2".equals(item))//fail-fast机制（快速失败），抛出ConcurrentModificationException异常
                list.remove(item);
        }
        System.out.println(list.toString());
    }

}
