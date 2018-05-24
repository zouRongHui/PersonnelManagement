<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员-部门管理</title>
<link rel="stylesheet" type="text/css" href="frame/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="css/manager.css"/>
</head>
<body>
<header>
	<img src="image/logo.png" alt="企业logo" />
	<p id="title">正文科技</p>
	<p id="login">欢迎：<span>${employee.name }</span><a href="loginOut.do" id="btn">注销</a></p>
</header>
<section>
	<ul id="list">
		<li><a href="manager_showEmployee.do">人员信息维护</a></li>
		<li style="border-bottom: 2px solid #ebebeb;"><a href="manager_showDepartment.do">部门管理</a></li>
		<li><a href="manager_showNotice.do">公告管理</a></li>
		<li><a href="manager_showSalary.do">薪资管理</a></li>
		<li><a href="manager_showPosition.do">人员调动</a></li>
	</ul>
	<div class="item" style="display: block;">
		<a href="###" id="addBuMen">新建部门</a>
		<table id="buMen">
			<tr >
				<th>ID</th>
				<th>部门名</th>
				<th>部门经理</th>
				<th>操作</th>
			</tr>
			<c:forEach var="one" items="${departmentList }">
			<tr>
				<td>${one.id }</td>
				<td>${one.name }</td>
				<td>${one.manager.name }</td>
				<td><a href="manager_removeDepartment.do?id=${one.id }" class="cheX">撤销部门</a></td>
			</tr>
			</c:forEach>
		</table>
		<form action="manager_showDepartment.do" id="yeme" method="post">
			共 ${count } 条记录
			<a href="manager_showDepartment.do?pageNumber=${pageNumber - 1 }" id="pre">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			第 ${pageNumber } 页
			<a href="manager_showDepartment.do?pageNumber=${pageNumber + 1 }" id="next">下一页</a>&nbsp;&nbsp;
			共 ${pages } 页&nbsp;&nbsp;
			<input type="submit" value="转跳至">
			<input type="text" name="pageNumber"> 
			页
		</form>
	</div>
	<div id="guanli_bumen">
		<a href="###" class="layui-icon" id="addCloseA1">&#x1006;</a>
		<form action="manager_insertDepartment.do" method="post">
			<label for="bumen_name">部门名:<input type="text" name="name" id="bumen_name"></label>
			<input type="submit" id="bumen_newA" value="新建部门">
		</form>
		<!-- 
		<a href="###" id="bumen_newA">新建部门</a>
		 -->
	</div>
</section>

</body>
<script type="text/javascript" src="frame/jquery-3.1.1.min.js"></script>
<script src="frame/layui/layui.js"></script>
<script>

var addBuMen=document.getElementById("addBuMen");

var addCloseA1=document.getElementById("addCloseA1");

var guanli_bumen=document.getElementById("guanli_bumen");

addBuMen.onclick=function(){
	guanli_bumen.style.display="block";
}

addCloseA1.onclick=function(){
	guanli_bumen.style.display="none";
}

</script>
</html>