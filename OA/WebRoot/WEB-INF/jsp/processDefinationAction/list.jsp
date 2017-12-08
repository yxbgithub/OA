<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<title>审批流程列表</title>
<%@ include file="/WEB-INF/jsp/public/header.jspf"%>
<script type="text/javascript">
	function showProcessImage(processDefId) {
		processDefId = encodeURI(processDefId);//以utf-8对参数进行编码，如果不指定的话，不同的浏览器可能有不同的编码，所以需要我们自己指定，这样方便我们在后台转码
		var url = "oa/processDefination_showDifinationImage.do?id=" + processDefId + "&t=" + new Date() ;//加上t参数预防缓存的问题，因为每一次t参数都不一样
		window.open(url, 600, 500, "showProcessImage", true);
		//打开一个模态对话框-模式对话框就是必须先处理此对话框，否则不可以处理父窗口.
		// window.showModalDialog(url, null, "dialogHeight:500px, dialogWidth:450px;resizable:yes");
		
	}
</script>
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 审批流程管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td width="200px">流程名称</td>
					<td width="80px">最新版本</td>
					<td width="300px">说明</td>
					<td>相关操作</td>
				</tr>
			</thead>
			<s:iterator value="%{#pdList}">
				<!--显示数据列表-->
				<tbody id="TableData" class="dataContainer" datakey="processDefList">
					<tr class="TableDetail1 template">
						<td>${name}&nbsp;</td>
						<td align="CENTER">${version}&nbsp;</td>
						<td>${description}&nbsp;</td>
						<td><s:a onclick="return delConfirm()" action="processDefination_delete">
								<s:param name="key" value="%{key}"></s:param>删除
							</s:a>
							<a href="javascript: showProcessImage('${id}')">查看流程图</a>
						</td>
					</tr>
				</tbody>
			</s:iterator>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<table border="0" cellspacing="0" cellpadding="10" align="left">
					<tr>
						<td><div class="FuncBtn">
								<div class=FuncBtnHead></div>
								<div class=FuncBtnMemo>
									<s:a action="processDefination_addUI">部署流程定义文档</s:a>
								</div>
								<div class=FuncBtnTail></div>
							</div></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	
	<div class="Description">
	<s:debug></s:debug>
		说明：<br /> 1，列表显示的是所有流程定义（不同名称）的最新版本。<br />
		2，删除流程定义时，此名称的所有版本的流程定义都会被删除。<br />
	</div>

</body>
</html>

