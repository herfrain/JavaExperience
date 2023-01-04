package java_stl;

import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args){
        // Collections.emptyList()，Collections.singletonList() 返回的List是不可修改的
        List<Integer> emptyList = Collections.emptyList();
        List<Integer> singletonList = Collections.singletonList(1);
        System.out.println(emptyList);
        System.out.println(singletonList);
//        emptyList.add(1); // UnsupportedOperationException异常
//        singletonList.add(2); // UnsupportedOperationException异常
    }
}
