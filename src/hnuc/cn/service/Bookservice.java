package hnuc.cn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import hnuc.cn.dao.Bookdao;
import hnuc.cn.entity.Author;
import hnuc.cn.entity.Book;
import hnuc.cn.util.DBHelper;
import hnuc.cn.util.Page;

public class Bookservice {
	private Bookdao bd;

	public Bookservice() {
		bd=new Bookdao();
	}
	
//	增
	public int doAdd(Book book) {
		Connection conn;
		try {
			conn = DBHelper.getConn();
			return bd.doadd(conn, book);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		 return 0 ;							
	}
//	删
	public int doDel(String ISBN) {
		Connection conn;
		try {
			conn = DBHelper.getConn();
			return bd.doDel(conn, ISBN);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		 return 0 ;							
	}
//	改
	public int doUpdate(Book book) {
		Connection conn;
		try {
			conn = DBHelper.getConn();
			return bd.doUpdate(conn, book);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		 return 0 ;							
	}
//	查
//	查出所有作者
	public List<Author> findAuthors() {
		ArrayList<Author> list=new ArrayList<Author>();
		Connection conn;
		try {
			conn = DBHelper.getConn();
			ResultSet rs=bd.selectAuthors(conn);
			while(rs.next()) {
				Integer author_id=rs.getInt("author_id");
				String name=rs.getString("name");
				list.add(new Author(author_id,name));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		return list;
		
	}
//	通过ISBN查询一本书的信息	
	public Book findDetail(String ISBN) {
		Connection conn;
		try {
			conn = DBHelper.getConn();
			ResultSet rs=bd.selectDetail(conn,ISBN);
			while(rs.next()) {
				String ISBN1=rs.getString("books.ISBN");
				String title=rs.getString("books.title");
				String publisher=rs.getString("books.publisher");
				String category=rs.getString("books.category");
				int author_id=rs.getInt("books.author_id");
				return new Book(ISBN1,title,new Author(author_id),publisher,category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		return null;
		
	}
//	通过Page对象分页查询书籍信息
	public Page<Book> findBooksByPage(Page<Book> page) {
		ArrayList<Book> list=new ArrayList<Book>();
		Connection conn;
		try {
			conn = DBHelper.getConn();
			Integer count=bd.selectBooksCount(conn);
			ResultSet rs=bd.selectBooksByPage(conn, page);
			while(rs.next()) {
				String ISBN=rs.getString("books.ISBN");
				String title=rs.getString("books.title");
				String publisher=rs.getString("books.publisher");
				String category=rs.getString("books.category");
				int author_id=rs.getInt("books.author_id");
				String name=rs.getString("authors.name");
				list.add(new Book(ISBN,title,new Author(author_id,name),publisher,category));
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
