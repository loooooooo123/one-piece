package JDBCDemo;

//导入mysql工具类
import java.sql.ResultSet;

//导入数据库sql操作类
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;
//导入自定义Mysql操作类
import JDBCDemo.Conn;

//JDBC——prepareStatement 增删改查例子
public class PrepareStatement_demo {

	public static void main(String[] args) throws Exception {

		//简单查询
		selectDemo();

		//插入记录
		Users user = new Users("哈哈","121212",22,"男","行为艺术家");
		insetRow1(user);
		
		//更新记录
		user.setUsername("汤姆森");
		user.setAge(29);
		user.setId(1);
		updateRow1(user);
		
		//删除记录
		deleteRow1(11);
		
	}

	//查询
	public static void selectDemo() throws Exception {

		// 实例化数据库连接对象
		Connection con = Conn.getMySQLCon();

		// sql语句
		String sql1 = "select * from users";

		// 预编译sql语句
		PreparedStatement select1 = (PreparedStatement) Conn.getMySQLCon().prepareStatement(sql1);

		// 获取结果集
		ResultSet rs = select1.executeQuery();

		// 循环输出结果集
		while (rs.next()) {
			// 拿到各字段的值
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getString("age"));
			System.out.println(rs.getString("sex"));
			System.out.println(rs.getString("job"));
			System.out.println("————————————————");
		}

		// 关闭数据库操作
		con.close();

	}
	
	/*插入记录
	 * @param javaBean定义的emp对象
	 * @return boolean	为true表示成功
	 * */
	public static boolean insetRow1(Users user) throws Exception{
		
		boolean result = false;		//存储插入的记录数量
		
		Connection con = Conn.getMySQLCon();
		
		//设置sql语句
		String sql = "insert into users(username,password,age,sex,job) values(?,?,?,?,?)";
		
		//预编译sql语句
		PreparedStatement insert = (PreparedStatement) Conn.getMySQLCon().prepareStatement(sql);
		
		/* 开始插入数据 */
		//设置第1个 ? 符号位置处的参数值
		insert.setString(1,user.getUsername() );
		//设置第2个 ? 符号位置处的参数值
		insert.setString(2, user.getPassword());
		//设置第3个 ? 符号位置处的参数值
		insert.setInt(3, user.getAge());
		//设置第4个 ? 符号位置处的参数值
		insert.setString(4, user.getSex());
		//设置第5个 ? 符号位置处的参数值
		insert.setString(5, user.getJob());
		
		//获取插入的成功记录数
		int a = insert.executeUpdate();
		
		//如果记录数为1条，即表示成功添加，返回true
		if(a==1){
			result = true;
		}
		
		//关闭数据库
		con.close();
		
		//返回插入的成功记录数
		return result;
	}
	
	//更新记录
	public static boolean updateRow1(Users user) throws Exception{
		
		boolean result = false;		//存储更新的记录数量
		
		//获得数据库链接
		Connection con1 = new Conn().getMySQLCon();
		
		//设置sql语句
		String str1 = "UPDATE users SET username=?,age=? WHERE id=?";
		
		//预编译sql语句
		PreparedStatement update1 = (PreparedStatement) con1.prepareStatement(str1);
	
		/* 开始插入数据 */
		//设置第1个 ? 符号位置处的参数值
		update1.setString(1,user.getUsername());
		//设置第2个 ? 符号位置处的参数值
		update1.setInt(2, user.getAge());
		//设置第3个 ? 符号位置处的参数值
		update1.setInt(3, user.getId());
		
		//获取插入的成功记录数
		int a = update1.executeUpdate();
		
		//如果记录数为1条，即表示成功添加，返回true
		if(a==1){
			result = true;
		}
	
		//关闭数据库
		con1.close();
		
		//返回更新成功的记录数
		return result;
	}
	
	//删除记录
	public static boolean deleteRow1(int did) throws Exception{
		
		boolean result = false;		//存储删除的记录数量
		
		//获得数据库链接
		Connection con1 = new Conn().getMySQLCon();
		
		//设置sql语句
		String str1 = "DELETE FROM users WHERE id=?";
		
		//预编译sql语句
		PreparedStatement del1 = (PreparedStatement) con1.prepareStatement(str1);
	
		/* 开始删除数据 */
		//设置第1个 ? 符号位置处的参数值
		del1.setInt(1, did);
		
		//获取删除的成功记录数
		int a = del1.executeUpdate();
		
		//如果记录数为1条，即表示成功删除，返回true
		if(a==1){
			result = true;
		}
	
		//关闭数据库
		con1.close();
		
		//返回删除成功的记录数
		return result;
	}

}
