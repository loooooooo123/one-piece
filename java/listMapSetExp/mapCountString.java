package listMapSetExp;

import java.util.HashMap;

/*
 * ʹ��map����ͳ��һ���ַ�����ÿ���ַ����ֵĴ���
 * 
 * �������£�
 * 1.����һ����Ҫ��ͳ�Ƶ��ַ���
 * 2.���ַ���ת��Ϊ����
 * 3.����˫�м��ϣ��洢�ַ������ַ�һ���ַ����ֵĴ���
 * 4.�����ַ������ȡÿһ���ַ��������ַ��洢��˫�м�����
 * 5.�洢������Ҫ���жϣ���������в�������������ͽ��ַ���������ֵΪ1�洢��
 *   ��������а�����������ͽ�ֵ��1�洢
 * 6.��ӡ˫�м��ϻ�ȡ�ַ������ֵĴ���
 * 
 * */
public class mapCountString {

	public static void main(String[] args) {
		
		//1.����һ����Ҫ��ͳ�Ƶ��ַ���
		String str = "aabbbccccddddddddddeeeeedaffffff";
		
		//2.���ַ���ת��Ϊ����
		char[] arr = str.toCharArray();
		
		//3.����˫�м��ϣ��洢�ַ������ַ�һ���ַ����ֵĴ���
		HashMap<Character,Integer> hm = new HashMap<>();
		
		//4.�����ַ������ȡÿһ���ַ��������ַ��洢��˫�м�����
		for(char c:arr) {
			//5.�洢������Ҫ���жϣ���������в�������������ͽ��ַ���������ֵΪ1�洢��
			hm.put(c, !hm.containsKey(c)?1:hm.get(c)+1);
		}
		
		//6.��ӡ˫�м��ϻ�ȡ�ַ������ֵĴ���
		for(Character key : hm.keySet()) {	//hm.keySet()���м�����
			//hm.get(key)���ݼ���ȡֵ
			System.out.println(key + "=" + hm.get(key));
		}
		
	}

}
