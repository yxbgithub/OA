<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
<html>
<head>
	<title>帖子回复</title>
	<link type="text/css" rel="stylesheet" href="style/blue/forum.css" />
	<%@ include file="/WEB-INF/jsp/public/header.jspf" %>
	<script language="javascript" src="fckeditor/fckeditor.js" charset="utf-8"></script>
    <script type="text/javascript">
   		 $().ready(function(){
			var fck = new FCKeditor("content");
			fck.Width = "99%";
			fck.Height = "100%";
			fck.ToolbarSet = "bbs";
			fck.BasePath = "fckeditor/";
			//fck.Config['SkinPath'] = "scriipt/fckeditoreditor/skins/office2003/";
			//fck.Config['SkinPath'] = "http://bbs.itcast.cn:80/widgets/fckeditor/editor/skins/office2003/";
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
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 帖子回复
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
<form action="oa/reply_add.do" style="margin: 0; padding: 0;">
	<input type="hidden" name="topicId" value="${topicId}">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1">
			<div width=85% style="float:left">
				<font class="MenuPoint"> &gt; </font>
				<a href="BBS_Forum/forumList.html">论坛</a>
				<font class="MenuPoint"> &gt; </font>
				<a href="BBS_Forum/forumShow.html">销售常见问题</a>
				<font class="MenuPoint"> &gt;&gt; </font>
				帖子回复
			</div>
		</div>
		<div class="ItemBlockBorder">
			<table border="0" cellspacing="1" cellpadding="1" width="100%" id="InputArea">
				<!-- <tr>
					<td class="InputAreaBg" height="30"><div class="InputTitle">帖子主题</div></td>
					<td class="InputAreaBg"><div class="InputContent">新闻、通知、公告的类别怎么设置？</div></td>
				</tr>
				<tr>
					<td class="InputAreaBg" height="30"><div class="InputTitle">标题</div></td>
					<td class="InputAreaBg"><div class="InputContent">
						<input type="text" name="title" class="InputStyle" style="width:100%" value="回复：新闻、通知、公告的类别怎么设置？"/></div>
					</td>
				</tr> -->
				<tr>
					<td class="InputAreaBg" height="30"><div class="InputTitle">表情</div></td>
					<td class="InputAreaBg"><div class="InputContent">
						<!-- 显示表情符号 -->
						<!--现在在设计单选框(radio)和复选框(checkbox)时都会给选择文字加上label增大选择范围，以提高用户体验。
							但在给单独的图片加label时无法成功。
							解决方法是：给图片img标签加上disabled即可。-->
						<table cellpadding="0" border="0" cellspacing="0">
							<tr>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="1" id="r_1"/>
									<label for="r_1"><img width="19" height="19" src="style/images/face/face1.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="2" id="r_2"/>
									<label for="r_2"><img width="19" height="19" src="style/images/face/face2.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="3" id="r_3"/>
									<label for="r_3"><img width="19" height="19" src="style/images/face/face3.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="4" id="r_4"/>
									<label for="r_4"><img width="19" height="19" src="style/images/face/face4.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="5" id="r_5"/>
									<label for="r_5"><img width="19" height="19" src="style/images/face/face5.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="6" id="r_6"/>
									<label for="r_6"><img width="19" height="19" src="style/images/face/face6.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="7" id="r_7"/>
									<label for="r_7"><img width="19" height="19" src="style/images/face/face7.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="8" id="r_8"/>
									<label for="r_8"><img width="19" height="19" src="style/images/face/face8.gif" align="absmiddle" disabled="true"="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="9" id="r_9"/>
									<label for="r_9"><img width="19" height="19" src="style/images/face/face9.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="10" id="r_10"/>
									<label for="r_10"><img width="19" height="19" src="style/images/face/face10.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="11" id="r_11"/>
									<label for="r_11"><img width="19" height="19" src="style/images/face/face11.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="12" id="r_12"/>
									<label for="r_12"><img width="19" height="19" src="style/images/face/face12.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="13" id="r_13"/>
									<label for="r_13"><img width="19" height="19" src="style/images/face/face13.gif" align="absmiddle" disabled="true"/></label>
								</td>
								<td width="50" style="border-bottom:0 solid #ffffff">
									<input type="radio" name="faceIcon" value="14" id="r_14"/>
									<label for="r_14"><img width="19" height="19" src="style/images/face/face14.gif" align="absmiddle" disabled="true"/></label>
								</td>
							</tr>
						</table></div>
					</td>
				</tr>
				<tr height="240">
					<td class="InputAreaBg"><div class="InputTitle">内容</div></td>
					<td class="InputAreaBg"><div class="InputContent"><textarea name="content"></textarea></div></td>
				</tr>
				<tr height="30">
					<td class="InputAreaBg" colspan="2" align="center">
						<input type="image" src="style/blue/images/button/submit.PNG" style="margin-right:15px;"/>
						<a href="javascript:history.go(-1);"><img src="style/blue/images/button/goBack.png"/></a>
					</td>
				</tr>
			</table>
		</div>
	</center>
</form>
</div>

<div class="Description">
	说明：<br />
	
</div>

</body>
</html>
