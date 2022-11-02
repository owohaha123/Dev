<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="css/Style_login.css">
    <link rel="stylesheet" href="css/Style.css">
</head>
<body>
<div class="helloId">
    <h1 id="title">Member Manager</h1>
    <b>${mem.m_name}님</b>
    <a href="logoutProc">로그아웃</a>
</div>
</body>
<script>
    let loginsuc = "${mem.m_id}";
    if (loginsuc == ""){
        // 로그인을 안 한 경우 로그인페이지로 이동
        location.href = "/";
    }
    let m = "${msg}";
    if (m != ""){
        alert(m)
    };
</script>
</html>
