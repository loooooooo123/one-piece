package JDBCDemo;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

//��̬sql���ִ�����ӡ���login��½��ȫ����
public class Login {

	public static void main(String[] args) throws Exception {
		//��½��֤�����û�����' OR '1=1�󣬾Ͳ�����©���������½��
		loginRex("��ķɭ","222fdfasdf' OR '1=1");
	}
	
	//��½��֤
	public static void loginRex(String username,String password) throws Exception{
		Connection con = Conn.getMySQLCon();
		java.sql.Statement st = con.createStatement();
		
		String sql1="select * from  users where username='"+username+"' and password='"+password+"'";
		
		ResultSet rs = st.executeQuery(sql1);
		
		if(rs.next()) {
			System.out.println("��½�ɹ�");
		}else{
			System.out.println("��½ʧ��");
		}
	}

}
