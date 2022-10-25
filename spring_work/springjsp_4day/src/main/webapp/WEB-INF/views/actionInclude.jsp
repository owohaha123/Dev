<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>오늘의 메뉴</title>
</head>
<body>
<h1>오늘의 메뉴</h1>
<div>
    <ul>
    <c:forEach var="m" items="${menu}" varStatus="status">
        <c:if test="${status.first}">
            <li><b>${status.index}-${status.count} : ${m}</b></li>
        </c:if>
<%--        <c:if test="${status.count % 2 == 0}">--%>
<%--            <li><span style="color: blue">${status.index}-${status.count} : ${m}</li>--%>
<%--        </c:if>--%>
<%--        <c:if test="${!status.count % 2 == 0}">--%>
<%--            <li>${status.index}-${status.count} : ${m}</li>--%>
<%--        </c:if>--%>
        <c:if test="${!status.first}">
            <li>${status.index}-${status.count} : ${m}</li>
        </c:if>
    </c:forEach>
    </ul>
</div>
<hr>
<%--<%@include file="today.jsp"%> &lt;%&ndash; include 지시자 &ndash;%&gt;--%>
<hr>
<%--<jsp:include page="today.jsp"></jsp:include> include 태그(액션 태그) --%>
<c:import url="today.jsp"></c:import>
</body>
</html>
