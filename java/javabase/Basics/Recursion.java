package Basics;

//�ݹ�����
public class Recursion {
	
	//�ݹ麯��������n��y��
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
		
		//���õݹ飬5��2��
		int num = rec(5,2);
		
		//���õݹ飬6��10��
		int num2 = rec(6,10);
		
		System.out.println(num);
		System.out.println(num2);
	}

}
