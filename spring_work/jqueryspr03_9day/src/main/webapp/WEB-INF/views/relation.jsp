<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계층관계</title>
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
    <div style="width:500px;">div (great-grandparent)
        <ul>ul (grandparent)
            <li>li (direct parent)
                <span>span</span>
            </li>
        </ul>
    </div>

    <div style="width:500px;">div (grandparent)
        <p>p (direct parent)
            <span>span</span>
        </p>
    </div>
</div>
<button id="parent">부모선택</button>
<button id="parents">상위요소선택</button>
<button id="until">...까지선택</button>
</body>
<script>
    $("#parent").click(function (){
        $("span").parent().css({
        //$("span").parent().parent().css({
            "color": "red",
            "border" : "2px solid red"
        });
    });
    $("#parents").click(function (){
        $("span").parents().css({
            "color": "blue",
            "border" : "2px solid blue"
        });
    });
    $("#until").click(function (){
        $("span").parentsUntil(".ancestors").css({
            "color": "orange",
            "border" : "2px solid orange"
        });
    })
</script>
</html>
