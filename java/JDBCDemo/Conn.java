package JDBCDemo;

//�������ݿ���ص�������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

/*
 * DBC����ʹ��
 * 
 *   	
 ����ʹ�ã�
//ʵ����Conn���ݿ��������
Statement st = new Conn().getQueryCon();

//sql���
String sql1 = "select * from users";

//ִ��sql���
st.executeQuery(sql1);
 * 
 * */
public class Conn {

	private static final String URL="jdbc:mysql://localhost:3306/javatest";
	private static final String NAME="root";
	private static final String PWD="123456";
	
	//�������ݿ�
	public static Connection getMySQLCon() throws Exception{
		Connection con = null;
		
		try{
			//ע������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//��������
			con = DriverManager.getConnection(
					URL,
					NAME,
					PWD
			);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		//����con���ݿ����Ӷ���
		return con;
	}
	
	//���캯���������������ݿ��Ƿ����ӳɹ�
	public static void main(String args[]) throws Exception{
		Connection conn = Conn.getMySQLCon();
		if(conn != null){
			System.out.print("���ݿ����ӳɹ���"+conn.toString());
		}
	}

}
