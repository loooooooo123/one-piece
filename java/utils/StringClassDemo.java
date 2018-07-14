package utils;

//字符串操作类
public class StringClassDemo {

	static String str1 = "Hello World";
	static String str2 = "Come on Baby";
	static String strNew1 = " chi ji ";

	public static void main(String[] args) {

		// 判断2个字符串是否相等
		str1.equals(str2);

		// 字符串转数组
		for (char a : str1.toCharArray()) {
			System.out.println(a);
		}

		// 截取指定下标处字符
		System.out.println(str2.charAt(2));

		// 将str1转换为比特数组
		byte b[] = str1.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]); // 循环输出b[]的每个元素
		}

		// 再将比特数组转换为字符串，转换5个
		String str3 = new String(b, 0, 5);
		System.out.println(str3);

		// 取得字符串长度
		System.out.println(str1.length());

		// 查找指定字符的下标值，从前往后找第一次出现的，下标值从0开始
		System.out.println(str1.indexOf('o'));

		// 查找指定字符的下标值，从后往前找第一次出现的，下标值从0开始
		System.out.println(str1.lastIndexOf('o'));

		// 截取指定下标范围内的字符，不包含结束下标处的字符
		System.out.println(str1.substring(1, 3));

		// 去除首尾空格
		System.out.println(strNew1.trim());

		// 字符串拆分为数组，以空格拆分
		String strSp1[] = str2.split(" ");
		for (int i = 0; i < strSp1.length; i++) {
			System.out.println(strSp1[i]); // 循环输出拆分后的字符串数组每个元素
		}

		// 字符串转大小写
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());

		// 判断是否以指定字符开头
		System.out.println(str1.startsWith("H") ? "是以H开头" : "不以H开头");
		System.out.println(str1.endsWith("a") ? "是以a结尾" : "不以a结尾");

		// 判断2个字符串是否相等，不区分大小写
		System.out.println(str1.equalsIgnoreCase("hello world") ? "相等" : "不相等");

		// 替换字符
		System.out.println(str2.replace('C', 'c'));

		// 向字符串的尾部追加字符，此方法的追加对象，一定要被实例化为StringBuilder的字符串数组才可以使用
		StringBuilder bd1 = new StringBuilder("hello");
		System.out.println(bd1.append(" world"));

		// 向字符串指定下标处追加字符，此方法的追加对象，一定要被实例化为StringBuilder的字符串数组才可以使用
		StringBuilder newbd1 = new StringBuilder("haha");
		System.out.println(newbd1.insert(2, " a "));

		// 删除指定下标范围内的字符，此方法的追加对象，一定要被实例化为StringBuilder的字符串数组才可以使用
		StringBuilder bd2 = new StringBuilder(str1);
		System.out.println(bd2.delete(0, 3));
		
		// 使用split反转字符串（倒序排列字符串）
		System.out.println(split_str(str1));
		
		// 使用charAt反转字符串（倒序排列字符串）
		System.out.println(charAt_str(str2));
	}

	// 使用split反转字符串（倒序排列字符串）
	private static String split_str(String str) {
		String str2[] = str.split(""); // 截取字符串
		String newStr = ""; // 初始化一个字符串容器
		int len = str2.length; // 获取截取后的字符串长度
		for (int i = len - 1; i >= 0; i--) {
			newStr += str2[i]; // newStr字符串等于每次str2[i]的值相加
		}
		return newStr; // 返回最后的newStr
	}

	// 使用charAt反转字符串（倒序排列字符串）
	private static String charAt_str(String str) {
		String newStr = ""; // 初始化一个字符串容器
		int len = str.length(); // 获取截取后的字符串长度
		for (int i = len - 1; i >= 0; i--) {
			// newStr字符串等于每次charAt[i]的值相加
			newStr += str.charAt(i);
		}
		return newStr; // 返回最后的newStr
	}

}
