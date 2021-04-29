<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<form id="myform" class="form-horizontal" action="../authors/AuthorServlet?op=doadd" method="post">
  <div class="form-group">
    <label class="col-sm-2 control-label">作者编号</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="author_id">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">作者</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="name" >
    </div>
  </div>
  <div>
    <label class="col-sm-2 control-label">简介</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="brief" >
    </div>
  </div>

</form>
</body>
</html>