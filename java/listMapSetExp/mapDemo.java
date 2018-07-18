package listMapSetExp;

import java.util.*;

import base.Users;

//map集合
public class mapDemo {

	// 声明哈希map，map集合是无序的
	public static HashMap map1 = new HashMap();
	
	// 声明树map，map集合是有序的，不允许null为键
	public static TreeMap map2 = new TreeMap();

	public static void main(String[] args) {
		// map集合操作
		mapDemoFn();
		
		// map的遍历，不能直接遍历，必须用keySet()和values()方法来遍历
		MapforDemo();
		
		//哈希map的键为一个对象
		mapDemo1();
		
	}

	// map集合操作
	public static void mapDemoFn() {

		// 添加元素，key:value形式
		map1.put(0, "hello");
		map1.put("username", "tom");
		System.out.println(map1);

		// 如果存在键的映射关系，则返回true
		System.out.println(map1.containsKey(0));
		// 如果存在值的映射关系，则返回true
		System.out.println(map1.containsValue("hello"));

		// 获取指定键的元素
		System.out.println(map1.get(0));
		System.out.println(map1.get("username"));

		// 返回所有键组成的数组
		System.out.println(map1.keySet());
		// 返回所有值组成的数组
		System.out.println(map1.values());

	}

	// map的遍历，不能直接遍历，必须用keySet()和values()方法来遍历
	public static void MapforDemo() {
		
		map1.clear();
		map1.put("username","apple");
		map1.put("sex","男");
		
		// 实例化为keySet对象，用于获取key集合
		Collection<String> keyset = map1.keySet();
		// 实例化keySet集合的迭代器
		Iterator<String> keyIt = keyset.iterator();

		// 实例化为valueSet对象，用于并获取value集合
		Collection<String> valueset = map1.values();
		// 实例化keySet集合的迭代器
		Iterator<String> valueIt = valueset.iterator();

		while (keyIt.hasNext()) { // 遍历key集合的元素
			String key1 = keyIt.next(); // 每次键指向下一个元素
			System.out.println(key1);
		}

		while (valueIt.hasNext()) { // 遍历key集合的元素
			String value1 = valueIt.next(); // 每次键指向下一个元素
			System.out.println(value1);
		}
	}
	
	// TreeMap的操作
	public static void mapTreeDemoFn() {
		
		// 添加元素，key:value形式
		map2.put("username","apple");
		map2.put("sex","男");
		
		// 实例化为keySet对象，用于获取key集合
		Collection<String> keyset = map2.keySet();
		// 实例化keySet集合的迭代器
		Iterator<String> keyIt = keyset.iterator();

		// 实例化为valueSet对象，用于并获取value集合
		Collection<String> valueset = map2.values();
		// 实例化keySet集合的迭代器
		Iterator<String> valueIt = valueset.iterator();

		while (keyIt.hasNext()) { // 遍历key集合的元素
			String key1 = keyIt.next(); // 每次键指向下一个元素
			System.out.println(key1);
		}

		while (valueIt.hasNext()) { // 遍历key集合的元素
			String value1 = valueIt.next(); // 每次键指向下一个元素
			System.out.println(value1);
		}
	}
	
	//哈希map的键为一个对象
	public static void mapDemo1() {
		HashMap<Users,String> hm = new HashMap();
		
		Users user1 = new Users("李芬","女",26,"女神","18522688588");
		hm.put(user1, "北京");
		hm.put(user1, "上海");
		hm.put(new Users("李芬","女",26,"女神","18522688588"), "深圳");
		
		// 实例化keySet集合的迭代器
		Collection<String> valueset = hm.values();
		Iterator<String> valueIt = valueset.iterator();
		while (valueIt.hasNext()) { // 遍历key集合的元素
			String value1 = valueIt.next(); // 每次键指向下一个元素
			System.out.println(value1);
		}
	}
	
	

}
