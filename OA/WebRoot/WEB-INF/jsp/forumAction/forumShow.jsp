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
	<title>【常见问题】中的主题列表</title>
	<%@ include file="/WEB-INF/jsp/public/header.jspf" %>
	<link type="text/css" rel="stylesheet" href="style/blue/forum.css" />
	<script type="text/javascript">
			function gotoPage(pageNUm) {
				window.location.href = "oa/forum_forumShow.do?id=${forum.id}&currentPage=" + pageNUm;
			}
	
	</script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 【<s:property value="%{#forum.name}"/>】中的主题列表
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1" style="width: 98%;">
			<font class="MenuPoint"> &gt; </font>
			<a href="oa/forum_list.do">论坛</a>
			<font class="MenuPoint"> &gt; </font>
			<s:property value="%{forum.name}"/>
			<span style="margin-left:30px;"><a href='oa/topic_addUI.do?forumId=<s:property value="%{#forum.id}"/>'>
				<img align="absmiddle" src="style/blue/images/button/publishNewTopic.png"/></a>
			</span>
		</div>
		
		<div class="ForumPageTableBorder">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<!--表头-->
				<tr align="center" valign="middle">
					<td width="3" class="ForumPageTableTitleLeft">
						<img border="0" width="1" height="1" src="style/images/blank.gif" />
					</td>
					<td width="50" class="ForumPageTableTitle"><!--状态/图标-->&nbsp;</td>
					<td class="ForumPageTableTitle">主题</td>
					<td width="130" class="ForumPageTableTitle">作者</td>
					<td width="100" class="ForumPageTableTitle">回复数</td>
					<td width="130" class="ForumPageTableTitle">最后回复</td>
					<td width="3" class="ForumPageTableTitleRight">
						<img border="0" width="1" height="1" src="style/images/blank.gif" />
					</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="8"></td></tr>
				<tr height=3><td colspan=8></td></tr>
				
				<s:iterator value="%{recordList}">
				<!--主题列表-->
					<tbody class="dataContainer" datakey="topicList">
						<tr height="35" id="d0" class="template">
							<td></td>
							<td class="ForumTopicPageDataLine" align="center"><img src='style/images/topicType_${type}.gif' /></td>
							<td class="Topic"><a class="Default" href='oa/topic_topicShow.do?id=<s:property value="%{id}"/>'><s:property value="%{title}"/></a></td>
							<td class="ForumTopicPageDataLine">
								<ul class="ForumPageTopicUl">
									<li class="Author"><s:property value="%{author.name}"/></li>
									<li class="CreateTime"><s:date name="%{postDate}" format="yyyy-MM-dd HH:mm"/></li>
								</ul>
							</td>
							<td class="ForumTopicPageDataLine Reply" align="center"><b><s:property value="%{replyCount}"/></b></td>
							<td class="ForumTopicPageDataLine">
								<ul class="ForumPageTopicUl">
									<li class="Author"><s:property value="%{lastReply.author.name}"/></li>
									<li class="CreateTime"><s:date name="%{lastReply.postDate}" format="yyyy-MM-dd HH:mm"/></li>
								</ul>
							</td>
							<td></td>
						</tr>
						</tbody>
					<!--主题列表结束-->	
					</s:iterator>
					<tr height="3"><td colspan="9"></td></tr>
				
			</table>
			
			<!--其他操作-->
			<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
						<tr valign=bottom>
							<td></td>
							<td><select name="viewType">
									<option value="0">全部主题</option>
									<option value="1">全部精华贴</option>
									<!--
									<option value="2">当天的主题</option>
									<option value="3">本周的主题</option>
									<option value="4">本月的主题</option>
									-->
								</select>
								<select name="orderBy">
									<option value="0">默认排序（按最后更新时间排序，但所有置顶帖都在前面）</option>
									<option value="1">按最后更新时间排序</option>
									<option value="2">按主题发表时间排序</option>
									<option value="3">按回复数量排序</option>
								</select>
								<select name="reverse">
									<option value="true">降序</option>
									<option value="false">升序</option>
								</select>
								<input type="IMAGE" src="style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
							</td>
						</tr>
					</table>
				</div>
			</div>
			
		</div>
	</center>
</div>

<!--分页信息-->
<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>

<div class="Description">
	说明：<br />
	1，主题默认按最后更新的时间降序排列。最后更新时间是指主题最后回复的时间，如果没有回复，就是主题发表的时间。<br />
	2，帖子有普通、置顶、精华之分。置顶贴始终显示在最上面，精华贴用不同的图标标示。<br />
</div>

</body>
</html>
