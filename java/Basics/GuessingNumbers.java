package Basics;

import java.util.*;

public class GuessingNumbers {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//获取控制台的用户输入
        Scanner input = new Scanner(System.in);
        //产生随机数
        int number = (int) (Math.random() * 100);
        //用户猜的数字
        int guess;
        //猜测次数
        int count = 0;
        
        //初始化打印提示信息
        System.out.println("我心里有一个0到99之间的整数，你猜是什么？");
        
        // 用户猜测随机数
        do {
        	//获取控制台的用户输入
            guess = input.nextInt();
            
            //判断猜测结果
            if (number < guess) {
                System.out.println("大了点，再猜！");
                count++;
            } else if (number > guess) {
                System.out.println("小了点，再猜！");
                count++;
            } else {
                count++;
                break;
            }
        } while (guess!=number);	//用于输入=随机数，猜对了
        
        //打印猜测结果
         System.out.println("这个数字是"+number);
         System.out.println("您猜的次数是"+count);
         
        // 根据猜测次数给出评价
        if (count == 3) {
        	System.out.println("恭喜你获得最佳蒙神奖！");
        } else if (count >= 4 && count <= 8) {
        	System.out.println("不错，不错，再接再厉！");
        } else {
        	System.out.println("你太笨了，小学僧吗！");
        }

	}
	
}
