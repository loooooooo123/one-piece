package utils;


//方法传参，可变参数
public class FncDemo {

	public static void main(String[] args) {
		//调用函数
		num1(arr1("tom","jick","yohan"));
	}
	
	//接收一个字符串数组，遍历值
	public static void num1(String num[]) {
		for(int i = 0;i<num.length;i++) {
			System.out.println(num[i]);
		}
	}
	
	//接收不限个数的字符串（可变参数），返回一个字符串数组
	public static String[] arr1(String ... str) {
		String[] arr = {"tom","jick","yuhon"};
		
		for(int i = 0;i<str.length;i++) {
			arr[i] = str[i];
		}
		
		return arr;
	}

}
