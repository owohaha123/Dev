<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
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
		<form action="boardUpdate" class="write-form"
			method="post" enctype="multipart/form-data">
			<div class="user-info">
				<div class="user-info-sub">
					<p class="grade">등급 [${mb.g_name}]</p>
					<p class="point">POINT [${mb.m_point}]</p>
				</div>
			</div>
			<h2 class="login-header">글수정</h2>
			<!-- 로그인한 id(숨김), 글번호(숨김), 제목, 내용, 파일-->
			<input type="hidden" name="b_id" value="${mb.m_id}">
			<input type="hidden" name="b_num" value="${board.b_num}">
			<input type="text" class="write-input"
				name="b_title" autofocus placeholder="제목"
				required value="${board.b_title}">
			<textarea rows="15" name="b_contents"
				placeholder="내용을 적어주세요."
				class="write-input ta">${board.b_contents}</textarea>
			<div class="filebox">
			<!-- 첨부된 파일 출력 영역 -->
				<div id="bfile" style="margin-bottom: 10px;">
					<c:if test="${empty fList}">
						<label style="width: 100%">첨부 파일 없음</label>
					</c:if>
					<c:if test="${!empty fList}">
						<c:forEach var="f" items="${fList}">
						<label style="width: 100%;" onclick="del('${f.bf_sysname}');">
							${f.bf_oriname}
						</label>
						</c:forEach>
					</c:if>
				</div>
			<!-- 파일 입력 처리 영역 -->
				<label for="file">파일 추가</label>
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
					value="U">
				<input type="reset" class="btn-write"
					value="R">
				<input type="button" class="btn-write"
					value="B"
					onclick="location.href='./contents?bnum=${board.b_num}'">
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

function del(sysname){
	console.log(sysname);
	
	var con = confirm("파일을 삭제하겠습니까?");
	
	if(con == true){
		var objdata = {"sysname":sysname};
		objdata.bnum = ${board.b_num};//파일목록 다시 불러오기에서 사용
		console.log(objdata);
		
		$.ajax({
			url: "delFile",
			type: "post",
			data: objdata,
			dataType: "json",
			success: function(result){
				console.log(result);
				alert("삭제 성공");
				
				//새로운 파일 목록 출력
				var flist = "";
				var rflist = result.fList;
				console.log(rflist);
				if(rflist.length == 0){
					flist += '<label style="width: 100%">첨부 파일 없음</label>';
				}
				else {
					for(var i = 0; i < rflist.length; i++){
						flist += '<label style="width: 100%" onclick="del(\''
								+ rflist[i].bf_sysname + '\')">'
								+ rflist[i].bf_oriname + '</label>';
					}
				}
				
				$("#bfile").html(flist);
			},
			error: function(error){
				console.log(error);
				alert("삭제 실패");
			}
		});
	}
}
</script>
</html>








