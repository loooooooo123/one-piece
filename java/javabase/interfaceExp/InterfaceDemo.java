package interfaceExp;

//接口测试
public class InterfaceDemo implements demo_one,demo_two{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//定义接口的方法
	public String toString1(String str) {
		return str;
	}
	
	//定义接口的方法
	public String toString2(String str) {
		return str;
	}
	
	public InterfaceDemo() {
		//打印接口定义好的属性
		System.out.println(this.str1+this.str2);
		//打印接口定义好的方法
		System.out.println(this.toString1("hello")+this.toString2(" world2"));
	}

}
