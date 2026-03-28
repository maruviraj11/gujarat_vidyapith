<%-- 
    Document   : updateBook
    Created on : 14 Mar, 2026, 10:07:17 PM
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
            int bookId = Integer.parseInt(request.getParameter("bookId"));

            Class.forName("com.mysql.cj.jdbc.Driver");

            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");

            java.sql.PreparedStatement ps = con.prepareStatement("UPDATE book SET title=?, author=?, price=?, quantity=?, isbn=?, publisher=?, edition_year=?, catalogueId=? WHERE bookId=?");

            ps.setString(1, request.getParameter("title"));
            ps.setString(2, request.getParameter("author"));
            ps.setDouble(3, Double.parseDouble(request.getParameter("price")));
            ps.setInt(4, Integer.parseInt(request.getParameter("quantity")));
            ps.setString(5, request.getParameter("isbn"));
            ps.setString(6, request.getParameter("publisher"));
            ps.setInt(7, Integer.parseInt(request.getParameter("edition_year")));
            ps.setString(8, request.getParameter("catalogueId"));
            ps.setInt(9, bookId);

            ps.executeUpdate();

            response.sendRedirect("viewBooks.jsp");

        %>
    </body>
</html>
