package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Login</title>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("function validate() {\n");
      out.write("    let email = document.forms[\"f\"][\"email\"].value;\n");
      out.write("    let password = document.forms[\"f\"][\"password\"].value;\n");
      out.write("\n");
      out.write("   \n");
      out.write("    if (email == \"\" || password == \"\") {\n");
      out.write("        alert(\"All fields required!\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("   \n");
      out.write("    let emailPattern = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/;\n");
      out.write("\n");
      out.write("    if (!emailPattern.test(email)) {\n");
      out.write("        alert(\"Enter valid email address!\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    return true;\n");
      out.write("}\n");
      out.write("function noSpace(event)\n");
      out.write("{\n");
      out.write("    if(event.key === \" \")\n");
      out.write("    {\n");
      out.write("        alert(\"do not enter space\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("\n");
      out.write("body {\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    font-family: Arial, sans-serif;\n");
      out.write("    background: linear-gradient(to right, #4facfe, #00f2fe);\n");
      out.write("    height: 100vh;\n");
      out.write("    display: flex;\n");
      out.write("    justify-content: center;\n");
      out.write("    align-items: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".box {\n");
      out.write("    background: white;\n");
      out.write("    padding: 40px;\n");
      out.write("    width: 320px;\n");
      out.write("    border-radius: 12px;\n");
      out.write("    box-shadow: 0px 8px 20px rgba(0,0,0,0.2);\n");
      out.write("    text-align: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write(".box h2 {\n");
      out.write("    margin-bottom: 20px;\n");
      out.write("    color: #333;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".box input {\n");
      out.write("    width: 100%;\n");
      out.write("    padding: 12px;\n");
      out.write("    margin: 10px 0;\n");
      out.write("    border: 1px solid #ccc;\n");
      out.write("    border-radius: 8px;\n");
      out.write("    outline: none;\n");
      out.write("    transition: 0.3s;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write(".box input:focus {\n");
      out.write("    border-color: #4facfe;\n");
      out.write("    box-shadow: 0 0 5px #4facfe;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write(".box button {\n");
      out.write("    width: 100%;\n");
      out.write("    padding: 12px;\n");
      out.write("    background: #4facfe;\n");
      out.write("    border: none;\n");
      out.write("    color: white;\n");
      out.write("    font-size: 16px;\n");
      out.write("    border-radius: 8px;\n");
      out.write("    cursor: pointer;\n");
      out.write("    transition: 0.3s;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".box button:hover {\n");
      out.write("    background: #007bff;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"box\">\n");
      out.write("<h2>Login</h2>\n");
      out.write("\n");
      out.write("<form name=\"f\" action=\"validate.jsp\" method=\"post\" onsubmit=\"return validate()\">\n");
      out.write("    <input type=\"text\" name=\"email\" placeholder=\"Email\" onkeypress=\"return noSpace(event)\"><br><br>\n");
      out.write("    <input type=\"password\" name=\"password\" placeholder=\"Password\" onkeypress=\"return noSpace(event)\"><br><br>\n");
      out.write("    <button type=\"submit\">Login</button>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
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
