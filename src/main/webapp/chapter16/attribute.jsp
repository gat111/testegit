<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@page import="bean.Product" %>


<%@ page import="java.util.Date" %>
<%
    Date today = new Date();
%>
<p>Today is: <%= today %></p>



<% Product p=(Product)request.getAttribute("product"); %>
<% String name=(String)request.getAttribute("name"); %>




<%=name%>

<%=p.getId() %>：<%=p.getName() %>：<%=p.getPrice() %><br>

<%@include file="../footer.html" %>

