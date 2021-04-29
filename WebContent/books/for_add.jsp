<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="hnuc.cn.entity.Author"%>
    <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>for_add</title>
</head>
<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css"></link>
<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript"></script>
<style type="text/css">
</style>
<body>
<%
 List<Author> alist =(List<Author>)request.getAttribute("alist");
%>
<form id="myform" class="form-horizontal" action="../books/BookServlet?op=doadd" method="post">
  <div class="form-group">
    <label class="col-sm-2 control-label">ISBN</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="ISBN">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">书名</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="title" >
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">作者</label>
    <div class="col-sm-6">
      <select class="form-control" name="author_id">
      <%for(Author a:alist){%> 
        <option value="<%=a.getAuthor_id()%>"><%=a.getName() %></option>
        <%}%>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">出版社</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="publisher" >
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">类目</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="category" >
    </div>
  </div>
</form>
</body>
</html>