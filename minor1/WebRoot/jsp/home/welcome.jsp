<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="validate.js" ></script>
<script src="icommon.js" ></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
  	<base href="<%=basePath%>">
    <title>ª∂”≠ π”√£°</title>
	<link rel="stylesheet" type="text/css" href="styles.css" >
  </head>
  <body style="padding-top:40px;">

		<p align="center"><img src="images/welcome.jpg"></img></p>	
  </body>
</html:html>
