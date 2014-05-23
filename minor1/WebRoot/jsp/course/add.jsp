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
    <title>��ӿγ�</title>
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
				alert("�γ�������Ϊ�գ�");
				return;
			}
			if(cre=="" || cre==null){
				alert("ѧ�ֲ���Ϊ��!");
				return;
			}
			if(per=="" || per==null){
				alert("ѧʱ����Ϊ��!");
				return;
			}
			if(tea=="" || tea==null){
				alert("�ڿ���ʦ����Ϊ��!");
				return;
			}
			if(dep=="" || dep==null){
				alert("ϵ������Ϊ��"!);
				return;
			}
			if(addr=="" || addr==null){
				alert("��ַ����Ϊ��"!);
				return;
			}
			if(stal=="" || stal==null){
				alert("�������Ϊ��"!);
				return;
			}	
		}
	</script>
  </head>

  <body class="main">
  <form action="course.do?method=doAddCourse" method="post" name="editform">
     <span style="font-weight:bold;">��ӿγ�</span>
  		<div class="button_bar">
		<input type="button" class="common_button" onclick="javascript:history.go(-1)" value="����"/>
		<input type="submit" class="common_button" onclick="clickMe()"  value="����"/>
	
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th class="input_title">�γ���</th>
				<td class="input_content">
					<input type="text" value="" name="course.courseName" id="coursename" />&nbsp;
				</td>
				<th class="input_title">ѧ��</th>
				<td class="input_content">
				<input type="text" value="" name="course.credit" maxlength="30" id="credit"/>	
				</td>
			</tr>
			<tr>
				<th class="input_title">ѧʱ</th>
				<td class="input_content">
					<input type="text" value="" name="course.period" maxlength="30" id="period"/>	
				</td>
				<th class="input_title">�ڿ���ʦ</th>
				<td class="input_content">
					<input type="text" value="" name="course.teacherName" maxlength="30" id="teachername"/>	
				</td>
			</tr>
			<tr>
				<th class="input_title">ϵ��</th>
				<td class="input_content">
					<input type="text" value="" name="course.deptName" maxlength="30" id="deptname"/>	
				</td>
				<th class="input_title">�ص�</th>
				<td class="input_content">
					<input type="text" value="" name="course.address" maxlength="30" id="address"/>	
				</td>
			</tr>
			<tr><th class="input_title">������</th>
				<td class="input_content">
					<input type="text" value="" name="course.stuTotal" maxlength="30" id="stutotal"/>	
				</td>
				<th class="input_title">����ѧ����</th>
				<td class="input_content">
					<input type="text" value="0" name="course.haveStu" maxlength="30" readonly="readonly"/>	
				</td>
			</tr>
		</table>
	
</div>
</form>	
  </body>
</html>