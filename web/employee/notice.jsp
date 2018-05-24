<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员   工-企业公告</title>
<link rel="stylesheet" type="text/css" href="css/yuangong.css"/>
</head>
<body>
<header>
	<img src="image/logo.png" alt="企业logo" />
	<p id="title">正文科技</p>
	<p id="login">欢迎：<span>${employee.name }</span><a href="loginOut.do" id="btn">注销</a></p>
</header>
<section>
	<ul id="list">
		<li><a href="showEmployee.do">人员信息</a></li>
		<li><a href="showVacate.do?id=${employee.ID }">请假管理</a></li>
		<li><a style="border-bottom: 2px solid #ebebeb;" href="showNotice.do">企业公告</a></li>
		<li><a href="showSalary.do">薪资信息</a></li>
	</ul>
	<div class="item" style="display: block;">
		<table id="gonggao">
			<tr>
				<th>ID</th>
				<th>标题</th>
				<th>日期</th>
				<th>内容</th>
			</tr>
			<c:forEach var="one" items="${noticeList }">
			<tr>
				<td>${one.id }</td>
				<td>${one.title }</td>
				<td>${one.date }</td>
				<td>${one.content }</td>
			</tr>
			</c:forEach>
			<tr>
				<td>1</td>
				<td>开业公告</td>
				<td>2017-05-01</td>
				<td>公司成立啦</td>
			</tr>
		</table>
		<form action="" id="yeme" method="post">
			共 ${count } 条记录
			<a href="?pageNumber=${pageNumber - 1 }" id="pre">上一页</a>&nbsp;
			第 ${pageNumber } 页
			<a href="?pageNumber=${pageNumber + 1 }" id="next">下一页</a>&nbsp;&nbsp;
			共 ${pages } 页&nbsp;&nbsp;
			<input type="submit" value="转跳至">
			<input type="text" name="pageNumber"> 
			页
		</form>
	</div>
</section>
</body>
<script type="text/javascript" src="frame/jquery-3.1.1.min.js"></script>
</html>