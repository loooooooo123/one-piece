package Basics;

public class LoginDemo {

	   public static void main(String[] args){
		 //用getInstance()方法来获取单例对象
		       Login login1 = Login.getInstance();   
		       
		       //用户token正确
		       if(login1.getToken()=="222222"){
		    	   System.out.println("您已经登陆");
		       }else{
		    	   System.out.println("您尚未登陆");
		       }
		  
		      //或者 Login login1 = Login.L; 根据静态方法可以以类名直接调用
		}

}
