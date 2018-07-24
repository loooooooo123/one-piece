package Basics;
import java.util.Arrays;

//子类 继承 父类
public class ChildClass extends ParentClass {
	
	public ChildClass(){
		
		//使用super调用父类构造方法
		super("come on baby");
		
		//使用this调用父类成员
		System.out.println(this.num);
		//使用super调用父类成员
		System.out.println(super.username);
		
		//获取不能被继承的成员 会报错
		//System.out.println(this.sex);
		
		for(String a:this.list1()) {
			System.out.println(a);
		}
		
		for(String a:this.list2()) {
			System.out.println(a);
		}
		
		//获取不能被继承的成员 会报错
		//System.out.println(this.list3());
		
		//不能改变父类的属性值 因为声明了final 会报错
		//this.hello = "go go go";
	}

	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
	}

}
