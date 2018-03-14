<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script language="javascript" src="js/AjaxRequest.js"></script>
<script language="javascript">
/******************错误处理的方法*******************************/
function onerror(){
	alert("用户名有非法字符！");
}
/******************实例化Ajax对象的方法*******************************/
function getInfo(userName){
	var loader=new net.AjaxRequest("checkUser.jsp?user="+userName.value,deal_getInfo,onerror,"GET");
	/* alert("您的操作有误！"); */
}
/************************回调函数**************************************/
function deal_getInfo(){
	document.getElementById("toolTip").innerHTML=this.req.responseText;
    document.getElementById("toolTip").style.display="block";	//显示提示框
}

function checkUser(userName){
	if(userName.value==""){
		userName.focus();return;
	}else{
		
		createRequest('checkUser.jsp?user='+userName.value);
	}
}
function regis() {
	  
	/* ----------- 验证用户名是否含有中文 --------------------- */
 	/* var re =/.*[\u4e00-\u9fa5]+.*$/;  
	if(re.test(document.getElementById("username").value)) { 
			alert('"用户名"不能含有中文！');
		    return false; }  */
		
	/* ----------- 验证两次输入的密码是否一致 --------------------- */
	var pwd = document.getElementById("password").value;
	var pwd2 = document.getElementById("pwd").value;
	if (pwd !== pwd2) {
		alert('"密码"前后不一致！');
		return false;
	}
	/* ----------- 验证真实姓名是否全中文 --------------------- */
	var re=/[^\u4e00-\u9fa5]/;  
    if(re.test(document.getElementById("ename").value)){
    	alert('请输出正确的"真实姓名"');
    	return false; 
    }
    
    if(document.getElementById("username").value == "" || document.getElementById("password").value == ""){
    	alert('“用户名”或“密码”不能空');
    	return false; 
    }
	return true;
}
</script>
<style type="text/css">
<!--
#toolTip {
	font-size:11px;
	color:red;
}
-->
</style>

</head>
<body>

<s:form name="form1" method="post" action="employee_register" namespace="/" theme="simple" onsubmit="return regis();">
	<center>
	<h1>注册</h1>
	<hr>
	<br>
	<table width="509" height="352" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg.gif">
		
		  <tr>
    <td height="54">&nbsp;</td>
  </tr>
 
		
		<tr>
			<td width="23%" align="right" style="color:#8e6723 ">用户名：</td>
			<td><input id="username" name="username" type="text" onblur="getInfo(form1.username);"/><div id="toolTip"></div></td>
		</tr>
		
		<tr>
			<td align="right" style="color:#8e6723 ">密码：</td>
			<td><input id="password" name="password" type="password"></td>
		<tr>
			<td align="right" style="color:#8e6723 ">确认密码：</td>
			<td><input id="pwd" name="pwd" type="password"></td>
		</tr>
		<tr>
			<td align="right" style="color:#8e6723 ">真实姓名：</td>
			<td><input id="ename" name="ename" type="text"/></td>
		</tr>
		
		<tr>
			<td align="right" style="color:#8e6723 ">性别：</td>
			<td><s:radio list="{'男','女'}" value="%{model.sex}" name="sex" /></td>
		<tr>
		
		<tr>
			<td align="right" style="color:#8e6723 ">编号：</td>
				<td><s:textfield value="%{model.eno}" name="eno" /></td>
		</tr>
		<tr>
			<td align="right" style="color:#8e6723 ">出生日期：</td>
			<td><input type="text" name="birthday" value="<s:date name="model.birthday" format="yyyy-MM-dd"/>" /></td>
		</tr>
		<tr>
			<td align="right" style="color:#8e6723 ">入职日期：</td>
				<td><input type="text" name="joinDay" value="<s:date name="model.joinDay" format="yyyy-MM-dd"/>" /></td>
		</tr>


		<tr>
			<td align="center" style="color:#8e6723 "><input type="submit" value="注册" /></td>
			<td style="color:#8e6723 "><input type="reset" value="重置"/></td>
		</tr>
		
			  <tr>
    <td height="54">&nbsp;</td>
  </tr>
	</table>
		
	</center>
	
</s:form>
</body>
</html>