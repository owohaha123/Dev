<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>오픈인공지능 게시판 홈</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
$(function(){
	//bxSlider 설정용 스크립트
	$(".slider").bxSlider({
		auto: true,
		slideWidth: 600,
	});
	
	//화면 크기 변경(반응형)에 따라 bx슬라이더 재설정.
	var mql = window.matchMedia("screen and (max-width: 768px)");
	mql.addListener(function(e){
		if(!e.matches){
			slider.reloadSlider();
		}
	});
	
	//메시지 출력 부분
	var msg = "${msg}";
	if(msg != ""){
		alert(msg);
	}
});
</script>
</head>
<body>
<div class="wrap">
	<header>
	<jsp:include page="header.jsp"/>
	</header>
	<section>
	<div class="content-home">
		<div class="slider">
			<div><img src="images/Chrysanthemum.jpg"></div>
			<div><img src="images/Desert.jpg"></div>
			<div><img src="images/Lighthouse.jpg"></div>
			<div><img src="images/Tulips.jpg"></div>
		</div>	
	</div>
	</section>
	<footer>
	<jsp:include page="footer.jsp"/>
	</footer>
</div>
</body>
</html>
