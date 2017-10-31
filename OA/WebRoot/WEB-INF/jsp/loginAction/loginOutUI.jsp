<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<title>您已退出Itcast OA系统</title>
<link href="style/blue/logout.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
		<tr>
			<td align=center>
				<div id=Logout>
					<div id=AwokeMsg>
						<img id=LogoutImg src="style/blue/images/logout/logout.gif"
							border=0 /><img id=LogoutTitle
							src="style/blue/images/logout/logout1.gif" border=0 />
					</div>
					<div id=LogoutOperate>
						<img src="style/blue/images/logout/logout2.gif" border=0 /> <a
							href="oa/login_loginInUI.do">重新进入系统</a> <img
							src="style/blue/images/logout/logout3.gif" border=0 /> <a
							href="javascript: window.close();">关闭当前窗口</a>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
