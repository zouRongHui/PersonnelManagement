<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员   工-人员信息</title>
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
		<li><a style="border-bottom: 2px solid #ebebeb;" href="showEmployee.do">人员信息</a></li>
		<li><a href="showVacate.do?id=${employee.ID }">请假管理</a></li>
		<li><a href="showNotice.do">企业公告</a></li>
		<li><a href="showSalary.do">薪资信息</a></li>
	</ul>
	<div class="item" style="display: block;">
		<a href="###" id="weihu">修改个人密码</a>
		<table id="personal">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>性别</th>
				<th>民族</th>
				<th>手机</th>
				<th>邮箱</th>
				<th>籍贯</th>
				<th>毕业学校</th>
				<th>学历</th>
				<th>部门</th>
				<th>职位</th>
				<th>入职时间</th>
				<th>现住地址</th>
				<th>婚姻状况</th>
				<th>身份证号码</th>
			</tr>
			<c:forEach var="one" items="${employeeList }">
			<tr>
				<td>${one.ID }</td>
				<td>${one.name }</td>
				<td>${one.sex }</td>
				<td>${one.national }</td>
				<td>${one.phone }</td>
				<td>${one.email }</td>
				<td>${one.nativePlace }</td>
				<td>${one.graduateSchool }</td>
				<td>${one.education }</td>
				<td>${one.department.name }</td>
				<td>${one.position }</td>
				<td>${one.hireDate }</td>
				<td>${one.address }</td>
				<td>${one.maritalStatus }</td>
				<td>${one.IDCardNumber }</td>
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
	<div id="newsWeihu">
		<a href="###" class="layui-icon" id="addCloseA">&#x1006;</a>   
		<form action="updatePassword.do">
		<table>
			<tr>
				<td style="text-indent:3em"><label for="addName">原密码:<input type="password" id="addName"></label></td>
			</tr>
			<tr>
				<td style="text-indent:3em"><label for="addMinzu">新密码:<input type="password" name="password" id="addMinzu"></label></td>
			</tr>
			<tr>
				<td style="text-indent:3em"><label for="addEmail">重复新密码:<input type="password" id="addEmail"></label></td>
			</tr>
		</table>
		<input type="hidden" name="id" value="${employee.ID }">
		<input type="submit" id="querenX" value="确认修改">
		</form>
	</div>	
</section>
</body>
<script type="text/javascript" src="frame/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
var weihu=document.getElementById("weihu");
var newsWeihu=document.getElementById("newsWeihu");
var addCloseA=document.getElementById("addCloseA");
weihu.onclick=function(){
	newsWeihu.style.display="block";
}
addCloseA.onclick=function(){
	newsWeihu.style.display="none";
}
</script>
</html>