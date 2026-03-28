<%-- 
    Document   : saveBook
    Created on : 14 Mar, 2026, 9:23:01 PM
    Author     : VIRAJ
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt((request.getParameter("quantity")));
            String isbn = request.getParameter("isbn");
            String publisher = request.getParameter("publisher");
            int edition_year = Integer.parseInt(request.getParameter("edition_year"));
            String catalogueId = request.getParameter("catalogueId");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");

                java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO book(title,author,price,quantity,isbn,publisher,edition_year,catalogueId) VALUES(?,?,?,?,?,?,?,?)");

                ps.setString(1, title);
                ps.setString(2, author);
                ps.setDouble(3, price);
                ps.setInt(4, quantity);
                ps.setString(5, isbn);
                ps.setString(6, publisher);
                ps.setInt(7, edition_year);
                ps.setString(8, catalogueId);

                ps.executeUpdate();

                response.sendRedirect("viewBooks.jsp");

            } catch (Exception e) {
                e.printStackTrace();
            }


        %>
    </body>
</html>
