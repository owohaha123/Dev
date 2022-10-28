<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>선택 필터링</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
</head>
<body>
<div style="border: 1px solid black;">
    <p>첫번째 div 엘리먼트</p>
    <p class="sel">두번째 div 엘리먼트</p>
    <p>세번째 div 엘리먼트</p>
    <p class="sel">네번째 div 엘리먼트</p>
</div>
<br>
<div style="border: 1px solid black;">
    <p>다섯번째 div 엘리먼트</p>
    <p class="sel">여섯번째 div 엘리먼트</p>
    <p>일곱번째 div 엘리먼트</p>
    <p class="sel">여덟번째 div 엘리먼트</p>
</div>
<button id="first">first</button>
<button id="last">last</button>
<button id="eq">eq(2)</button>
<button id="filter">filter</button>
<button id="not">not</button>
</body>
<script>
    $("#first").click(function (){
        $("p").first().css("background-color" , "orange");
    });
    $("#last").click(function (){
        $("p").last().css("background-color" , "purple");
    });
    $("#eq").click(function (){
        $("p").eq(2).css("background-color" , "green");
    });
    $("#filter").click(function (){
        $("p").filter(".sel").css("background-color" , "skyblue");
    });
    $("#not").click(function (){
        $("p").not(".sel").css("background-color" , "pink");
    });
</script>
</html>
