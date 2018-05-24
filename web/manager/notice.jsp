<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员-公告管理</title>
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
		<li style="border-bottom: 2px solid #ebebeb;"><a href="manager_showNotice.do">公告管理</a></li>
		<li><a href="manager_showSalary.do">薪资管理</a></li>
		<li><a href="manager_showPosition.do">人员调动</a></li>
	</ul>
	<div class="item" style="display: block;">
		<a href="###" id="addGongGao">发布公告</a>
		<form action="manager_showNotice.do" method="post">
			<div id="sousuo">
				<label for="biaoti">标题:<input type="text" name="title" id="biaoti"></label>
				<label for="">
						发布时间:
						<div class="layui-input-inline riqi">
							<input class="layui-input" name="startDay" id="LAY_demorange_s" placeholder="开始日">
							<i class="layui-icon" id="st">&#xe637;</i>  
						</div>
						<div class="layui-input-inline riqi">
							<input class="layui-input" name="endDay" id="LAY_demorange_e" placeholder="截止日">
							<i class="layui-icon" id="en">&#xe637;</i>  
						</div>
					</label>
				<input type="submit" id="searchA" value="搜索">
			</div>			
		</form>

		<table id="gonggao">
			<tr>
				<th>ID</th>
				<th>标题</th>
				<th>日期</th>
				<th>内容</th>
				<th>操作</th>
			</tr>
			<c:forEach var="one" items="${noticeList }">
			<tr>
				<td>${one.id }</td>
				<td contenteditable="true">${one.title }</td>
				<td>${one.date }</td>
				<td contenteditable="true">${one.content }</td>
				<td><a href="manager_removeNotice.do?id=${one.id }" class="gsc">删除</a><a href="###" class="ggx">更新</a></td>
			</tr>
			</c:forEach>
		</table>
		<form action="manager_showNotice.do" id="yeme" method="post">
			共 ${count } 条记录
			<a href="manager_showNotice.do?pageNumber=${pageNumber - 1 }" id="pre">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			第 ${pageNumber } 页
			<a href="manager_showNotice.do?pageNumber=${pageNumber + 1 }" id="next">下一页</a>&nbsp;&nbsp;
			共 ${pages } 页&nbsp;&nbsp;
			<input type="submit" value="转跳至">
			<input type="text" name="pageNumber"> 
			页
		</form>
	</div>
	<div id="gonggao_fabu">
		<a href="###" class="layui-icon" id="addCloseA2">&#x1006;</a> 
		<form action="manager_insertNotice.do" method="post">
			<label for="fabu_title">标题:<input type="text" name="title" id="fabu_title"></label><br/><br/>
			<label for="fabu_content">内容:<textarea name="content" id="fabu_content"></textarea></label>
			<!-- <a href="###" id="fabu_newA">发布公告</a> -->
			<input type="submit" id="fabu_newA" value="发布公告">
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
		max: '2099-06-16 23:59:59',
		istoday: false,
		choose: function(datas){
			end.min = datas; //开始日选好后，重置结束日的最小日期
			end.start = datas //将结束日的初始值设定为开始日
		}
    };
  
    var end = {
	    min: '2000-01-01 23:59:59',
	    max: '2099-06-16 23:59:59',
	    istoday: false,
	    choose: function(datas){
	      start.max = datas; //结束日选好后，重置开始日的最大日期
	    }
    };
  
 document.getElementById('st') .onclick = function(){
    start.elem = document.getElementById('LAY_demorange_s');
    laydate(start);
  }
  document.getElementById('en').onclick = function(){
    end.elem = document.getElementById('LAY_demorange_e');
    laydate(end);
  }
});
//添加新公告
var gonggao_fabu=document.getElementById("gonggao_fabu");
var addCloseA2=document.getElementById("addCloseA2");
var addGongGao=document.getElementById("addGongGao");
addGongGao.onclick=function(){
	gonggao_fabu.style.display="block";
}
addCloseA2.onclick=function(){
	gonggao_fabu.style.display="none";
};
//更新公告
$(".ggx").click(function() {
	var trObj=$(this).parent().parent().children();
	var srcObj = "manager_updateNotice.do";
	srcObj += "?id=" + trObj[0].innerHTML;
	srcObj += "&title=" + trObj[1].innerHTML;
	srcObj += "&content=" + trObj[3].innerHTML;
	alert(srcObj);
	$(this).attr('href',srcObj); 
});
</script>
</html>