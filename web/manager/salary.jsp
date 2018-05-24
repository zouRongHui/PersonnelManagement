<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员-薪资管理</title>
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
		<li style="border-bottom: 2px solid #ebebeb;"><a href="manager_showSalary.do">薪资管理</a></li>
		<li><a href="manager_showPosition.do">人员调动</a></li>
	</ul>
	<div class="item" style="display: block;">
		<div id="item4">
			<a href="manager_insertSalary.do">生成本月工资表</a>
			<form action="manager_showSalary.do" method="post">
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
				<th>该月上班天数</th>
				<th>基本工资</th>
				<th>奖金</th>
				<th>加班工资</th>
				<th>操作</th>
			</tr>
			<c:forEach var="one" items="${salaryList }">
			<tr>
				<td>${one.employee.ID }</td>
				<td>${one.employee.name }</td>
				<td>${one.date.toString().substring(0, 7) }</td>
				<td contenteditable="true">${one.days }</td>
				<td contenteditable="true">${one.salary }</td>
				<td contenteditable="true">${one.bonus }</td>
				<td contenteditable="true">${one.overtimePay }</td>
				<td><a href="###" class="xinUpdate" data-id="${one.id }">更新</a></td>
			</tr>
			</c:forEach>
		</table>
		<form action="manager_showSalary.do" id="yeme" method="post">
			共 ${count } 条记录
			<a href="manager_showSalary.do?pageNumber=${pageNumber - 1 }" id="pre">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			第 ${pageNumber } 页
			<a href="manager_showSalary.do?pageNumber=${pageNumber + 1 }" id="next">下一页</a>&nbsp;&nbsp;
			共 ${pages } 页&nbsp;&nbsp;
			<input type="submit" value="转跳至">
			<input type="text" name="pageNumber"> 
			页
		</form>
	</div>

</section>


</body>
<script type="text/javascript" src="frame/jquery-3.1.1.min.js"></script>
<script src="frame/layui/layui.js"></script>
<script>
	layui.use('laydate', function(){
	    var laydate = layui.laydate;
	    var start = {
	    		min: '2000-01-01 23:59:59',
	    		max: '2099-06-01 23:59:59',
	    		istoday: false
	        };
	    document.getElementById('xinzi').onclick = function(){
		    start.elem = document.getElementById('xinziYear');
		    laydate(start);
	    }
	});
//更新薪资表
$(".xinUpdate").click(function() {
	var trObj=$(this).parent().parent().children();
	var srcObj = "manager_updateSalary.do";
	srcObj += "?id=" + $(this).data("id");
	srcObj += "&days=" + trObj[3].innerHTML;
	srcObj += "&salary=" + trObj[4].innerHTML;
	srcObj += "&bonus=" + trObj[5].innerHTML;
	srcObj += "&overtimePay=" + trObj[6].innerHTML;
	alert(srcObj);
	$(this).attr('href',srcObj); 
});
</script>
</html>