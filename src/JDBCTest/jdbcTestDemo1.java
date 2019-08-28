package JDBCTest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class jdbcTestDemo1 {

	public static void main(String[] args) {
		//导入jar包后注册驱动,使用什么驱动连接数据库
		try {
			//后面不带.class
			Class.forName("com.mysql.jdbc.Driver");
			//url为固定写法  此处填写的是本机本地地址
			String url = "jdbc:mysql://localhost:3306/web01";
			//指定该url使用utf8编码
//			String url = "jdbc:mysql://localhost:3306/web01?useUnicode=true&characterEncoding=UTF8";
			String user = "root";
			String password = "123456";
			//建立数据库的连接
		Connection con =  DriverManager.getConnection(url, user, password);
		
		//发起请求
		Statement st = con.createStatement();
		//查询语句
		ResultSet result = st.executeQuery("select * from user");
		while(result.next())
		{
			//按一行来打印id 名字 密码
			System.out.println(result.getInt(1)+","+result.getString(2)+","+result.getString(3));
		}
		//先关闭语句再关闭连接
		if(result!=null)
			result.close();
		if(st!=null)
			result.close();
		if(con!=null)
			con.close();
		} catch (Exception e) {
			System.out.println("注册失败，找不到该驱动");
			e.printStackTrace();
		} 

	}

}
