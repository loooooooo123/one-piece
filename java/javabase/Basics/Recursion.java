package Basics;

//递归例子
public class Recursion {
	
	//递归函数，计算n的y倍
	public static int rec(int n,int y) {
		if(y<=0) {
			return n;
		}else {
			y--;
			System.out.println(n);
			return rec(n*2,y);
		}
	}

	public static void main(String[] args) {
		
		//调用递归，5的2倍
		int num = rec(5,2);
		
		//调用递归，6的10倍
		int num2 = rec(6,10);
		
		System.out.println(num);
		System.out.println(num2);
	}

}
