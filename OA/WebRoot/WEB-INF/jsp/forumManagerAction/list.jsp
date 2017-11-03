<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>版块列表</title>
    <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 版块管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="250px">版块名称</td>
                <td width="300px">版块说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="forumList">
        	<s:iterator value="#forums" status="status">
				<tr class="TableDetail1 template">
					<td><s:property value="%{name}"/>&nbsp;</td>
					<td><s:property value="%{description}"/>&nbsp;</td>
					<td><a onClick="return delConfirm()" href='oa/forumManager_delete.do?id=<s:property value="%{id}"/>'>删除</a>
						<a href='oa/forumManager_editUI.do?id=<s:property value="%{id}"/>'>修改</a>
						<s:if test="%{#status.first}">
							<span style="color:gray;cursor:pointer;">上移</span>
						</s:if>
						<s:else>
							<a href='oa/forumManager_moveUp.do?id=<s:property value="%{id}"/>'>上移</a>
						</s:else>
						<s:if test="%{#status.last}">
							<span style="color:gray;cursor:pointer;">下移</span>
						</s:if>
						<s:else>
							<a href='oa/forumManager_moveDown.do?id=<s:property value="%{id}"/>'>下移</a>
						</s:else>
					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="oa/forumManager_addUI.do"><img src="style/images/createNew.png" /></a>
        </div>
    </div>
</div>

<div class="Description">
	说明：<br />
	1，显示的列表按其sortOrder值升序排列。<br />
	2，可以通过上移与下移功能调整顺序。最上面的不能上移，最下面的不能下移。<br />
</div>

</body>
</html>
