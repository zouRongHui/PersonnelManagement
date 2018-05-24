<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>人事管理</title>
  <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<table width="1284" height="422">
  <tr>
    <td width="777" height="160">&nbsp;</td>
    <td width="495">&nbsp;</td>
  </tr>
  <tr>
    <td height="300">&nbsp;</td>
    <td>
      <form action="login.do" method="post" onsubmit="return login()">
        <table>
          <tr><td colspan="2" align="center"><label>${tip }</label></td></tr>
          <tr><td>用户名: <input type="text" name="name" id="userName" value="${tipsName }"/></td><td><label id="userNameTip"></label></td></tr>
          <tr><td></td><td></td></tr>
          <tr><td></td><td></td></tr>
          <tr><td>密　码: <input type="password" name="password" id="userPassword"/></td><td><label id="userPasswordTip"></label></td></tr>
          <tr><td></td><td></td></tr>
          <tr><td></td><td></td></tr>
          <tr><td>验证码: <input type="text" name="authCode" id="authCode"/></td><td><label id="authCodeTip"></label></td></tr>
          <tr><td></td><td></td></tr>
          <tr><td></td><td></td></tr>
          <tr><td align="center"><span id="code"></span><a href="javascript:nextAuthCode()">看不清</a></td><td></td></tr>
          <tr><td></td><td></td></tr>
          <tr><td></td><td></td></tr>
          <tr><td align="center"><input type="submit" id="loginButton" value="  " /></td></tr>
        </table>
      </form>
    </td>
  </tr>
</table>
<br/>
</body>
<script type="text/javascript" src="frame/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    var ranNum = "";
    for (var i = 0; i < 4; i++) {
        ranNum += parseInt(Math.random()*10, 10) + "";
    }
    $("#code").html(ranNum);

    $("#userName").blur(function(){
        $("#userNameTip").html("");
    });

    $("#userPassword").blur(function(){
        $("#userPasswordTip").html("");
    });

    $("#authCode").blur(function(){
        $("#authCodeTip").html("");
    });

    function login() {
        var $userName = $("#userName");
        var $userPassword = $("#userPassword");
        var $authCode = $("#authCode");
        if ($userName.val() == "") {
            $("#userNameTip").html("* 请输入账号");
            $userName.focus();
            return false;
        }
        if ($userPassword.val() == "") {
            $("#userPasswordTip").html("* 请输入密码");
            $userPassword.focus();
            return false;
        }
        if ($authCode.val() == "") {
            $("#authCodeTip").html("* 请输入验证码");
            $authCode.focus();
            return false;
        }
        var regex = "^.{6,16}$";
        if (!$userPassword.val().match(regex)) {
            $("#userPasswordTip").html("* 请输入6至16位密码");
            $userPassword.focus();
            return false;
        }
        regex = "^\\d{4}$";
        if (!$authCode.val().match(regex)) {
            $("#authCodeTip").html("* 请输入4位数字验证码");
            $authCode.focus();
            return false;
        }
        if (!($authCode.val() == ranNum)) {
            $("#authCodeTip").html("* 验证码输入错误");
            $authCode.focus();
            return false;
        }
    }

    function nextAuthCode(){
        $("#authCode").val("");
        ranNum = "";
        for (var i = 0; i < 4; i++) {
            ranNum += parseInt(Math.random()*10, 10);
        }
        $("#code").html(ranNum);
    }
</script>
</html>