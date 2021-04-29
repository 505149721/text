package hnuc.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hnuc.cn.entity.Author;
import hnuc.cn.service.Authorservice;
import hnuc.cn.util.Page;


@WebServlet("/authors/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Authorservice as;
    public AuthorServlet() {
        super();
        as=new Authorservice();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String op=req.getParameter("op");
		if(op.equals("readyedit")) {
	    	   findDetail(req,resp);
	       }else if(op.equals("findallbypage")) {
	    	   findAuthorsByPage(req,resp);
	       }else if(op.equals("doedit")) {
	    	   updateDetail(req,resp);
	       }else if(op.equals("dodel")) {
	    	   doDel(req,resp);
	       }
	       else if(op.equals("doadd")) {
	    	   doAdd(req,resp);
	       }
		
	}
	//增
	protected void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		   
		   Integer author_id=Integer.parseInt(req.getParameter("author_id"));
		   String name=req.getParameter("name");
		   String brief=req.getParameter("brief");
		   Author a=new Author(author_id,name,brief);
		 
		   PrintWriter out=resp.getWriter();
		   if(as.doAdd(a)>0) {
			   out.print("<script>alert('恭喜你添加成功！');location.href='authors/AuthorServlet?op=findallbypage&"
			   		+ "curpage=1&pagesize=6'</script>");
		   }else {
			   out.print("<script>alert('抱歉，添加失败！');history.back</script>");
		   }
		   
		}
//	删
	protected void doDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		   Integer author_id=Integer.parseInt(req.getParameter("author_id"));
		   
		   PrintWriter out=resp.getWriter();
		   if(as.doDel(author_id)>0) {
			   out.print("<script>alert('恭喜你删除成功！');location.href='../authors/AuthorServlet?op=findallbypage&"
			   		+ "curpage=1&pagesize=6'</script>");
		   }else {
			   out.print("<script>alert('抱歉，删除失败！');history.back</script>");
		   }
		   
		}
//	查单独
	protected void findDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		Integer author_id=Integer.parseInt(req.getParameter("author_id"));
		   Author a=as.findDetail(author_id);
		   req.setAttribute("author", a);
		   req.getRequestDispatcher("for_edit.jsp").forward(req, resp);
		}
//	改
	protected void updateDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		   Integer author_id=Integer.parseInt(req.getParameter("author_id"));
		   String name=req.getParameter("name");
		   String brief=req.getParameter("brief");
		   Author a=new Author(author_id,name,brief);
		   
		   PrintWriter out=resp.getWriter();
			if(as.doUpdate(a)>0) {
				out.print("<script>alert('恭喜你修改成功！');location.href='authors/AuthorServlet?op=findallbypage&curpage=1"
						+ "&pagesize=6'</script>");
			}else {
				out.print("<script>alert('抱歉，修改失败！');history.back</script>");
			}
		}
//	查全部
	protected void findAuthorsByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer curPage=Integer.parseInt(req.getParameter("curpage"));
		Integer pageSize=Integer.parseInt(req.getParameter("pagesize"));
		Page<Author> page=as.findAuthorsByPage(new Page<Author>(curPage,pageSize));
		req.setAttribute("page", page);
		req.getRequestDispatcher("showallbypage.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
