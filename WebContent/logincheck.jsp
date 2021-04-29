<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title >loginWhether</title>
</head>
<body>
<%
Object name=session.getAttribute("username") ;
if(name==null){
	out.print("<script>alert('请先登录！');location.href='login.html'</script>");
}else{
	/*  为何改不了？*/
	out.print("<script>document.getElementByTagName('title').innerHTML='主页'</script>");
}
%>
</body>
</html>