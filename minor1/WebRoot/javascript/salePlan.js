String.prototype.trim =function()
{
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
//查询
function salequery(){
	document.form1.action="chance.do?method=toPlanList&spb.currPage=1";
	document.form1.submit();
}
//转到指定计划页面
function toDev_plan(id){
	window.location.href="plan.do?method=toDev_plan&id="+id;
}
//转到执行计划页面
function toDev_execute(id){
	window.location.href="plan.do?method=toDev_execute&id="+id;
}
//转到查看计划页面
function toDev_detail(id){
	window.location.href="plan.do?method=toDev_detail&id="+id;
}
//指定计划
function addDev_plan(){
	var date=document.form2["sp.date"].value.trim();
	var plantodo=document.form2["sp.plantodo"].value.trim();
	if(date==""){
		alert("时间未指定");
		return;
	}
	if(plantodo==""){
		alert("计划项不能为空");
		return;
	}
	//alert("保存成功");
	document.form2.submit();
}
//更新开发计划项
function saveDev_plan(pid,index,id){
	var plantodo=document.form1["plan"+index].value.trim();
	if(plantodo==""){
		alert("计划项不能为空");
		return;
	}
	document.form1.action="plan.do?method=updateDev_plan&sp.id="+pid+"&sp.plantodo="+plantodo+"&sp.saleChance.id="+id;
	alert("保存成功");
	document.form1.submit();
}
//删除开发计划项
function delDev_plan(pid,id){
	var isdelete = window.confirm("确定删除该开发计划吗?");
	if(isdelete)
	{
		document.form1.action="plan.do?method=delDev_plan&pid="+pid+"&id="+id;
		alert("已删除");
		document.form1.submit();
	}else{
		return;
	}
}
//添加执行效果
function updateDev_execute(pid,index,id){
	var planresult=document.form1["plan"+index].value.trim();
	document.form1.action="plan.do?method=updateDev_execute&sp.id="+pid+"&sp.planresult="+planresult+"&sp.saleChance.id="+id;
	alert("保存成功");
	document.form1.submit();
}
//中止开发
function updateStat(id){
	var isdelete = window.confirm("确定中止开发该开发计划吗?");
	if(isdelete)
	{
		alert('开发失败，已归档。');
		window.location.href="plan.do?method=updateStat&id="+id;
	}else{
		return;
	}
}
//开发成功
function addCustomer(id){
	var isdelete = window.confirm("确定添加此客户?");
	if(isdelete)
	{
		alert('用户开发成功，已添加新客户记录。');
		window.location.href="plan.do?method=addCustomer&id="+id;
	}else{
		return;
	}
}