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
    <title>岗位列表</title>
    <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
        	<s:iterator value="%{#roles}">
				<tr class="TableDetail1 template">
					<td><s:property value="%{name}"/>&nbsp;</td>
					<td><s:property value="%{description}"/>&nbsp;</td>
					<td>
						<s:if test="%{#session.user.hasPrivilegeByUrl('role_delete')}">
							<a onClick="return delConfirm()" href='oa/role_delete.do?id=<s:property value="%{id}"/>'>删除</a>
						</s:if>
						<s:if test="#session.user.hasPrivilegeByUrl('role_edit')">
							<a href='oa/role_editUI.do?id=<s:property value="%{id}"/>'>修改</a>
						</s:if>
						<s:if test="#session.user.hasPrivilegeByUrl('role_privilege')">
							<a href='oa/role_setPrivilegeUI.do?id=<s:property value="%{id}"/>'>设置权限</a>
						</s:if>
					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
       	 <s:if test="#session.user.hasPrivilegeByUrl('role_add')">
            <a href="oa/role_addUI.do"><img src="style/images/createNew.png" /></a>
          </s:if>
        </div>
    </div>
</div>
</body>
</html>
