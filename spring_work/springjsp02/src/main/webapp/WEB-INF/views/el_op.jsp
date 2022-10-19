<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Js Framework EL</title>
</head>
<body>
<h1>EL 활용</h1>
<p>첫번째 데이터 : ${d1}</p>
<p>두번째 데이터 : ${d2}</p>

<h2>EL과 연산자 활용</h2>
<p>덧셈 : ${d1 + d2}</p>
<p>곱셈 : ${d1 * d2}</p>
<p>비교 : 첫번째 데이터가 크다? ${d1 > d2}</p>
<p>비교 : 두 데이터가 같다? ${d1 == d2}</p>
<p>논리 : 두번째 데이터가 크고 양수다? ${(d1 < d2) && (d2 > 0)}</p>
<p>조건 : 두 데이터가 다르다? ${(d1 != d2)? "다르다" : "같다"}</p>
<hr>
<h2>안녕하세요, ${(empty id) ? "Guest" : id}님.</h2>
</body>
</html>
