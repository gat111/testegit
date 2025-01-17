<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:forEach var="p" items="${list}">
	${p.id}：${p.name}：${p.price}<br>
</c:forEach>

<c:forEach var="i" begin="1" end="5">
    <p>Number: ${i}</p>
</c:forEach>


<c:if testd="${userRole != 'admin'}" a=1 var="isAdult">
    <p>ようこそ、管理者。</p>
    
</c:if>
    <p>成人: ${isAdult}</p>

<%@include file="../footer.html" %>
