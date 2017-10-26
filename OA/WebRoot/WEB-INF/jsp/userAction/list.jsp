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
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
    	<s:debug></s:debug>
    	<s:iterator value="%{#users}">
    		登录名：<s:property value="loginName"/> 姓名：<s:property value="name"/>
    		所属部门:<s:property value="department.name"/>
    		岗位：<s:iterator value="roles">
    				<s:property value="name"/>:
    			</s:iterator>
    		备注：<s:property value="description"/><br>
    	</s:iterator>
    	<br>
    	<s:a href="oa/user_addUI.do">新建</s:a>
  </body>
</html>
