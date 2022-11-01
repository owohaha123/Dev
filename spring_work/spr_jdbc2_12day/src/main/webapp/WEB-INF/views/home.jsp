<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>
<html>
<head>
    <title>데이터 관리자</title>
</head>
<body>
<h1>데이터 관리자</h1>
<p>
    <a href="inputFrm">[데이터 입력]</a> |
    <a href="dataList">[데이터 목록]</a> |
</p>
<hr>
<p>${nowtime}</p>
</body>
<script>
    let m = "${msg}";
    if(m != ""){
        alert(m);
    }
</script>
</html>
