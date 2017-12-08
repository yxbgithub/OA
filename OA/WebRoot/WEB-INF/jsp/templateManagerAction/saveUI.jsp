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
	<title>文档模板信息</title>
	 <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
	 <script type="text/javascript">
	     $().ready(function() { 
	    	 if(${null==name}) {
	    	    $("form").validate({
	    	    	rules:{
	    	    		upload:{
	    	    			required:true,
	    	    			accept:"doc"
	    	    		}
	    	    	},
	    	    	messages: {
	    	    		upload: {
	    	    			required:"请添加文件",
	    	    			accept:"请添加正确格式的文件"
	    	    		}
	    	    	}
	    	    });
	    	 }
	    	});
     </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 文档模板信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
	<s:form action="templateManager_%{#parameters.id == null ? 'add' : 'edit'}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="<s:property value='%{id}'/>">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" /> 模板基本信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
				   	<tr>
                        <td>模板名称</td>
                        <td>  <input type="text" name="name"  value='<s:property value="%{model.name}"/>' class="InputStyle" />  *</td>
                    </tr>
                    <tr>
                        <td>所用流程</td>
                        <td>
                        	<s:select list="pdList" cssclass="SelectStyle" name="definationName" listKey="key" listValue="key">
							</s:select> *
						</td>
                    </tr>
                </table>
            </div>
        </div>
		
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" /> 模板文件 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
				   	<tr>
                        <td width="120px;">请选择文件(doc格式)</td>
                        <td><input type="file" name="upload" class="InputStyle" style="width:450px;" /> </td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
        </div>
	</s:form>
</div>

<div class="Description">
	<s:debug></s:debug>
	说明：<br />
	1，模板文件是doc扩展名的文件（Word文档）。<br />
	2，如果是添加：必须要选择模板文件。<br />
	3，如果是修改：只是在 需要更新模板文件时 才选择一个文件。
</div>

</body>
</html>

</html>
