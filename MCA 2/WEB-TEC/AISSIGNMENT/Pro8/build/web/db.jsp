<%-- 
    Document   : db
    Created on : 19 Mar, 2026, 11:56:57 AM
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
        "jdbc:mysql://localhost:3306/webpro3",
        "root",
        ""
    );
} catch(Exception e) {
    out.println("DB Error: " + e);
}
%>