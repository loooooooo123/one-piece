package utils;

public class Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      User  userA=new  User();   //实例化User类为 userA对象
	      User  userB=new  User();   //实例化User类为 userB对象
	     
	      userA.setUsername("小明");    //用userA对象调用set方法并传参
	      userA.setId(1);
	      userA.setLevel(5);
	 
	      userB.setUsername("小明");    //用userA对象调用set方法并传参
	      userB.setId(1);
	      userB.setLevel(5);
	 
	      System.out.println("用户B未改名前："+userA.equals(userB));
	 
	      userB.setUsername("小刚");    //用userA对象调用set方法并传参
	      System.out.println("用户B改名后："+userA.equals(userB));
		
	}

}
