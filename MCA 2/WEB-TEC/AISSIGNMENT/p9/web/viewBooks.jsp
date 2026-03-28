<%-- 
    Document   : viewBooks
    Created on : 14 Mar, 2026, 9:31:13 PM
    Author     : VIRAJ
--%>
<%@page import="java.sql.*"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">

            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>ISBN</th>
                <th>Publisher</th>
                <th>Edition Year</th>
                <th>Catalogue ID</th>
                <th>Action</th>
            </tr>   
            <%

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");

                    java.sql.Statement st = con.createStatement();

                    java.sql.ResultSet rs = st.executeQuery("SELECT * FROM book");

                    while (rs.next()) {
            %>
            <tr>

                <td><%= rs.getInt("bookId")%></td>
                <td><%= rs.getString("title")%></td>
                <td><%= rs.getString("author")%></td>
                <td><%= rs.getDouble("price")%></td>
                <td><%= rs.getInt("quantity")%></td>
                <td><%= rs.getString("isbn")%></td>
                <td><%= rs.getString("publisher")%></td>
                <td><%= rs.getInt("edition_year")%></td>
                <td><%= rs.getString("catalogueId")%></td>
                
                <td>
                    <button onclick="location.href='editBook.jsp?id=<%= rs.getInt("bookId") %>'" >Edit</button>
                    <button onclick="location.href='deleteBook.jsp?id=<%= rs.getInt("bookId") %>'" >Delete</button>
                </td>

            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            %>
        </table>
        
        <button onclick="location.href='index.jsp'">Add Book</button>
    </body>
</html>
