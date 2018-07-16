package utils;
import java.text.SimpleDateFormat;
import java.util.*;

//���ó�����
public class common {

	public static void main(String[] args) {
		
		//����ת����
		NumberDemo();
		
		//�ַ�����
		StringDemo();
		
		//������
		DateDemo();
		
		//�����࣬�Ƽ�
		DateDemo2();
		
		//��ֵ������
		MathDemo();

	}
	
	//����ת����
	public static void NumberDemo() {
		// ����int���ͱ�����ֵΪ86
		int score1 = 86; 
	    
		// ����Integer��װ����󣬱�ʾ����score1��ֵ
		Integer score2=new Integer(score1);
	    
		// ��Integer��װ��ת��Ϊdouble����
		double score3=score2.doubleValue();
	    
		// ��Integer��װ��ת��Ϊfloat����
		float score4=score2.floatValue();
	    
		// ��Integer��װ��ת��Ϊint����
		int score5 =score2.intValue();

		System.out.println("Integer��װ�ࣺ" + score2);
		System.out.println("double���ͣ�" + score3);
		System.out.println("float���ͣ�" + score4);
		System.out.println("int���ͣ�" + score5);
	}
	
	//�ַ�����
	public static void StringDemo() {
		String a = "hello ";
		String b = "world";
		System.out.println("ת��Ϊ�ַ������ͣ�" + (a+b).toString());
	}

	//������
	public static void DateDemo() {
		//��ȡ��ǰ����
		Date d = new Date();

		// ����SimpleDateFormat�࣬��ʼ������ʱ���ʽ
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//����SimpleDateFormat ��� format��������ʽ������
		System.out.println(sdf1.format(d));
		System.out.println(sdf2.format(d));
		System.out.println(sdf3.format(d));
	}
	
	//�����࣬�Ƽ�
	public static void DateDemo2() {

		// ����Calendar���getInstance��������ȡ��ǰʱ��
		Calendar c= Calendar.getInstance();

		//��ȡ���
		int year = c.get(Calendar.YEAR);
		//��ȡ�·�
		int month = c.get(Calendar.MONTH);
		//��ȡ��
		int day = c.get(Calendar.DAY_OF_MONTH);
		//��ȡСʱ
		int hour = c.get(Calendar.HOUR_OF_DAY);
		//��ȡ����
		int minute = c.get(Calendar.MINUTE);
		//��ȡ����
		int second = c.get(Calendar.SECOND);
			

		//��ӡ���
		System.out.print(year + "-");
		System.out.print(month + "-");
		System.out.print(day + " ");
		System.out.print(hour + ":");
		System.out.print(minute + ":");
		System.out.println(second);
	}
	
	//��ֵ������
	public static void MathDemo() {
		System.out.println("�������룺" + Math.round(26.53));
		System.out.println("����С��26.53�����������" + Math.floor(26.53));
		System.out.println("���ش���26.53����С������" + Math.ceil(26.53));
		System.out.println("������� 0��1֮��ĸ�������" + Math.random());
	}

	
}
