String.prototype.trim =function()
{
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function checkLogin()
{
	if($("#username").val().trim()=="")
	{
		alert('用户名不能为空');return;
	}
	if($("#password").val().trim()=="")
	{
		alert('密码不能为空');return;
	}
	$("form:first").submit();
}

function query()
{
	document.form1.action="user.do?method=toList&spb.currPage=1";//每当点查询的时候默认显示第一页
	document.form1.submit();
}
function toadd()
{
	window.location.href="user.do?method=toadd";
}
function add()  //添加用户
{
	var username = document.addform["user.username"].value.trim();
	var password = document.addform["user.password"].value.trim();
	if(username == "")
	{
		alert('用户名不能为空');
		return;
	}if(password == "")
	{
		alert('密码不能为空');
		return;
	}
	document.addform.submit();
	
}
function checkusername() //验证用户名是否存在
{
	var username1 = document.addform["user.username"].value.trim();
    var check = $("#check");
	$.ajax({
		   type: "POST",
		   url: "user.do?method=checkusername",
		   data: "username="+username1,
		   success: function(data){
		      if(data != "")
		      {
		        check.html(data);
		        document.addform["user.username"].value="";
		      }else
		      {
		    	  check.html("用户名可用!");
		      }
		   }
		});
	
}
//查看用户

function detail(userid,flag)
{
	
	window.location.href="user.do?method=detail&userid="+userid+"&flag="+flag;
}
//删除用户
function del(id,username)
{
	var isdelete = window.confirm('确定删除用户  ['+username+'] ?');
	if(isdelete)
	{
		$.ajax({
			   type: "POST",
			   url: "user.do?method=delete&userid="+id,
	           success: function(data){
			   if(data == 1)
			      {
			       alert('删除成功!');
			      }else
			      {
			    	  alert('删除失败! 用户['+username+']可能已被删除');
			      }
			      $("form:first").submit();
			   }
			});
		
	}

	
}
function toedit(userid,flag)
{
	
	window.location.href="user.do?method=toedit&userid="+userid+"&flag="+flag;
}
function toassign(userid,flag)
{
	window.location.href="user.do?method=toassign&userid="+userid+"&flag="+flag;
}
function assign()
{
	
	var roleid = document.assignform["user.role.roleid"].value;
	if(roleid == "0")
	{
		alert("请选择一个角色");
		return false;
	}
	var isassign = window.confirm("确定给该用户分配角色吗");
	if(isassign)
	{
		document.assignform.submit();
	}
}

function backtoList()
{
	window.location.href="user.do?method=toList";
}
function tohistory()
{
	var date = new Date();
	window.history.go(-1);
}


