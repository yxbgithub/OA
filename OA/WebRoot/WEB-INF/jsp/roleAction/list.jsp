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
    <title>��λ�б�</title>
    <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--ҳ�����-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> ��λ����
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- ��ͷ-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">��λ����</td>
                <td width="300px">��λ˵��</td>
                <td>��ز���</td>
            </tr>
        </thead>

		<!--��ʾ�����б�-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
        	<s:iterator value="%{#roles}">
				<tr class="TableDetail1 template">
					<td><s:property value="%{name}"/>&nbsp;</td>
					<td><s:property value="%{description}"/>&nbsp;</td>
					<td>
						<s:if test="%{#session.user.hasPrivilegeByUrl('role_delete')}">
							<a onClick="return delConfirm()" href='oa/role_delete.do?id=<s:property value="%{id}"/>'>ɾ��</a>
						</s:if>
						<s:if test="#session.user.hasPrivilegeByUrl('role_edit')">
							<a href='oa/role_editUI.do?id=<s:property value="%{id}"/>'>�޸�</a>
						</s:if>
						<s:if test="#session.user.hasPrivilegeByUrl('role_privilege')">
							<a href='oa/role_setPrivilegeUI.do?id=<s:property value="%{id}"/>'>����Ȩ��</a>
						</s:if>
					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- �������ܳ����� -->
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
