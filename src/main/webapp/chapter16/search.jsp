<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ include file="../header.html" %>

<% 

    // Servlet側でセットされた属性を取得
    Integer count = (Integer) session.getAttribute("count");
%>

<!-- 属性を表示 -->
<p>現在のカウント: <%= count != null ? count : "未設定" %></p>


<%@ include file="../footer.html" %>