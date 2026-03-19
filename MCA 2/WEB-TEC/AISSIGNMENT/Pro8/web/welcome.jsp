<%-- 
    Document   : welcome
    Created on : 19 Mar, 2026, 12:00:12 PM
    Author     : viraj maru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
String user = (String)session.getAttribute("user");
%>

<h1>Welcome User: <%= user %></h1>