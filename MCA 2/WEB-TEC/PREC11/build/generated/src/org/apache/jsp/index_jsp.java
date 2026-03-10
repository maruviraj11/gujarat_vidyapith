package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function validationform()\n");
      out.write("            {\n");
      out.write("                let name=document.getElementById(\"name\").value;\n");
      out.write("                let lastname=document.getElementById(\"lastname\").value;\n");
      out.write("                let email=document.getElementById(\"email\").value;\n");
      out.write("                let password=document.getElementById(\"password\").value;\n");
      out.write("                \n");
      out.write("                if(name==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"NAME REQIERD\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(lastname==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"LAST NAME REQIERD\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(email==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"EMAIL REQUIERD\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(password == \"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"ENTER PASSWORD\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(password.length<6)\n");
      out.write("                {\n");
      out.write("                    alert(\"ENTER A PASSWORD REQIERED FILED\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                alert(\"LOGIN SUUCCESSFULLY\");\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("            </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>THIS IS A LOGIN PAGE</h1>\n");
      out.write("        \n");
      out.write("        <form action=\"prec\"  method=\"post\" onsubmit=\" return validationform()\">\n");
      out.write("            \n");
      out.write("            <label>ENTER A NAME</label><br><br>\n");
      out.write("            <input type=\"text\" id=\"name\"><br><br>\n");
      out.write("            <label>ENTER A LAST NAME</label><br><br>\n");
      out.write("            <input type=\"text\" id=\"lastname\"><br><br>\n");
      out.write("            <label>ENTER A EMAIL</label><br><br>\n");
      out.write("            <input type=\"text\" id=\"email\"><br><br>\n");
      out.write("            \n");
      out.write("            <label>PASSWORD</label><br><br>\n");
      out.write("            <input type=\"password\" id=\"password\"><br><br>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" id=\"sbtn\">\n");
      out.write("            \n");
      out.write("        </form>\n");
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
