package Basics;

public class MethodOverloading {
	
	//�������أ����ܳ���2������
	public static int getPerimeter(int w,int h) {
		return (w+h)*2;
	}
	
	//�������أ����ܳ���1������
	public static int getPerimeter(int w) {
		int h = 1;
		return (w+h)*2;
	}
	
	public static void main(String[] arg) {
		
		//���÷������أ���1������
		int num1 = getPerimeter(2,3);
		//���÷������أ���1������
		int num2 = getPerimeter(2);
		
		System.out.println(num1);
		System.out.println(num2);

	}
}
