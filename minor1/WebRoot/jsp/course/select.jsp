<%@page language="java" contentType="text/html; charset=gb2312"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%int pp=Integer.parseInt(request.getAttribute("page").toString());
  int pageCount=Integer.parseInt(request.getAttribute("pageCount").toString());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
  <META   HTTP-EQUIV=��Pragma��   CONTENT=��no-cache��>   
  <META   HTTP-EQUIV=��Cache-Control��   CONTENT=��no-cache��>   
  <META   HTTP-EQUIV=��Expires��   CONTENT=��0��>   
    <title>�鿴�γ���ϸ��Ϣ</title>
    <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/styles.css" >
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  </head>
  <script type="text/javascript">
  function goback()
  {
   history.back();
  }
  function clickMe(cid){
  	window.location.href="course.do?method=selectCourse&cid="+cid;
  }
  function deleteMe(cid,cname){
  	if(window.confirm("�Ƿ�ȷ����ѡ"+cname+"�γ̣�")){
  		window.location.href="course.do?method=delCourse&cid="+cid;
  	};
  }
  </script>

  <body class="main">
  <form action="" method="post" name="detailform">
  	<span class="page_title">���޿γ���Ϣ</span>
  	<div class="button_bar">
		<input type="button" class="common_button" onclick="history.go(-1)" value="����"/>
	</div>
	<c:if test="${sessionScope.USER.roleinfo.roleId== 2}">
		<font size="3">��ѡ�γ̣�</font><br/>
		<table  border="1"  cellPadding="3" cellSpacing="0">
			<c:forEach var="sc" items="${requestScope.SC}">
				<tr>
					<th>�γ���</th>
					<td >
						<font size="12px"></font>${sc.course.courseName }&nbsp;
					</td>
					<th>�ڿ���ʦ</th>
					<td>
						${sc.course.teacherName}&nbsp;
					</td>
					<th>רҵ</th>
					<td>
						${sc.course.deptName }&nbsp;
					</td>
					
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:deleteMe(${sc.course.courseId},'${sc.course.courseName }')">��ѡ</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</c:forEach>
			</table>
		</c:if><br/>
		<font size="3">���и��޿γ̣�</font><br/>
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<c:forEach var="course" items="${requestScope.COURSES}">
				<tr>
					<th>�γ���</th>
					<td class="input_content">
						${course.courseName }&nbsp;
					</td>
					<th>�ڿ���ʦ</th>
					<td class="input_content">
						${course.teacherName}&nbsp;
					</td>
					<th>רҵ</th>
					<td class="input_content">
						${course.deptName }&nbsp;
					</td>
					<c:if test="${sessionScope.USER.roleinfo.roleId== 2}">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="clickMe(${course.courseId})" value="ѡ��"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</c:if>
				</tr>
			</c:forEach>
			<tr>
			<td colspan="8" align="center">
			<DIV>
		<c:choose>
			<c:when test="<%=pp<=1 %>">
				��һҳ
			</c:when>
			<c:otherwise>
				<a href="course.do?method=toSelect&page=<%=pp-1 %>">��һҳ</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="<%=pp==pageCount %>">
				��һҳ
			</c:when>
			<c:otherwise>
				<a href="course.do?method=toSelect&page=<%=pp+1 %>">��һҳ</a>
			</c:otherwise>
		</c:choose>
			</DIV>
			</td>
		</tr>
		</table>
</form>
  </body>
</html>
