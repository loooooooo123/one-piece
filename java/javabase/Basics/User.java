package Basics;

public class User {

	// �û���Ϣ
	public int id;
	public String username;
	public int level;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//get set����
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

	// ��дequals����
	public boolean equals(Object obj) { // ��дequals����
		// ���Ϊͬһ����Ĳ�ͬ����,����ͬ
		if (this == obj) {
			return true;
		}
		// �������Ķ���Ϊ��,�򷵻�false
		if (obj == null) {
			return false;
		}
		// ����������ڲ�ͬ������,�������
		if (getClass() != obj.getClass()) {
			return false;
		}

		// �Ƚ������Ƿ����
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
		return true; // Ĭ�Ϸ���true�������������
	}

}
