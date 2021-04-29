package hnuc.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Basedao {
//ʵ�ֻ�������ɾ�Ĳ����
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

//	����ɾ����
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
//	��
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
//	�ر���Դ
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
				System.out.println("----��Դ�رճɹ�----");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
