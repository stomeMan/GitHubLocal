String.prototype.trim =function()
{
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
//��ѯ
function salequery(){
	document.form1.action="chance.do?method=toPlanList&spb.currPage=1";
	document.form1.submit();
}
//ת��ָ���ƻ�ҳ��
function toDev_plan(id){
	window.location.href="plan.do?method=toDev_plan&id="+id;
}
//ת��ִ�мƻ�ҳ��
function toDev_execute(id){
	window.location.href="plan.do?method=toDev_execute&id="+id;
}
//ת���鿴�ƻ�ҳ��
function toDev_detail(id){
	window.location.href="plan.do?method=toDev_detail&id="+id;
}
//ָ���ƻ�
function addDev_plan(){
	var date=document.form2["sp.date"].value.trim();
	var plantodo=document.form2["sp.plantodo"].value.trim();
	if(date==""){
		alert("ʱ��δָ��");
		return;
	}
	if(plantodo==""){
		alert("�ƻ����Ϊ��");
		return;
	}
	//alert("����ɹ�");
	document.form2.submit();
}
//���¿����ƻ���
function saveDev_plan(pid,index,id){
	var plantodo=document.form1["plan"+index].value.trim();
	if(plantodo==""){
		alert("�ƻ����Ϊ��");
		return;
	}
	document.form1.action="plan.do?method=updateDev_plan&sp.id="+pid+"&sp.plantodo="+plantodo+"&sp.saleChance.id="+id;
	alert("����ɹ�");
	document.form1.submit();
}
//ɾ�������ƻ���
function delDev_plan(pid,id){
	var isdelete = window.confirm("ȷ��ɾ���ÿ����ƻ���?");
	if(isdelete)
	{
		document.form1.action="plan.do?method=delDev_plan&pid="+pid+"&id="+id;
		alert("��ɾ��");
		document.form1.submit();
	}else{
		return;
	}
}
//���ִ��Ч��
function updateDev_execute(pid,index,id){
	var planresult=document.form1["plan"+index].value.trim();
	document.form1.action="plan.do?method=updateDev_execute&sp.id="+pid+"&sp.planresult="+planresult+"&sp.saleChance.id="+id;
	alert("����ɹ�");
	document.form1.submit();
}
//��ֹ����
function updateStat(id){
	var isdelete = window.confirm("ȷ����ֹ�����ÿ����ƻ���?");
	if(isdelete)
	{
		alert('����ʧ�ܣ��ѹ鵵��');
		window.location.href="plan.do?method=updateStat&id="+id;
	}else{
		return;
	}
}
//�����ɹ�
function addCustomer(id){
	var isdelete = window.confirm("ȷ����Ӵ˿ͻ�?");
	if(isdelete)
	{
		alert('�û������ɹ���������¿ͻ���¼��');
		window.location.href="plan.do?method=addCustomer&id="+id;
	}else{
		return;
	}
}