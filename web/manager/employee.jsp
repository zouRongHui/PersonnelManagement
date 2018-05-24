<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员-员工信息维护</title>
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
		<li style="border-bottom: 2px solid #ebebeb;"><a href="manager_showEmployee.do">人员信息维护</a></li>
		<li><a href="manager_showDepartment.do">部门管理</a></li>
		<li><a href="manager_showNotice.do">公告管理</a></li>
		<li><a href="manager_showSalary.do">薪资管理</a></li>
		<li><a href="manager_showPosition.do">人员调动</a></li>
	</ul>
	<div class="item" style="display: block;">
		<a href="###" id="add">添加新员工</a>
		<form action="manager_showEmployee.do" method="post">
			<div class="content">
				<input type="submit" id="chaxun" value="查询">
				<label for="name">
					姓名:<input type="text" name="name" id="name"/>
				</label>
				<label for="phone">
					手机:<input type="text" name="phone" id="phone"/>
				</label>
				<label for="">
					部门:<select name="department" id="bumen">
							<option value="">全部</option>
						<c:forEach var="one" items="${departmentList }">
							<option value="${one.name }">${one.name }</option>
						</c:forEach>
					</select>
				</label>
				<label for="">
					性别:<input type="radio" name="sex" value="男" class="radion">男
					<input type="radio" name="sex" value="女" class="radion">女
				</label>
				<label for="">
					入职时间:
					<div class="layui-input-inline riqi">
						<input class="layui-input" name="startDay" id="LAY_demorange_s" placeholder="开始日">
						<i class="layui-icon" id="st">&#xe637;</i>  
					</div>
					<div class="layui-input-inline riqi">
						<input class="layui-input" name="endDay" id="LAY_demorange_e" placeholder="截止日">
						<i class="layui-icon" id="en">&#xe637;</i>  
					</div>
				</label>
			</div>
		</form>
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
				<th>操作</th>
			</tr>
			<c:forEach var="one" items="${employeeList }">
			<tr>
				<td>${one.ID }</td>
				<td>${one.name }</td>
				<td class="sex">${one.sex }</td>
				<td contenteditable="true">${one.national }</td>
				<td contenteditable="true">${one.phone }</td>
				<td contenteditable="true">${one.email }</td>
				<td contenteditable="true">${one.nativePlace }</td>
				<td contenteditable="true">${one.graduateSchool }</td>
				<td contenteditable="true">${one.education }</td>
				<td>${one.department.name }</td>
				<td>${one.position }</td>
				<td>${one.hireDate }</td>
				<td contenteditable="true">${one.address }</td>
				<td contenteditable="true">${one.maritalStatus }</td>
				<td contenteditable="true">${one.IDCardNumber }</td>
				<td><a href="###" class="GA">更改</a></td>
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

<div id="addNewPerson">
	<a href="###" class="layui-icon" id="addCloseA">&#x1006;</a>  
	<form action="manager_insertEmployee.do" method="post">
		<table>
			<tr>
				<td style="text-indent:3em"><label for="addName">姓名:<input type="text" name="name" id="addName"></label></td>
				<td style="text-indent:2em"><label for="">性别:<input type="radio" name="sex" value="男" checked="checked" >男<input type="radio" name="sex" value="女">女</td>
			</tr>
			<tr>
				<td style="text-indent:3em"><label for="addMinzu">民族:<input type="text" name="national" id="addMinzu"></label></td>
				<td style="text-indent:2em"><label for="addPhone">手机:<input type="text" name="phone" id="addPhone"></label></td>
			</tr>
			<tr>
				<td style="text-indent:3em"><label for="addEmail">邮箱:<input type="text" name="email" id="addEmail"></label></td>
				<td style="text-indent:2em"><label for="addJiguan">籍贯:<input type="text" name="nativePlace" id="addJiguan"></label></td>
			</tr>
			<tr>
				<td style="text-indent:1em"><label for="addBiye">毕业院校:<input type="text" name="graduateSchool" id="addBiye"></label></td>
				<td style="text-indent:2em"><label for="addXueli">学历:<input type="text" name="education" id="addXueli"></label></td>
			</tr>
			<tr>
				<td style="text-indent:3em"><label for="">部门:<select name="department" id="addBumen">
					<c:forEach var="one" items="${departmentList }">
						<option value="${one.name }">${one.name }</option>
					</c:forEach></select></label></td>
				<td style="text-indent:2em"><label for="addZhiwei">职位:<input type="text" name="position" id="addZhiwei"></label></td>
			</tr>
			<tr>
				<td style="text-indent:1em"><label for="addAddress">现住地址:<input type="text" name="address" id="addAddress"></label></td>
				<td><label for="addHunyin">婚姻状况:<input type="text" name="maritalStatus" id="addHunyin"></label></td>
			</tr>
			<tr>
				<td><label for="addShenfen">身份证号码:<input type="text" name="IDCardNumber" id="addShenfen"></label></td>
				<td></td>
			</tr>
		</table>
		<!--  <a href="###" id="addPersonA"> 添加员工</a>  -->
		<input type="submit" id="addPersonA" value="添加员工">
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
  };
  document.getElementById('en').onclick = function(){
    end.elem = document.getElementById('LAY_demorange_e');
    laydate(end);
  };
});

//点击新员工
var add=document.getElementById("add");
var addCloseA=document.getElementById("addCloseA");
var addNewPerson=document.getElementById("addNewPerson");
add.onclick=function(){
	addNewPerson.style.display="block";
}
addCloseA.onclick=function(){
	addNewPerson.style.display="none";
};
//表格栏位修改
var personal=document.getElementById("personal");
personal.ondblclick=function(e){
	var e=e||window.event;
	var obj=e.target;
	obj.style.position="relative";
	var width=obj.offsetWidth;
	var height=obj.offsetHeight;
	var text=$("<select></select>");
	if(obj.tagName=="TD"&&(obj.className=="sex")){
		var opt = $("<option value='男'>男</option>");
		text.append(opt);
		opt = $("<option value='女'>女</option>")
		text.append(opt);
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
};
//更新数据
$(".GA").click(function() {
	var trObj=$(this).parent().parent().children();
	var srcObj = "manager_updateEmployee.do";
	srcObj += "?id=" + trObj[0].innerHTML;
	srcObj += "&sex=" + trObj[2].innerHTML;
	srcObj += "&national=" + trObj[3].innerHTML;
	srcObj += "&phone=" + trObj[4].innerHTML;
	srcObj += "&email=" + trObj[5].innerHTML;
	srcObj += "&nativePlace=" + trObj[6].innerHTML;
	srcObj += "&graduateSchool=" + trObj[7].innerHTML;
	srcObj += "&education=" + trObj[8].innerHTML;
	srcObj += "&address=" + trObj[12].innerHTML;
	srcObj += "&maritalStatus=" + trObj[13].innerHTML;
	srcObj += "&IDCardNumber=" + trObj[14].innerHTML;
	$(this).attr('href',srcObj); 
});
</script>
</html>