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
	<title>��λ����</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" src="script/jquery.js"></script>
    <script language="javascript" src="script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
    <script type="text/javascript"> 
    </script>
</head>

<body> 

<!-- ������ʾ -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--ҳ�����-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> ��λ����
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--��ʾ������-->
<div id="MainArea">
    <form action='oa/role_<s:property value="%{#parameters.id == null ? 'add' : 'edit'}"/>.do'>
    	<input type="hidden" name="id" value='<s:property value="%{#role.id}"/>'/>
        <div class="ItemBlock_Title1"><!-- ��Ϣ˵��<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> ��λ��Ϣ </DIV>  -->
        </div>
        
        <!-- ��������ʾ -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">��λ����</td>
                        <td><input type="text" name="name" class="InputStyle" value='<s:property value="%{#role.name}"/>' /> *</td>
                    </tr>
                    <tr>
                        <td>��λ˵��</td>
                        <td><textarea name="description" class="TextareaStyle"/><s:property value="%{#role.description}"/></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- ������ -->
        <div id="InputDetailBar">
            <input type="image" src="style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
        </div>
    </form>
</div>

</body>
</html>
