<%@ page import="hnuc.cn.entity.Book"%>
<%@ page import="hnuc.cn.util.Page"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show all books by page</title>
</head>
<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css"></link>
<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript"></script>
<style type="text/css">
mark{
background-color:#B7CDDE
}
p{
font-family:YouYuan;
}
.mm{
height:340px;
} 
</style>
<%
Page<Book> bpage=(Page<Book>)request.getAttribute("page");//名字报错？
List<Book> list=bpage.getList();
%>
<body>
<table class="table table-hover">
<tr>
<td colspan="6"><a class="btn btn-primary btn-sm" data-toggle="modal" data-target="#addModal" onclick="readyAdd()" >添加图书</a></td>
</tr>
<tr>
<td><strong>书籍编号</strong></td>
<td><strong>书名</strong></td>
<td><strong>作者</strong></td>
<td><strong>出版社</strong></td>
<td><strong>类目</strong></td>
<td><strong>操作</strong></td>
</tr>
<%for(Book book:list){ %>
<tr>
<td><strong><small><%=book.getISBN()%></small></strong></td>
<td><small><%=book.getTitle()%></small></td>
<td><small><%=book.getAuthor().getName()%></small></td>
<td><small><%=book.getPublisher()%></small></td>
<td><small><%=book.getCategory() %></small></td>
<td><a class="glyphicon glyphicon-pencil"  data-toggle="modal" data-target="#editModal" 
    onclick="readyEdit(<%=book.getISBN()%>)"></a>&nbsp;&nbsp;&nbsp;
    <a class="glyphicon glyphicon-remove"  data-toggle="modal" data-target="#delModal"
    onclick="readyDel(<%=book.getISBN()%>)"></a></td>
</tr>
<%} %>
<tr>
<td colspan="6">
<p><a class="btn btn-default btn-sm" href="../books/BookServlet?op=findallbypage&curpage=<%=bpage.getPrePage()%>&pagesize=6"><small>上一页</small></a>
 &nbsp;&nbsp;&nbsp;当前是&nbsp;<mark><em>&nbsp;第<%=bpage.getCurPage() %>页&nbsp;</em></mark> &nbsp;&nbsp;&nbsp;共&nbsp;<mark><em>&nbsp;<%=bpage.getTotalPage() %>&nbsp;</em></mark>&nbsp;页 &nbsp;&nbsp;&nbsp;
<a class="btn btn-default btn-sm" href="../books/BookServlet?op=findallbypage&curpage=<%=bpage.getNextPage()%>&pagesize=6"><small>下一页</small></a></p>
</td>
</tr>
</table>

<!-- 修改 模态框-->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">书目修改</h4>
      </div>
      <div class="modal-body mm">
        <iframe id="edit" src="" width="100%" height="100%" frameborder="0"></iframe>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
        <button type="button" class="btn btn-primary" onclick="doEdit()">确认修改</button>
      </div>
    </div>
  </div>
</div>
<!-- 确认删除模态框 -->
<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-body">
        确认删除此书目吗？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
        <button id="delbt" type="button" class="btn btn-primary" onclick="del()">确认删除</button>
      </div>
    </div>
  </div>
</div>
<!--  添加模态框-->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">书目添加</h4>
      </div>
      <div class="modal-body mm">
        <iframe id="add" src="" width="100%" height="100%" frameborder="0"></iframe>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
        <button type="button" class="btn btn-primary" onclick="doAdd()">确认添加</button>
      </div>
    </div>
  </div>
</div>
</body>
<script>
function readyEdit(ISBN){
 	
	var t=document.getElementById("edit");
	t.src="../books/BookServlet?op=readyedit&ISBN="+ISBN; 
}
function readyDel(ISBN){
	var t=document.getElementById("delbt");
	t.value=ISBN;
}
function readyAdd(){
 	
	var t=document.getElementById("add");
	t.src="../books/BookServlet?op=readyadd"; 
}
function doEdit(){
 	var t=document.getElementById("edit");
 	window.parent.document.getElementById("showall").src="books/BookServlet?op=findallbypage&curpage=<%=bpage.getCurPage() %>&pagesize=6"; 
 	t.contentWindow.document.getElementById("myform").submit();
}
function del(){
	var t=document.getElementById("delbt");
	location.href="../books/BookServlet?op=dodel&ISBN="+t.value;
	
}
function doAdd(){
 	var t=document.getElementById("add");
 	window.parent.document.getElementById("showall").src="books/BookServlet?op=findallbypage&curpage=<%=bpage.getCurPage() %>&pagesize=6"; 
 	t.contentWindow.document.getElementById("myform").submit();
}
</script>
</html>