package org.apache.jsp.jsp.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<script src=\"validate.js\" ></script>\r\n");
      out.write("<script src=\"icommon.js\" ></script>\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      //  html:html
      org.apache.struts.taglib.html.HtmlTag _jspx_th_html_005fhtml_005f0 = (org.apache.struts.taglib.html.HtmlTag) _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flang.get(org.apache.struts.taglib.html.HtmlTag.class);
      _jspx_th_html_005fhtml_005f0.setPageContext(_jspx_page_context);
      _jspx_th_html_005fhtml_005f0.setParent(null);
      // /jsp/home/header.jsp(12,0) name = lang type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_html_005fhtml_005f0.setLang(true);
      int _jspx_eval_html_005fhtml_005f0 = _jspx_th_html_005fhtml_005f0.doStartTag();
      if (_jspx_eval_html_005fhtml_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  <head>\r\n");
          out.write("    <title></title>\r\n");
          out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" >\r\n");
          out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" >\r\n");
          out.write("\t<base href=\"");
          out.print(basePath);
          out.write("\">\r\n");
          out.write("\t<script type=\"text/javascript\">\r\n");
          out.write("\t\tfunction logout()\r\n");
          out.write("\t\t{\r\n");
          out.write("\t\t\twindow.parent.location.href=\"../../user.do?method=loginOut\";\r\n");
          out.write("\t\t}\r\n");
          out.write("\t</script>\r\n");
          out.write("\r\n");
          out.write("  </head>\r\n");
          out.write("  <body style=\"border-bottom:solid 1px #666;\">\r\n");
          out.write("\t<TABLE style=\"width:100%;\">\r\n");
          out.write("\t<TR >\r\n");
          out.write("\t\t<td >&nbsp;<img src=\"images/top1.jpg\" style=\"width: 180px;height: 60px;border-color: blue;\"></td>\r\n");
          out.write("\t\t<td style=\"font-family:黑体;font-size:33px;font-weight:bold;\"> 辅修课程管理系统</td>\t\r\n");
          out.write("\t\t<td width=\"25%\" align=\"right\" style=\"font-size:12px;\" valign=\"bottom\">\r\n");
          out.write("\t\t\t<b>当前登录用户:</b> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.USER.userName }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&nbsp;&nbsp;(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.USER.roleinfo.roleName }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(")&nbsp;&nbsp;&nbsp; [<a href=\"javascript:logout()\" style=\"text-decoration: none;\">注销</a>]&nbsp;&nbsp;<br />\r\n");
          out.write("\t\t </td>\r\n");
          out.write("\t</tr>\r\n");
          out.write("\t\r\n");
          out.write("\t</table>\r\n");
          out.write("  </body>\r\n");
          out.write("  \r\n");
          int evalDoAfterBody = _jspx_th_html_005fhtml_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_html_005fhtml_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flang.reuse(_jspx_th_html_005fhtml_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fhtml_005fhtml_0026_005flang.reuse(_jspx_th_html_005fhtml_005f0);
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
}
