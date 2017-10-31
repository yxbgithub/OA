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
    <title>部门列表</title>
    <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 部门管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="150px">部门名称</td>
				<td width="150px">上级部门名称</td>
				<td width="200px">职能说明</td>
				<td>相关操作</td>
            </tr>
        </thead>

		<%-- <s:debug></s:debug> --%>
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="departmentList">
        	<s:iterator value="%{#departments}">
				<tr class="TableDetail1 template">
					<td><a href='oa/department_list.do?parentId=<s:property value="%{id}"/>'><s:property value="%{name}"/></a>&nbsp;</td>
					<td><s:property value="%{parent.name}"/>&nbsp;</td>
					<td><s:property value="%{description}"/>&nbsp;</td>
					<td>
						<s:if test="%{#session.user.hasPrivilegeByUrl('department_delete')}">
							<s:a href="oa/department_delete.do?id=%{id}&parentId=%{parentId}" onclick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')">删除</s:a>
						</s:if>
						<s:if test="%{#session.user.hasPrivilegeByUrl('department_edit')}">
							<s:a href="oa/department_editUI.do?parent.id=%{parent.id}&name=%{name}&description=%{description}&id=%{id}&parentId=%{parentId}">修改</s:a>
						</s:if>
					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        	<s:if test="%{#session.user.hasPrivilegeByUrl('department_add')}">
          		<s:a href="oa/department_addUI.do?parentId=%{parentId}"><img src="style/images/createNew.png" /></s:a>  
           	</s:if>
            <s:if test="%{parentId != null}">
            	 <a href="oa/department_back.do?parentId=<s:property value="%{parentId}"/>"><IMG src="style/blue/images/button/ReturnToPrevLevel.png" /></a>
            </s:if>
        </div>
    </div>
</div>

<!--说明-->	
<div id="Description"> 
	说明：<br />
	1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
	2，点击部门名称，可以查看此部门相应的下级部门列表。<br />
	3，删除部门时，同时删除此部门的所有下级部门。
</div>

</body>
</html>
