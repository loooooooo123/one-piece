package utils;
import java.util.*;

public class ArrayCopyFor {

	public static void main(String[] args) {
		
		String[] str = {"tom","jick","yohan"};
		
		//foreach����
		System.out.println("����һ�����������飺");
		for(String v:arrCopyCount(str)) {
			System.out.println(v);
		}
		
		//foreach����
		System.out.println("����ָ����Χ�ڵ����飺");
		for(String v:arrCopyAny(str)) {
			System.out.println(v);
		}
		
		//foreach��ά�������
		String[][] str1 = {
			{"����ѧ","�Ͽ���ѧ"},
			{"���ҵ��ѧ","���������ѧ","���ҽ�ƴ�ѧ"},
			{"���Ƽ���ѧ","����񺽴�ѧ"},
			{"�������ѧ"}
		};
		System.out.println("������ά���飺");
		for(String[] v:str1) {
			for(String v2:v) {
				System.out.println(v2);
			}
		}
	}
	
	//����һ������������
	public static String[] arrCopyCount(String[] str) {
		//����2��Ԫ��
		String[] newstr = Arrays.copyOf(str ,2);
		return newstr;
	}
	
	//����ָ����Χ�ڵ����飬��������ʼ�ͽ�β�±괦��Ԫ��
	public static String[] arrCopyAny(String[] str) {
		//���ƿ�ʼ�±굽�����±�֮���Ԫ��
		String[] newstr = Arrays.copyOfRange(str,1,2);
		return newstr;
	}

}
