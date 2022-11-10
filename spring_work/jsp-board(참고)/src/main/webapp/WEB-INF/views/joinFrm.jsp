<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
$(function(){
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
	<div class="content">
		<form name="joinFrm" class="login-form"
			action="memInsert" method="post"
			onsubmit="return check()">
			<h2 class="login-header">회원 가입</h2>
			<input type="text" class="login-input" id="mid"
				title="아이디" name="m_id" autofocus
				placeholder="아이디">
			<input type="button" class="idcheck-btn" 
				value="중복확인" onclick="idcheck()">
			<input type="password" class="login-input"
				title="비밀번호" name="m_pwd" placeholder="비밀번호">
			<input type="text" class="login-input"
				title="이름" name="m_name" placeholder="이름">
			<input type="text" class="login-input"
				title="생일" name="m_birth" placeholder="생일">
			<input type="text" class="login-input"
				title="주소" name="m_addr" placeholder="주소">
			<input type="text" class="login-input"
				title="연락처" name="m_phone" placeholder="연락처">
			<input type="submit" class="login-btn" value="가입">
		</form>
	</div>
	</section>
	<footer>
	<jsp:include page="footer.jsp"/>
	</footer>
</div>
</body>
<script type="text/javascript">
//아이디 중복 체크
var ckOk = false;//false일 경우 가입 프로세스 실행 X

function idcheck(){
	var inId = $("#mid").val();
	
	//id 값을 입력했는지 검사.
	if(inId == ""){//입력을 안했을 경우
		alert("아이디를 입력하세요.");
		$("#mid").focus();
		return;
	}
	
	var ckObj = {"mid":inId};
	console.log(ckObj);
	
	//서버로 입력한 id 전송
	$.ajax({
		url: "./idCheck",
		type: "get",
		data: ckObj,
		success: function(result){
			console.log(result);
			if(result == "ok"){
				alert("아이디 사용 가능");
				ckOk = true;
			}
			else {
				alert("사용할 수 없는 아이디");
				$("#mid").val("");//입력한 아이디 지우기
				$("#mid").focus();//아이디 입력칸 포커스
				ckOk = false;
			}
		},
		error: function(error){
			console.log(error);
			ckOk = false;
		}
	});
}

function check(){
	if(ckOk == false){
		alert("아이디 중복 체크를 해주세요.");
		return false;//submit 실행 막기
	}
	
	//form 태그의 내용 전부 가져오기
	var frm = document.joinFrm;
	console.log(frm);
	
	var length = frm.length - 1;//submit 버튼 제외
	console.log(length);
	
	for(var i = 0; i < length; i++){
		if(frm[i].value == "" || frm[i].value == null){
			alert(frm[i].title + "입력!");
			frm[i].focus();
			return false;
		}
	}
	
	return true;//모든 칸이 다 채워졌고, 중복 체크도 한 상태
}
</script>
</html>



