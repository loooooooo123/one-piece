package JDBCDemo;

//����mysql������
import java.sql.ResultSet;

//�������ݿ�sql������
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;
//�����Զ���Mysql������
import JDBCDemo.Conn;

//JDBC����prepareStatement ��ɾ�Ĳ�����
public class PrepareStatement_demo {

	public static void main(String[] args) throws Exception {

		//�򵥲�ѯ
		selectDemo();

		//�����¼
		Users user = new Users("����","121212",22,"��","��Ϊ������");
		insetRow1(user);
		
		//���¼�¼
		user.setUsername("��ķɭ");
		user.setAge(29);
		user.setId(1);
		updateRow1(user);
		
		//ɾ����¼
		deleteRow1(11);
		
	}

	//��ѯ
	public static void selectDemo() throws Exception {

		// ʵ�������ݿ����Ӷ���
		Connection con = Conn.getMySQLCon();

		// sql���
		String sql1 = "select * from users";

		// Ԥ����sql���
		PreparedStatement select1 = (PreparedStatement) Conn.getMySQLCon().prepareStatement(sql1);

		// ��ȡ�����
		ResultSet rs = select1.executeQuery();

		// ѭ����������
		while (rs.next()) {
			// �õ����ֶε�ֵ
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getString("age"));
			System.out.println(rs.getString("sex"));
			System.out.println(rs.getString("job"));
			System.out.println("��������������������������������");
		}

		// �ر����ݿ����
		con.close();

	}
	
	/*�����¼
	 * @param javaBean�����emp����
	 * @return boolean	Ϊtrue��ʾ�ɹ�
	 * */
	public static boolean insetRow1(Users user) throws Exception{
		
		boolean result = false;		//�洢����ļ�¼����
		
		Connection con = Conn.getMySQLCon();
		
		//����sql���
		String sql = "insert into users(username,password,age,sex,job) values(?,?,?,?,?)";
		
		//Ԥ����sql���
		PreparedStatement insert = (PreparedStatement) Conn.getMySQLCon().prepareStatement(sql);
		
		/* ��ʼ�������� */
		//���õ�1�� ? ����λ�ô��Ĳ���ֵ
		insert.setString(1,user.getUsername() );
		//���õ�2�� ? ����λ�ô��Ĳ���ֵ
		insert.setString(2, user.getPassword());
		//���õ�3�� ? ����λ�ô��Ĳ���ֵ
		insert.setInt(3, user.getAge());
		//���õ�4�� ? ����λ�ô��Ĳ���ֵ
		insert.setString(4, user.getSex());
		//���õ�5�� ? ����λ�ô��Ĳ���ֵ
		insert.setString(5, user.getJob());
		
		//��ȡ����ĳɹ���¼��
		int a = insert.executeUpdate();
		
		//�����¼��Ϊ1��������ʾ�ɹ���ӣ�����true
		if(a==1){
			result = true;
		}
		
		//�ر����ݿ�
		con.close();
		
		//���ز���ĳɹ���¼��
		return result;
	}
	
	//���¼�¼
	public static boolean updateRow1(Users user) throws Exception{
		
		boolean result = false;		//�洢���µļ�¼����
		
		//������ݿ�����
		Connection con1 = new Conn().getMySQLCon();
		
		//����sql���
		String str1 = "UPDATE users SET username=?,age=? WHERE id=?";
		
		//Ԥ����sql���
		PreparedStatement update1 = (PreparedStatement) con1.prepareStatement(str1);
	
		/* ��ʼ�������� */
		//���õ�1�� ? ����λ�ô��Ĳ���ֵ
		update1.setString(1,user.getUsername());
		//���õ�2�� ? ����λ�ô��Ĳ���ֵ
		update1.setInt(2, user.getAge());
		//���õ�3�� ? ����λ�ô��Ĳ���ֵ
		update1.setInt(3, user.getId());
		
		//��ȡ����ĳɹ���¼��
		int a = update1.executeUpdate();
		
		//�����¼��Ϊ1��������ʾ�ɹ���ӣ�����true
		if(a==1){
			result = true;
		}
	
		//�ر����ݿ�
		con1.close();
		
		//���ظ��³ɹ��ļ�¼��
		return result;
	}
	
	//ɾ����¼
	public static boolean deleteRow1(int did) throws Exception{
		
		boolean result = false;		//�洢ɾ���ļ�¼����
		
		//������ݿ�����
		Connection con1 = new Conn().getMySQLCon();
		
		//����sql���
		String str1 = "DELETE FROM users WHERE id=?";
		
		//Ԥ����sql���
		PreparedStatement del1 = (PreparedStatement) con1.prepareStatement(str1);
	
		/* ��ʼɾ������ */
		//���õ�1�� ? ����λ�ô��Ĳ���ֵ
		del1.setInt(1, did);
		
		//��ȡɾ���ĳɹ���¼��
		int a = del1.executeUpdate();
		
		//�����¼��Ϊ1��������ʾ�ɹ�ɾ��������true
		if(a==1){
			result = true;
		}
	
		//�ر����ݿ�
		con1.close();
		
		//����ɾ���ɹ��ļ�¼��
		return result;
	}

}
