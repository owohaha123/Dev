<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
    <style>
        .siblings * {
            display: block;
            border: 2px solid lightgrey;
            color: lightgrey;
            padding: 5px;
            margin: 15px;
        }
    </style>
</head>
<body>
<div class="siblings">div (parent)
    <p>p</p>
    <span>span</span>
    <h2>h2</h2>
    <h3>h3</h3>
    <h4>h4</h4>
    <h5>h5</h5>
    <h6>h6</h6>
    <p>p</p>
</div>
<button id="sib">sibling</button>
<button id="next">next</button>
<button id="nextAll">next all</button>
<button id="nextUntil">next until</button>
</body>
<script>
    $("#sib").click(function (){
       // 선택자 요소를 '제외'한 형제 요소 선택
        $("h2").siblings().css({
            "color": "red",
            "border" : "2px solid red"
        });
    });
    $("#next").click(function (){
       $("h2").next().css({
           "color": "blue",
           "border" : "2px solid blue"
       });
    });
    $("#nextAll").click(function (){
        $("h2").nextAll().css({
            "color": "orange",
            "border" : "2px solid orange"
        });
    });
    $("#nextUntil").click(function (){
        $("h2").nextUntil("h6").css({
            "color": "green",
            "border" : "2px solid green"
        });
    });
</script>
</html>
