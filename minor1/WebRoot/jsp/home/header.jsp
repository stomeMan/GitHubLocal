<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="validate.js" ></script>
<script src="icommon.js" ></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <title></title>
	<link rel="stylesheet" type="text/css" href="styles.css" >
	<link rel="stylesheet" type="text/css" href="styles.css" >
	<base href="<%=basePath%>">
	<script type="text/javascript">
		function logout()
		{
			window.parent.location.href="../../user.do?method=loginOut";
		}
	</script>

  </head>
  <body style="border-bottom:solid 1px #666;">
	<TABLE style="width:100%;">
	<TR >
		<td >&nbsp;<img src="images/top1.jpg" style="width: 180px;height: 60px;border-color: blue;"></td>
		<td style="font-family:黑体;font-size:33px;font-weight:bold;"> 辅修课程管理系统</td>	
		<td width="25%" align="right" style="font-size:12px;" valign="bottom">
			<b>当前登录用户:</b> ${sessionScope.USER.userName }&nbsp;&nbsp;(${sessionScope.USER.roleinfo.roleName })&nbsp;&nbsp;&nbsp; [<a href="javascript:logout()" style="text-decoration: none;">注销</a>]&nbsp;&nbsp;<br />
		 </td>
	</tr>
	
	</table>
  </body>
  
</html:html>
