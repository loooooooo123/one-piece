package JDBCDemo;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

//静态sql语句执行例子——login登陆安全问题
public class Login {

	public static void main(String[] args) throws Exception {
		//登陆验证，当用户输入' OR '1=1后，就产生了漏洞，任意登陆了
		loginRex("汤姆森","222fdfasdf' OR '1=1");
	}
	
	//登陆验证
	public static void loginRex(String username,String password) throws Exception{
		Connection con = Conn.getMySQLCon();
		java.sql.Statement st = con.createStatement();
		
		String sql1="select * from  users where username='"+username+"' and password='"+password+"'";
		
		ResultSet rs = st.executeQuery(sql1);
		
		if(rs.next()) {
			System.out.println("登陆成功");
		}else{
			System.out.println("登陆失败");
		}
	}

}
