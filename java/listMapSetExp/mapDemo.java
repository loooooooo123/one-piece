package listMapSetExp;

import java.util.*;

import base.Users;

//map����
public class mapDemo {

	// ������ϣmap��map�����������
	public static HashMap map1 = new HashMap();
	
	// ������map��map����������ģ�������nullΪ��
	public static TreeMap map2 = new TreeMap();

	public static void main(String[] args) {
		// map���ϲ���
		mapDemoFn();
		
		// map�ı���������ֱ�ӱ�����������keySet()��values()����������
		MapforDemo();
		
		//��ϣmap�ļ�Ϊһ������
		mapDemo1();
		
	}

	// map���ϲ���
	public static void mapDemoFn() {

		// ���Ԫ�أ�key:value��ʽ
		map1.put(0, "hello");
		map1.put("username", "tom");
		System.out.println(map1);

		// ������ڼ���ӳ���ϵ���򷵻�true
		System.out.println(map1.containsKey(0));
		// �������ֵ��ӳ���ϵ���򷵻�true
		System.out.println(map1.containsValue("hello"));

		// ��ȡָ������Ԫ��
		System.out.println(map1.get(0));
		System.out.println(map1.get("username"));

		// �������м���ɵ�����
		System.out.println(map1.keySet());
		// ��������ֵ��ɵ�����
		System.out.println(map1.values());

	}

	// map�ı���������ֱ�ӱ�����������keySet()��values()����������
	public static void MapforDemo() {
		
		map1.clear();
		map1.put("username","apple");
		map1.put("sex","��");
		
		// ʵ����ΪkeySet�������ڻ�ȡkey����
		Collection<String> keyset = map1.keySet();
		// ʵ����keySet���ϵĵ�����
		Iterator<String> keyIt = keyset.iterator();

		// ʵ����ΪvalueSet�������ڲ���ȡvalue����
		Collection<String> valueset = map1.values();
		// ʵ����keySet���ϵĵ�����
		Iterator<String> valueIt = valueset.iterator();

		while (keyIt.hasNext()) { // ����key���ϵ�Ԫ��
			String key1 = keyIt.next(); // ÿ�μ�ָ����һ��Ԫ��
			System.out.println(key1);
		}

		while (valueIt.hasNext()) { // ����key���ϵ�Ԫ��
			String value1 = valueIt.next(); // ÿ�μ�ָ����һ��Ԫ��
			System.out.println(value1);
		}
	}
	
	// TreeMap�Ĳ���
	public static void mapTreeDemoFn() {
		
		// ���Ԫ�أ�key:value��ʽ
		map2.put("username","apple");
		map2.put("sex","��");
		
		// ʵ����ΪkeySet�������ڻ�ȡkey����
		Collection<String> keyset = map2.keySet();
		// ʵ����keySet���ϵĵ�����
		Iterator<String> keyIt = keyset.iterator();

		// ʵ����ΪvalueSet�������ڲ���ȡvalue����
		Collection<String> valueset = map2.values();
		// ʵ����keySet���ϵĵ�����
		Iterator<String> valueIt = valueset.iterator();

		while (keyIt.hasNext()) { // ����key���ϵ�Ԫ��
			String key1 = keyIt.next(); // ÿ�μ�ָ����һ��Ԫ��
			System.out.println(key1);
		}

		while (valueIt.hasNext()) { // ����key���ϵ�Ԫ��
			String value1 = valueIt.next(); // ÿ�μ�ָ����һ��Ԫ��
			System.out.println(value1);
		}
	}
	
	//��ϣmap�ļ�Ϊһ������
	public static void mapDemo1() {
		HashMap<Users,String> hm = new HashMap();
		
		Users user1 = new Users("���","Ů",26,"Ů��","18522688588");
		hm.put(user1, "����");
		hm.put(user1, "�Ϻ�");
		hm.put(new Users("���","Ů",26,"Ů��","18522688588"), "����");
		
		// ʵ����keySet���ϵĵ�����
		Collection<String> valueset = hm.values();
		Iterator<String> valueIt = valueset.iterator();
		while (valueIt.hasNext()) { // ����key���ϵ�Ԫ��
			String value1 = valueIt.next(); // ÿ�μ�ָ����һ��Ԫ��
			System.out.println(value1);
		}
	}
	
	

}
