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
	<title>�������</title>
	 <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>

<!-- ������ʾ -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--ҳ�����-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> �������
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--��ʾ��������-->
<div id="MainArea">
    <form action='oa/forumManager_<s:property value="%{#parameters.id == null ? 'add' : 'edit'}"/>.do'>
    <input type="hidden" name="id" value='<s:property value="%{#forum.id}"/>'>
        <div class="ItemBlock_Title1"><!-- ��Ϣ˵��<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> �����Ϣ </DIV>  -->
        </div>
        
        <!-- ����������ʾ -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">�������</td>
                        <td><input type="text" name="name" value='<s:property value="%{#forum.name}"/>' class="InputStyle" /> *</td>
                    </tr>
                    <tr>
                        <td>���˵��</td>
                        <td><textarea name="description" class="TextareaStyle"><s:property value="%{#forum.description}"/></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- �������� -->
        <div id="InputDetailBar">
            <input type="image" src="style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
	<s:debug></s:debug>
	˵����<br />
	1�������ӵİ��Ĭ����ʾ�������档<br />
</div>

</body>
</html>