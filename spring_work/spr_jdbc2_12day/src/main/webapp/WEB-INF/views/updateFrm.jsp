<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오후 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수정양식</title>
</head>
<body>
<h1>데이터 수정</h1>
<fieldset>
  <legend>다음 데이터를 입력하세요.</legend>
  <form action="updateProc">
    <p>코드 : <input type="text" name="m_code" value="${data.m_code}" readonly></p>
    <p>문자열 : <input type="text" name="m_str" value="${data.m_str}"></p>
    <p>정수 : <input type="number" name="m_int" value="${data.m_int}"></p>
    <p>날짜 : <input type="date" name="m_date" value="${data.m_date}"></p>
    <input type="submit" value="전송">
  </form>
</fieldset>
</body>
<script>
  let m = "${msg}";
  if(m != ""){
    alert(m);
  }
</script>
</html>
