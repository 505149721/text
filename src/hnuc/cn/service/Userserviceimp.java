package hnuc.cn.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import hnuc.cn.dao.Userdaoimp;
import hnuc.cn.entity.User;
import hnuc.cn.util.DBHelper;

public class Userserviceimp implements Userservice {
	private Userdaoimp ud;
	public Userserviceimp() {
		ud=new Userdaoimp();
	}
	@Override
	public User findUserByLogin(User u) {
		
		Connection conn=null;
		try {
			conn=DBHelper.getConn();
			ResultSet rs=ud.selectUserByLogin(conn, u);
			if(rs.next()) {
				int id=rs.getInt("id");
				String username=rs.getString("username");
				String password=rs.getString("password");
				return new User(id,username,password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ud.closeAll();
		}
		return null;
	}
}
