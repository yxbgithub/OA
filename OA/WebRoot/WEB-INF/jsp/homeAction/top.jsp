<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Top</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="style/blue/top.css" />
</head>

<body class="PageBody" style="margin: 0">

	<div id="Head1">
		<div id="Logo">
			<a id="msgLink" href="javascript:void(0)"></a> <font color="#0000CC"
				style="color:#F1F9FE; font-size:28px; font-family:Arial Black, Arial">Itcast
				OA</font>
			<!--<img border="0" src="style/blue/images/logo.png" />-->
		</div>

		<div id="Head1Right">
			<div id="Head1Right_UserName">
				<img border="0" width="13" height="14"
					src="style/images/top/user.gif" /> ���ã�<b><s:property value="%{#session.user.name}"/></b>
			</div>
			<div id="Head1Right_UserDept"></div>
			<div id="Head1Right_UserSetup">
				<a href="javascript:void(0)"> <img border="0" width="13"
					height="14" src="style/images/top/user_setup.gif" /> ��������
				</a>
			</div>
			<div id="Head1Right_Time"></div>
		</div>

		<div id="Head1Right_SystemButton">
			<a target="_parent" href="JavaScript:parent.window.location.href='oa/login_loginOut.do';"> <img
				width="78" height="20" alt="�˳�ϵͳ"
				src="style/blue/images/top/logout.gif" />
			</a>
		</div>

		<div id="Head1Right_Button">
			<a target="desktop" href="/desktop?method=show"> <img width="65"
				height="20" alt="��ʾ����" src="style/blue/images/top/desktop.gif" />
			</a>
		</div>
	</div>

	<div id="Head2">
		<div id="Head2_Awoke">
			<ul id="AwokeNum">
				<li><a target="desktop" href="javascript:void(0)"> <img
						border="0" width="11" height="13" src="style/images/top/msg.gif" />
						��Ϣ <span id="msg"></span>
				</a></li>
				<li class="Line"></li>
				<li><a target="desktop" href="javascript:void(0)"> <img
						border="0" width="16" height="11" src="style/images/top/mail.gif" />
						�ʼ� <span id="mail"></span>
				</a></li>
				<li class="Line"></li>
				<!-- �Ƿ��д������ĵ�����ʾ1������ -->
				<li><a href="Flow_Formflow/myTaskList.html" target="desktop">
						<img border="0" width="12" height="14"
						src="style/images/top/wait.gif" /> �������<span id="wait"
						class="taskListSize">1</span>��
				</a></li>

				<!-- �Ƿ��д������ĵ�����ʾ2����ʾ���� -->
				<li id="messageArea">���� 1 ���������ĵ����뼰ʱ������������</li>
			</ul>
		</div>

		<div id="Head2_FunctionList">
			<marquee style="WIDTH: 100%;" onMouseOver="this.stop()"
				onMouseOut="this.start()" scrollamount=1 scrolldelay=30
				direction=left>
				<b>���ǹ�������Ϣ</b>
			</marquee>
		</div>
	</div>

</body>
</html>
