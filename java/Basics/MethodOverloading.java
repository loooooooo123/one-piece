package Basics;

public class MethodOverloading {
	
	//方法重载，求周长，2个参数
	public static int getPerimeter(int w,int h) {
		return (w+h)*2;
	}
	
	//方法重载，求周长，1个参数
	public static int getPerimeter(int w) {
		int h = 1;
		return (w+h)*2;
	}
	
	public static void main(String[] arg) {
		
		//调用方法重载，传1个参数
		int num1 = getPerimeter(2,3);
		//调用方法重载，传1个参数
		int num2 = getPerimeter(2);
		
		System.out.println(num1);
		System.out.println(num2);

	}
}
