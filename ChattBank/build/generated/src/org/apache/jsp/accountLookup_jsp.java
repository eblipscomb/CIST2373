package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class accountLookup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Account Lookup</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                text-align: center;                \n");
      out.write("            }\n");
      out.write("            #wrapper {\n");
      out.write("                width:400px;\n");
      out.write("                margin:0px auto;\n");
      out.write("\t\tborder:1px solid #bbb;\n");
      out.write("\t\tpadding:10px;\n");
      out.write("                background-color: #f9deea\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <form action=\"http://localhost:8084/ChattBank/AccountLookupServlet\"  method=\"post\">\n");
      out.write("            <h1>Account Lookup</h1>\n");
      out.write("            <br>\n");
      out.write("            <span style=\"padding-left:85px\">AcctNo:</span>\n");
      out.write("            <input type=\"text\" name=\"number\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <span style=\"padding-left:55px\">CustomerID:</span>\n");
      out.write("            <input type=\"text\" name=\"cid\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <span style=\"padding-left:55px\">Account Type:</span>\n");
      out.write("            <input type=\"text\" name=\"type\">\n");
      out.write("            <br>   \n");
      out.write("            <br>\n");
      out.write("            <span style=\"padding-left:80px\">Balance:</span>\n");
      out.write("            <span><input type=\"text\" name=\"balance\"></span>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <span><input type=\"submit\" value=\"Lookup\"></span>\n");
      out.write("            <span><input type=\"reset\" value=\"Clear\"></span>\n");
      out.write("            <br>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
