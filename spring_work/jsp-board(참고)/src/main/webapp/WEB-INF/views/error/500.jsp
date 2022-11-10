<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내부 서버 오류</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrap">
	<header>
	<jsp:include page="../header.jsp"/>
	</header>
	<section>
	<div class="content-home">
		<center>
		<h1>서버에 문제가 발생했습니다.</h1>
		<p>관리자에게 문의하세요.</p>
		</center>
	</div>
	</section>
	<footer>
	<jsp:include page="../footer.jsp"/>
	</footer>
</div>
</body>
</html>