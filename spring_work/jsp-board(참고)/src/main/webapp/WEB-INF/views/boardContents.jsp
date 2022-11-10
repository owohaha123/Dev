<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
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
	
	//수정/삭제 버튼 처리(본인의 글이 아니면 수정/삭제 버튼 숨기기)
	$("#upbtn").hide();
	$("#delbtn").hide();
	
	var mid = "${mb.m_id}";
	var bid = "${board.b_id}";
	
	if(mid == bid){
		$("#upbtn").show();
		$("#delbtn").show();
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
		<div class="write-form">
			<div class="user-info">
				<div class="user-info-sub">
					<p class="grade">등급 [${mb.g_name}]</p>
					<p class="point">POINT [${mb.m_point}]</p>
				</div>
			</div>
			<h2 class="login-header">상세 보기</h2>
			<!-- 게시글 상세 내용 출력(div) -->
			<div>
				<div class="t_content p-15">NUM</div>
				<div class="d_content p-85">${board.b_num}</div>
			</div>
			<div>
				<div class="t_content p-15">WRITER</div>
				<div class="d_content p-35">${board.m_name}</div>
				<div class="t_content p-15">DATE</div>
				<div class="d_content p-35">
					<fmt:formatDate value="${board.b_date}"
						pattern="yyyy-MM-dd HH:mm:ss"/>
				</div>
			</div>
			<div>
				<div class="t_content p-15">TITLE</div>
				<div class="d_content p-85">${board.b_title}</div>
			</div>
			<div>
				<div class="t_content p-15 content_h">CONTENTS</div>
				<div class="d_content p-85 content_h">
					<div class="content_in">
						${board.b_contents}
					</div>
					<div class="content_tag">
					<c:if test="${!empty tList}">
						<c:forEach var="t" items="${tList}">
						<a href="./list?colname=b_contents&keyword=${t.t_word}&pageNum=1">
							&#35;${t.t_word}
						</a>
						</c:forEach>
					</c:if>
					</div>
				</div>
			</div>
			<div>
				<div class="t_content p-15 file_h">FILES</div>
				<div class="d_content p-85 file_h" style="overflow: auto;">
					<c:if test="${empty fList}">
					첨부된 파일이 없습니다.
					</c:if>
					<c:if test="${!empty fList}">
					<c:forEach var="fitem" items="${fList}">
					<a href="./download?bf_sysname=${fitem.bf_sysname}&bf_oriname=${fitem.bf_oriname}">
						<span class="file-title">
							${fitem.bf_oriname}
						</span>
					</a>
					</c:forEach>
					</c:if>
				</div>
			</div>
			<table class="con_table">
				<!-- 이미지 파일 미리보기 -->
				<c:if test="${!empty fList}">
				<tr>
					<th>PREVIEW</th>
				</tr>
				<tr>
					<td>
					<c:forEach var="f" items="${fList}">
					<c:choose>
						<c:when test="${fn:contains(f.bf_sysname,'.jpg')}">
							<img src="upload/${f.bf_sysname}" width="100">
						</c:when>
						<c:when test="${fn:contains(f.bf_sysname,'.png')}">
							<img src="upload/${f.bf_sysname}" width="100">
						</c:when>
						<c:when test="${fn:contains(f.bf_sysname,'.gif')}">
							<img src="upload/${f.bf_sysname}" width="100">
						</c:when>
						<c:otherwise>미리보기 없음</c:otherwise>
					</c:choose>
					</c:forEach>
					</td>
				</tr>
				</c:if>
				<tr>
					<td colspan="6" align="center">
						<button class="btn-write" id="upbtn"
							onclick="location.href='./updateFrm?bnum=${board.b_num}'">U</button>
						<button class="btn-write" id="delbtn"
							onclick="delCheck('${board.b_num}')">D</button>
						<button class="btn-sub"
							onclick="backbtn();">B</button>
					</td>
				</tr>
			</table>
			<!-- 댓글 작성 양식 -->
			<form id="rFrm">
				<input type="hidden" name="r_bnum" value="${board.b_num}">
				<textarea rows="3" class="write-input ta"
					name="r_contents" id="comment"
					placeholder="댓글을 적어주세요~"></textarea>
				<input type="hidden" name="r_id" value="${mb.m_id}">
				<input type="button" value="댓글 전송"
					class="btn-write" onclick="replyInsert()"
					style="width: 100%; margin-bottom: 30px;">
			</form>
			<!-- 댓글 목록 보기 -->
			<table style="width: 100%"><!-- 제목 테이블 -->
				<tr class="rtbl-head">
					<td class="p-20">WRITER</td>
					<td class="p-50">CONTENTS</td>
					<td class="p-30">DATE</td>
				</tr>
			</table>
			<table id="rtable" style="width: 100%">
				<c:forEach var="r" items="${rList}">
					<tr>
						<td class="p-20">${r.r_id}</td>
						<td class="p-50">${r.r_contents}</td>
						<td class="p-30">
							<fmt:formatDate value="${r.r_date}"
											pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</section>
	<footer>
	<jsp:include page="footer.jsp"/>
	</footer>
</div>
</body>
<!-- 댓글 전송 및 댓글 목록 새로고침용 스크립트 -->
<script type="text/javascript">
function replyInsert(){
	var replyFrm = $("#rFrm").serialize();
	console.log(replyFrm);
	
	//controller에 ajax로 전송
	$.ajax({
		url: "replyIns",
		type: "post",
		data: replyFrm,
		success: function(result){
			var listStr = "";
			console.log(result);

			listStr += "<tr>"
					+ "<td class='p-20'>" + result.r_id + "</td>"
					+ "<td class='p-50'>" + result.r_contents + "</td>"
					+ "<td class='p-30'>" + result.r_date + "</td>"
					+ "</tr>";
			
			$("#rtable").prepend(listStr);
			$("#comment").val("");
		},
		error: function(error){
			console.log(error);
			alert("댓글 입력 실패");
		}
	});
}

function delCheck(bnum){
	var conf = confirm("삭제하겠습니까?");
	
	if(conf == true){
		location.href="./delete?bnum=" + bnum;
	}
}

//여기에 뒤로가기 버튼 처리 함수 작성.
function backbtn(){
	var urlstr = "./list?";
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




