<%@ page language="java" contentType="text/html; charset=gb2312"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
    <title>�༭�γ�</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css" >
  </head>

  <body class="main">
  <form action="course.do?method=doedit" method="post" name="editform">
     <span style="font-weight:bold;">�༭�γ�</span>
  		
  		<div class="button_bar">
		<input type="button" class="common_button" onclick="javascript:history.go(-1)" value="����"/>
	<input type="submit" class="common_button"  value="����"/>
	
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th class="input_title">�γ���</th>
				<td class="input_content">
				<input type="hidden" value="${requestScope.CO.courseId}" name="course.courseId"/>
					<input type="text" value="${requestScope.CO.courseName }" name="course.courseName" readonly="readonly"/>&nbsp;
				</td>
				<th class="input_title">ѧ��</th>
				<td class="input_content">
				<input type="text" value="${requestScope.CO.credit }" name="course.credit" maxlength="30"/>	
				</td>
			</tr>
			<tr>
				<th class="input_title">ѧʱ</th>
				<td class="input_content">
					<input type="text" value="${requestScope.CO.period }" name="course.period" maxlength="30"/>	
				</td>
				<th class="input_title">�ڿ���ʦ</th>
				<td class="input_content">
					<input type="text" value="${requestScope.CO.teacherName }" name="course.teacherName" maxlength="30"/>	
				</td>
			</tr>
			<tr>
				<th class="input_title">ϵ��</th>
				<td class="input_content">
					<input type="text" value="${requestScope.CO.deptName }" name="course.deptName" maxlength="30"/>	
				</td>
				<th class="input_title">�ص�</th>
				<td class="input_content">
					<input type="text" value="${requestScope.CO.address }" name="course.address" maxlength="30"/>	
				</td>
			</tr>
		</table>
	
</div>
</form>	
  </body>
</html>