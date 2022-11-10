<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="top-bar">
		<div class="content">
			<img alt="로고" src="images/r-logo.jpg"
				class="top-left logo" onclick="gohome()">
			<h2 class="top-left top-home">Web Board</h2>
			<nav class="top-right">
				<ul>
					<li class="suc" id="mname">테스트님</li>
					<li class="suc"><a href="logout">Logout</a></li>
					<li class="bef"><a href="loginFrm">Login</a></li>
					<li class="bef"><a href="joinFrm">Join</a></li>
				</ul>
			</nav>
		</div>
	</div>
	
	<script>
		function gohome(){
			var id = "${mb.m_id}";
			
			if(id == ""){//로그인 전
				location.href = "/";
			}
			else {//로그인 후
				location.href = "list?pageNum=1";
			}
		}
	</script>