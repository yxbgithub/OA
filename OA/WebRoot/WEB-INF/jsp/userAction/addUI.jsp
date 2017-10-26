<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editUI.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
   <body>
  	<form name="addUIForm" method="get" action="oa/user_add.do">
  		所属部门：<select name="department.id">
  				<s:iterator value="%{#departments}">
  					<option value='<s:property value="%{id}"/>'><s:property value="%{name}"/></option>
  				</s:iterator>
  			</select><br>
  		登录名：<input type="text" name="loginName"><br>
  		姓名：<input type="text" name="name">	<br>
  		性别：<input type="radio" name="gender" value="male">男
			<input type="radio" name="gender" value="female">女<br>
		联系电话：<input type="text" name="phoneNumber"><br>
		E-mail：<input type="text" name="email"><br>
		备注：<input type="text" name="description"><br>
		岗位：<s:iterator value="%{#roles}">
				<input type="checkbox" name="role" value='<s:property value="%{id}"/>'><s:property value="%{name}"/><br>
			</s:iterator>
		<input type="submit" value="保存">
  	</form>
 
    
  </body>
</html>
