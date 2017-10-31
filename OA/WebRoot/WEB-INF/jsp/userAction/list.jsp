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
    <title>用户列表</title>
     <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        	<s:iterator value="#users">
	            <tr class="TableDetail1 template">
	                <td><s:property value="loginName"/>&nbsp;</td>
	                <td><s:property value="name"/>&nbsp;</td>
	                <td><s:property value="department.name"/>&nbsp;</td>
	                <td>
	                	<s:iterator value="roles">
	                		<s:property value="name"/>
	                	</s:iterator>
	                	&nbsp;
	                </td>
	                <td><s:property value="description"/>&nbsp;</td>
	                <td>
	                	<s:if test="%{#session.user.hasPrivilegeByUrl('user_delete')}">
	                		<s:a onclick="return delConfirm()" href="oa/user_delete.do?id=%{id}">删除</s:a>
	                	</s:if>
	                	<s:if test="%{#session.user.hasPrivilegeByUrl('user_edit')}">
	                   	 	<s:a href="oa/user_editUI.do?departmentId=%{department.id}&id=%{id}">修改</s:a>
						</s:if>
						<s:if test="%{#session.user.hasPrivilegeByUrl('user_initPassword')}">
							<s:a onclick="return window.confirm('您确定要初始化密码为1234吗？')" href="oa/user_initPassword.do?id=%{id}">初始化密码</s:a>
	               		</s:if>
	                </td>
	            </tr>
            </s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        	<s:if test="%{#session.user.hasPrivilegeByUrl('user_add')}">
        		<s:a href="oa/user_addUI.do"><img src="style/images/createNew.png" /></s:a>
        	</s:if>
        </div>
    </div>
</div>

<s:iterator value="%{#session.user.roles}">
	<s:property value="name"/>
	<s:iterator value="privileges">
		<s:property value="name"/>
	</s:iterator>
</s:iterator>

<s:debug></s:debug>
</body>
</html>
