package hnuc.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import hnuc.cn.entity.User;

public interface Userdao {
ResultSet selectUserByLogin(Connection conn,User u) throws SQLException;
}
