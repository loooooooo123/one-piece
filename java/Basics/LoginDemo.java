package Basics;

public class LoginDemo {

	   public static void main(String[] args){
		 //��getInstance()��������ȡ��������
		       Login login1 = Login.getInstance();   
		       
		       //�û�token��ȷ
		       if(login1.getToken()=="222222"){
		    	   System.out.println("���Ѿ���½");
		       }else{
		    	   System.out.println("����δ��½");
		       }
		  
		      //���� Login login1 = Login.L; ���ݾ�̬��������������ֱ�ӵ���
		}

}
