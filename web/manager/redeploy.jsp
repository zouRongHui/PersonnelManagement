<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员-职位变更</title>
<link rel="stylesheet" type="text/css" href="frame/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="css/manager.css"/>
</head>
<body>
<header>
	<img src="image/logo.png" alt="企业logo" />
	<p id="title">正文科技</p>
	<p id="login">欢迎：<span>${sessionScope.employee.name }</span><a href="loginOut.do" id="btn">注销</a></p>
</header>
<section>
	<ul id="list">
		<li><a href="manager_showEmployee.do">人员信息维护</a></li>
		<li><a href="manager_showDepartment.do">部门管理</a></li>
		<li><a href="manager_showNotice.do">公告管理</a></li>
		<li><a href="manager_showSalary.do">薪资管理</a></li>
		<li style="border-bottom: 2px solid #ebebeb;"><a href="manager_showPosition.do">人员调动</a></li>
	</ul>
	<div class="item" style="display: block;">
		<div id="item5">
			<form action="manager_showPosition.do" method="post">
				<input type="submit" id="diaoSearch" value="查询">
				<label for="name2">姓名:<input type="text" name="name" id="name2"></label>
				<label for="">部门:
					<select name="department" id="diaoBuMen">
						<option value="">全部</option>
					<c:forEach var="one" items="${departmentList }">
						<option value="${one.name }">${one.name }</option>
					</c:forEach>
					</select></label>
			</form>
		</div>
		<table id="diaoT">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>部门</th>
				<th>职位</th>
				<th>操作</th>
			</tr>
			<c:forEach var="one" items="${employeeList }">
			<tr>
				<td>${one.ID }</td>
				<td>${one.name }</td>
				<td class="department">${one.department.name }</td>
				<td contenteditable="true">${one.position }</td>
				<td>
					<a href="manager_removeEmployee.do?id=${one.ID }" class="xgbmA">离职</a>
					<a href="###" class="xgbmA">确认</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<form action="manager_showPosition.do" id="yeme" method="post">
			共 ${count } 条记录
			<a href="manager_showPosition.do?pageNumber=${pageNumber - 1 }" id="pre">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			第 ${pageNumber } 页
			<a href="manager_showPosition.do?pageNumber=${pageNumber + 1 }" id="next">下一页</a>&nbsp;&nbsp;
			共 ${pages } 页&nbsp;&nbsp;
			<input type="submit" value="转跳至">
			<input type="text" name="pageNumber"> 
			页
		</form>
	</div>
</section>
</body>
<script type="text/javascript" src="frame/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
var show = document.getElementById("diaoT");
show.ondblclick=function(e){
	var e=e||window.event;
	var obj=e.target;
	obj.style.position="relative";
	var width=obj.offsetWidth;
	var height=obj.offsetHeight;
	var text=$("<select></select>");
	if(obj.tagName=="TD"&&(obj.className=="department")){
		<c:forEach var="one" items="${departmentList }">
		var opt=$("<option value='${one.name}'>${one.name}</option>");
		text.append(opt);
		</c:forEach>;
		text.width(width);
		text.height(height);
		text[0].style.position="absolute";
		text[0].style.left="0px";
		text[0].style.top="0px";
		obj.appendChild(text[0]);
	}
	text[0].onchange=function(){
		obj.innerHTML=this.value;
	}
}
//更新职位
$(".xgbmA").click(function() {
	var trObj=$(this).parent().parent().children();
	var srcObj = "manager_updatePosition.do";
	srcObj += "?id=" + trObj[0].innerHTML;
	srcObj += "&department=" + trObj[2].innerHTML;
	srcObj += "&position=" + trObj[3].innerHTML;
	alert(srcObj);
	$(this).attr('href',srcObj); 
});
</script>
</html>