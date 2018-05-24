<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员   工-请假管理</title>
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
		<li><a style="border-bottom: 2px solid #ebebeb;" href="showVacate.do?id=${employee.ID }">请假管理</a></li>
		<li><a href="showNotice.do">企业公告</a></li>
		<li><a href="showSalary.do">薪资信息</a></li>
	</ul>
	<div class="item" style="display: block;">
		<a href="###" id="qinjia">请假申请</a>
		<table id="qinjiaTiao">
			<tr >
				<th>ID</th>
				<th>申请人</th>
				<th>处理人</th>
				<th>开始时间</th>
				<th>天数</th>
				<th>是否允批</th>
				<th>缘由</th>
				<th>操作</th>
			</tr>
			<c:forEach var="one" items="${vacateList }">
			<tr>
				<td>${one.id }</td>
				<td>${one.applicant.name }</td>
				<td>${one.handler.name }</td>
				<td>${one.date }</td>
				<td>${one.days }</td>
				<td>${one.approve }</td>
				<td>${one.reason }</td>
				<c:if test="${one.applicant.ID == employee.ID }">
				<td><a href="removeVacate.do?id=${one.id }&employeeId=${employee.ID }" class="delA">删除</a></td>
				</c:if>
				<c:if test="${one.handler.ID == employee.ID }">
				<td><a href="approveVacate.do?id=${one.id }&employeeId=${employee.ID }" class="delA">同意</a>&nbsp;
					<a href="opposeVacate.do?id=${one.id }&employeeId=${employee.ID }" class="delA">驳回</a></td>
				</c:if>
			</tr>
			</c:forEach>
		</table>
		<form action="" id="yeme" method="post">
			共 ${count } 条记录
			<a href="?pageNumber=${pageNumber - 1 }" id="pre">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			第 ${pageNumber } 页
			<a href="?pageNumber=${pageNumber + 1 }" id="next">下一页</a>&nbsp;&nbsp;
			共 ${pages } 页&nbsp;&nbsp;
			<input type="submit" value="转跳至">
			<input type="text" name="pageNumber"> 
			页
		</form>
	</div>	
	<div id="guanli_qinjia">
		<a href="###" class="layui-icon" id="addCloseA1">&#x1006;</a> 
		<form action="insertVacate.do">
			<label for="qingjia_begintime" class="qin">请假时间:<input type="text" name="date" id="qingjia_begintime"></label>
			<label for="qingjia_time"  class="qin">请假天数:<input type="text" name="days" id="qingjia_time"></label>
			<label for="qingjia_yuanyou"  class="qin">请假缘由:<textarea name="reason" id="qingjia_yuanyou"></textarea></label>
			<input type="hidden" name="id" value="${employee.ID }">
			<input type="submit" id="tijiaoS" value="提交申请">
		</form>
	</div>
</section>
</body>
<script type="text/javascript" src="frame/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
var addCloseA1=document.getElementById("addCloseA1");
var qinjia=document.getElementById("qinjia");
var guanli_qinjia=document.getElementById("guanli_qinjia")
qinjia.onclick=function(){
	guanli_qinjia.style.display="block";
}
addCloseA1.onclick=function(){
	guanli_qinjia.style.display="none";
}
</script>
</html>