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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Registration Form</title>\n");
      out.write("    <script>\n");
      out.write("        function validateForm() {\n");
      out.write("\n");
      out.write("            var fname = document.forms[\"regForm\"][\"fname\"].value;\n");
      out.write("            var lname = document.forms[\"regForm\"][\"lname\"].value;\n");
      out.write("            var password = document.forms[\"regForm\"][\"password\"].value;\n");
      out.write("            var confirmPassword = document.forms[\"regForm\"][\"confirmPassword\"].value;\n");
      out.write("            var email = document.forms[\"regForm\"][\"email\"].value;\n");
      out.write("            var mobile = document.forms[\"regForm\"][\"mobile\"].value;\n");
      out.write("            var address = document.forms[\"regForm\"][\"address\"].value;\n");
      out.write("            var role = document.forms[\"regForm\"][\"role\"].value;\n");
      out.write("\n");
      out.write("            var namePattern = /^[A-Za-z]{6,}$/;\n");
      out.write("            var emailPattern = /^[^ ]+@[^ ]+\\.[a-z]{2,3}$/;\n");
      out.write("            var mobilePattern = /^[0-9]{10}$/;\n");
      out.write("\n");
      out.write("            if (!namePattern.test(fname)) {\n");
      out.write("                alert(\"First Name must contain only alphabets and minimum 6 characters.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (!namePattern.test(lname)) {\n");
      out.write("                alert(\"Last Name must contain only alphabets and minimum 6 characters.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (password.length < 6) {\n");
      out.write("                alert(\"Password must be at least 6 characters.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (password !== confirmPassword) {\n");
      out.write("                alert(\"Password and Confirm Password must match.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (!emailPattern.test(email)) {\n");
      out.write("                alert(\"Enter valid email address.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (!mobilePattern.test(mobile)) {\n");
      out.write("                alert(\"Mobile number must be 10 digits.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (address.trim() == \"\") {\n");
      out.write("                alert(\"Address cannot be empty.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (role == \"\") {\n");
      out.write("                alert(\"Please select user role.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            return true;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h2>Registration Form</h2>\n");
      out.write("\n");
      out.write("<form name=\"regForm\" action=\"RegisterServlet\" method=\"post\" onsubmit=\"return validateForm()\">\n");
      out.write("\n");
      out.write("    First Name: <input type=\"text\" name=\"fname\"><br><br>\n");
      out.write("    Last Name: <input type=\"text\" name=\"lname\"><br><br>\n");
      out.write("    Password: <input type=\"password\" name=\"password\"><br><br>\n");
      out.write("    Confirm Password: <input type=\"password\" name=\"confirmPassword\"><br><br>\n");
      out.write("    Email: <input type=\"text\" name=\"email\"><br><br>\n");
      out.write("    Mobile: <input type=\"text\" name=\"mobile\"><br><br>\n");
      out.write("    Address: <textarea name=\"address\"></textarea><br><br>\n");
      out.write("\n");
      out.write("    User Role:\n");
      out.write("    <select name=\"role\">\n");
      out.write("        <option value=\"\">--Select--</option>\n");
      out.write("        <option value=\"Admin\">Admin</option>\n");
      out.write("        <option value=\"Registered User\">Registered User</option>\n");
      out.write("        <option value=\"Guest\">Guest</option>\n");
      out.write("    </select><br><br>\n");
      out.write("\n");
      out.write("    <input type=\"submit\" value=\"Register\">\n");
      out.write("\n");
      out.write("</form>\n");
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
