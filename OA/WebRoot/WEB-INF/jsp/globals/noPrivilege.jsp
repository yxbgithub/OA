<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <TITLE>û��Ȩ��</TITLE>
    <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</HEAD>
<BODY>

<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--ҳ�����-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="../style/images/title_arrow.gif"/> ��ʾ
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>


<!--��ʾ������-->
<DIV ID="MainArea">
		<DIV CLASS="ItemBlock_Title1">
        </DIV> 

        <DIV CLASS="ItemBlockBorder" STYLE="margin-left: 15px;">
            <DIV CLASS="ItemBlock" STYLE="text-align: center; font-size: 16px;">
                �����ˣ���û��Ȩ�޷��ʴ˹��ܣ�
            </DIV>
        </DIV>
        
        <!-- ���� -->
        <DIV ID="InputDetailBar">
            <A HREF="javascript:history.go(-1);"><IMG SRC="../style/images/goBack.png"/></A>
        </DIV>
    
</DIV>

</BODY>
</HTML>
