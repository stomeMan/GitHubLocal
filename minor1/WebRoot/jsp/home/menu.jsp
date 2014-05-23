<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<base href="<%=basePath%>">
	<title>欢迎使用！</title>
	<style type="text/css">
	font {
		color: white;
	}
	a {
		color: #333;
		text-decoration: none;
	}
	a:LINK{
		text-decoration: none;
	}
</style>
<link rel="stylesheet" type="text/css" href="css/dtree.css" >
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<script type="text/javascript" src="javascript/dtree.js"></script>
</head>
<body > 
${sessionScope.MENU_STRING} 
</body>

</html:html>











