<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome</h2>
	<!-- 1st Way of catching the information -->
	<%-- 
	<%
		String user = (String) request.getAttribute("user");
		out.println(user);
	%>
	--%>
	<!-- 2nd Way of catching the information -->
	<%-- 
	<%=session.getAttribute("user") %>
	<%=session.getAttribute("password") %>
	<c:out value="${sessionScope.user}"></c:out>
	<c:if test="${user != null }">
		Welcome <c:out value="${user}"></c:out>
	</c:if>
	<c:if test="${user == null }">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	--%>
	<!-- 3rd Way of catching the information -->
	<c:choose>
	<c:when test="${user != null }">
		Welcome <c:out value="${user}"></c:out>
	</c:when>
	<c:otherwise>
		<c:redirect url="index.jsp"></c:redirect>
	</c:otherwise>
	</c:choose>
</body>
</html>