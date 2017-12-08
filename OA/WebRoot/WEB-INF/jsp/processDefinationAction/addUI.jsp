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
	<title>部署流程定义</title>
	<%@ include file="/WEB-INF/jsp/public/header.jspf"%>
	<script type="text/javascript">
	     $().ready(function() {
	    	    $("form").validate({
	    	    	rules:{
	    	    		zipFile:{
	    	    			required:true,
	    	    			accept:"zip"
	    	    		}
	    	    	},
	    	    	messages: {
	    	    		zipFile: {
	    	    			required:"请添加文件",
	    	    			accept:"请添加正确格式的文件"
	    	    		}
	    	    	}
	    	    });
	    	});
     </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 部署流程定义
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
	<form action="oa/processDefination_add.do" method="post" enctype="multipart/form-data">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> 部署流程定义 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
						<td>请选择流程定义文档(zip格式)</td>
                        <td><input type="file" name="zipFile" class="InputStyle" style="width:450px;" /> *</td>
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

<div class="Description">
	说明：只接受zip扩展名的文件。
</div>

</body>
</html>
