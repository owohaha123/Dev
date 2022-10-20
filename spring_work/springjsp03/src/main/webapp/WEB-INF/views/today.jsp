<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="now" value="<%=new Date()%>"/>

<h3><fmt:formatDate value="${now}" type="date" dateStyle="full"/></h3>
<h3><fmt:formatDate value="${now}" type="time" timeStyle="full"/></h3>
<h3>
    <fmt:formatDate value="${now}" type="date" pattern="yyyy-MM-dd (E)"/></h3>
    <fmt:formatDate value="${now}" type="time" pattern="[a] HH:mm:ss"/></h3>
</h3>

<hr>

<h2>숫자 형식 지정</h2>
<fmt:formatNumber value="1234567" groupingUsed="true"/><br>
<fmt:formatNumber value="3.141592" pattern="#.##"/><br>
<fmt:formatNumber value="1.5664" pattern="#.000"/><br> <!--빈 자리엔 0을 채운다-->
<fmt:formatNumber value="0.45" type="percent"/><br>
<fmt:formatNumber value="1000000" type="currency" currencySymbol="$"/><br>







<%--
  Date now = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  String nowdate = sdf.format(now);

  // out 객체 : 브라우저에 출력하는 객체
  // System.out.println 과 같은 효과
  out.println("<h3>" + nowdate + "</h3>"); // 예전에 썼던 방식
--%>

<%--<h3><%=nowdate%></h3>--%>