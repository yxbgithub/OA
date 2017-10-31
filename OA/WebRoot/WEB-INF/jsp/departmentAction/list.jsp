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
    <title>�����б�</title>
    <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--ҳ�����-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> ���Ź���
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- ��ͷ-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="150px">��������</td>
				<td width="150px">�ϼ���������</td>
				<td width="200px">ְ��˵��</td>
				<td>��ز���</td>
            </tr>
        </thead>

		<%-- <s:debug></s:debug> --%>
		<!--��ʾ�����б�-->
        <tbody id="TableData" class="dataContainer" datakey="departmentList">
        	<s:iterator value="%{#departments}">
				<tr class="TableDetail1 template">
					<td><a href='oa/department_list.do?parentId=<s:property value="%{id}"/>'><s:property value="%{name}"/></a>&nbsp;</td>
					<td><s:property value="%{parent.name}"/>&nbsp;</td>
					<td><s:property value="%{description}"/>&nbsp;</td>
					<td>
						<s:if test="%{#session.user.hasPrivilegeByUrl('department_delete')}">
							<s:a href="oa/department_delete.do?id=%{id}&parentId=%{parentId}" onclick="return window.confirm('�⽫ɾ�����е��¼����ţ���ȷ��Ҫɾ����')">ɾ��</s:a>
						</s:if>
						<s:if test="%{#session.user.hasPrivilegeByUrl('department_edit')}">
							<s:a href="oa/department_editUI.do?parent.id=%{parent.id}&name=%{name}&description=%{description}&id=%{id}&parentId=%{parentId}">�޸�</s:a>
						</s:if>
					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- �������ܳ����� -->
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

<!--˵��-->	
<div id="Description"> 
	˵����<br />
	1���б�ҳ��ֻ��ʾһ��ģ�ͬ���ģ��������ݣ�Ĭ����ʾ����Ĳ����б�<br />
	2������������ƣ����Բ鿴�˲�����Ӧ���¼������б�<br />
	3��ɾ������ʱ��ͬʱɾ���˲��ŵ������¼����š�
</div>

</body>
</html>
