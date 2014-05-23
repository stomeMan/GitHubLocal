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
    <title>添加课程</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css" >
	<script type="text/javascript">
		function clickMe(){
			var cname=document.getElementById("coursename").value;
			var cre=document.getElementById("credit").value;
			var per=document.getElementById("period").value;
			var dep=document.getElementById("deptname").value;
			var tea=document.getElementById("teachername").value;
			var addr=document.getElementById("address").value;
			var stal=document.getElementById("stutotal").value;
			if(cname=="" || cname==null){
				alert("课程名不能为空！");
				return;
			}
			if(cre=="" || cre==null){
				alert("学分不能为空!");
				return;
			}
			if(per=="" || per==null){
				alert("学时不能为空!");
				return;
			}
			if(tea=="" || tea==null){
				alert("授课老师不能为空!");
				return;
			}
			if(dep=="" || dep==null){
				alert("系名不能为空"!);
				return;
			}
			if(addr=="" || addr==null){
				alert("地址不能为空"!);
				return;
			}
			if(stal=="" || stal==null){
				alert("总名额不能为空"!);
				return;
			}	
		}
	</script>
  </head>

  <body class="main">
  <form action="course.do?method=doAddCourse" method="post" name="editform">
     <span style="font-weight:bold;">添加课程</span>
  		<div class="button_bar">
		<input type="button" class="common_button" onclick="javascript:history.go(-1)" value="返回"/>
		<input type="submit" class="common_button" onclick="clickMe()"  value="保存"/>
	
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th class="input_title">课程名</th>
				<td class="input_content">
					<input type="text" value="" name="course.courseName" id="coursename" />&nbsp;
				</td>
				<th class="input_title">学分</th>
				<td class="input_content">
				<input type="text" value="" name="course.credit" maxlength="30" id="credit"/>	
				</td>
			</tr>
			<tr>
				<th class="input_title">学时</th>
				<td class="input_content">
					<input type="text" value="" name="course.period" maxlength="30" id="period"/>	
				</td>
				<th class="input_title">授课老师</th>
				<td class="input_content">
					<input type="text" value="" name="course.teacherName" maxlength="30" id="teachername"/>	
				</td>
			</tr>
			<tr>
				<th class="input_title">系部</th>
				<td class="input_content">
					<input type="text" value="" name="course.deptName" maxlength="30" id="deptname"/>	
				</td>
				<th class="input_title">地点</th>
				<td class="input_content">
					<input type="text" value="" name="course.address" maxlength="30" id="address"/>	
				</td>
			</tr>
			<tr><th class="input_title">总名额</th>
				<td class="input_content">
					<input type="text" value="" name="course.stuTotal" maxlength="30" id="stutotal"/>	
				</td>
				<th class="input_title">已有学生数</th>
				<td class="input_content">
					<input type="text" value="0" name="course.haveStu" maxlength="30" readonly="readonly"/>	
				</td>
			</tr>
		</table>
	
</div>
</form>	
  </body>
</html>