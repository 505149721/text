package hnuc.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hnuc.cn.entity.Author;
import hnuc.cn.entity.Book;
import hnuc.cn.service.Bookservice;
import hnuc.cn.util.Page;
@WebServlet("/books/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Bookservice bs;	
	public BookServlet() {
		super();
		bs=new Bookservice();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String op=req.getParameter("op");
       if(op.equals("readyedit")) {
    	   findDetail(req,resp);
       }else if(op.equals("readyadd")) {
    	   findAuthors(req,resp);
       }else if(op.equals("findallbypage")) {
    	   findBooksByPage(req,resp);
       }else if(op.equals("doedit")) {
    	   updateDetail(req,resp);
       }else if(op.equals("dodel")) {
    	   doDel(req,resp);
       }
       else if(op.equals("doadd")) {
    	   doAdd(req,resp);
       }
	}
	//Ôö
	protected void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		   String ISBN=req.getParameter("ISBN");
		   String title=req.getParameter("title");
		   Integer author_id=Integer.parseInt(req.getParameter("author_id"));
		   String publisher=req.getParameter("publisher");
		   String category=req.getParameter("category");
		   Book book=new Book(ISBN,title,new Author(author_id),publisher,category);
		 
		   PrintWriter out=resp.getWriter();
		   if(bs.doAdd(book)>0) {
			   out.print("<script>alert('¹§Ï²ÄãÌí¼Ó³É¹¦£¡');location.href='books/BookServlet?op=findallbypage&"
			   		+ "curpage=1&pagesize=6'</script>");
		   }else {
			   out.print("<script>alert('±§Ç¸£¬Ìí¼ÓÊ§°Ü£¡');history.back</script>");
		   }
		   
		}
//	É¾
	protected void doDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		   String ISBN=req.getParameter("ISBN");
		   
		   PrintWriter out=resp.getWriter();
		   if(bs.doDel(ISBN)>0) {
			   out.print("<script>alert('¹§Ï²ÄãÉ¾³ý³É¹¦£¡');location.href='../books/BookServlet?op=findallbypage&"
			   		+ "curpage=1&pagesize=6'</script>");
		   }else {
			   out.print("<script>alert('±§Ç¸£¬É¾³ýÊ§°Ü£¡');history.back</script>");
		   }
		   
		}
//	²éµ¥¶À
	protected void findDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		   String ISBN=req.getParameter("ISBN");
		   Book book=bs.findDetail(ISBN);
		   List<Author> alist=bs.findAuthors();
		   req.setAttribute("book", book);
		   req.setAttribute("alist", alist);
		   req.getRequestDispatcher("for_edit.jsp").forward(req, resp);
		}
	protected void findAuthors(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   List<Author> alist=bs.findAuthors();
		   req.setAttribute("alist", alist);
		   req.getRequestDispatcher("for_add.jsp").forward(req, resp);
		}
//	¸Ä
	protected void updateDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		   String ISBN=req.getParameter("ISBN");
		   String title=req.getParameter("title");
		   Integer author_id=Integer.parseInt(req.getParameter("author_id"));
		   String publisher=req.getParameter("publisher");
		   String category=req.getParameter("category");
		   Book book=new Book(ISBN,title,new Author(author_id),publisher,category);
		   
		   PrintWriter out=resp.getWriter();
			if(bs.doUpdate(book)==1) {
				out.print("<script>alert('¹§Ï²ÄãÐÞ¸Ä³É¹¦£¡');location.href='books/BookServlet?op=findallbypage&curpage=1"
						+ "&pagesize=6'</script>");
			}else {
				out.print("<script>alert('±§Ç¸£¬ÐÞ¸ÄÊ§°Ü£¡');history.back</script>");
			}
		}
//	²éÈ«²¿
	protected void findBooksByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer curPage=Integer.parseInt(req.getParameter("curpage"));
		Integer pageSize=Integer.parseInt(req.getParameter("pagesize"));
		Page<Book> page=bs.findBooksByPage(new Page<Book>(curPage,pageSize));
		req.setAttribute("page", page);
		req.getRequestDispatcher("showallbypage.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	

}
