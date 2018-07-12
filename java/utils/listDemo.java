package utils;

import java.util.*;
import base.Users;

@SuppressWarnings("unchecked")
public class listDemo {
	
	//设置用户信息
	public static Users setUsers(String name,String sex,int age,String job,String phone) {
		Users users = new Users();
		users.setUsername(name);
		users.setSex(sex);
		users.setAge(age);
		users.setJob(job);
		users.setPhone(phone);
		return users;
	}
	
	public static void main(String[] arg) {

		//创建数组list
		@SuppressWarnings("rawtypes")
		ArrayList list = new ArrayList(); // 实例化List集合类为list对象

		//向list对象添加数据
		list.add(setUsers("汤姆","男",20,"程序员","18655566666"));
		list.add(setUsers("杰克","男",26,"UI设计","13855566666"));
		list.add(setUsers("罗丝","女",22,"原型设计","13955566666"));

		// 替换list集合中的 下标1处的对象
		list.set(1, setUsers("约翰","男",28,"全栈工程师","13755566666")); 

		//遍历list
		@SuppressWarnings("rawtypes")
		Iterator it = list.iterator(); // 创建迭代器
		for (int i = 0; i < list.size(); i++) {
			Users us = (Users) it.next();
			System.out.println("姓名:"+us.getUsername()+"，性别:"+us.getSex()+"，年龄:"+us.getAge()+"，职业:"+us.getJob()+"，电话:"+us.getPhone());
		}
	}
}
