package listMapSetExp;

import java.util.ArrayList;
import java.util.Collections;

//�˿�����
public class Poker {

	public static void main(String[] args) {
		
		//����
		ArrayList<String> zhangsan = createpoker();	//��������
		ArrayList<String> wangwu = createpoker();	//�������
		ArrayList<String> zhaoliu = createpoker();	//��������
		
		System.out.println("�������ƣ�");
		System.out.println(zhangsan);
		System.out.println("������ƣ�");
		System.out.println(wangwu);
		System.out.println("�������ƣ�");
		System.out.println(zhaoliu);
	}

	
	//����һ���ƣ���ϴ��
	public static ArrayList<String> createpoker() {
		String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] type = {"����","��Ƭ","����","÷��"};
		ArrayList<String> arr = new ArrayList();
		
		//��ʼ����
		for(String v1:num) {
			for(String v2:type) {
				arr.add(v1.concat(v2));	//����2���ַ���
			}
		}
		
		//��Ӵ���С��
		arr.add("С��");
		arr.add("����");
		
		//System.out.println(arr.size());
		
		//ϴ��
		Collections.shuffle(arr);
		
		return arr;
	}

}
