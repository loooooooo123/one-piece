package Basics;
import java.util.Arrays;

//���� �̳� ����
public class ChildClass extends ParentClass {
	
	public ChildClass(){
		
		//ʹ��super���ø��๹�췽��
		super("come on baby");
		
		//ʹ��this���ø����Ա
		System.out.println(this.num);
		//ʹ��super���ø����Ա
		System.out.println(super.username);
		
		//��ȡ���ܱ��̳еĳ�Ա �ᱨ��
		//System.out.println(this.sex);
		
		for(String a:this.list1()) {
			System.out.println(a);
		}
		
		for(String a:this.list2()) {
			System.out.println(a);
		}
		
		//��ȡ���ܱ��̳еĳ�Ա �ᱨ��
		//System.out.println(this.list3());
		
		//���ܸı丸�������ֵ ��Ϊ������final �ᱨ��
		//this.hello = "go go go";
	}

	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
	}

}
