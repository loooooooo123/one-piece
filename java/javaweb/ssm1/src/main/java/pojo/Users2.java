package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//xml格式的pojo类
@XmlRootElement(name = "Users2")
public class Users2 {
	
	private int id;
	private String username;
	private String sex;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//无参构造方法
	public Users2() {
		super();
	}
	
	//有参构造方法
	public Users2(int id,String username,String sex) {
		super();
		
		this.id=id;
		this.username=username;
		this.sex=sex;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	@XmlElement
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Users2 [id=" + id + ", username=" + username + ", sex=" + sex + "]";
	}
	
	

}
