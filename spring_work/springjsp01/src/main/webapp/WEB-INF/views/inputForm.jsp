<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>입력 화면</title>
</head>
<body>
<h1>사용자 입력</h1>
<form action="inputProc" method="get"> <%--method 의 기본은 get (따라서 생략가능)--%>
  <input type = "text" name="str" placeholder="문자열 입력"> <br> <%-- input 태그의 name 속성이 변수명이 됨--%>
  <input type = "number" name="num" placeholder="숫자 입력"> <br>
  <input type = "submit" value="전송">
</form>
</body>
</html>
