package hnuc.cn.test;

import java.io.IOException;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import hnuc.cn.entity.User;
import hnuc.cn.service.Userservice;
import hnuc.cn.service.Userserviceimp;
import hnuc.cn.util.DBHelper;

public class Jdbctest {
	
	
	public static String getInput() {
		byte []buf=new byte[50];
		try {
			System.in.read(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(buf).trim();
	}
	public static void main(String[] args) {
		Userserviceimp us=new Userserviceimp();
		
		//测试驱动是否加载成功，是否获得连接。
//		try {
//			Connection conn=DBHelper.getConn();
//			System.out.println(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}	
		while(true) {
			System.out.println("输入用户名：");
			String username=getInput();
			System.out.println("请输入密码：");
			String password=getInput();
			
			User u=us.findUserByLogin(new User(username,password));
			if(u!=null) {
				System.out.println("登录成功！");
				System.out.println(u.getId());
			}
			else {
				System.out.println("登录失败！");
			}
		}		
	}
}
