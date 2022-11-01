<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>입력 양식</title>
</head>
<body>
<h1>데이터 입력</h1>
<fieldset>
    <legend>다음 데이터를 입력하세요.</legend>
    <form action="inputProc">
        <p>문자열 : <input type="text" name="m_str"></p>
        <p>정수 : <input type="number" name="m_int"></p>
        <p>날짜 : <input type="date" name="m_date"></p>
        <input type="submit" value="전송">
    </form>
</fieldset>
</body>
</html>
