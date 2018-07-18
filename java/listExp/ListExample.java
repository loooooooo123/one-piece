package lianshou4;

import java.io.IOException;
import java.util.*;

import org.dom4j.DocumentException;

import base.Users;

//list 例子
public class ListExample {
	
	public static void main(String[] args){
		//ArrayList+自定义对象+for 例子
		al_obj_for();
		//多层嵌套ArrayList+自定义对象+for 例子
		al_obj_nesting_for();
	}
	
	//ArrayList+自定义对象+for 例子
	public static void al_obj_for() {
		
		//声明装载Users对象的ArrayList集合
		ArrayList<Users> arr1 = new ArrayList();
		
		//插入对象信息
		arr1.add(new Users("tom","男",26,"前端工程师","17602655555"));
		arr1.add(new Users("jick","男",28,"java工程师","13899988588"));
		
		//遍历嵌套的ArrayList集合
			for(Users u:arr1) {
				System.out.println("用户名："+u.getUsername());
				System.out.println("性别："+u.getSex());
				System.out.println("年龄："+u.getAge());
				System.out.println("职业："+u.getJob());
				System.out.println("电话："+u.getPhone());
				System.out.println("----------------------------");
			}
		
	}

	//多层嵌套ArrayList+自定义对象+for 例子
	public static void al_obj_nesting_for() {
		
		//父集合，声明普通ArrayList集合
		ArrayList<ArrayList<Users>> arr1 = new ArrayList();
		
		//子集合，声明装载Users对象的ArrayList集合
		ArrayList<Users> arr2 = new ArrayList();
		//插入对象信息
		arr2.add(new Users("tom","男",26,"前端工程师","17602655555"));
		arr2.add(new Users("jick","男",28,"java工程师","13899988588"));
		
		//子集合，声明装载Users对象的ArrayList集合
		ArrayList<Users> arr3 = new ArrayList();
		//插入对象信息
		arr3.add(new Users("yohan","男",30,"全栈工程师","15622288585"));
		arr3.add(new Users("losi","女",23,"UI设计师","18655521656"));
		
		//嵌套ArrayList集合
		arr1.add(arr2);
		arr1.add(arr3);
		
		//遍历嵌套的ArrayList集合
		System.out.println("---------多层嵌套的ArrayList集合---------");
		for(ArrayList<Users> u:arr1) {
			for(Users uu:u) {
				System.out.println("用户名："+uu.getUsername());
				System.out.println("性别："+uu.getSex());
				System.out.println("年龄："+uu.getAge());
				System.out.println("职业："+uu.getJob());
				System.out.println("电话："+uu.getPhone());
				System.out.println("----------------------------");
			}
		}
		
	}
}
