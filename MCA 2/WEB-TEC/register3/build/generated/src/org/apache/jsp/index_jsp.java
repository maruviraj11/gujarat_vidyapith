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
      out.write("        <title>REGISTER PAGE</title>\n");
      out.write("        <style>\n");
      out.write("    body {\n");
      out.write("        font-family: Arial, sans-serif;\n");
      out.write("        background-color: #f2f2f2;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    h1 {\n");
      out.write("        text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    form {\n");
      out.write("        width: 350px;\n");
      out.write("        margin: 20px auto;\n");
      out.write("        padding: 20px;\n");
      out.write("        background-color: white;\n");
      out.write("        border: 1px solid #ccc;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"text\"],\n");
      out.write("    input[type=\"password\"],\n");
      out.write("    textarea,\n");
      out.write("    select {\n");
      out.write("        width: 100%;\n");
      out.write("        padding: 6px;\n");
      out.write("        margin-top: 5px;\n");
      out.write("        margin-bottom: 10px;\n");
      out.write("        border: 1px solid #ccc;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    textarea {\n");
      out.write("        height: 60px;\n");
      out.write("        resize: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"submit\"] {\n");
      out.write("        padding: 8px 15px;\n");
      out.write("        background-color: #4CAF50;\n");
      out.write("        color: white;\n");
      out.write("        border: none;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"submit\"]:hover {\n");
      out.write("        background-color: #45a049;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("        <script>\n");
      out.write("function validateForm()\n");
      out.write("{\n");
      out.write("    var fname = document.forms[\"regform\"][\"fname\"].value.trim();\n");
      out.write("    var lname = document.forms[\"regform\"][\"lname\"].value.trim();\n");
      out.write("    var password = document.forms[\"regform\"][\"password\"].value.trim();\n");
      out.write("    var conpassword = document.forms[\"regform\"][\"conpassword\"].value.trim();\n");
      out.write("    var email = document.forms[\"regform\"][\"email\"].value.trim();\n");
      out.write("    var mobile = document.forms[\"regform\"][\"mobile\"].value.trim();\n");
      out.write("    var address = document.forms[\"regform\"][\"address\"].value.trim();\n");
      out.write("    var role = document.forms[\"regform\"][\"role\"].value;\n");
      out.write("\n");
      out.write("   var namePattern = /^[A-Za-z]{3,20}$/;\n");
      out.write("    var emailPattern = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$/;\n");
      out.write("    var mobilePattern = /^[6-9][0-9]{9}$/;\n");
      out.write("    var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&]).{8,}$/;\n");
      out.write("\n");
      out.write("\n");
      out.write("    if (fname==\"\") \n");
      out.write("    {\n");
      out.write("        alert(\"do not blank first name filed...\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    if (!namePattern.test(fname)) {\n");
      out.write("        alert(\"First name must contain only alphabets and minimum 3 characters.\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("  if (lname==\"\") \n");
      out.write("    {\n");
      out.write("        alert(\"do not blank last name filed...\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    if (!namePattern.test(lname)) {\n");
      out.write("        alert(\"Last name must contain only alphabets and minimum 3 characters.\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    if (password==\"\") \n");
      out.write("    {\n");
      out.write("        alert(\"do not blank password filed...\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    if (!passwordPattern.test(password)) {\n");
      out.write("        alert(\"Password must be minimum 8 characters and include uppercase, lowercase, number and special character.\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    if (conpassword==\"\") \n");
      out.write("    {\n");
      out.write("        alert(\"do not blank conforim password filed...\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    if (password !== conpassword) {\n");
      out.write("        alert(\"Passwords do not match.\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    if (email==\"\") \n");
      out.write("    {\n");
      out.write("        alert(\"do not blank email filed...\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("  \n");
      out.write("    if (!emailPattern.test(email)) {\n");
      out.write("        alert(\"Enter valid email address.\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("   if (mobile==\"\") \n");
      out.write("    {\n");
      out.write("        alert(\"do not blank mobile filed...\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    if (!mobilePattern.test(mobile)) {\n");
      out.write("        alert(\"Enter valid 10-digit mobile number starting with 6-9.\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    if (address==\"\") \n");
      out.write("    {\n");
      out.write("        alert(\"do not blank address filed...\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    if (address.length < 10) {\n");
      out.write("        alert(\"Address must be at least 10 characters.\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    \n");
      out.write("   \n");
      out.write("    if (role === \"\") {\n");
      out.write("        alert(\"Please select a role.\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    alert(\"Form submitted successfully!\");\n");
      out.write("    return true;\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>THIS IS A RAGISTER PAGE</h1>\n");
      out.write("        \n");
      out.write("        <form name=\"regform\" action=\"registerservlet\" method=\"post\" onsubmit=\" return validateForm()\">\n");
      out.write("           \n");
      out.write("            FIRST NAME:<input type=\"text\" name=\"fname\" maxlength=\"20\"  onkeypress=\"return /^[A-Za-z ]$/.test(event.key)\" required><br><br>\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            SECOUND NAME:<input type=\"text\" name=\"lname\" maxlength=\"20\"  onkeypress=\"return /^[A-Za-z ]$/.test(event.key)\" required><br><br>\n");
      out.write("            \n");
      out.write("            PASSWORD<input type=\"password\" name=\"password\"><br><br>\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            CONFORM PASSWORD:<input type=\"password\" name=\"conpassword\"><br><br>\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            EMAIL:<input type=\"text\" name=\"email\"><br><br>\n");
      out.write("            \n");
      out.write("            MOBILE<input type=\"number\" name=\"mobile\" maxlength=\"10\" required><br><br>\n");
      out.write("            \n");
      out.write("            ADDRESS<textarea name=\"address\"></textarea><br><br>\n");
      out.write("            \n");
      out.write("            ROLE<select name=\"role\">\n");
      out.write("                <option value=\"\"> select role</option>\n");
      out.write("                <option value=\"admin\">admin</option>\n");
      out.write("                <option value=\"registerd\">registered</option>\n");
      out.write("                <option value=\"guest\">guest</option>\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            <br><br>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" name=\"register\" value=\"Register\" onclick=\"return validateForm()\">\n");
      out.write("            \n");
      out.write("            \n");
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
