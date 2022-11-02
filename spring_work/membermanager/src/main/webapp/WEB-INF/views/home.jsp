<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="css/Style_login.css">
    <link rel="stylesheet" href="css/Style.css">
</head>
<body>
<div class="helloId">
    <h1 id="title">Member Manager</h1>
</div>
<br>
<center>
    <div class="login">
        <div class="login-screen">
            <div class="app-title">
                <h6>로그인 하세요</h6>
            </div>
            <div class="login-form">
                <form action="" method="post">
                    <div class="control-group">
                        <input type="text" class="login-field" placeholder="아이디를 입력하세요" name="m_id">
                    </div>
                    <div class="control-group">
                        <input type="password" class="login-field" placeholder="비밀번호를 입력하세요" name="m_pwd">
                    </div>
                    <input type="submit" value="LOGIN" class="btn btn-primary btn-large btn-block">
                    <a class="login-link" href="register">회원가입</a>
                </form>
            </div>
        </div>
    </div>
</center>
</body>
<script>
    let m = "${msg}"
    if (m != ""){
        alert(m)
    };
</script>
</html>
