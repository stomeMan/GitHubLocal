<%@page language="java" contentType="text/html; charset=gb2312"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
    <title>ѡ�ι���</title>
    <base href="<%=basePath%>">
    <META   HTTP-EQUIV=��Pragma��   CONTENT=��no-cache��>   
    <META   HTTP-EQUIV=��Cache-Control��   CONTENT=��no-cache��>   
    <META   HTTP-EQUIV=��Expires��   CONTENT=��0��>   
	<link rel="stylesheet" type="text/css" href="css/styles.css" >
	<script type="text/javascript">
	 	function goback()
  			{
   			history.back();
  			}
	</script>
  </head>
  
  <body class="main">
  <form action="course.do?method=selCourse" name="roleform" method="post">
  
  	<div class="page_title">�γ�����</div>
		<!-- �б����� -->
		<br />
		<div class="button_bar">
			<input type="button" class="common_button" onclick="history.go(-1)" value="����"/>
		</div>
		<table class="data_list_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
    			<td>ѧ�ţ�</td><td><input type="text" name="user.userId" value="${sessionScope.USER.userId }"/></td>
    		</tr>
    		<tr>
    			<td>������</td><td><input type="text" name="user.userName" value="${sessionScope.USER.userName}"/></td>
    		</tr>
    		<tr>
    			<td>�γ�����</td><td>
    			<input type="hidden" name="cid" value="${requestScope.COURSE.courseId }"/>
    			<input type="hidden" name="uid" value="${sessionScope.USER.userId }"/>
    			<input type="text" name="course.courseName" value="${requestScope.COURSE.courseName }"/></td>
    		</tr>
    		<tr>
    			<td>�ڿ���ʦ��</td><td><input type="text" name="course.teacherName" value="${requestScope.COURSE.teacherName }"/></td>
    		</tr>
    		<tr><td colspan="2"><input type="submit" value="����" /></td></tr>
		</table>	
	</form>
  </body>
</html>
