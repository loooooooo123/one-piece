package listMapSetExp;

import java.util.HashMap;

/*
 * 使用map集合统计一个字符串中每个字符出现的次数
 * 
 * 步骤如下：
 * 1.定义一个需要被统计的字符串
 * 2.将字符串转换为数组
 * 3.定义双列集合，存储字符串中字符一级字符出现的次数
 * 4.遍历字符数组获取每一个字符，并将字符存储在双列集合中
 * 5.存储过程中要做判断，如果集合中不包含这个键，就将字符当作键，值为1存储，
 *   如果集合中包含这个键，就将值加1存储
 * 6.打印双列集合获取字符串出现的次数
 * 
 * */
public class mapCountString {

	public static void main(String[] args) {
		
		//1.定义一个需要被统计的字符串
		String str = "aabbbccccddddddddddeeeeedaffffff";
		
		//2.将字符串转换为数组
		char[] arr = str.toCharArray();
		
		//3.定义双列集合，存储字符串中字符一级字符出现的次数
		HashMap<Character,Integer> hm = new HashMap<>();
		
		//4.遍历字符数组获取每一个字符，并将字符存储在双列集合中
		for(char c:arr) {
			//5.存储过程中要做判断，如果集合中不包含这个键，就将字符当作键，值为1存储，
			hm.put(c, !hm.containsKey(c)?1:hm.get(c)+1);
		}
		
		//6.打印双列集合获取字符串出现的次数
		for(Character key : hm.keySet()) {	//hm.keySet()所有键集合
			//hm.get(key)根据键获取值
			System.out.println(key + "=" + hm.get(key));
		}
		
	}

}
