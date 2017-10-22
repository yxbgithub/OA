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
  	<form name="addUIForm" method="get" action="oa/department_add.do">
  		
  		上级部门<select name="parent.id">
  				<s:iterator value="%{#departments}">
  					<option value='<s:property value="%{id}"/>'><s:property value="%{name}"/></option>
  				</s:iterator>
  			</select><br>
  		部门名称<input type="text" name="name"><br>
  		职能说明<textarea name="description" cols="30" rows="15"></textarea> <br>
  		<input type="submit" value="保存">
  	</form>
  <body>
    
  </body>
</html>
