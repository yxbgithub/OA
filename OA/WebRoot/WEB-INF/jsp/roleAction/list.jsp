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
    	
    	<s:iterator value="#roles">
    		
    		<s:property value="name"/><s:a href="oa/role_delete.do?id=%{id}&name=%{name}&description=%{description}">ɾ��</s:a><s:a href="oa/role_editUI.do?id=%{id}">�޸�</s:a><br>
    	</s:iterator>
    	<s:a href="oa/role_addUI.do">�½�</s:a>
  </body>
</html>
