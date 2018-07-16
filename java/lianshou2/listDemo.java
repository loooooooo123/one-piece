package lianshou2;

import java.util.*;

//list����
public class listDemo {
	
	//����ArrayList��������ʽ�����򼯺ϣ������ɾ������Ҫ������Ԫ�ض���ǰ������ƶ�һλ
	public static ArrayList arr = new ArrayList();
	public static ArrayList arr2 = new ArrayList();
	public static ArrayList arr3 = new ArrayList();
	
	//����LinkedList������ʽ�洢������죬ɾ����
	public static LinkedList arr4 = new LinkedList();

	public static void main(String[] args) {

		//����ArrayList����ӣ�ɾ�������£���ȡԪ��ֵ����ȡ����ֵ
		myDemo1();

		//����LinkedList����ӣ�ɾ������ȡԪ��ֵ
		myDemo2();
		
		//list��setȥ��
		myDemo1_repeat();
		
		//list��Collections.sort()����
		myDemo2_sort();
		
	}
	
	//����ArrayList����ӣ�ɾ�������£���ȡԪ��ֵ����ȡ����ֵ
	public static void myDemo1() {
		//���Ԫ��
		arr.add("tom");
		arr.add("jick");
		
		//���Ԫ�ص�ָ������λ��
		arr.add(1,"yohan");
		System.out.println(arr.toString());
		
		//���һ�����ϵ�������
		arr3.add("aaa");
		arr3.add("bbb");
		arr.addAll(arr3);
		System.out.println(arr3.toString());
		
		//���һ�����ϵ�������ָ������λ��
		arr.addAll(1,arr3);
		System.out.println(arr.toString());
		
		//ɾ��ĳ���±괦��Ԫ��
		arr.remove(1);
		System.out.println(arr.toString());
		
		//����/���� ĳ���±괦��Ԫ��ֵ
		arr.set(1,"aaa");
		System.out.println(arr.toString());
		
		//��ȡĳ���±괦��Ԫ��ֵ
		System.out.println(arr.get(1));
		
		//��ȡĳ��Ԫ��ֵ��ͷ���𣬵�һ�γ��ֵ��±�ֵ
		System.out.println(arr.indexOf("aaa"));
		
		//��ȡĳ��Ԫ��ֵ��β���𣬵�һ�γ��ֵ��±�ֵ
		System.out.println(arr.lastIndexOf("aaa"));
		
		//��������Ƿ��ǿյ�
		System.out.println(arr.isEmpty());
		System.out.println(arr2.isEmpty());
	}
	
	//list��setȥ��
	public static void myDemo1_repeat() {
		 Set set1=new HashSet();   //����set���϶���
	     set1.addAll(arr);   //��List�����е�Ԫ��ȫ�������set������
	     System.out.println(set1.toString());
	}
	
	//list��Collections.sort()����
	public static void myDemo2_sort() {
		Collections.sort(arr);   //�� Collections.sort()������������
	    System.out.println(arr.toString());
	}
	
	//����LinkedList����ӣ�ɾ������ȡԪ��ֵ
	public static void myDemo2() {
		//��ͷ�����Ԫ��
		arr4.addFirst("apple");
		arr4.addFirst("orange");
		System.out.println(arr4.toString());
		
		//��β�����Ԫ��
		arr4.addLast("pear");
		arr4.addLast("Litchi");
		System.out.println(arr4.toString());
		
		//��ͷ��ɾ����һ��Ԫ��
		arr4.removeFirst();
		System.out.println(arr4.toString());
		
		//��β��ɾ����һ��Ԫ��
		arr4.removeLast();
		System.out.println(arr4.toString());
		
		//��ͷ����ȡ��һ��Ԫ��
		System.out.println(arr4.getFirst());
		
		//��β����ȡ��һ��Ԫ��
		arr4.getLast();
		System.out.println(arr4.getLast());
		
	}

}
