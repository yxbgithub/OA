<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>用户信息</title>
     <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
     <script type="text/javascript">
	     $().ready(function() {
	    	    $("form").validate({
	    	    	rules:{
	    	    		loginName:"required",
	    	    			email:{
	    	    				required:true,
	    	    				email:true
	    	    			},
	    	    			phoneNumber: {
	    	    				required:true,
	    	    				rangelength:[11,11]
	    	    			}
	    	    	},
	    	    	messages: {
	    	    		phoneNumber: {
	    	    			required:"请输入电话号码",
	    	    			rangelength:"请输入11位的电话号码"
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
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action='oa/user_<s:property value="%{#parameters.id == null ? 'add' : 'edit'}"/>.do' method="post">
    <input type="hidden" name="id" value='<s:property value="%{id}"/>'/>
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">所属部门</td>
                        <td><select name="department.id" class="SelectStyle">
                                <option value="-1"  <s:if test="%{departmentId == null}">selected="selected"</s:if> >请选择部门</option>
                                <s:iterator value="%{#departments}">
	                                <option value='<s:property value="%{id}"/>'    <s:if test="%{departmentId.intValue() == id}">selected="selected"</s:if> >   <s:property value="%{name}"/>
                                </s:iterator>
                            </select> 
                        </td>
                    </tr>
                    <tr><td>登录名</td>
                        <td><input type="text" name="loginName" class="InputStyle" value='<s:property value="%{model.loginName}"/>'/> *
							（登录名要唯一）
						</td>
                    </tr>
                    <tr><td>姓名</td>
                        <td><input type="text" name="name" class="InputStyle" value='<s:property value="%{model.name}"/>'/> *</td>
                    </tr>
					<tr><td>性别</td>
                        <td><input type="RADIO" name="gender" value="male" id="male"  <s:if test="%{model.gender == 'male'}">checked="checked"</s:if> /><label for="male">男</label>
							<input type="RADIO" name="gender" value="female" id="female"  <s:if test="%{model.gender == 'female'}">checked="checked"</s:if>/><label for="female">女</label>
						</td>
                    </tr>
					<tr><td>联系电话</td>
                        <td><input type="text" name="phoneNumber" class="InputStyle" value='<s:property value="%{model.phoneNumber}"/>'/></td>
                    </tr>
                    <tr><td>E-mail</td>
                        <td><input type="text" name="email" class="InputStyle" value='<s:property value="%{model.email}"/>'/></td>
                    </tr>
                    <tr><td>备注</td>
                        <td><textarea name="description" class="TextareaStyle"><s:property value="%{#odel.description}"/></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" /> 岗位设置 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
						<td width="100">岗位</td>
                        <td><select name="roleIds" multiple="true" size="10" class="SelectStyle">
                        		<s:iterator value="%{#roles}">
	                                <option value='<s:property value="%{id}"/>' <s:iterator value="model.roles"><s:if test="%{[0].id == [1].id}">selected="selected"</s:if></s:iterator>/>
	                                <s:property value="%{name}"/>
                                </s:iterator>
                            </select>
                            按住Ctrl键可以多选或取消选择
                        </td>
                    </tr>
                </table>
            </div>
        </div>		
		<s:debug></s:debug>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image"  src="style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
        </div>
    </form>
</div>
<div class="Description">
	说明：<br />
	1，用户的登录名要唯一，在填写时要同时检测是否可用。<br />
	2，新建用户后，密码被初始化为"1234"。<br />
	3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br />
	4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
	5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
	6，修改用户信息时，登录名不可修改。
</div>

</body>
</html>
