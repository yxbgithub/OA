<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>导航菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" src="script/jquery.js"></script>
<script language="JavaScript" src="script/menu.js"></script>
<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
</head>
<body style="margin: 0">
<div id="Menu">
    <ul id="MenuUl">
    	<s:iterator value="#application.topPrivileges">
    		<s:if test="%{#session.user.hasPrivilegeByName(name)}">
		        <li class="level1">
		            <div onClick="menuClick(this);" class="level1Style"><img src="style/images/MenuIcon/FUNC20082.gif" class="Icon" /> <s:property value="%{name}"/></div>
			            <ul style="display: none;" class="MenuLevel2">
			            	<s:iterator value="children">
			            		<s:if test="%{#session.user.hasPrivilegeByName(name)}">
					                <li class="level2">
					                    <div class="level2Style"><img src="style/images/MenuIcon/menu_arrow_single.gif" /> <a target="right" href='oa/<s:property value="%{url}"/>.do'> <s:property value="%{name}"/></a></div>
					                </li>
				               </s:if>
			                </s:iterator>
			            </ul>
		        </li>
	        </s:if>
        </s:iterator>
    </ul>
</div>
</body>
</html>
