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
    <title>�γ̹���</title>
    <base href="<%=basePath%>">
    <META   HTTP-EQUIV=��Pragma��   CONTENT=��no-cache��>   
  <META   HTTP-EQUIV=��Cache-Control��   CONTENT=��no-cache��>   
  <META   HTTP-EQUIV=��Expires��   CONTENT=��0��>   
	<link rel="stylesheet" type="text/css" href="css/styles.css" >
	<script type="text/javascript">
		function query(){
			var cname=document.getElementById("coursename").value;
			var dname=document.getElementById("deptname").value;
			if(cname=="" && dname==""){
				alert("������Ҫ��ѯ�Ŀγ̻�ϵ����������");
				return;
			}
			if(dname=="" ||dname==null){
				var url="course.do?method=showCourseByCname&cn="+cname;
				window.location.href=encodeURI(url);
				return;
			}
			if(cname=="" ||cname==null){
				var url="course.do?method=showCourseByDname&dn="+dname;
				window.location.href=encodeURI(url);
				return;
			}
			var url="course.do?method=showCourseByCDname&dn="+dname+"&cn="+cname;
			window.location.href=encodeURI(url);
		}
		function toAssign(courseid)
		{
			window.location.href="course.do?method=toAssign&cid="+courseid;
		}
		function del(cid,cname){
			if(window.confirm("�Ƿ�ȷ��Ҫɾ��"+cname+"?")){
				window.location.href="course.do?method=deleteCourse&cid="+cid;
				}
			}
		function toEdit(cid){
			window.location.href="course.do?method=editCourse&cid="+cid;
		}
	</script>
  </head>
  
  <body class="main">
  <form action="jsp/course/add.jsp" name="roleform" method="post">
  
  	<div class="page_title">�γ̹���</div>
		<!-- �б����� -->
		<br />
		
    		 �γ���:<input type="text" class="common_button" name="course.courseName" id="coursename"/>
        	ϵ��:<input type="text" class="common_button" name="course.deptName"/ id="deptname">
           	<input type="button" class="common_button" onclick="query()" value="��ѯ"/>
           	 <input type="submit" class="common_button"  value="�½�"/>
		<table class="data_list_table" border="0" cellPadding="3" cellSpacing="0">
		<tr>
			<th class="data_title" >���</th>
			<th class="data_title" >�γ���</th>
			<th class="data_title" >ѧ��</th>
			<th class="data_title" >ѧʱ</th>
			<th class="data_title" >��ʦ</th>
			<th class="data_title" >רҵ</th>
			<th class="data_title" >�Ͽεص�</th>
			<th class="data_title" >����</th>
		</tr>
		<c:if test="${requestScope.COURSES}==null">
			<tr>
				<td class="data_cell" colspan="20" style="text-align: center; height: 40px;">
						��ʱ��û�м�¼
				</td>
			</tr>
		</c:if>
		<c:forEach var="course" items="${requestScope.COURSES}" varStatus="status">
			<tr>
				<td class="data_cell" style="text-align:right;padding:0 10px;">${status.index+1 }</td>
				<td class="data_cell" style="text-align:center;">${course.courseName }</td>
				<td class="data_cell" style="text-align:center;">${course.credit }&nbsp;</td>
				<td class="data_cell" style="text-align:center;">${course.period }</td>
				<td class="data_cell" style="text-align:center;">${course.teacherName }&nbsp;</td>
				<td class="data_cell" style="text-align:center;">${course.deptName }</td>
				<td class="data_cell" style="text-align:center;">${course.address }&nbsp;</td>
				<td class="data_cell">
					<img onclick='toAssign(${course.courseId})' title="��ϸ��Ϣ" src="images/bt_linkman.gif" class="op_button" />
					<img onclick="del(${course.courseId},'${course.courseName }')" title="ɾ��" src="images/bt_del.gif" class="op_button" />
					<img class="op_button" onclick="toEdit(${course.courseId})" src="images/bt_edit.gif" title="�༭" />
				</td>
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
				<a href="course.do?method=manageCourse&page=<%=pp-1 %>">��һҳ</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="<%=pp==pageCount %>">
				��һҳ
			</c:when>
			<c:otherwise>
				<a href="course.do?method=manageCourse&page=<%=pp+1 %>">��һҳ</a>
			</c:otherwise>
		</c:choose>
			</DIV>
			</td>
		</tr>
		</table>	
	</form>
  </body>
</html>

