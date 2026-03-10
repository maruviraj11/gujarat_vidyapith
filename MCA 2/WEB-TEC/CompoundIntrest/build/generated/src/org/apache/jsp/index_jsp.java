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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Compound Interest Calculator</title>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    body {\n");
      out.write("        font-family: Arial, sans-serif;\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("        background: linear-gradient(to right, #87CEEB, #00BFFF);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .container {\n");
      out.write("        width: 400px;\n");
      out.write("        margin: 70px auto;\n");
      out.write("        padding: 30px;\n");
      out.write("        background-color: #ffffff;\n");
      out.write("        border-radius: 12px;\n");
      out.write("        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    h2 {\n");
      out.write("        text-align: center;\n");
      out.write("        color: #0077b6;\n");
      out.write("        margin-bottom: 25px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    label {\n");
      out.write("        font-weight: bold;\n");
      out.write("        color: #023e8a;\n");
      out.write("        display: block;\n");
      out.write("        margin-top: 12px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"text\"] {\n");
      out.write("        width: 100%;\n");
      out.write("        padding: 10px;\n");
      out.write("        margin-top: 6px;\n");
      out.write("        border-radius: 6px;\n");
      out.write("        border: 1px solid #90e0ef;\n");
      out.write("        outline: none;\n");
      out.write("        transition: 0.3s;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"text\"]:focus {\n");
      out.write("        border-color: #00b4d8;\n");
      out.write("        box-shadow: 0 0 5px #90e0ef;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"submit\"] {\n");
      out.write("        width: 100%;\n");
      out.write("        padding: 12px;\n");
      out.write("        margin-top: 20px;\n");
      out.write("        background: linear-gradient(to right, #00BFFF, #0077b6);\n");
      out.write("        color: white;\n");
      out.write("        border: none;\n");
      out.write("        border-radius: 6px;\n");
      out.write("        cursor: pointer;\n");
      out.write("        font-size: 16px;\n");
      out.write("        transition: 0.3s;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"submit\"]:hover {\n");
      out.write("        background: linear-gradient(to right, #0077b6, #023e8a);\n");
      out.write("        transform: scale(1.03);\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("function validateForm() {\n");
      out.write("\n");
      out.write("    var principal = document.forms[\"ciForm\"][\"principal\"].value;\n");
      out.write("    var rate = document.forms[\"ciForm\"][\"rate\"].value;\n");
      out.write("    var compound = document.forms[\"ciForm\"][\"compound\"].value;\n");
      out.write("    var months = document.forms[\"ciForm\"][\"months\"].value;\n");
      out.write("\n");
      out.write("    if (principal === \"\" || rate === \"\" || compound === \"\" || months === \"\") {\n");
      out.write("        alert(\"All fields are required!\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    if (isNaN(principal) || isNaN(rate) || isNaN(compound) || isNaN(months)) {\n");
      out.write("        alert(\"Please enter numeric values only!\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    if (principal <= 0 || rate <= 0 || compound <= 0 || months <= 0) {\n");
      out.write("        alert(\"Values must be greater than 0!\");\n");
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
      out.write("<div class=\"container\">\n");
      out.write("\n");
      out.write("<h2>Compound Interest Calculator</h2>\n");
      out.write("\n");
      out.write("<form name=\"ciForm\" action=\"CIServlet\" method=\"post\" onsubmit=\"return validateForm()\">\n");
      out.write("\n");
      out.write("    <label>Principal Amount (P):</label>\n");
      out.write("    <input type=\"text\" name=\"principal\">\n");
      out.write("\n");
      out.write("    <label>Annual Interest Rate (%):</label>\n");
      out.write("    <input type=\"text\" name=\"rate\">\n");
      out.write("\n");
      out.write("    <label>Compounded Per Year (n):</label>\n");
      out.write("    <input type=\"text\" name=\"compound\">\n");
      out.write("\n");
      out.write("    <label>Total Months:</label>\n");
      out.write("    <input type=\"text\" name=\"months\">\n");
      out.write("\n");
      out.write("    <input type=\"submit\" value=\"Calculate\">\n");
      out.write("\n");
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
