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
    <title>����б�</title>
    <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--ҳ�����-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> ������
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- ��ͷ-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="250px">�������</td>
                <td width="300px">���˵��</td>
                <td>��ز���</td>
            </tr>
        </thead>

		<!--��ʾ�����б�-->
        <tbody id="TableData" class="dataContainer" datakey="forumList">
        	<s:iterator value="#forums">
				<tr class="TableDetail1 template">
					<td><s:property value="%{name}"/>&nbsp;</td>
					<td><s:property value="%{description}"/>&nbsp;</td>
					<td><a onClick="return delConfirm()" href='oa/forumManager_delete.do?id=<s:property value="%{id}"/>'>ɾ��</a>
						<a href='oa/forumManager_editUI.do?id=<s:property value="%{id}"/>'>�޸�</a>
						<a href='oa/forumManager_moveUp.do?id=<s:property value="%{id}"/>'>����</a>
						<a href='oa/forumManager_moveDown.do?id=<s:property value="%{id}"/>'>����</a>
					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- �������ܳ����� -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="oa/forumManager_addUI.do"><img src="style/images/createNew.png" /></a>
        </div>
    </div>
</div>

<div class="Description">
	˵����<br />
	1����ʾ���б�����sortOrderֵ�������С�<br />
	2������ͨ�����������ƹ��ܵ���˳��������Ĳ������ƣ�������Ĳ������ơ�<br />
</div>

</body>
</html>