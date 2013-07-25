<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>left</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<script language="JavaScript" src="script/menu.js"></script>
<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
</head>

<body style="margin: 0">
<div id="Menu">
	<ul id="MenuUl">
	<s:iterator value="#application.topPrivilegeList">
		<s:if test="#session.user.hasPrivilegeByName(name)">	
			<li class="level1">
				<div onclick="javascript:menuClick(this);" class="level1Style">
					<img src="style/images/MenuIcon/${icon }" class="Icon">
					${name }
				</div>
				<ul class="MenuLevel2">
					<s:iterator value="children">
						<s:if test="#session.user.hasPrivilegeByName(name)">
							<li class="level2">
								<div class="level2Style">
									<img  src="style/images/MenuIcon/menu_arrow_single.gif">
									<a target="right" href="${url}.action">${name }</a>
								</div>
							</li>
						</s:if>
					</s:iterator>
				</ul>
			</li>
		</s:if>
	</s:iterator>
	</ul>
</div>
</body>
</html>
