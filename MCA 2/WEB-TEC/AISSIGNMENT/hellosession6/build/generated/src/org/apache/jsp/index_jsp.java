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
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("          function validateForm()\n");
      out.write("         {\n");
      out.write("             var name = document.getElementById(\"name\").value.trim();\n");
      out.write("\n");
      out.write("             if(name === \"\")\n");
      out.write("             {\n");
      out.write("                 alert(\"do not blank any filed\");\n");
      out.write("                 return false;\n");
      out.write("             }\n");
      out.write("\n");
      out.write("             return true;\n");
      out.write("         }\n");
      out.write("         function noSpace(event)\n");
      out.write("            {\n");
      out.write("                if(event.key === \" \")\n");
      out.write("                {\n");
      out.write("                    alert(\"Space is not allowed\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function onlyLetters(event)\n");
      out.write("            {\n");
      out.write("                var char = event.key;\n");
      out.write("\n");
      out.write("                if(!/[a-zA-Z]/.test(char))\n");
      out.write("                {\n");
      out.write("                    alert(\"Only letters allowed in Name field\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("}\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("            \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <h2>Enter Your Name</h2>\n");
      out.write("\n");
      out.write("<form action=\"helloservlet\" method=\"post\"  onsubmit=\"return validateForm()\">\n");
      out.write("<!--Name : <input type=\"text\" id=\"name\" name=\"name\"  onkeypress=\"return noSpace(event)\" onkeypress=\"return onlyLetters(event)\" required>-->\n");
      out.write("<input type=\"text\" name=\"name\" id=\"name\"\n");
      out.write("onkeypress=\"return onlyLetters(event)\"  \n");
      out.write("onkeypress=\"return noSpace(event)\"\n");
      out.write("maxlength=\"15\" placeholder=\"ENTER YOUR NAME\"><br>\n");
      out.write("<br><br>\n");
      out.write("\n");
      out.write("<input type=\"submit\" value=\"Submit\">\n");
      out.write("\n");
      out.write("</form>\n");
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
