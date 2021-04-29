package hnuc.cn.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class DBHelper {
	private static String url="jdbc:mysql://localhost:3306/todowhat";
	private static String user="root";
	private static String password="123456";
	
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static Connection getConn() throws SQLException {
		return (Connection) DriverManager.getConnection(url, user, password);
	}
}
