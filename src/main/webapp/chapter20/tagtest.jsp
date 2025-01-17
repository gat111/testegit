<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@page import="bean.Product" %>

<%
	 Product bean = new Product();
	 bean.setPrice(100);
	 request.setAttribute("product", bean);
%>
   
   
<% Product p=(Product)request.getAttribute("product"); %>
<%=p.getPrice() %>



<%@include file="../footer.html" %>
