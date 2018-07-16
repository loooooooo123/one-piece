package lianshou2;

import java.util.*;

//list集合
public class listDemo {
	
	//声明ArrayList，数组形式，有序集合，插入和删除都需要将所有元素都向前或向后移动一位
	public static ArrayList arr = new ArrayList();
	public static ArrayList arr2 = new ArrayList();
	public static ArrayList arr3 = new ArrayList();
	
	//声明LinkedList，链表式存储，插入快，删除慢
	public static LinkedList arr4 = new LinkedList();

	public static void main(String[] args) {

		//操作ArrayList，添加，删除，更新，获取元素值，获取索引值
		myDemo1();

		//操作LinkedList，添加，删除，获取元素值
		myDemo2();
		
		//list用set去重
		myDemo1_repeat();
		
		//list用Collections.sort()排序
		myDemo2_sort();
		
	}
	
	//操作ArrayList，添加，删除，更新，获取元素值，获取索引值
	public static void myDemo1() {
		//添加元素
		arr.add("tom");
		arr.add("jick");
		
		//添加元素到指定索引位置
		arr.add(1,"yohan");
		System.out.println(arr.toString());
		
		//添加一个集合到集合中
		arr3.add("aaa");
		arr3.add("bbb");
		arr.addAll(arr3);
		System.out.println(arr3.toString());
		
		//添加一个集合到集合中指定索引位置
		arr.addAll(1,arr3);
		System.out.println(arr.toString());
		
		//删除某个下标处的元素
		arr.remove(1);
		System.out.println(arr.toString());
		
		//设置/更新 某个下标处的元素值
		arr.set(1,"aaa");
		System.out.println(arr.toString());
		
		//获取某个下标处的元素值
		System.out.println(arr.get(1));
		
		//获取某个元素值从头部起，第一次出现的下标值
		System.out.println(arr.indexOf("aaa"));
		
		//获取某个元素值从尾部起，第一次出现的下标值
		System.out.println(arr.lastIndexOf("aaa"));
		
		//检测数组是否是空的
		System.out.println(arr.isEmpty());
		System.out.println(arr2.isEmpty());
	}
	
	//list用set去重
	public static void myDemo1_repeat() {
		 Set set1=new HashSet();   //创建set集合对象
	     set1.addAll(arr);   //将List集合中的元素全部添加至set集合中
	     System.out.println(set1.toString());
	}
	
	//list用Collections.sort()排序
	public static void myDemo2_sort() {
		Collections.sort(arr);   //用 Collections.sort()方法进行排序
	    System.out.println(arr.toString());
	}
	
	//操作LinkedList，添加，删除，获取元素值
	public static void myDemo2() {
		//向头部添加元素
		arr4.addFirst("apple");
		arr4.addFirst("orange");
		System.out.println(arr4.toString());
		
		//向尾部添加元素
		arr4.addLast("pear");
		arr4.addLast("Litchi");
		System.out.println(arr4.toString());
		
		//从头部删除第一个元素
		arr4.removeFirst();
		System.out.println(arr4.toString());
		
		//从尾部删除第一个元素
		arr4.removeLast();
		System.out.println(arr4.toString());
		
		//从头部获取第一个元素
		System.out.println(arr4.getFirst());
		
		//从尾部获取第一个元素
		arr4.getLast();
		System.out.println(arr4.getLast());
		
	}

}
