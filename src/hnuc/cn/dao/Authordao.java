package hnuc.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import hnuc.cn.entity.Author;
import hnuc.cn.util.Page;

public class Authordao extends Basedao{
//	��
	public int doadd(Connection conn,Author a) throws SQLException {
		String sql="insert authors(author_id,name,brief) values(?,?,?)";
		Object[] objs= {a.getAuthor_id(),a.getName(),a.getBrief()};
		return super.update(conn, sql,objs);
	}
//	ɾ
	public int doDel(Connection conn,int a_id) throws SQLException {
		String sql="delete from authors where author_id="+a_id;
		
		return super.update(conn, sql);
	}
//	��
	public int doUpdate(Connection conn,Author a) throws SQLException {
		String sql="update authors set name=?,brief=? where author_id=?";
		Object[] objs= {a.getName(),a.getBrief(),a.getAuthor_id()};
		return super.update(conn, sql, objs);
	}
//	��
	//������ѯһλ������Ϣ
		public ResultSet selectDetail(Connection conn,int a_id) throws SQLException {
			String sql="select * from authors where author_id=?";
			return super.select(conn, sql,a_id);
		}
	//��ҳ��ѯ������Ϣ
		public  ResultSet selectAuthorsByPage(Connection conn,Page<Author> p) throws SQLException {
			String sql="select * from authors limit ?,?";
			Object []objs= {(p.getCurPage()-1)*p.getPageSize(),p.getPageSize()};
			return super.select(conn, sql,objs);
		}
	//��ѯ��¼����
		public Integer selectAuthorsCount(Connection conn) throws SQLException {
			String sql="select count(*) from authors";
			
			ResultSet rs=super.select(conn, sql);
			Integer count = null;
			while(rs.next()) {
				count= rs.getInt("count(*)");
			}
			return count;
			
		}
	}

