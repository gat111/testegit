<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List, java.util.ArrayList" %>

<c:if test="${fn:contains('hello world', 'world')}">
    <p>含まれています。</p>
</c:if>
<p>文字列の長さ: ${fn:length('abcdef')}</p>

<p>置換後の文字列: ${fn:replace('hello world', 'world', 'JSTL')}</p>

<%
String[] fruits = {"りんご", "みかん", "バナナ"};
pageContext.setAttribute("fruits", fruits);
%>

<%
	List<String> fruitsList = new ArrayList<>();
	fruitsList.add("りんご");
	fruitsList.add("みかん");
	fruitsList.add("バナナ");
	String[] fruitsArray = fruitsList.toArray(new String[0]);
	pageContext.setAttribute("fruits", fruitsArray);
%>

${fn:join(fruits, '、')}




<%@include file="../footer.html"%>
