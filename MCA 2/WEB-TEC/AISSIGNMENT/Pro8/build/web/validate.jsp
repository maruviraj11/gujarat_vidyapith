<%-- 
    Document   : validate
    Created on : 19 Mar, 2026, 11:59:02 AM
    Author     :  viraj maru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>

<%
Connection con = null;

try {
    Class.forName("com.mysql.jdbc.Driver");

    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/userdb",
        "root",
        ""
    );

    String email = request.getParameter("email");
    String password = request.getParameter("password");

//    PreparedStatement ps = con.prepareStatement(
//        "SELECT * FROM users WHERE email=? AND password=?"
//    );
//
//    ps.setString(1, email);
//    ps.setString(2, password);
//
//    ResultSet rs = ps.executeQuery();
    Statement st = con.createStatement();

    String query = "SELECT * FROM users WHERE email='" 
                    + email + "' AND password='" 
                    + password + "'";

    ResultSet rs = st.executeQuery(query);

    if(rs.next()) {

        String role = rs.getString("role");
        session.setAttribute("user", email);

        if(role.equalsIgnoreCase("Admin")) {
%>
            <jsp:forward page="admin.jsp" />
<%
        } else {
%>
            <jsp:forward page="welcome.jsp" />
<%
        }

    } else {
%>
        <jsp:forward page="login.jsp" />
<%
    }

} catch(Exception e) {
    out.println("Error: " + e);
}
%>