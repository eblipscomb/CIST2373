package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PatientLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Patient Login Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Bright Smiles Dental</h1>        \n");
      out.write("        <br>\n");
      out.write("        <div id=\"login-box\">\n");
      out.write("            <h2>Patient Login</h2>\n");
      out.write("            <form action=\"http://localhost:8084/DentalOfficeBank/LoginServlet\"  method=\"post\">             \n");
      out.write("            <p>\n");
      out.write("            <div>\n");
      out.write("                <span>Patient ID:</span>\n");
      out.write("                <input type =\"text\" name=\"idtb\">\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div>\n");
      out.write("                <span id=\"add-padding-left\">Password:</span>\n");
      out.write("                <input type=\"password\" name=\"pwtb\">\n");
      out.write("            </div>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <input type=\"submit\" name=\"login\" value=\"Login\">\n");
      out.write("                <input type=\"reset\" name=\"reset\" value=\"Clear\">\n");
      out.write("                <input type=\"hidden\" name=\"user\" value=\"patient\">\n");
      out.write("            </p>\n");
      out.write("        </form>\n");
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
