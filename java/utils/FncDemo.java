package utils;


//�������Σ��ɱ����
public class FncDemo {

	public static void main(String[] args) {
		//���ú���
		num1(arr1("tom","jick","yohan"));
	}
	
	//����һ���ַ������飬����ֵ
	public static void num1(String num[]) {
		for(int i = 0;i<num.length;i++) {
			System.out.println(num[i]);
		}
	}
	
	//���ղ��޸������ַ������ɱ������������һ���ַ�������
	public static String[] arr1(String ... str) {
		String[] arr = {"tom","jick","yuhon"};
		
		for(int i = 0;i<str.length;i++) {
			arr[i] = str[i];
		}
		
		return arr;
	}

}
