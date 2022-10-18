<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>출력 화면</title>
</head>
<body>
<p>data1 : ${data1}</p>
<p>data2 : ${data2}</p>
<p>msg : ${msg}</p>
<hr>
<h1>회원 정보</h1>
<p>아이디 : ${mem.id}</p>
<p>비밀번호 : ${mem.pwd}</p>
<p>이름 : ${mem.name}</p>
<p>나이 : ${mem.age}</p>
</body>
<script>
    let message = '${msg}'; // 자바스크립트에서도 controller 의 데이터를 받을 수 있다!
    alert(message);
</script>
</html>
