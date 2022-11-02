<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/Style_login.css">
    <link rel="stylesheet" href="css/Style.css">
</head>
<body>
<div class="helloId">
    <h1 id="title">Member Manager</h1>
</div>
<center>
    <div class="login">
        <div class="login-screen">
            <div class="app-title">
                <h6>회원가입</h6>
            </div>
            <div class="login-form">
                <form action="regProc" method="post">
                    <div class="control-group">
                        <input type="text" name="m_id" class="login-field" placeholder="아이디" required>
                    </div>
                    <div class="control-group">
                        <input type="password" name="m_pwd" class="login-field" placeholder="비밀번호" required>
                    </div>
                    <div class="control-group">
                        <input type="text" name="m_name" class="login-field" placeholder="이름" required>
                    </div>
                    <div class="control-group">
                        <input type="date" name="m_birth" class="login-field">
                    </div>
                    <div class="control-group">
                        <input type="text" name="m_phone" class="login-field" placeholder="연락처">
                    </div>
                    <input type="submit" value="가입" class="btn">
                    <a href="/" class="login-link">돌아가기</a>
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
