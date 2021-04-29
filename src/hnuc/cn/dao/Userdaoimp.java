package hnuc.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import hnuc.cn.entity.User;

public class Userdaoimp extends Basedao implements Userdao{

	@Override
	public ResultSet selectUserByLogin(Connection conn, User u) throws SQLException {
		String sql="select * from user where username= ? and password = ?";
		
		return super.select(conn, sql, u.getUsername(),u.getPassword());
	}

}
