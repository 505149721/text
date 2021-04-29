<%@ page import="hnuc.cn.entity.Book"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css"></link>
<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript"></script>
<style type="text/css">
</style>
<%
List<Book> list=(List<Book>)request.getAttribute("list");
%>
<body>
<table class="table table-striped">
<tr>
<td>ISBN</td>
<td>TITLE</td>
<td>AUTHOR</td>
<td>PUBLISHER</td>
<td>CATAGORY</td>
</tr>
<%for(Book book:list){ %>
<tr>
<td><%=book.getISBN()%></td>
<td><%=book.getTitle()%></td>
<td><%=book.getAuthor().getName()%></td>
<td><%=book.getPublisher()%></td>
<td><%=book.getCategory() %></td>
</tr>
<%} %>
</table>
</body>
</html>