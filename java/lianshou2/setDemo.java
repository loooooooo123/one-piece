package lianshou2;

import java.util.*;

//set集合拥有list的大部分方法，基本操作一致
public class setDemo {
	
	//声明set集合，无序集合，不允许存在重复的元素
	public static Set set1 = new HashSet();
	public static Set set2 = new HashSet();

	public static void main(String[] args) {

		//操作ArrayList，添加，删除，更新，获取元素值，获取索引值
		myDemo1();
		
	}
	
	//操作ArrayList，添加，删除，更新，获取元素值，获取索引值
	public static void myDemo1() {
		//添加元素
		set1.add("tom");
		set1.add("jick");
		System.out.println(set1);
		
		//添加一个集合到集合中
		set2.add("aaa");
		set2.add("bbb");
		set1.addAll(set2);
		System.out.println(set1);
		
		//删除某个元素
		set1.remove("aaa");
		System.out.println(set1);
		
		//检测数组是否是空的
		System.out.println(set1.isEmpty());
		System.out.println(set2.isEmpty());
	}

}
