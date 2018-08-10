package pojo;

//pojo类
public class Users {
	
	private int id;
	private String username;
	private String sex;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//无参构造方法
	public Users() {
		super();
	}
	
	//有参构造方法
	public Users(int id,String username,String sex) {
		super();
		
		this.id=id;
		this.username=username;
		this.sex=sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", sex=" + sex + "]";
	}
	
	

}
