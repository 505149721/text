package hnuc.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hnuc.cn.entity.User;
import hnuc.cn.service.Userserviceimp;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Userserviceimp us;
	public LoginServlet() {
		us=new Userserviceimp();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User u=us.findUserByLogin(new User(username,password));
		PrintWriter out=resp.getWriter();
		if(u!=null) {
			req.getSession().setAttribute("username", u.getUsername());
			out.print("<script>alert('恭喜你登陆成功！');location.href='main.jsp'</script>");
		}else {
			out.print("<script>alert('密码或用户名错误！');history.back</script>");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
