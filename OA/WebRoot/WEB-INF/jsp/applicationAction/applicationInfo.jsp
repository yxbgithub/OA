<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>查看申请信息</title>
	<%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>

<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 申请信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
	<div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
		<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> 申请信息 </DIV>  -->
	</div>
	<div class="ItemBlockBorder" style="margin: 15px;">
		<div class="ItemBlock">
			<table cellpadding="0" cellspacing="0" class="mainForm">
				<tr>
					<td><a href="javascript:void(0)" style="text-decoration: underline">[点击下载申请的文档]</a></td>
				</tr>
			</table>
		</div>
	</div>
	
	<!-- 表单操作 -->
    <div id="InputDetailBar">
        <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
    </div>
</div>

</body>
</html>
