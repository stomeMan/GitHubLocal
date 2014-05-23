<%@ page language="java" contentType="text/html; charset=gb2312"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
 	 <base href="<%=basePath%>">
    <title>ѡ��γ̵�ѧ��</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css" >
      <script type="text/javascript" src="javascript/user.js" charset="gb2312"></script>
  </head>

  <body class="main">
  <form action="course.do?method=doAddCourse" method="post" name="editform">
     <span style="font-weight:bold;">ѡ��ÿγ̵�ѧ��</span>
  		
  		<div class="button_bar">
		<input type="button" class="common_button" onclick="javascript:history.go(-1)" value="����"/>
	
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
		<tr><th class="input_title">ѧ��</th><th class="input_title">����</th></tr>
		<c:forEach var="stu" items="${requestScope.CSTU}">
			<tr>
				<td class="input_content" align="center">
					${stu.userinfo.userId }&nbsp;
				</td>
				<td class="input_content" align="center">
				${stu.userinfo.userName }	
				</td>
			</tr>
		</c:forEach>
		</table>
	
</div>
</form>	
  </body>
</html>