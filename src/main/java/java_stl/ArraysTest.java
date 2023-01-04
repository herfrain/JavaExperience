package java_stl;

import java.util.*;

public class ArraysTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //1.排序基本类型数组（只能升序） Arrays.sort(基本类型数组)
        //如果不是升序，则要用下面两个方法，而且类型不能使基本类型
        int a[] = {4, 51, 2, 3, 5, 2};
        int b[] = a.clone();
        Arrays.sort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + ",");
        }
        System.out.println();

        //2.排序任意类型数组 Arrays.sort(T t,Comparator c)
        Integer[] integer = new Integer[a.length];//要使用包装类
        for (int i = 0; i < a.length; i++) {
            integer[i] = a[i];
        }
        Arrays.sort(integer, new Comparator<Integer>() {//加入比较器可以实现自定义比较

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2 - o1;//如果是正数，则互换两者
            }
        });
        for (int i = 0; i < a.length; i++) {
            System.out.print(integer[i] + ",");
        }
        System.out.println();

        //3.排序list Collections.sort(List list,Comparator c)
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2 - o1;
            }
        });
        for (int i = 0; i < a.length; i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println();

        //4.复制 Arrays.copyOf(原数组，长度) 返回新数组（扩容时可以用）
        int c[] = Arrays.copyOf(a, 2);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + ",");
        }
        System.out.println();

        /*
         * System.arraycopy(Object src,  int  srcPos,
         * Object dest, int destPos, int length);
         */
        int d[] = {1, 2, 3, 4, 5};
        System.arraycopy(a, 2, d, 2, 3);
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + ",");
        }
        System.out.println();

        //5.数组转ArrayList Arrays.asList(包装类数组)，转换后的List不能新增，删除，但可以修改，修改的操作会反映到原数组（反之亦然）
        ArrayList arrayList = new ArrayList<>(Arrays.asList(integer));
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        //6.list转数组 Collections.toArray()，没指明参数则返回Object类型数组
        List<Integer> list_2 = Arrays.asList(integer);//数组转List
        Integer[] integers_2 = list_2.toArray(new Integer[0]);//参数中指明返回的类型
        for (int i = 0; i < integers_2.length; i++) {
            System.out.print(integers_2[i] + " ");
        }
        System.out.println();


        //7.翻转list
        Collections.reverse(list_2);
        for (int i = 0; i < list_2.size(); i++) {
            System.out.print(list_2.get(i) + " ");
        }
        System.out.println();

    }

}
