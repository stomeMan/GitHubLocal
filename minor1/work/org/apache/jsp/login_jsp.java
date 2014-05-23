package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flang;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flang = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flang.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_html_005fhtml_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_html_005fhtml_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:html
    org.apache.struts.taglib.html.HtmlTag _jspx_th_html_005fhtml_005f0 = (org.apache.struts.taglib.html.HtmlTag) _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flang.get(org.apache.struts.taglib.html.HtmlTag.class);
    _jspx_th_html_005fhtml_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhtml_005f0.setParent(null);
    // /login.jsp(5,0) name = lang type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fhtml_005f0.setLang(true);
    int _jspx_eval_html_005fhtml_005f0 = _jspx_th_html_005fhtml_005f0.doStartTag();
    if (_jspx_eval_html_005fhtml_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("<HEAD>\r\n");
        out.write("<TITLE>客户关系管理系统</TITLE>\r\n");
        out.write("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=GB2312\">\r\n");
        out.write("<script type=\"text/javascript\" src=\"javascript/jquery.js\" charset=\"gb2312\"></script>\r\n");
        out.write("\t<script type=\"text/javascript\" src=\"javascript/user.js\" charset=\"gb2312\"></script>\r\n");
        out.write("<style>\r\n");
        out.write("\tth{\r\n");
        out.write("\t\tfont-size:12px;\r\n");
        out.write("\t\ttext-align:right;\r\n");
        out.write("\t\tfont-weight:normal;\r\n");
        out.write("\t}\r\n");
        out.write("\ttd{\r\n");
        out.write("\t\tfont-size:12px;\r\n");
        out.write("\t\ttext-align:left;\r\n");
        out.write("\t}\r\n");
        out.write("\tinput{\r\n");
        out.write("\t\twidth:100px;\r\n");
        out.write("\t\tfont-size:12px;\r\n");
        out.write("\t\tborder:solid 1px lightblue;\r\n");
        out.write("\t}\r\n");
        out.write("</style>\r\n");
        out.write("<script>\r\n");
        out.write("</script>\r\n");
        out.write("</HEAD>\r\n");
        out.write("<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 style=\"text-align:center;padding-top:20px;\">\r\n");
        out.write("\t<form action=\"user.do?method=doLogin\" method=\"post\" name=\"form1\">\r\n");
        out.write("\t\t<TABLE WIDTH=800 BORDER=0 CELLPADDING=0 CELLSPACING=0>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\t\t\t\t<TD COLSPAN=7><IMG SRC=\"images/top1.jpg\" WIDTH=253px\r\n");
        out.write("\t\t\t\t\tHEIGHT=86px ALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=1 HEIGHT=71 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\t\t\t\t<TD COLSPAN=7>&nbsp;</TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=1 HEIGHT=66 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\t\t\t\t<TD COLSPAN=7><IMG SRC=\"images/login/login_03.jpg\" WIDTH=800\r\n");
        out.write("\t\t\t\t\tHEIGHT=6 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=1 HEIGHT=6 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<TD COLSPAN=3>&nbsp;</TD>\r\n");
        out.write("\t\t\t\t<TD COLSPAN=3 ROWSPAN=2><IMG SRC=\"images/login/login_05.jpg\"\r\n");
        out.write("\t\t\t\t\tWIDTH=426 HEIGHT=83 ALT=\"\"></TD>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<TD ROWSPAN=3>&nbsp;</TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=1 HEIGHT=44 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<TD ROWSPAN=4>&nbsp;</TD>\r\n");
        out.write("\t\t\t\t<TD COLSPAN=2><IMG SRC=\"images/login/login_08.jpg\" WIDTH=94\r\n");
        out.write("\t\t\t\t\tHEIGHT=39 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><font size=\"7\"><img height=\"39\" width=\"1\"\r\n");
        out.write("\t\t\t\t\t\tsrc=\"images/login/spacer.gif\" alt=\"\"></font></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\t\t\t\t<TD ROWSPAN=3><IMG SRC=\"images/login/login_09.jpg\" WIDTH=15\r\n");
        out.write("\t\t\t\t\tHEIGHT=141 ALT=\"\"></TD>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<TD COLSPAN=2 ROWSPAN=2 background=\"images/login/login_10.jpg\">\r\n");
        out.write("\t\t\t\t\t<table width=\"100%\">\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<th>用户名</th>\r\n");
        out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"user.userId\" id=\"username\" /></td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<th>密码</th>\r\n");
        out.write("\t\t\t\t\t\t\t<td><input type=\"password\" name=\"user.pass\" id=\"password\" /></td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
        out.write("\t\t\t\t\t\t\t<td><img onclick=\"checkLogin()\" style=\"cursor: hand;\"\r\n");
        out.write("\t\t\t\t\t\t\t\tsrc=\"images/login/login_button.jpg\" width=\"73\" height=\"25\"></td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t</table>\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t</TD>\r\n");
        out.write("\t\t\t\t<TD COLSPAN=2><IMG SRC=\"images/login/login_11.jpg\" WIDTH=304\r\n");
        out.write("\t\t\t\t\tHEIGHT=86 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=1 HEIGHT=86 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\t\t\t\t<TD ROWSPAN=2><IMG SRC=\"images/login/login_12.jpg\" WIDTH=19\r\n");
        out.write("\t\t\t\t\tHEIGHT=55 ALT=\"\"></TD>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<TD COLSPAN=2 ROWSPAN=3>&nbsp;</TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=1 HEIGHT=28 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\t\t\t\t<TD COLSPAN=2><IMG SRC=\"images/login/login_14.jpg\" WIDTH=201\r\n");
        out.write("\t\t\t\t\tHEIGHT=27 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=1 HEIGHT=27 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<TD COLSPAN=5>&nbsp;</TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=1 HEIGHT=67 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<TD COLSPAN=7 background=\"images/login/login_16.jpg\"\r\n");
        out.write("\t\t\t\t\tstyle=\"text-align: right; padding-right: 25px;\">&copy; 2010\r\n");
        out.write("\t\t\t\t\t【cczu】minor</TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=1 HEIGHT=55 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t\t<TR>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=150 HEIGHT=1\r\n");
        out.write("\t\t\t\t\tALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=15 HEIGHT=1 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=79 HEIGHT=1 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=122 HEIGHT=1\r\n");
        out.write("\t\t\t\t\tALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=19 HEIGHT=1 ALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=285 HEIGHT=1\r\n");
        out.write("\t\t\t\t\tALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD><IMG SRC=\"images/login/spacer.gif\" WIDTH=130 HEIGHT=1\r\n");
        out.write("\t\t\t\t\tALT=\"\"></TD>\r\n");
        out.write("\t\t\t\t<TD></TD>\r\n");
        out.write("\t\t\t</TR>\r\n");
        out.write("\t\t</TABLE>\r\n");
        out.write("\t</form>\r\n");
        out.write("</body>\r\n");
        int evalDoAfterBody = _jspx_th_html_005fhtml_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_005fhtml_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flang.reuse(_jspx_th_html_005fhtml_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flang.reuse(_jspx_th_html_005fhtml_005f0);
    return false;
  }
}
