<%-- 
    Document   : admin
    Created on : 19 Mar, 2026, 11:59:38 AM
    Author     :  viraj maru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
String user = (String)session.getAttribute("user");
%>

<h1>Welcome Admin: <%= user %></h1>