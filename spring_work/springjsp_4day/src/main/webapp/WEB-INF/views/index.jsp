<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--JSTL 변수 생성--%>
<c:set var="num1" value="11"></c:set>
<c:set var="num2" value="4"></c:set>
<c:set var="res" value="${num1 * num2}"/>
<c:set var="id" value="user"/>
<html>
<head>
    <title>JSTL home</title>
</head>
<body>
<c:if test="${empty id}"> <!--empty 는 비어있어야 true-->
    <p>환영합니다. Guest 님</p>
</c:if>

<c:if test="${!empty id}"> <!--else 를 사용하지 않기 때문에 if로 다시 작성-->
    <p>안녕하세요. ${id}님</p>
</c:if>
<c:set var="sel" value="3"></c:set>
<c:choose>
    <c:when test="${sel == 1}">
        <p>처음 뵙겠습니다.</p>
    </c:when>
    <c:when test="${sel > 1}">
        <p>반갑습니다.</p>
    </c:when>
    <c:otherwise>
        <p>안녕하세요.</p>
    </c:otherwise>
</c:choose>

<c:forEach var="cnt" begin="1" end="5" step="2"> <!--반복 횟수 지정 (무한 반복x)-->
    <font size="${cnt}"> 야호!!!! </font><br>
</c:forEach>

<hr>
${num1} * ${num2} = ${res}
<hr>

<a href="include">[오늘의 메뉴]</a>

</body>
<script>
  let n = ${res};
  alert(n);
</script>
</html>
