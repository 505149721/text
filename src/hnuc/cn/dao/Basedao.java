package hnuc.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Basedao {
//实现基本的增删改查操作
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

//	增，删，改
	public int update(Connection conn,String sql,Object...objs) throws SQLException {
		this.conn=conn;
		this.ps=(PreparedStatement) conn.prepareStatement(sql);
		if(objs.length>0) {
			for(int i=0;i<objs.length;i++) {
				ps.setObject(i+1, objs[i]);
			}
		}
		return ps.executeUpdate();
	}
//	查
	public ResultSet select(Connection conn,String sql,Object...objs) throws SQLException {
		this.conn=conn;
		this.ps=(PreparedStatement) conn.prepareStatement(sql);
		if(objs.length>0) {
			for(int i=0;i<objs.length;i++) {
				ps.setObject(i+1, objs[i]);
			}
		}
		this.rs=ps.executeQuery();
		return rs;
	}
//	关闭资源
	public void closeAll() {
			try {
				if(rs!=null) {
				rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
				System.out.println("----资源关闭成功----");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
