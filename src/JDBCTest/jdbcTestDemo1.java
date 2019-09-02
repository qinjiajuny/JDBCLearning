package JDBCTest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class jdbcTestDemo1 {

	public static void main(String[] args) {
		selectALL();
		//可以当作登录检验
		System.out.println(selectByUsernamePassword("小红", "234"));
		System.out.println(selectByUsernamePassword("小红", "1234"));
		//sql注入
		System.out.println(selectByUsernamePassword("sfsaf", "fsafsa' or '1'='1"));

	}

	public static void selectALL() {
		//不放在try语句外面作用域无法作用与finally
		Connection con = null;
		Statement st = null;
		ResultSet result = null;  
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
			
		//与数据库建立连接
		 con =  DriverManager.getConnection(url, user, password);
		
		//发起请求
		 st = con.createStatement();
		//查询语句
		 result = st.executeQuery("select * from user");
		while(result.next())
		{
			//逐行来打印id 名字 密码
			//里面的数字是列的索引 数据中的第一列 第二列 第三列
			//两种方式获取 一种索引值 一种是列名
			System.out.println(result.getInt(1)+","+result.getString(2)+","+result.getString(3));
//			System.out.println(result.getString("password")+","+result.getString("username"));
		}
		
		} catch (Exception e) {
			System.out.println("注册失败，找不到该驱动");
			e.printStackTrace();
		} finally {
			//使用该种做法避免前面出错后面不能执行
			//先关闭语句再关闭连接
		
			try {
				if(result!=null)
				result.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			try {
				if(st!=null)
				result.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static boolean selectByUsernamePassword(String username,String password)
	{
		Connection con = null;
		Statement st = null;
		ResultSet result = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/web01";
			 con = DriverManager.getConnection(url, "root", "123456");
			 st = con.createStatement();
			String sql = "select * from user where username='"+username+"'and password = '"+password+"'";
			 result = st.executeQuery(sql);
			 System.out.println(sql);
			if(result.next())
			{
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(result!=null)
				result.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			try {
				if(st!=null)
				result.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return false;
		
		
	}

}
