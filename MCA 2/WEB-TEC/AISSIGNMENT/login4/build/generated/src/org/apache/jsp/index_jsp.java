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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Login Page</title>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("body{\n");
      out.write("    font-family: Arial;\n");
      out.write("    background: linear-gradient(to right,#4facfe,#00f2fe);\n");
      out.write("}\n");
      out.write(".login-box{\n");
      out.write("    width:350px;\n");
      out.write("    margin:100px auto;\n");
      out.write("    padding:30px;\n");
      out.write("    background:white;\n");
      out.write("    border-radius:10px;\n");
      out.write("    box-shadow:0 0 15px gray;\n");
      out.write("}\n");
      out.write("input{\n");
      out.write("    width:100%;\n");
      out.write("    padding:10px;\n");
      out.write("    margin:10px 0;\n");
      out.write("}\n");
      out.write("button{\n");
      out.write("    width:100%;\n");
      out.write("    padding:10px;\n");
      out.write("    background:#4facfe;\n");
      out.write("    color:white;\n");
      out.write("    border:none;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    function noSpace(event){\n");
      out.write("    \n");
      out.write("    if(event.key === \" \"){\n");
      out.write("        alert(\"Space is not allowed\");\n");
      out.write("        event.preventDefault();\n");
      out.write("    }\n");
      out.write("\n");
      out.write("}\n");
      out.write("function validateForm(){\n");
      out.write("\n");
      out.write("    let email=document.getElementById(\"email\").value.trim();\n");
      out.write("    let password=document.getElementById(\"password\").value.trim();\n");
      out.write("    let emailPattern=/^[^ ]+@[^ ]+\\.[a-z]{2,3}$/;\n");
      out.write("    let spacePattern=/\\s/;\n");
      out.write("\n");
      out.write("    if(email===\"\"){\n");
      out.write("        alert(\"Email required\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("     if(!email.match(emailPattern)){\n");
      out.write("        alert(\"Enter valid email format (example@gmail.com)\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("     if(spacePattern.test(email)){\n");
      out.write("        alert(\"Spaces are not allowed in Email\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    if(password===\"\"){\n");
      out.write("        alert(\"Password required\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    if(password.length < 6){\n");
      out.write("        alert(\"Password must be minimum 6 characters\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    return true;\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"login-box\">\n");
      out.write("\n");
      out.write("<h2 align=\"center\">Login</h2>\n");
      out.write("\n");
      out.write("<form action=\"loginServlet\" method=\"post\" onsubmit=\"return validateForm()\">\n");
      out.write("\n");
      out.write("<!--<input type=\"text\" id=\"email\" name=\"email\" placeholder=\"Enter Email\" maxlength=\"30\" >\n");
      out.write("\n");
      out.write("<input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Enter Password\" maxlength=\"20\">-->\n");
      out.write("\n");
      out.write("<input type=\"text\" id=\"email\" name=\"email\" onkeypress=\"noSpace(event)\" maxlength=\"30\">\n");
      out.write("\n");
      out.write("<input type=\"password\" id=\"password\" name=\"password\" onkeypress=\"noSpace(event)\" maxlength=\"20\">\n");
      out.write("<button type=\"submit\">Login</button>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
