<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
    <s:iterator value="%{#departments}">
    	部门名称:<s:property value="%{name}"/> 上级部门名称:<s:property value="parent.getName()"/> 职能说明:<s:property value="description"/><s:a href="oa/department_delete.do?id=%{id}">删除</s:a>
    	<s:a href="oa/department_editUI.do?parent.id=%{parent.id}&name=%{name}&description=%{description}&id=%{id}">修改</s:a><br>
    </s:iterator>
    <s:a href="oa/department_addUI.do">新建</s:a>
  </body>
</html>
