String.prototype.trim =function()
{
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function checkLogin()
{
	if($("#username").val().trim()=="")
	{
		alert('�û�������Ϊ��');return;
	}
	if($("#password").val().trim()=="")
	{
		alert('���벻��Ϊ��');return;
	}
	$("form:first").submit();
}

function query()
{
	document.form1.action="user.do?method=toList&spb.currPage=1";//ÿ�����ѯ��ʱ��Ĭ����ʾ��һҳ
	document.form1.submit();
}
function toadd()
{
	window.location.href="user.do?method=toadd";
}
function add()  //����û�
{
	var username = document.addform["user.username"].value.trim();
	var password = document.addform["user.password"].value.trim();
	if(username == "")
	{
		alert('�û�������Ϊ��');
		return;
	}if(password == "")
	{
		alert('���벻��Ϊ��');
		return;
	}
	document.addform.submit();
	
}
function checkusername() //��֤�û����Ƿ����
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
		    	  check.html("�û�������!");
		      }
		   }
		});
	
}
//�鿴�û�

function detail(userid,flag)
{
	
	window.location.href="user.do?method=detail&userid="+userid+"&flag="+flag;
}
//ɾ���û�
function del(id,username)
{
	var isdelete = window.confirm('ȷ��ɾ���û�  ['+username+'] ?');
	if(isdelete)
	{
		$.ajax({
			   type: "POST",
			   url: "user.do?method=delete&userid="+id,
	           success: function(data){
			   if(data == 1)
			      {
			       alert('ɾ���ɹ�!');
			      }else
			      {
			    	  alert('ɾ��ʧ��! �û�['+username+']�����ѱ�ɾ��');
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
		alert("��ѡ��һ����ɫ");
		return false;
	}
	var isassign = window.confirm("ȷ�������û������ɫ��");
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


