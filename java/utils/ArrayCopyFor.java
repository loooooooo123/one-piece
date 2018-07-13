package utils;
import java.util.*;

public class ArrayCopyFor {

	public static void main(String[] args) {
		
		String[] str = {"tom","jick","yohan"};
		
		//foreach遍历
		System.out.println("复制一定数量的数组：");
		for(String v:arrCopyCount(str)) {
			System.out.println(v);
		}
		
		//foreach遍历
		System.out.println("复制指定范围内的数组：");
		for(String v:arrCopyAny(str)) {
			System.out.println(v);
		}
		
	}
	
	//复制一定数量的数组
	public static String[] arrCopyCount(String[] str) {
		//复制2个元素
		String[] newstr = Arrays.copyOf(str ,2);
		return newstr;
	}
	
	//复制指定范围内的数组，不包含开始和结尾下标处的元素
	public static String[] arrCopyAny(String[] str) {
		//复制开始下标到结束下标之间的元素
		String[] newstr = Arrays.copyOfRange(str,1,2);
		return newstr;
	}

}
