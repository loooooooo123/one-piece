package Basics;

//����
public class ParentClass {
	
	public ParentClass(String str){
		System.out.println(str);
	}
	
	//���๫�����ԣ����Ա��̳�
	public int num=100;
	
	//��������ɼ����ԣ����Ա��̳�
	protected String username="��ķ";
	
	//����˽�����ԣ������Ա��̳�
	@SuppressWarnings("unused")
	private String sex="��";
	
	//�����Ըı���ֵ
	final String hello = "hello world";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//���๫�з��������Ա��̳�
	public String[] list1() {
		String[] strlist = {"java�����ŵ���ͨ","php�����ŵ���ͨ","node�����ŵ���ͨ"};
		return strlist;
	}
	
	//��������ɼ����������Ա��̳�
	protected String[] list2() {
		String[] strlist = {"java����","php����","node����"};
		return strlist;
	}
	
	//����˽�����ԣ������Ա��̳�
	@SuppressWarnings("unused")
	private String[] list3() {
		String[] strlist = {"java����","php����","node����"};
		return strlist;
	}

}
