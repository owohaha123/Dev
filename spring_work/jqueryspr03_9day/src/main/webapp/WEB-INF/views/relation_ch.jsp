<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계층관계_하위</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
    <style>
        .ancestors * {
            display: block;
            border: 2px solid gray;
            color: black;
            padding: 5px;
            margin: 15px;
        }
    </style>
</head>

<body>
<div class="ancestors">
    <div class="parents" style="width:500px;">
        div(.parents)
        <ul>ul
            <li>li
                <span class="first">span</span>
            </li>
        </ul>
    </div>
    <div class="parents" style="width:500px;">
        div(.parents)
        <p>p
            <span class="second">span</span>
        </p>
    </div>
</div>
<button id="child">자식찾기</button>
<button id="find">span 찾기</button>
<button id="find2">자식 전체 찾기</button>
</body>
<script>
    $("#child").click(function (){
        $(".parents").children().css({
            "color" : "red",
            "border" : "2px solid red"
        });
    });
    $("#find").click(function (){
       $(".parents").find("span").css({
           "color" : "blue",
           "border" : "2px solid blue"
       }) ;
    });
    $("#find2").click(function (){
        $(".parents").find("*").css({
            "color" : "orange",
            "border" : "2px solid orange"
        }) ;
    });
</script>
</html>
