<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>部门设置</title>
    <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>

<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 部门信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<!--显示表单内容-->
<div id=MainArea>
    <form action='oa/department_<s:property value="%{#parameters.id == null ? 'add' : 'edit'}"/>.do' method="get">
    	<input type="hidden" name="parentId" value='<s:property value="%{parentId}"/>'/>
    	<input type="hidden" name="id" value='<s:property value="%{id}"/>'/>
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">上级部门</td>
                        <td><select name="parent.id" class="SelectStyle">
                                <option value="-1"  <s:if test="%{parentId == null}">selected="selected"</s:if> >请选择部门</option>
                                <s:iterator value="%{#departments}">
	                                <option value='<s:property value="%{id}"/>'    <s:if test="%{parentId.intValue() == id}">selected="selected"</s:if> >   <s:property value="%{name}"/>
                                </s:iterator>
                            </select>
                        </td>
                    </tr>
                    <tr><td>部门名称</td>
                        <td><input type="text" name="name" value='<s:property value="name"/>' class="InputStyle"/> *</td>
                    </tr>
                    <tr><td>职能说明</td>
                        <td><textarea name="description" class="TextareaStyle"><s:property value="description"/></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
        </div>
    </form>
</div>
<s:debug></s:debug>
<div class="Description">
	说明：<br />
	1，上级部门的列表是有层次结构的（树形）。<br/>
	2，如果是修改：上级部门列表中不能显示当前修改的部门及其子孙部门。因为不能选择自已或自已的子部门作为上级部门。<br />
</div>

</body>
</html>
