package Basics;

//父类
public class ParentClass {
	
	public ParentClass(String str){
		System.out.println(str);
	}
	
	//父类公有属性，可以被继承
	public int num=100;
	
	//父类子类可见属性，可以被继承
	protected String username="汤姆";
	
	//父类私有属性，不可以被继承
	@SuppressWarnings("unused")
	private String sex="男";
	
	//不可以改变其值
	final String hello = "hello world";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//父类公有方法，可以被继承
	public String[] list1() {
		String[] strlist = {"java从入门到精通","php从入门到精通","node从入门到精通"};
		return strlist;
	}
	
	//父类子类可见方法，可以被继承
	protected String[] list2() {
		String[] strlist = {"java开发","php开发","node开发"};
		return strlist;
	}
	
	//父类私有属性，不可以被继承
	@SuppressWarnings("unused")
	private String[] list3() {
		String[] strlist = {"java大神","php大神","node大神"};
		return strlist;
	}

}
