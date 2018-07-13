package utils;

//字符串操作类
public class StringClassDemo {

	public static void main(String[] args) {
		
		int num = 1;
		String str1 ="Hello World";
		String str2 ="Come on Baby";
		String strNew1 =" chi ji ";
		
		//判断2个字符串是否相等
		str1.equals(str2);
		
		//字符串转数组
		for(char a:str1.toCharArray()) {
			System.out.println(a);
		}
		
		//截取指定下标处字符
		System.out.println(str2.charAt(2));
		
		//将str1转换为比特数组
	    byte b[]=str1.getBytes();    
	    for(int i=0;i<b.length;i++){
	      System.out.println(b[i]);  //循环输出b[]的每个元素
	    }
	    
	    //再将比特数组转换为字符串，转换5个
	    String str3=new String(b,0,5);   
	    System.out.println(str3);
	    
	    //取得字符串长度
	    System.out.println(str1.length());  
	    
	    //查找指定字符的下标值，从前往后找第一次出现的，下标值从0开始
	    System.out.println(str1.indexOf('o'));  
	    
	    //查找指定字符的下标值，从后往前找第一次出现的，下标值从0开始
	    System.out.println(str1.lastIndexOf('o'));  
	    
	    //截取指定下标范围内的字符，不包含结束下标处的字符
	    System.out.println(str1.substring(1,3));  
	    
	    //去除首尾空格
	    System.out.println(strNew1.trim());
	    
	    //字符串拆分为数组，以空格拆分
	    String strSp1[] = str2.split(" ");
	    for(int i=0;i<strSp1.length;i++){
	      System.out.println(strSp1[i]); //循环输出拆分后的字符串数组每个元素
	    }
		
	    //字符串转大小写
	    System.out.println(str1.toUpperCase());
	    System.out.println(str1.toLowerCase());
	    
	    //判断是否以指定字符开头
	    System.out.println(str1.startsWith("H")?"是以H开头":"不以H开头");
	    System.out.println(str1.endsWith("a")?"是以a结尾":"不以a结尾");
	    
	    //判断2个字符串是否相等，不区分大小写
	    System.out.println(str1.equalsIgnoreCase("hello world")?"相等":"不相等");
	}
	
	//2个字符串是否相等
	public static <Any> void str_equals(Any str1,Any str2){
		if(str1.equals(str2)) {
			System.out.println("相等");
		}else {
			System.out.println("不相等");
		}
	}

}
