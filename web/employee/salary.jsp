<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员   工-薪资信息</title>
<link rel="stylesheet" type="text/css" href="frame/layui/css/layui.css"/>
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
		<li><a href="showNotice.do">企业公告</a></li>
		<li><a style="border-bottom: 2px solid #ebebeb;" href="showSalary.do">薪资信息</a></li>
	</ul>
	<div class="item" style="display: block;">
		<div id="item4">
			<form action="showSalary.do" method="post">
			<input type="submit" id="moneySearch" value="查询">
			<label for="">年月:
				<div class="layui-input-inline nianyue">
					<input class="layui-input" name="month" id="xinziYear">
					<i class="layui-icon" id="xinzi">&#xe637;</i>  
				</div>
			</label>
			</form>
		</div>
		<table id="xiziT">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>年月</th>
				<th>工资</th>
			</tr>
			<c:forEach var="one" items="${salaryList }">
			<tr>
				<td>${one.employee.ID }</td>
				<td>${one.employee.name }</td>
				<td>${one.date.toString().substring(0, 7) }</td>
				<td>${one.salary + one.bonus + one.overtimePay }</td>
			</tr>
			</c:forEach>
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
<script src="frame/layui/layui.js"></script>
<script type="text/javascript" src="frame/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  var start = {
	    		min: '2000-01-01 23:59:59',
	    		max: '2099-06-01 23:59:59',
	    		istoday: false
	        };
	  document.getElementById('xinzi') .onclick = function(){
	    start.elem = document.getElementById('xinziYear');
	    laydate(start);
	  }
	});
</script>
</html>