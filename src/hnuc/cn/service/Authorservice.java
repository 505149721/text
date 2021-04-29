package hnuc.cn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import hnuc.cn.dao.Authordao;
import hnuc.cn.entity.Author;
import hnuc.cn.util.DBHelper;
import hnuc.cn.util.Page;

public class Authorservice {
	private Authordao bd;

	public Authorservice() {
		super();
		bd=new Authordao();
	}
//	��
	public int doAdd(Author a) {
		Connection conn;
		try {
			conn = DBHelper.getConn();
			return bd.doadd(conn, a);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		 return 0 ;							
	}
//	ɾ
	public int doDel(int a_id) {
		Connection conn;
		try {
			conn = DBHelper.getConn();
			return bd.doDel(conn, a_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		 return 0 ;							
	}
//	��
	public int doUpdate(Author a) {
		Connection conn;
		try {
			conn = DBHelper.getConn();
			return bd.doUpdate(conn, a);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		 return 0 ;							
	}
//	��
//	ͨ��author_id��ѯһλ���ߵ���Ϣ	
	public Author findDetail(int a_id) {
		Connection conn;
		try {
			conn = DBHelper.getConn();
			ResultSet rs=bd.selectDetail(conn,a_id);
			while(rs.next()) {
				String name=rs.getString("name");
				String brief=rs.getString("brief");
				return new Author(a_id,name,brief);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		return null;
		
	}
//	ͨ��Page�����ҳ��ѯ������Ϣ
	public Page<Author> findAuthorsByPage(Page<Author> page) {
		ArrayList<Author> list=new ArrayList<Author>();
		Connection conn;
		try {
			conn = DBHelper.getConn();
			Integer count=bd.selectAuthorsCount(conn);
			ResultSet rs=bd.selectAuthorsByPage(conn, page);
			while(rs.next()) {
				int author_id=rs.getInt("author_id");
				String name=rs.getString("name");
				String brief=rs.getString("brief");
				list.add(new Author(author_id,name,brief));
			}
			page.setList(list);
			page.setTotalCount(count);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		return page;
		
	}
	
}
