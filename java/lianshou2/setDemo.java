package lianshou2;

import java.util.*;

//set����ӵ��list�Ĵ󲿷ַ�������������һ��
public class setDemo {
	
	//����set���ϣ����򼯺ϣ�����������ظ���Ԫ��
	public static Set set1 = new HashSet();
	public static Set set2 = new HashSet();

	public static void main(String[] args) {

		//����ArrayList����ӣ�ɾ�������£���ȡԪ��ֵ����ȡ����ֵ
		myDemo1();
		
	}
	
	//����ArrayList����ӣ�ɾ�������£���ȡԪ��ֵ����ȡ����ֵ
	public static void myDemo1() {
		//���Ԫ��
		set1.add("tom");
		set1.add("jick");
		System.out.println(set1);
		
		//���һ�����ϵ�������
		set2.add("aaa");
		set2.add("bbb");
		set1.addAll(set2);
		System.out.println(set1);
		
		//ɾ��ĳ��Ԫ��
		set1.remove("aaa");
		System.out.println(set1);
		
		//��������Ƿ��ǿյ�
		System.out.println(set1.isEmpty());
		System.out.println(set2.isEmpty());
	}

}
