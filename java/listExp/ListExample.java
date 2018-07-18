package lianshou4;

import java.io.IOException;
import java.util.*;

import org.dom4j.DocumentException;

import base.Users;

//list ����
public class ListExample {
	
	public static void main(String[] args){
		//ArrayList+�Զ������+for ����
		al_obj_for();
		//���Ƕ��ArrayList+�Զ������+for ����
		al_obj_nesting_for();
	}
	
	//ArrayList+�Զ������+for ����
	public static void al_obj_for() {
		
		//����װ��Users�����ArrayList����
		ArrayList<Users> arr1 = new ArrayList();
		
		//���������Ϣ
		arr1.add(new Users("tom","��",26,"ǰ�˹���ʦ","17602655555"));
		arr1.add(new Users("jick","��",28,"java����ʦ","13899988588"));
		
		//����Ƕ�׵�ArrayList����
			for(Users u:arr1) {
				System.out.println("�û�����"+u.getUsername());
				System.out.println("�Ա�"+u.getSex());
				System.out.println("���䣺"+u.getAge());
				System.out.println("ְҵ��"+u.getJob());
				System.out.println("�绰��"+u.getPhone());
				System.out.println("----------------------------");
			}
		
	}

	//���Ƕ��ArrayList+�Զ������+for ����
	public static void al_obj_nesting_for() {
		
		//�����ϣ�������ͨArrayList����
		ArrayList<ArrayList<Users>> arr1 = new ArrayList();
		
		//�Ӽ��ϣ�����װ��Users�����ArrayList����
		ArrayList<Users> arr2 = new ArrayList();
		//���������Ϣ
		arr2.add(new Users("tom","��",26,"ǰ�˹���ʦ","17602655555"));
		arr2.add(new Users("jick","��",28,"java����ʦ","13899988588"));
		
		//�Ӽ��ϣ�����װ��Users�����ArrayList����
		ArrayList<Users> arr3 = new ArrayList();
		//���������Ϣ
		arr3.add(new Users("yohan","��",30,"ȫջ����ʦ","15622288585"));
		arr3.add(new Users("losi","Ů",23,"UI���ʦ","18655521656"));
		
		//Ƕ��ArrayList����
		arr1.add(arr2);
		arr1.add(arr3);
		
		//����Ƕ�׵�ArrayList����
		System.out.println("---------���Ƕ�׵�ArrayList����---------");
		for(ArrayList<Users> u:arr1) {
			for(Users uu:u) {
				System.out.println("�û�����"+uu.getUsername());
				System.out.println("�Ա�"+uu.getSex());
				System.out.println("���䣺"+uu.getAge());
				System.out.println("ְҵ��"+uu.getJob());
				System.out.println("�绰��"+uu.getPhone());
				System.out.println("----------------------------");
			}
		}
		
	}
}
