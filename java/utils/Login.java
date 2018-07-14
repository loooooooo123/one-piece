package utils;

/*
 * 单例设计模式
 * 
 * 实现功能：
 * 1）不允许其他程序对该类进行new实例化。
 * 2）在该类创建一个本类的实例。
 * 3）对外提供一个方法，让其他程序可以获取该对象。
 * 
 * 实现过程：
 * 1）私有化该类的构造函数。
 * 2）通过new在本类中创建一个本类的对象。
 * 3）定义一个共有方法，return 本类的对象，供外界调用。
*/
public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//登陆token
	private String token = "111111";

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	//私有化该类的构造函数
	static Login L = new Login();

	 //定义私有构造函数
	private Login() {
		System.out.println("欢迎进入本系统");
	}

	//定义一个公有方法，return 本类的对象，供外界调用
	public static Login getInstance() {
		return L; // 返回 L对象
	}

}
