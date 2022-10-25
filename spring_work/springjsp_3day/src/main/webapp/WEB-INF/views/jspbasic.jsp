<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.jsframe.springjsp02.dto.CalDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%
  Date now = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("(a) hh:mm:ss");

  String nowTime = sdf.format(now);

  // 내가 작성한 클래스 활용도 가능
  CalDto cd = new CalDto();
  cd.setNum1(5);
%>
<h1>현재 시간</h1>
<h2><%=nowTime%></h2>

<%--include 되는 파일은 이만큼은 생략해도 된다.--%>
<%--</body>--%>
<%--</html>--%>
