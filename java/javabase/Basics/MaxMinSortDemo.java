package Basics;

//求最大值，最小值，冒泡排序
public class MaxMinSortDemo {

	public static void main(String[] args) {
		
		double sort[]={55,879.55,12,95,1.2,96.76};      //创建数组
		
		//求最大值
		System.out.println("数组的最大值为："+maxFn(sort));
		//求最小值
		System.out.println("数组的最大值为："+minFn(sort));
		
		//冒泡排序
		System.out.println("数组冒泡排序后：");
	    for(int  x=0;x<sortFn(sort).length;x++){
	    	System.out.println(sortFn(sort)[x]); 
	    }
		
	}
	
	//求最大值
	public static double maxFn(double[] arr) {
		
		double max=0;   //初始化最大值
		
		max=arr[0];        //将数组的第一个值装进max和min中
		for(int x=0;x<arr.length;x++){     //遍历每个数组元素
		  if(arr[x]>max){
		     max=arr[x];     //如果当前元素大于max则重新赋值
		  }
		}
		
		return max;
		
	}
	
	//求最小值
	public static double minFn(double[] arr) {
		
		double min=0;   //初始化最大值
		
		min=arr[0];        //将数组的第一个值装进max和min中
		for(int x=0;x<arr.length;x++){     //遍历每个数组元素
		  if(arr[x]<min){
			 min=arr[x];     //如果当前元素大于max则重新赋值
		  }
		}
		
		return min;
		
	}
	
	//冒泡排序
	public static double[] sortFn(double[] arr) {
	     for(int j=1;j<arr.length;j++){   //从第2下标开始循环
	       for(int i=0;i<arr.length;i++){   //从第1下标开始循环
	         if (arr[i]>arr[j]){   //如果下标1的值大于下标2的值
	        	double temp=arr[i];
	            arr[i]=arr[j];      //互换位置
	            arr[j]=temp;      
	            /*互换位置，以为上面sort[i]=sort[j] 已经互换而改变了sort[i]的值，不能再用sort[i] 了，而temp变量储存的sort[i]的值并没有改变*/
	         }
	       }
	     }
	     
	     return arr;
	}
	//提示：也可以使用java提供的sort方法进行排序：java.util.Arrays.sort(arr);

}
