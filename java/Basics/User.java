package Basics;

public class User {

	// 用户信息
	public int id;
	public String username;
	public int level;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//get set方法
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// 重写equals方法
	public boolean equals(Object obj) { // 重写equals方法
		// 如果为同一对象的不同引用,则相同
		if (this == obj) {
			return true;
		}
		// 如果传入的对象为空,则返回false
		if (obj == null) {
			return false;
		}
		// 如果两者属于不同的类型,不能相等
		if (getClass() != obj.getClass()) {
			return false;
		}

		// 比较内容是否相等
		User other = (User) obj;
		if (id != other.id) {
			return false;
		}
		if (username != other.username) {
			return false;
		}
		if (level != other.level) {
			return false;
		}
		return true; // 默认返回true，两个对象相等
	}

}
