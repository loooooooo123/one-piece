package utils;

import java.util.*;
import base.Users;

@SuppressWarnings("unchecked")
public class listDemo {
	
	//�����û���Ϣ
	public static Users setUsers(String name,String sex,int age,String job,String phone) {
		Users users = new Users();
		users.setUsername(name);
		users.setSex(sex);
		users.setAge(age);
		users.setJob(job);
		users.setPhone(phone);
		return users;
	}
	
	public static void main(String[] arg) {

		//��������list
		@SuppressWarnings("rawtypes")
		ArrayList list = new ArrayList(); // ʵ����List������Ϊlist����

		//��list�����������
		list.add(setUsers("��ķ","��",20,"����Ա","18655566666"));
		list.add(setUsers("�ܿ�","��",26,"UI���","13855566666"));
		list.add(setUsers("��˿","Ů",22,"ԭ�����","13955566666"));

		// �滻list�����е� �±�1���Ķ���
		list.set(1, setUsers("Լ��","��",28,"ȫջ����ʦ","13755566666")); 

		//����list
		@SuppressWarnings("rawtypes")
		Iterator it = list.iterator(); // ����������
		for (int i = 0; i < list.size(); i++) {
			Users us = (Users) it.next();
			System.out.println("����:"+us.getUsername()+"���Ա�:"+us.getSex()+"������:"+us.getAge()+"��ְҵ:"+us.getJob()+"���绰:"+us.getPhone());
		}
	}
}
