package Basics;

//�����ֵ����Сֵ��ð������
public class MaxMinSortDemo {

	public static void main(String[] args) {
		
		double sort[]={55,879.55,12,95,1.2,96.76};      //��������
		
		//�����ֵ
		System.out.println("��������ֵΪ��"+maxFn(sort));
		//����Сֵ
		System.out.println("��������ֵΪ��"+minFn(sort));
		
		//ð������
		System.out.println("����ð�������");
	    for(int  x=0;x<sortFn(sort).length;x++){
	    	System.out.println(sortFn(sort)[x]); 
	    }
		
	}
	
	//�����ֵ
	public static double maxFn(double[] arr) {
		
		double max=0;   //��ʼ�����ֵ
		
		max=arr[0];        //������ĵ�һ��ֵװ��max��min��
		for(int x=0;x<arr.length;x++){     //����ÿ������Ԫ��
		  if(arr[x]>max){
		     max=arr[x];     //�����ǰԪ�ش���max�����¸�ֵ
		  }
		}
		
		return max;
		
	}
	
	//����Сֵ
	public static double minFn(double[] arr) {
		
		double min=0;   //��ʼ�����ֵ
		
		min=arr[0];        //������ĵ�һ��ֵװ��max��min��
		for(int x=0;x<arr.length;x++){     //����ÿ������Ԫ��
		  if(arr[x]<min){
			 min=arr[x];     //�����ǰԪ�ش���max�����¸�ֵ
		  }
		}
		
		return min;
		
	}
	
	//ð������
	public static double[] sortFn(double[] arr) {
	     for(int j=1;j<arr.length;j++){   //�ӵ�2�±꿪ʼѭ��
	       for(int i=0;i<arr.length;i++){   //�ӵ�1�±꿪ʼѭ��
	         if (arr[i]>arr[j]){   //����±�1��ֵ�����±�2��ֵ
	        	double temp=arr[i];
	            arr[i]=arr[j];      //����λ��
	            arr[j]=temp;      
	            /*����λ�ã���Ϊ����sort[i]=sort[j] �Ѿ��������ı���sort[i]��ֵ����������sort[i] �ˣ���temp���������sort[i]��ֵ��û�иı�*/
	         }
	       }
	     }
	     
	     return arr;
	}
	//��ʾ��Ҳ����ʹ��java�ṩ��sort������������java.util.Arrays.sort(arr);

}
