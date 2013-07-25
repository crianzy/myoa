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
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>index</title>
</head>
<frameset rows="100,*,25" framespacing="0" border="0" frameborder="no">
    <frame src="homeAction_top.action" name="TopMenu"  scrolling="no" noresize />
    <frameset cols="180,*" id="resize">
        <frame noresize name="menu" src="homeAction_left.action" scrolling="yes" />
        <frame noresize name="right" src="homeAction_right.action" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="homeAction_bottom.action" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
