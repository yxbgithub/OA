<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>��������</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="script/jquery.js"></script>
    <script language="javascript" src="script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
</head>
<body>

<!-- ������ʾ --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--ҳ�����-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> ������Ϣ
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--��ʾ������-->
<div id=MainArea>
<s:debug></s:debug>
    <form action="oa/department_add.do" method="get">
        <div class="ItemBlock_Title1"><!-- ��Ϣ˵��<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> ������Ϣ </DIV>  -->
        </div>
        
        <!-- ��������ʾ -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">�ϼ�����</td>
                        <td><select name="parent.id" class="SelectStyle">
                        		<option value="-1" selected="selected">��ѡ����</option>
                        		<s:iterator  value="%{#departments}">
	                                <option value='<s:property value="%{id}"/>'><s:property value="%{name}"/></option>
                                </s:iterator>
                            </select>
                        </td>
                    </tr>
                    <tr><td>��������</td>
                        <td><input type="text" name="name" class="InputStyle"/> *</td>
                    </tr>
                    <tr><td>ְ��˵��</td>
                        <td><textarea name="description" class="TextareaStyle"></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- ������ -->
        <div id="InputDetailBar">
            <input type="image" src="style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
	˵����<br />
	1���ϼ����ŵ��б����в�νṹ�ģ����Σ���<br/>
	2��������޸ģ��ϼ������б��в�����ʾ��ǰ�޸ĵĲ��ż������ﲿ�š���Ϊ����ѡ�����ѻ����ѵ��Ӳ�����Ϊ�ϼ����š�<br />
</div>

</body>
</html>
	