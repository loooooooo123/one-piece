package Basics;

import java.util.*;

public class GuessingNumbers {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//��ȡ����̨���û�����
        Scanner input = new Scanner(System.in);
        //���������
        int number = (int) (Math.random() * 100);
        //�û��µ�����
        int guess;
        //�²����
        int count = 0;
        
        //��ʼ����ӡ��ʾ��Ϣ
        System.out.println("��������һ��0��99֮��������������ʲô��");
        
        // �û��²������
        do {
        	//��ȡ����̨���û�����
            guess = input.nextInt();
            
            //�жϲ²���
            if (number < guess) {
                System.out.println("���˵㣬�ٲ£�");
                count++;
            } else if (number > guess) {
                System.out.println("С�˵㣬�ٲ£�");
                count++;
            } else {
                count++;
                break;
            }
        } while (guess!=number);	//��������=��������¶���
        
        //��ӡ�²���
         System.out.println("���������"+number);
         System.out.println("���µĴ�����"+count);
         
        // ���ݲ²������������
        if (count == 3) {
        	System.out.println("��ϲ����������񽱣�");
        } else if (count >= 4 && count <= 8) {
        	System.out.println("���������ٽ�������");
        } else {
        	System.out.println("��̫���ˣ�Сѧɮ��");
        }

	}
	
}
