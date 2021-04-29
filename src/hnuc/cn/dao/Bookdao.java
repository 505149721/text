package hnuc.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import hnuc.cn.entity.Book;
import hnuc.cn.util.Page;

public class Bookdao extends Basedao {
//	增
	public int doadd(Connection conn,Book book) throws SQLException {
		String sql="insert books(ISBN,title,author_id,publisher,category) values(?,?,?,?,?)";
		Object[] objs= {book.getISBN(),book.getTitle(),book.getAuthor().getAuthor_id(),book.getPublisher(),book.getCategory()};
		return super.update(conn, sql,objs);
	}
//	删
	public int doDel(Connection conn,String ISBN) throws SQLException {
		String sql="delete from books where ISBN="+ISBN;
		
		return super.update(conn, sql);
	}
//	改
	public int doUpdate(Connection conn,Book book) throws SQLException {
		String sql="update books set title=?,author_id=?,publisher=?,category=? where ISBN=?";
		Object[] objs= {book.getTitle(),book.getAuthor().getAuthor_id(),book.getPublisher(),book.getCategory(),book.getISBN()};
		return super.update(conn, sql, objs);
	}
	
//	查
//单独查询一本书信息
	public ResultSet selectDetail(Connection conn,String ISBN) throws SQLException {
		String sql="select * from books where books.ISBN=?";
		return super.select(conn, sql,ISBN);
	}
//查询所有作者
	public ResultSet selectAuthors(Connection conn) throws SQLException {
		String sql="select * from authors";
		return super.select(conn, sql);
	}
//分页查询书籍信息
	public  ResultSet selectBooksByPage(Connection conn,Page<Book> p) throws SQLException {
		String sql="select * from books,authors where books.author_id=authors.author_id limit ?,?";
		Object []objs= {(p.getCurPage()-1)*p.getPageSize(),p.getPageSize()};
		return super.select(conn, sql,objs);
	}
//查询记录条数
	public Integer selectBooksCount(Connection conn) throws SQLException {
		String sql="select count(*) from books";
		
		ResultSet rs=super.select(conn, sql);
		Integer count = null;
		while(rs.next()) {
			count= rs.getInt("count(*)");
		}
		return count;
		
	}
}
