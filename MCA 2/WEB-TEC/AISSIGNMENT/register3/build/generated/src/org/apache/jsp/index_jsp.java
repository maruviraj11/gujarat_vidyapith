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
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function validateForm()\n");
      out.write("            {\n");
      out.write("                var fname=document.forms[\"regform\"][\"fname\"].value;\n");
      out.write("                var lname=document.forms[\"regform\"][\"lname\"].value;\n");
      out.write("                var password=document.forms[\"regform\"][\"password\"].value;\n");
      out.write("                var conpassword=document.forms[\"regform\"][\"conpassword\"].value;\n");
      out.write("                var email=document.forms[\"regform\"][\"email\"].value;\n");
      out.write("                var mobile=document.forms[\"regform\"][\"mobile\"].value;\n");
      out.write("                var address=document.forms[\"regform\"][\"address\"].value;\n");
      out.write("                var role=document.forms[\"regform\"][\"role\"].value;\n");
      out.write("                \n");
      out.write("                var namePattern = /^[A-Za-z]{6,}$/;\n");
      out.write("                var emailPattern = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$/;\n");
      out.write("                var mobilePattern = /^[0-9]{10}$/;\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                 if(fname==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace do not blank any filed\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(fname.length<6)\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace enter atlist 6 char name\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (!namePattern.test(fname))\n");
      out.write("                {\n");
      out.write("                    alert(\"First Name must contain alphabets only and minimum 6 characters.\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("\n");
      out.write("                if(lname==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace do not blank any filed\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(lname.length<6)\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace enter aylist 6 character\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                 if (!namePattern.test(lname))\n");
      out.write("                 {\n");
      out.write("                    alert(\"Last Name must contain alphabets only and minimum 6 characters.\");\n");
      out.write("                    return false;\n");
      out.write("                 }\n");
      out.write("                \n");
      out.write("                if(password==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace do not blank any filed\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                 if(conpassword==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace do not blank any filed\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(password != conpassword)\n");
      out.write("                {\n");
      out.write("                    alert(\"enter valid passwords\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(email==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace do not blank any filed\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (!emailPattern.test(email)) \n");
      out.write("                {\n");
      out.write("                    alert(\"Enter valid Email address.\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                 if(mobile==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace do not blank any filed\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(!mobilePattern.test(mobile))\n");
      out.write("                {\n");
      out.write("                    alert(\"Mobile number must contain exactly 10 digits.\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(address==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace do not blank any filed\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(role==\"\")\n");
      out.write("                {\n");
      out.write("                    alert(\"pleace do not blank any filed\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                return true;\n");
      out.write("                 \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            </script>\n");
      out.write("            \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>THIS IS A RAGISTER PAGE</h1>\n");
      out.write("        \n");
      out.write("        <form name=\"regform\" action=\"registerservlet\" method=\"post\" onsubmit=\" return validateForm()\">\n");
      out.write("           \n");
      out.write("            FIRST NAME:<input type=\"text\" name=\"fname\"><br><br>\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            SECOUND NAME:<input type=\"text\" name=\"lname\"><br><br>\n");
      out.write("            \n");
      out.write("            PASSWORD<input type=\"password\" name=\"password\"><br><br>\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            CONFORM PASSWORD:<input type=\"password\" name=\"conpassword\"><br><br>\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            EMAIL:<input type=\"text\" name=\"email\"><br><br>\n");
      out.write("            \n");
      out.write("            MOBILE<input type=\"text\" name=\"mobile\"><br><br>\n");
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
      out.write("            <input type=\"submit\" name=\"register\">\n");
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
