<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="hnuc.cn.entity.Author"%>
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
<%Author au=(Author)request.getAttribute("author"); 
%>
<form id="myform" class="form-horizontal" action="../authors/AuthorServlet?op=doedit" method="post">
<div class="form-group">
    <label class="col-sm-2 control-label">作者编号</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="author_id" value="<%=au.getAuthor_id() %>" readonly>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">作者</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="name" value="<%=au.getName() %>">
    </div>
  </div>
  <div>
    <label class="col-sm-2 control-label">简介</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="brief" value="<%=au.getBrief() %>">
    </div>
  </div>
</form>
</body>
</html>