package utils;

//�ַ���������
public class StringClassDemo {

	public static void main(String[] args) {
		
		int num = 1;
		String str1 ="Hello World";
		String str2 ="Come on Baby";
		String strNew1 =" chi ji ";
		
		//�ж�2���ַ����Ƿ����
		str1.equals(str2);
		
		//�ַ���ת����
		for(char a:str1.toCharArray()) {
			System.out.println(a);
		}
		
		//��ȡָ���±괦�ַ�
		System.out.println(str2.charAt(2));
		
		//��str1ת��Ϊ��������
	    byte b[]=str1.getBytes();    
	    for(int i=0;i<b.length;i++){
	      System.out.println(b[i]);  //ѭ�����b[]��ÿ��Ԫ��
	    }
	    
	    //�ٽ���������ת��Ϊ�ַ�����ת��5��
	    String str3=new String(b,0,5);   
	    System.out.println(str3);
	    
	    //ȡ���ַ�������
	    System.out.println(str1.length());  
	    
	    //����ָ���ַ����±�ֵ����ǰ�����ҵ�һ�γ��ֵģ��±�ֵ��0��ʼ
	    System.out.println(str1.indexOf('o'));  
	    
	    //����ָ���ַ����±�ֵ���Ӻ���ǰ�ҵ�һ�γ��ֵģ��±�ֵ��0��ʼ
	    System.out.println(str1.lastIndexOf('o'));  
	    
	    //��ȡָ���±귶Χ�ڵ��ַ��������������±괦���ַ�
	    System.out.println(str1.substring(1,3));  
	    
	    //ȥ����β�ո�
	    System.out.println(strNew1.trim());
	    
	    //�ַ������Ϊ���飬�Կո���
	    String strSp1[] = str2.split(" ");
	    for(int i=0;i<strSp1.length;i++){
	      System.out.println(strSp1[i]); //ѭ�������ֺ���ַ�������ÿ��Ԫ��
	    }
		
	    //�ַ���ת��Сд
	    System.out.println(str1.toUpperCase());
	    System.out.println(str1.toLowerCase());
	    
	    //�ж��Ƿ���ָ���ַ���ͷ
	    System.out.println(str1.startsWith("H")?"����H��ͷ":"����H��ͷ");
	    System.out.println(str1.endsWith("a")?"����a��β":"����a��β");
	    
	    //�ж�2���ַ����Ƿ���ȣ������ִ�Сд
	    System.out.println(str1.equalsIgnoreCase("hello world")?"���":"�����");
	}
	
	//2���ַ����Ƿ����
	public static <Any> void str_equals(Any str1,Any str2){
		if(str1.equals(str2)) {
			System.out.println("���");
		}else {
			System.out.println("�����");
		}
	}

}
