<%@page language="java" contentType="text/html; charset=gb2312"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
    <title>角色管理</title>
    <base href="<%=basePath%>">
    <META   HTTP-EQUIV=”Pragma”   CONTENT=”no-cache”>   
  	<META   HTTP-EQUIV=”Cache-Control”   CONTENT=”no-cache”>   
  	<META   HTTP-EQUIV=”Expires”   CONTENT=”0”>   
	<link rel="stylesheet" type="text/css" href="css/styles.css" >
	<script type="text/javascript">
		function query(cId){
			var cname=document.getElementById("coursename").value;
			if(cname=="" || cname==null){
				alert("请输入要查询的课程名！！！");
				return;
			}
			var url="course.do?method=showUsersByCname&cn="+cname;
			window.location.href=encodeURI(url);
		}
	</script>
  </head>
  
  <body class="main">
  <form action="jsp/course/add.jsp" name="roleform" method="post">
  
  	<div class="page_title">课程管理</div>
		<!-- 列表数据 -->
		<br />
		
    		 课程名:<input type="text" class="common_button" name="course.courseName" id="coursename"/>
           	<input type="button" class="common_button" onclick="query()" value="查询"/>
		<table class="data_list_table" border="0" cellPadding="3" cellSpacing="0">
		<tr>
			<th class="data_title" >编号</th>
			<th class="data_title" >课程名</th>
			<th class="data_title" >授课老师</th>
			<th class="data_title" >上课地点</th>
		</tr>
		<c:if test="${requestScope.COURSES}==null">
			<tr>
				<td class="data_cell" colspan="20" style="text-align: center; height: 40px;">
						暂时还没有记录
				</td>
			</tr>
		</c:if>
		<c:forEach var="course" items="${requestScope.COURSES}" varStatus="status">
			<tr>
				<td class="data_cell" style="text-align:right;padding:0 10px;">${status.index+1 }</td>
				<td class="data_cell" style="text-align:center;">${course.courseName }</td>
				<td class="data_cell" style="text-align:center;">${course.teacherName }&nbsp;</td>
				<td class="data_cell" style="text-align:center;">${course.address }&nbsp;</td>
			</tr>
		</c:forEach>
		</table>	
	</form>
  </body>
</html>

