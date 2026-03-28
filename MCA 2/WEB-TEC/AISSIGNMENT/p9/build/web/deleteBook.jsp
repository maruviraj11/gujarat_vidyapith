<%-- 
    Document   : deleteBook
    Created on : 14 Mar, 2026, 10:17:02 PM
    Author     : VIRAJ
--%>
<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb" , "root" , "");
            
            java.sql.PreparedStatement ps = con.prepareStatement("DELETE FROM book WHERE bookId=?");
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            response.sendRedirect("viewBooks.jsp");
        %>
    </body>
</html>
