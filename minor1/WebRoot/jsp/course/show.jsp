<%@page language="java" contentType="text/html; charset=gb2312"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
    <title></title>
    <base href="<%=basePath%>">
    <META   HTTP-EQUIV=”Pragma”   CONTENT=”no-cache”>   
    <META   HTTP-EQUIV=”Cache-Control”   CONTENT=”no-cache”>   
    <META   HTTP-EQUIV=”Expires”   CONTENT=”0”>   
	<link rel="stylesheet" type="text/css" href="css/styles.css" >
	<script type="text/javascript">
		 function goback()
  		{
   			history.back();
  		}
	</script>
  </head>
  
  <body class="main">
  <form action="" name="roleform" method="post">
  
  	<div class="page_title">听课证</div>
		<!-- 列表数据 -->
		<br />
		<div class="button_bar">
			<input type="button" class="common_button" onclick="history.go(-1)" value="返回"/>
		</div>
		<table class="data_list_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
    			<td>学号：</td><td><input type="text" name="user.userId" value="${sessionScope.USER.userId }" readonly="readonly"/></td>
    		</tr>
    		<tr>
    			<td>姓名：</td><td><input type="text" name="user.userName" value="${sessionScope.USER.userName}" readonly="readonly"/></td>
    		</tr>
    		<tr>
    			<td>课程名：</td><td><input type="text" name="course.courseName" value="${requestScope.COUR.courseName }" readonly="readonly"/></td>
    		</tr>
    		<tr>
    			<td>学分：</td><td><input type="text" name="course.credit" value="${requestScope.COUR.credit }" readonly="readonly"/></td>
    		</tr>
    		<tr>
    			<td>学时：</td><td><input type="text" name="course.period" value="${requestScope.COUR.period }" readonly="readonly"/></td>
    		</tr>
    		<tr>
    			<td>授课老师：</td><td><input type="text" name="course.teacherName" value="${requestScope.COUR.teacherName }" readonly="readonly"/></td>
    		</tr>
    		<tr>
    			<td>上课地点：</td><td><input type="text" name="course.address" value="${requestScope.COUR.address }" readonly="readonly"/></td>
    		</tr>
		</table>	
	</form>
  </body>
</html>
