package hnuc.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Helloservlet implements Servlet{

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("�����ʼ��");
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println("UserName:"+username+"---->password:"+password);
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out= res.getWriter();
		out.print("<h3>"+username+",��ã�</h3>");
		out.print("<br>");
		out.print("<font>����һ����ѧ������ƽ̨</font>");
	}
	@Override
	public void destroy() {
		System.out.println("�����˷���");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}



}
