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
	<title>�û���Ϣ</title>
     <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
</head>
<body>

<!-- ������ʾ -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--ҳ�����-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> �û���Ϣ
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--��ʾ������-->
<div id=MainArea>
    <form action='oa/user_<s:property value="%{#parameters.id == null ? 'add' : 'edit'}"/>.do'>
    <input type="hidden" name="id" value='<s:property value="%{id}"/>'/>
        <div class="ItemBlock_Title1"><!-- ��Ϣ˵�� --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" /> �û���Ϣ </div> 
        </div>
        
        <!-- ��������ʾ -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">��������</td>
                        <td><select name="department.id" class="SelectStyle">
                                <option value="-1"  <s:if test="%{departmentId == null}">selected="selected"</s:if> >��ѡ����</option>
                                <s:iterator value="%{#departments}">
	                                <option value='<s:property value="%{id}"/>'    <s:if test="%{departmentId.intValue() == id}">selected="selected"</s:if> >   <s:property value="%{name}"/>
                                </s:iterator>
                            </select> 
                        </td>
                    </tr>
                    <tr><td>��¼��</td>
                        <td><input type="text" name="loginName" class="InputStyle" value='<s:property value="%{model.loginName}"/>'/> *
							����¼��ҪΨһ��
						</td>
                    </tr>
                    <tr><td>����</td>
                        <td><input type="text" name="name" class="InputStyle" value='<s:property value="%{model.name}"/>'/> *</td>
                    </tr>
					<tr><td>�Ա�</td>
                        <td><input type="RADIO" name="gender" value="male" id="male"  <s:if test="%{model.gender == 'male'}">checked="checked"</s:if> /><label for="male">��</label>
							<input type="RADIO" name="gender" value="female" id="female"  <s:if test="%{model.gender == 'female'}">checked="checked"</s:if>/><label for="female">Ů</label>
						</td>
                    </tr>
					<tr><td>��ϵ�绰</td>
                        <td><input type="text" name="phoneNumber" class="InputStyle" value='<s:property value="%{model.phoneNumber}"/>'/></td>
                    </tr>
                    <tr><td>E-mail</td>
                        <td><input type="text" name="email" class="InputStyle" value='<s:property value="%{model.email}"/>'/></td>
                    </tr>
                    <tr><td>��ע</td>
                        <td><textarea name="description" class="TextareaStyle"><s:property value="%{#odel.description}"/></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
		<div class="ItemBlock_Title1"><!-- ��Ϣ˵�� --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="style/blue/images/item_point.gif" /> ��λ���� </div> 
        </div>
        
        <!-- ��������ʾ -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
						<td width="100">��λ</td>
                        <td><select name="roleIds" multiple="true" size="10" class="SelectStyle">
                        		<s:iterator value="%{#roles}">
	                                <option value='<s:property value="%{id}"/>' <s:iterator value="model.roles"><s:if test="%{[0].id == [1].id}">selected="selected"</s:if></s:iterator>/>
	                                <s:property value="%{name}"/>
                                </s:iterator>
                            </select>
                            ��סCtrl�����Զ�ѡ��ȡ��ѡ��
                        </td>
                    </tr>
                </table>
            </div>
        </div>		
		<s:debug></s:debug>
        <!-- ������ -->
        <div id="InputDetailBar">
            <input type="image"  src="style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
	˵����<br />
	1���û��ĵ�¼��ҪΨһ������дʱҪͬʱ����Ƿ���á�<br />
	2���½��û������뱻��ʼ��Ϊ"1234"��<br />
	3�����������ݿ��д洢����MD5ժҪ�����Ǵ洢�������룩��<br />
	4���û���¼ϵͳ�����ʹ�á��������á��޸����롱�����޸����롣<br />
	5���½��û��󣬻��Զ�ָ��Ĭ�ϵ�ͷ���û�����ʹ�á��������á�������Ϣ�������޸����ѵ�ͷ��<br />
	6���޸��û���Ϣʱ����¼�������޸ġ�
</div>

</body>
</html>
