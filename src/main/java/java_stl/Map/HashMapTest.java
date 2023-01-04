package java_stl.Map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/*
 * HashMap
 * 1.自动排序（以key按字典升序排序）
 * 2.Key唯一（允许键为null）
 */

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//初始化 HashMap<K, V> hashMap=new HashMap<K, V>();
		//键值对 Key->Value
		HashMap<String, Integer> hashMap=new HashMap<String, Integer>();

		//插入 put(K k,V v)，返回旧的value
		hashMap.put("b", 1);
		System.out.println(hashMap.put("a", 0));
		System.out.println(hashMap.put("a", 3));
		System.out.println(hashMap.get("c"));
		hashMap.getOrDefault("z", 2);
		hashMap.put("a", 1);//如果重复插入同一个key，则保留最后一个插入
		hashMap.put("b", 1);
		hashMap.put("c", 2);
		hashMap.put("d", 3);
		hashMap.put("e", 4);
		hashMap.put(null, 5);
		System.out.println(hashMap.toString());

		//删除 remove(Object key)，返回该key对应的value
		System.out.println(hashMap.remove("a"));
		//删除 remove(Object key,Object value)，只有key和value都对应才能删除
		System.out.println(hashMap.remove("b", 2));
		System.out.println(hashMap.remove("b", 1));

		//替换 replace(K key,V value)，返回旧的value
		System.out.println(hashMap.replace("c", 3));
		System.out.println(hashMap.toString());

		//是否含对应key 或 对应value
		System.out.println(hashMap.containsKey("a"));
		System.out.println(hashMap.containsValue(3));



		/*
		 * 遍历map
		 * 方法一：通过key找value（速度贼慢）
		 * 方法二：用entrySet()（快一点）
		 * 方法三：keySet()和values()，分别找key和value
		 */
		//方法一
		for(String key : hashMap.keySet()){
			System.out.print(key+"="+hashMap.get(key)+",");
		}System.out.println();
		//方法二
		for(Entry<String, Integer> entry : hashMap.entrySet()){
			System.out.print(entry.getKey()+"="+entry.getValue()+",");
		}System.out.println();
		//方法三
		for(String key : hashMap.keySet()){
			System.out.print(key+",");
		}System.out.println();
		for(Integer value : hashMap.values()){
			System.out.print(value+",");
		}System.out.println();

	}

}
