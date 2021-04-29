<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="hnuc.cn.entity.Book"%>
    <%@ page import="hnuc.cn.entity.Author"%>
    <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>for_edit</title>
</head>
<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css"></link>
<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript"></script>
<style type="text/css">
</style>
<body>
<%Book book=(Book)request.getAttribute("book"); 
 List<Author> alist =(List<Author>)request.getAttribute("alist");
%>
<form id="myform" class="form-horizontal" action="../books/BookServlet?op=doedit" method="post">
  <div class="form-group">
    <label class="col-sm-2 control-label">ISBN</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="ISBN" value="<%=book.getISBN()%>" readonly>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">书名</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="title" value="<%=book.getTitle()%>">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">作者</label>
    <div class="col-sm-2">
      <select class="form-control" name="author_id">
      <%for(Author a:alist){
    	  if(book.getAuthor().getAuthor_id()==a.getAuthor_id()){%>
    		  <option value="<%=a.getAuthor_id()%>" selected="selected"> <%=a.getName()%> </option>
    	 <%} else{%> 
        <option value="<%=a.getAuthor_id()%>"><%=a.getName() %></option>
        <%} }%>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">出版社</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="publisher" value="<%=book.getPublisher()%>">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">类目</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="category" value="<%=book.getCategory()%>">
    </div>
  </div>
</form>
</body>
</html>