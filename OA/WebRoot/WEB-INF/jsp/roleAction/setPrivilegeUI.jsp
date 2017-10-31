<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<title>����Ȩ��</title>
<%@ include file="/WEB-INF/jsp/public/header.jspf"%>
<script language="javascript"
	src="script/jquery_treeview/jquery.treeview.js"></script>
<link type="text/css" rel="stylesheet" href="style/blue/file.css" />
<link type="text/css" rel="stylesheet"
	href="script/jquery_treeview/jquery.treeview.css" />
	
	<script type="text/javascript">
 		// ѡ������
    	function selectAll(checkedValue){
    		$("input[type=checkbox][name=privilegeIds]").attr("checked", checkedValue);
    	}
 		
    	function doChecked( liID, checkedValue ){
			// ��ǰ�����checkboxԪ�����ڵ�liԪ��
    		var jLi = $("#" + liID);

    		// ѡ�����е�ֱ���¼�����children()������ɸѡ��һ����find()��ɸѡ���к����
    		jLi.children("ul").find("input[type=checkbox]").attr("checked", checkedValue);
    		
    		// ѡ�л�ȡ��ѡ��ֱ���ϼ�
    		if( checkedValue ){ // checkedValue��boolean�ͣ���ʾ�Ƿ�ѡ���˵�ǰ��ѡ��
    			// �����ǰ��ѡ�У���ѡ�����е�ֱ���ϼ�
				jLi.parents("li").children("input[type=checkbox]").attr("checked", checkedValue);
			}else{
				// �����ǰ��ȡ��ѡ�У�����ͬ����û�б�ѡ�е����Ҳȡ���ϼ���ѡ��״̬
				var jCheckedSibingCB = jLi.siblings("li").children("input[type=checkbox]:checked");
				if(jCheckedSibingCB.size() == 0){
					var jCheckboxInput = jLi.parent("ul").prev("label").prev("input[type=checkbox]");
					jCheckboxInput.attr("checked", checkedValue);
					
					// �ݹ����ÿһ��ֱ���ϼ�
					var jParentLi = jCheckboxInput.parent("li");
					if(jParentLi.size() > 0){
						doChecked(jParentLi.attr("id"), checkedValue);
					}
				}
			}
    	} 
		
    	$(function(){
    		$("#tree").treeview();
    	});

	</script>
</head>
<body>

	<!-- ������ʾ -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--ҳ�����-->
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> ����Ȩ��
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
	<!--��ʾ������-->
	<div id=MainArea>
		<form action="oa/role_setPrivilege.do">
		<input type="hidden" name="id" value='<s:property value="%{#role.id}"/>'>
			<div class="ItemBlock_Title1">
				<!-- ��Ϣ˵�� -->
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="style/blue/images/item_point.gif" /> ����Ϊ��<s:property value="%{#role.name}"/>������Ȩ��
				</div>
			</div>

			<!-- ��������ʾ -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<!--��ͷ-->
						<thead>
							<tr align="LEFT" valign="MIDDLE" id="TableTitle">
								<td width="300px" style="padding-left: 7px;">
									<!-- �����ȫѡԪ�ص�idָ��ΪselectAll�������к���selectAll()���ͻ��д���Ϊ��һ���÷�������ֱ����id����Ԫ�� -->
									<input type="CHECKBOX" id="cbSelectAll"
									onClick="selectAll(this.checked)" /> <label for="cbSelectAll">ȫѡ</label>
								</td>
							</tr>
						</thead>

						<!--��ʾ�����б�-->
						<tbody id="TableData">
							<tr class="TableDetail1">
								<!-- ��ʾȨ���� -->
								<td>
									<ul id='tree'>
										<s:iterator value="#topPrivileges">
											<li id='li_<s:property value="%{id}"/>'><input type='checkbox'  name='privilegeIds' value='<s:property value="%{id}"/>' id='cb_<s:property value="%{id}"/>' <s:if test="%{id in #role.privileges.{id}}"> checked="checked"</s:if> onclick='doChecked("li_<s:property value="%{id}"/>", this.checked)' /> 
												<label for='cb_<s:property value="%{id}"/>'><span class='folder' id='<s:property value="%{id}"/>'><s:property value="%{name}"/></span></label>
												<ul>
													<s:iterator value="children">
														<li id='li_<s:property value="%{id}"/>'>
														<input type='checkbox' name='privilegeIds' value='<s:property value="%{id}"/>' id='cb_<s:property value="%{id}"/>' <s:if test="%{id in #role.privileges.{id}}"> checked="checked"</s:if> onclick='doChecked("li_<s:property value="%{id}"/>", this.checked)'/>
														<label for='cb_<s:property value="%{id}"/>'><span class='folder' id='<s:property value="%{id}"/>'><s:property value="%{name}"/></span></label>
														
															<ul>
															<s:iterator value="children">
																<li id='li_<s:property value="%{id}"/>'>
																<input type='checkbox' name='privilegeIds' value='<s:property value="%{id}"/>' id='cb_<s:property value="%{id}"/>' <s:if test="%{id in #role.privileges.{id}}"> checked="checked"</s:if> onclick='doChecked("li_<s:property value="%{id}"/>", this.checked)'/>
																<label for='cb_<s:property value="%{id}"/>'><span class='folder' id='<s:property value="%{id}"/>'><s:property value="%{name}"/></span></label>
																</li>
																</s:iterator>
															</ul>
														</li>
													</s:iterator>
												</ul>
											</li>	
										</s:iterator>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<!-- ������ -->
			<div id="InputDetailBar">
				<input type="image" src="style/images/save.png" /> <a
					href="javascript:history.go(-1);"><img
					src="style/images/goBack.png" /></a>
			</div>
		</form>
	</div>
	<div class="Description">
		˵����<br /> 1��ѡ��һ��Ȩ��ʱ��<br /> &nbsp;&nbsp;&nbsp;&nbsp; a��Ӧ��ѡ�� ��������ֱϵ�ϼ���<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b��Ӧ��ѡ����������ֱϵ�¼���<br /> 2��ȡ��ѡ��һ��Ȩ��ʱ��<br />
		&nbsp;&nbsp;&nbsp;&nbsp; a��Ӧ��ȡ��ѡ�� ��������ֱϵ�¼���<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b�����ͬ����Ȩ�޶���δѡ��״̬����Ӧ��ȡ��ѡ������ֱ���ϼ������ݹ����������������<br />

		3��ȫѡ/ȡ��ȫѡ��<br /> 4��Ĭ��ѡ�е�ǰ��λ���е�Ȩ�ޡ�<br />
	</div>

</body>
</html>
