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
    <title>�û��б�</title>
     <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--ҳ�����-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> �û�����
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- ��ͷ-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">��¼��</td>
                <td width="100">����</td>
                <td width="100">��������</td>
                <td width="200">��λ</td>
                <td>��ע</td>
                <td>��ز���</td>
            </tr>
        </thead>
        
        <!--��ʾ�����б�-->
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
	                		<s:a onclick="return delConfirm()" href="oa/user_delete.do?id=%{id}">ɾ��</s:a>
	                	</s:if>
	                	<s:if test="%{#session.user.hasPrivilegeByUrl('user_edit')}">
	                   	 	<s:a href="oa/user_editUI.do?departmentId=%{department.id}&id=%{id}">�޸�</s:a>
						</s:if>
						<s:if test="%{#session.user.hasPrivilegeByUrl('user_initPassword')}">
							<s:a onclick="return window.confirm('��ȷ��Ҫ��ʼ������Ϊ1234��')" href="oa/user_initPassword.do?id=%{id}">��ʼ������</s:a>
	               		</s:if>
	                </td>
	            </tr>
            </s:iterator>
        </tbody>
    </table>
    
    <!-- �������ܳ����� -->
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
