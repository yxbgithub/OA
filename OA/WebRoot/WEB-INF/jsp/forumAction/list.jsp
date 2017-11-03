<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>论坛</title>
	<%@ include file="/WEB-INF/jsp/public/header.jspf" %>
	<link type="text/css" rel="stylesheet" href="style/blue/forum.css" />
</head>
<body>
<div id="Title_bar">
	<div id="Title_bar_Head">
		<div id="Title_Head"></div>
		<div id="Title">
			<!--页面标题-->
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 论坛 </div>
		<div id="Title_End"></div>
	</div>
</div>
<div id="MainArea">
	<center>
		<div class="ForumPageTableBorder" style="margin-top: 25px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			
				<!--表头-->
				<tr align="center" valign="middle">
					<td colspan="3" class="ForumPageTableTitleLeft">版块</td>
					<td width="80" class="ForumPageTableTitle">主题数</td>
					<td width="80" class="ForumPageTableTitle">文章数</td>
					<td width="270" class="ForumPageTableTitle">最后发表的主题</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="9"></td></tr>
				<tr height="3"><td colspan="9"></td></tr>
				
				<!--版面列表-->
				<s:iterator value="%{#forums}">
					<tbody class="dataContainer" datakey="forumList">
					<tr height="78" align="center" class="template">
						<td width="3"></td>
						<td width="75" class="ForumPageTableDataLine">
							<img src="style/images/forumpage3.gif" />
						</td>
						<td class="ForumPageTableDataLine">
							<ul class="ForumPageTopicUl">
								<li class="ForumPageTopic"><a class="ForumPageTopic" href='oa/forum_forumShow.do?id=<s:property value="%{id}"/>'><s:property value="%{name}"/></a></li>
								<li class="ForumPageTopicMemo"><s:property value="%{description}"/></li>
							</ul>
						</td>
						<td class="ForumPageTableDataLine"><b><s:property value="%{topicCount}"/></b></td>
						<td class="ForumPageTableDataLine"><b><s:property value="%{articleCount}"/></b></td>
						<td class="ForumPageTableDataLine">
							<ul class="ForumPageTopicUl">
								<li><font color="#444444">┌ 主题：</font> 
									<a class="ForumTitle" href="BBS_Topic/topicShow.html"><s:property value="%{lastTopic.title}"/></a>
								</li>
								<li><font color="#444444">├ 作者：</font><s:property value="%{lastTopic.author.name}"/></li>
								<li><font color="#444444">└ 时间：</font><s:property value="%{lastTopic.postTime}"/><s:date name="%{lastTopic.postTime}" format="YYYY年MM月DD日   HH:mm:ss"/></li>
							</ul>
						</td>
						<td width="3"></td>
					</tr>
					</tbody>
				</s:iterator>
				<!-- 版面列表结束 -->
				
				<tr height="3"><td colspan="9"></td></tr>
			</table>
		</div>
	</center>
</div>
</body>
</html>
