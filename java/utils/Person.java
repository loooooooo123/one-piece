package utils;

public class Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      User  userA=new  User();   //ʵ����User��Ϊ userA����
	      User  userB=new  User();   //ʵ����User��Ϊ userB����
	     
	      userA.setUsername("С��");    //��userA�������set����������
	      userA.setId(1);
	      userA.setLevel(5);
	 
	      userB.setUsername("С��");    //��userA�������set����������
	      userB.setId(1);
	      userB.setLevel(5);
	 
	      System.out.println("�û�Bδ����ǰ��"+userA.equals(userB));
	 
	      userB.setUsername("С��");    //��userA�������set����������
	      System.out.println("�û�B������"+userA.equals(userB));
		
	}

}
