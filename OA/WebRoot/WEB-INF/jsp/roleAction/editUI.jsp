<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
  	<s:debug></s:debug>
  	<form name="editUIForm" method="get" action="oa/role_edit.do">
  		<input type="hidden" name="id" value='<s:property value="%{id}"/>'/>
  		岗位名称<input type="text" name="name" value='<s:property value="%{name}"/>'/><br>
  		岗位说明<textarea name="description"  cols="30" rows="15"><s:property value="%{description}"/></textarea> <br>
  		<input type="submit" value="保存">
  	</form>
  <body>
    
  </body>
</html>
