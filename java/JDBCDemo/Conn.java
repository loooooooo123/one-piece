package JDBCDemo;

//导入数据库相关的驱动类
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

/*
 * DBC基本使用
 * 
 *   	
 基本使用：
//实例化Conn数据库操作对象
Statement st = new Conn().getQueryCon();

//sql语句
String sql1 = "select * from users";

//执行sql语句
st.executeQuery(sql1);
 * 
 * */
public class Conn {

	private static final String URL="jdbc:mysql://localhost:3306/javatest";
	private static final String NAME="root";
	private static final String PWD="123456";
	
	//链接数据库
	public static Connection getMySQLCon() throws Exception{
		Connection con = null;
		
		try{
			//注册驱动
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//建立连接
			con = DriverManager.getConnection(
					URL,
					NAME,
					PWD
			);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		//返回con数据库连接对象
		return con;
	}
	
	//构造函数，用来测试数据库是否链接成功
	public static void main(String args[]) throws Exception{
		Connection conn = Conn.getMySQLCon();
		if(conn != null){
			System.out.print("数据库链接成功！"+conn.toString());
		}
	}

}
