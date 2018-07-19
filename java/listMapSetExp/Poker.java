package listMapSetExp;

import java.util.ArrayList;
import java.util.Collections;

//扑克牌类
public class Poker {

	public static void main(String[] args) {
		
		//发牌
		ArrayList<String> zhangsan = createpoker();	//张三的牌
		ArrayList<String> wangwu = createpoker();	//王五的牌
		ArrayList<String> zhaoliu = createpoker();	//赵六的牌
		
		System.out.println("张三的牌：");
		System.out.println(zhangsan);
		System.out.println("王五的牌：");
		System.out.println(wangwu);
		System.out.println("赵六的牌：");
		System.out.println(zhaoliu);
	}

	
	//生成一副牌，并洗牌
	public static ArrayList<String> createpoker() {
		String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] type = {"红桃","方片","黑桃","梅花"};
		ArrayList<String> arr = new ArrayList();
		
		//开始生成
		for(String v1:num) {
			for(String v2:type) {
				arr.add(v1.concat(v2));	//连接2个字符串
			}
		}
		
		//添加大王小王
		arr.add("小王");
		arr.add("大王");
		
		//System.out.println(arr.size());
		
		//洗牌
		Collections.shuffle(arr);
		
		return arr;
	}

}
