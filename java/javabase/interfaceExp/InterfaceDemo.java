package interfaceExp;

//�ӿڲ���
public class InterfaceDemo implements demo_one,demo_two{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//����ӿڵķ���
	public String toString1(String str) {
		return str;
	}
	
	//����ӿڵķ���
	public String toString2(String str) {
		return str;
	}
	
	public InterfaceDemo() {
		//��ӡ�ӿڶ���õ�����
		System.out.println(this.str1+this.str2);
		//��ӡ�ӿڶ���õķ���
		System.out.println(this.toString1("hello")+this.toString2(" world2"));
	}

}
