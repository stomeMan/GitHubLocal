<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
  <META   HTTP-EQUIV=”Pragma”   CONTENT=”no-cache”>   
  <META   HTTP-EQUIV=”Cache-Control”   CONTENT=”no-cache”>   
  <META   HTTP-EQUIV=”Expires”   CONTENT=”0”>   
    <title>查看课程详细信息</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css" >
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  </head>
  <script type="text/javascript">
  function goback()
  {
   history.back();
  }
  </script>

  <body class="main">
  <c:set value="${requestScope.COURSE}" var="course"></c:set>
  <form action="user.do?method=detail" method="post" name="detailform">

  	<span class="page_title">用户信息</span>
  	<div class="button_bar">
		<input type="button" class="common_button" onclick="history.go(-1)" value="返回"/>
	</div>
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th>课程名</th>
				<td class="input_content">
					${course.courseName }&nbsp;
				</td>
				<th>学分</th>
				<td class="input_content">
					${course.credit }&nbsp;
				</td>
				<th>学时</th>
				<td class="input_content">
					${course.period }&nbsp;
				</td>
			</tr>
			<tr>
				<th>授课老师</th>
				<td class="input_content">
					${course.teacherName}&nbsp;
				</td>
				<th>专业</th>
				<td class="input_content">
					${course.deptName }&nbsp;
				</td>
				<th>地点</th>
				<td class="input_content">
					${course.address }&nbsp;
				</td>
			</tr>
			<tr>
				<th>名额</th>
				<td class="input_content">
					${course.stuTotal}&nbsp;
				</td>
				<th>已选人数</th>
				<td class="input_content">
					${course.haveStu }&nbsp;
				</td>
				<th></th>
				<td class="input_content">
					&nbsp;
				</td>
			</tr>
		</table>
</form>
  </body>
</html>
