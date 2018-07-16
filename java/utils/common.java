package utils;
import java.text.SimpleDateFormat;
import java.util.*;

//内置常用类
public class common {

	public static void main(String[] args) {
		
		//类型转换类
		NumberDemo();
		
		//字符串类
		StringDemo();
		
		//日期类
		DateDemo();
		
		//日期类，推荐
		DateDemo2();
		
		//数值操作类
		MathDemo();

	}
	
	//类型转换类
	public static void NumberDemo() {
		// 定义int类型变量，值为86
		int score1 = 86; 
	    
		// 创建Integer包装类对象，表示变量score1的值
		Integer score2=new Integer(score1);
	    
		// 将Integer包装类转换为double类型
		double score3=score2.doubleValue();
	    
		// 将Integer包装类转换为float类型
		float score4=score2.floatValue();
	    
		// 将Integer包装类转换为int类型
		int score5 =score2.intValue();

		System.out.println("Integer包装类：" + score2);
		System.out.println("double类型：" + score3);
		System.out.println("float类型：" + score4);
		System.out.println("int类型：" + score5);
	}
	
	//字符串类
	public static void StringDemo() {
		String a = "hello ";
		String b = "world";
		System.out.println("转换为字符串类型：" + (a+b).toString());
	}

	//日期类
	public static void DateDemo() {
		//获取当前日期
		Date d = new Date();

		// 调用SimpleDateFormat类，初始化日期时间格式
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//调用SimpleDateFormat 类的 format方法，格式化日期
		System.out.println(sdf1.format(d));
		System.out.println(sdf2.format(d));
		System.out.println(sdf3.format(d));
	}
	
	//日期类，推荐
	public static void DateDemo2() {

		// 调用Calendar类的getInstance方法，获取当前时间
		Calendar c= Calendar.getInstance();

		//获取年份
		int year = c.get(Calendar.YEAR);
		//获取月份
		int month = c.get(Calendar.MONTH);
		//获取日
		int day = c.get(Calendar.DAY_OF_MONTH);
		//获取小时
		int hour = c.get(Calendar.HOUR_OF_DAY);
		//获取分钟
		int minute = c.get(Calendar.MINUTE);
		//获取秒数
		int second = c.get(Calendar.SECOND);
			

		//打印输出
		System.out.print(year + "-");
		System.out.print(month + "-");
		System.out.print(day + " ");
		System.out.print(hour + ":");
		System.out.print(minute + ":");
		System.out.println(second);
	}
	
	//数值操作类
	public static void MathDemo() {
		System.out.println("四舍五入：" + Math.round(26.53));
		System.out.println("返回小于26.53的最大整数：" + Math.floor(26.53));
		System.out.println("返回大于26.53的最小整数：" + Math.ceil(26.53));
		System.out.println("随机返回 0到1之间的浮点数：" + Math.random());
	}

	
}
