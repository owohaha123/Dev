<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Js Framework Home</title>
</head>
<body>
<h1>초간단 계산기</h1>
<form action="calProc"> <%--대부분 get 사용. post 사용은 한정적--%>
    <p>값 1 : <input type="number" name="num1"></p>
    <p>값 2 : <input type="number" name="num2"></p>
    <p>
        <button type="button">+</button>
        <button type="button">-</button>
        <button type="button">*</button>
        <button type="button">/</button>
        <button type="button">%</button>
    </p>
    <input type="hidden" name="op" id="op">
    <p><input type="submit" value="전송"></p>
</form>
<hr>
<a href="dateProc">[오늘의 날짜]</a><br>
<a href="old">[jsp 기초]</a>
<a href="el_op">[EL 활용]</a>
</body>
<script>
    // 연산 버튼 가져오기
    const btns = document.getElementsByTagName("button");
    console.log(btns);
    const  opInput = document.getElementById("op")

    // 각 버튼 처리
    btns[0].addEventListener("click" , function (){
        opInput.value = "+";
    })
    btns[1].addEventListener("click" , function (){
        opInput.value = "-";
    })
    btns[2].addEventListener("click" , function (){
        opInput.value = "*";
    })
    btns[3].addEventListener("click" , function (){
        opInput.value = "/";
    })
    btns[4].addEventListener("click" , function (){
        opInput.value = "%";
    })
</script>
</html>
