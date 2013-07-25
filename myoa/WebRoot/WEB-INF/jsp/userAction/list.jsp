<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>用户列表</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body>
<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" >
        	<s:iterator value="userList">
        		<tr class="TableDetail1 template">
	                <td>${loginName}&nbsp;</td>
	                <td>${name}&nbsp;</td>
	                <td>${department.departmentName}&nbsp;</td>
	                <td>
	                	&nbsp;
	                	<s:iterator value="roles">
	                		${rolename }&nbsp;
	                	</s:iterator>
	                </td>
	                <td>${description}&nbsp;</td>
	                <td>
	                	<s:a href="userAction_del?id=%{id}"  onclick="javascript: delConfirm()" >删除</s:a>
	                	<%-- <a onClick="javascript: delConfirm()" href="userAction_del?id=${id }">删除</a> --%>
	                	<s:a href="userAction_editUI?id=%{id }">修改</s:a>
	                    <%-- <a href="userAction_editUI?id=${id }">修改</a> --%>
	                    <s:a href="userAction_initPassword?id=%{id }" onclick="javascript:window.confirm('您确定要初始化密码为1234吗？')">初始化密码</s:a>
						<%-- <a href="userAction_initPassword?id=${id }" onClick="javascript:window.confirm('您确定要初始化密码为1234吗？')">初始化密码</a> --%>
	                </td>
	            </tr>
        	</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        	<s:a href="userAction_addUI"><img src="style/images/createNew.png" /></s:a>
            <!-- <a href="userAction_addUI"><img src="style/images/createNew.png" /></a> -->
        </div>
    </div>
</div>

</body>
</html>
