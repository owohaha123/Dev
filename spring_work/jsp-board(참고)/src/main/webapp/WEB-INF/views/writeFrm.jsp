<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
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
	
	//로그인한 회원 정보 및 로그아웃 출력
	var lname = "${mb.m_name}";
	$("#mname").html(lname + "님");
	$(".suc").css("display", "block");
	$(".bef").css("display", "none");
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
		<form action="boardWrite" class="write-form"
			method="post" enctype="multipart/form-data">
			<div class="user-info">
				<div class="user-info-sub">
					<p class="grade">등급 [${mb.g_name}]</p>
					<p class="point">POINT [${mb.m_point}]</p>
				</div>
			</div>
			<h2 class="login-header">글쓰기</h2>
			<!-- 로그인한 id(숨김), 제목, 내용, 파일-->
			<input type="hidden" name="b_id" value="${mb.m_id}">
			<input type="text" class="write-input"
				name="b_title" autofocus placeholder="제목"
				required>
			<textarea rows="15" name="b_contents"
				placeholder="내용을 적어주세요."
				class="write-input ta"></textarea>
			<div class="filebox">
			<!-- 파일 입력 처리 영역 -->
				<label for="file">업로드</label>
				<input type="file" name="files" id="file"
					multiple>
				<input type="text" class="upload-name"
					value="파일선택" readonly>
				<!-- 업로드할 파일이 있으면 1, 없으면 0 -->
				<input type="hidden" id="filecheck"
					value="0" name="fileCheck">
			</div>
			<div class="btn-area">
				<input type="submit" class="btn-write"
					value="W">
				<input type="reset" class="btn-write"
					value="R">
				<input type="button" class="btn-write"
					value="B" onclick="backbtn();">
			</div>
		</form>
	</div>
	</section>
	<footer>
	<jsp:include page="footer.jsp"/>
	</footer>
</div>
</body>
<script type="text/javascript">
//업로드할 파일을 선택하면, 'upload-name' 요소에
//파일 이름을 출력하고, 'fileCheck' 요소의 value를 1로 변경
$("#file").on("change", function(){
	//파일 입력창에서 선택한 파일 목록 가져오기
	var files = $("#file")[0].files;
	console.log($("#file"));
	console.log(files);
	
	var fileName = "";
	
	if(files.length > 1){//하나 이상의 파일 선택 시
		fileName = files[0].name + " 외 "
			+ (files.length - 1) + "개"
	}
	else if(files.length == 1){
		fileName = files[0].name;
	}
	
	$(".upload-name").val(fileName);
	
	//fileCheck 부분 변경
	if(fileName == ""){//파일 취소 시
		$("#filecheck").val(0);
		$(".upload-name").val("파일선택");
	}
	else {//파일 선택 시
		$("#filecheck").val(1);
	}
	console.log($("#filecheck").val());
});

function backbtn(){
	var urlstr = "list?";
	var col = "${list.colname}";
	var key = "${list.keyword}";
	
	if(col == null || col == ""){//검색을 안한 경우
		urlstr += "pageNum=${pageNum}";
	}
	else {//검색을 한 경우
		urlstr += "colname=${list.colname}&keyword=${list.keyword}"
				+ "&pageNum=${pageNum}";
	}
	console.log(urlstr);
	
	location.href = urlstr;
}
</script>
</html>








