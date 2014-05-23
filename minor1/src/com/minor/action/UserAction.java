package com.minor.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.minor.entity.Rightinfo;
import com.minor.entity.Roleinfo;
import com.minor.entity.Roleright;
import com.minor.entity.Userinfo;
import com.minor.form.UserForm;
import com.minor.service.UserService;

public class UserAction extends DispatchAction {

	private UserService userService=new UserService();
	public ActionForward doLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf=(UserForm)form;
		List<Userinfo> ulist=userService.checkUser(uf.getUser());
		if(ulist!=null && ulist.size()>0){
			Userinfo user=ulist.get(0);
			request.getSession().setAttribute("USER", user);
			List<Roleright> rrlist=userService.getRights(user.getRoleinfo().getRoleId());
			String menuString=buildDTreeMenuString(rrlist);
	 		request.getSession().setAttribute("MENU_STRING", menuString);
			return mapping.findForward("main");
		}
		return mapping.findForward("regerr");
	}
	public ActionForward loginOut(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().invalidate();
		return mapping.findForward("login");
	}
	private String buildDTreeMenuString(List<Roleright> r)
	{
		StringBuilder sb=new StringBuilder();
		sb.append("<script>\r\n var tree=new dTree('tree');\r\n");
		for(int i=0;i<r.size();i++)
		{
			Rightinfo rr=r.get(i).getRightinfo();
			sb.append("tree.add(\""+rr.getRightCode()+"\",\""+rr.getRightParentCode()+"\",\""+rr.getRightText()+"\",");
			if(rr.getRightUrl()==null ||"".equals(rr.getRightUrl().trim()))
			{
				sb.append("\"\"");
			}
			else
			{
				sb.append("\""+rr.getRightUrl()+"\"");
			}
			sb.append(",\""+rr.getRightTip()+"\",\"mainFrame\");\r\n");
			
		}
		sb.append("document.write(tree);");
		sb.append("</script>");
		return sb.toString();
	}

}
