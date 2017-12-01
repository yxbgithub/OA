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
	<title>查看主题：新手发帖</title>
	<link type="text/css" rel="stylesheet" href="style/blue/forum.css" />
	<%@ include file="/WEB-INF/jsp/public/header.jspf"%>
	<script language="javascript" src="script/fckeditor/fckeditor.js" charset="utf-8"></script>
    <script type="text/javascript">
	    function gotoPage(pageNUm) {
			window.location.href = "oa/topic_topicShow.do?id=${topic.id}&currentPage=" + pageNUm;
		}
    
		$(function(){
			var fck = new FCKeditor("content");
			fck.Width = "90%";
			fck.ToolbarSet = "bbs";
			fck.BasePath = "script/fckeditor/";
			fck.ReplaceTextarea();
		});
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 查看主题
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--内容显示-->	
<div id="MainArea">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1" style="width: 98%">
			<font class="MenuPoint"> &gt; </font>
			<a href="oa/forum_list.do">论坛</a>
			<font class="MenuPoint"> &gt; </font>
			<a href="oa/forum_forumShow.do?id=${topic.forum.id}">${topic.forum.name}</a>
			<font class="MenuPoint"> &gt;&gt; </font>
			帖子阅读
			<span style="margin-left:30px;"><a href="oa/topic_addUI?forumId=${topic.forum.id}">
				<img align="absmiddle" src="style/blue/images/button/publishNewTopic.png"/></a>
			</span>
		</div>
		
		<div class="ForumPageTableBorder dataContainer" datakey="replyList">
		
			<!--显示主题标题等-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr valign="bottom">
				<td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
					<td class="ForumPageTableTitle"><b>本帖主题：${topic.title}</b></td>
					<td class="ForumPageTableTitle" align="right" style="padding-right:12px;">
						<a class="detail" href="oa/reply_addUI.do?topicId=${topic.id}"><img border="0" src="style/images/reply.gif" />回复</a>
						<a href="moveUI.html"><img border="0" src="style/images/edit.gif" />移动到其他版块</a>
						<a href="oa/topic_setType.do?id=${topic.id}&type=1" onClick="return confirm('要把本主题设为精华吗？')"><img border="0" src="style/images/forum_hot.gif" />精华</a>
						<a href="oa/topic_setType.do?id=${topic.id}&type=2" onClick="return confirm('要把本主题设为置顶吗？')"><img border="0" src="style/images/forum_top.gif" />置顶</a>
						<a href="oa/topic_setType.do?id=${topic.id}&type=0" onClick="return confirm('要把本主题设为普通吗？')"><img border="0" src="style/images/forum_comm.gif" />普通</a>
					</td>
					<td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="4"></td></tr>
			</table>

			<!-- ~~~~~~~~~~~~~~~ 显示主帖 ~~~~~~~~~~~~~~~ -->
			<div class="ListArea">
				<table border="0" cellpadding="0" cellspacing="1" width="100%">
					<tr>
						<td rowspan="3" width="130" class="PhotoArea" align="center" valign="top">
							<!--作者头像-->
							<div class="AuthorPhoto">
								<img border="0" width="110" height="110" src="style/images/defaultAvatar.gif" 
									onerror="this.onerror=null; this.src='style/images/defaultAvatar.gif';" />
							</div>
							<!--作者名称-->
							<div class="AuthorName"><s:property value="%{#session.user.name}"/></div>
						</td>
						<td align="center">
							<ul class="TopicFunc">
								<!--操作列表-->
								<li class="TopicFuncLi">
									<a class="detail" href="BBS_Topic/saveUI.html"><img border="0" src="style/images/edit.gif" />编辑</a>
									<a class="detail" href="#" onClick="return confirm('确定要删除本帖吗？')"><img border="0" src="style/images/delete.gif" />删除</a>
								</li>
								<!-- 文章表情与标题 -->
								<li class="TopicSubject">
									<img width="19" height="19" src="style/images/face/face1.gif"/>
									<s:property value="%{#topic.title}"/>
								</li>
							</ul>
						</td>
					</tr>
					<tr><!-- 文章内容 -->
						<td valign="top" align="center">
							<!-- escape=false注意设置 -->
							<div class="Content"><s:property value="%{#topic.content}" escape="false"/></div>
						</td>
					</tr>
					<tr><!--显示楼层等信息-->
						<td class="Footer" height="28" align="center" valign="bottom">
							<ul style="margin: 0px; width: 98%;">
								<li style="float: left; line-height:18px;"><font color=#C30000>[楼主]</font>
									<s:date name="%{#topic.postDate}" format="yyyy-MM-dd HH:mm"/>
								</li>
								<li style="float: right;"><a href="javascript:scroll(0,0)">
									<img border="0" src="style/images/top.gif" /></a>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			<!-- ~~~~~~~~~~~~~~~ 显示主帖结束 ~~~~~~~~~~~~~~~ -->


			<!-- ~~~~~~~~~~~~~~~ 显示回复列表 ~~~~~~~~~~~~~~~ -->
			<s:iterator value="%{recordList}" status="status">
				<div class="ListArea template">
					<table border="0" cellpadding="0" cellspacing="1" width="100%">
						<tr>
							<td rowspan="3" width="130" class="PhotoArea" align="center" valign="top">
								<!--作者头像-->
								<div class="AuthorPhoto">
									<img border="0" width="110" height="110" src="style/images/defaultAvatar.gif" 
										onerror="this.onerror=null; this.src='style/images/defaultAvatar.gif';" />
								</div>
								<!--作者名称-->
								<div class="AuthorName"><s:property value="%{author.name}"/></div>
							</td>
							<td align="center">
								<ul class="TopicFunc">
									<!--操作列表-->
									<li class="TopicFuncLi">
										<a class="detail" href="BBS_Topic/saveUI.html"><img border="0" src="style/images/edit.gif" />编辑</a>
										<a class="detail" href="#" onClick="return confirm('确定要删除本帖吗？')"><img border="0" src="style/images/delete.gif" />删除</a>
									</li>
									<!-- 文章表情与标题 -->
									<%-- <li class="TopicSubject">
										<img width="19" height="19" src="style/images/face/${reply.faceIcon}"/>
										<s:property value="%{title}"/>
									</li> --%>
								</ul>
							</td>
						</tr>
						<tr><!-- 文章内容 -->
							<td valign="top" align="center">
								<div class="Content"><s:property value="%{content}" escape="false"/></div>
							</td>
						</tr>
						<tr><!--显示楼层等信息-->
							<td class="Footer" height="28" align="center" valign="bottom">
								<ul style="margin: 0px; width: 98%;">
									<li style="float: left; line-height:18px;"><font color=#C30000>[<s:property value="%{(currentPage-1)*pageSize + #status.count}"/> 楼]</font>
										<s:date name="%{postDate}" format="yyyy-MM-dd HH:mm"/>
									</li>
									<li style="float: right;"><a href="javascript:scroll(0,0)">
										<img border="0" src="style/images/top.gif" /></a>
									</li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
			</s:iterator>
			<!-- ~~~~~~~~~~~~~~~ 显示回复列表结束 ~~~~~~~~~~~~~~~ -->
		</div>

		<!--分页信息-->
		<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>

		<div class="ForumPageTableBorder" style="margin-top: 25px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr valign="bottom">
					<td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
					<td class="ForumPageTableTitle"><b>快速回复</b></td>
					<td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine">
					<td colspan="3"></td>
				</tr>
			</table>
		</div>
	</center>
			
	<!--快速回复-->
	<div class="QuictReply">
	<form action="">
		<div style="padding-left: 3px;">
			<table border="0" cellspacing="1" width="98%" cellpadding="5" class="TableStyle">
				<tr height="30" class="Tint">
					<td width="50px" class="Deep"><b>标题</b></td>
					<td class="no_color_bg">
						<input type="text" name="title" class="InputStyle" value="回复：昨天发现在表单里删除的图片" style="width:90%"/>
					</td>
				</tr>
				<tr class="Tint" height="200">
					<td valign="top" rowspan="2" class="Deep"><b>内容</b></td>
					<td valign="top" class="no_color_bg">
						<textarea name="content" style="width: 95%; height: 300px"></textarea>
					</td>
				</tr>
				<tr height="30" class="Tint">
					<td class="no_color_bg" colspan="2" align="center">
						<input type="image" src="style/blue/images/button/submit.PNG" style="margin-right:15px;"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
	</div>
</div>

<div class="Description">
	说明：<br />
	1，主帖只在第一页显示。<br />
	2，只有是管理员才可以进行“移动”、“编辑”、“删除”、“精华”、“置顶”的操作。<br />
	3，删除主帖，就会删除所有的跟帖（回复）。<br />
</div>

</body>
</html>
