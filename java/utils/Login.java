package utils;

/*
 * �������ģʽ
 * 
 * ʵ�ֹ��ܣ�
 * 1����������������Ը������newʵ������
 * 2���ڸ��ഴ��һ�������ʵ����
 * 3�������ṩһ��������������������Ի�ȡ�ö���
 * 
 * ʵ�ֹ��̣�
 * 1��˽�л�����Ĺ��캯����
 * 2��ͨ��new�ڱ����д���һ������Ķ���
 * 3������һ�����з�����return ����Ķ��󣬹������á�
*/
public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//��½token
	private String token = "111111";

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	//˽�л�����Ĺ��캯��
	static Login L = new Login();

	 //����˽�й��캯��
	private Login() {
		System.out.println("��ӭ���뱾ϵͳ");
	}

	//����һ�����з�����return ����Ķ��󣬹�������
	public static Login getInstance() {
		return L; // ���� L����
	}

}
