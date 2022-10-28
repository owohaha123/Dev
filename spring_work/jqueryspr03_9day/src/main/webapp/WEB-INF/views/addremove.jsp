<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>요소의 추가/제거</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
    <style>
        .parent {
            background-color: pink;
            width: 400px;
            height: 180px;
            text-align: center;
        }
        .c1 {
            background-color: skyblue;
            width: 300px;
            height: 50px;
            margin: 20px auto;
        }
        .c2 {
            background-color: skyblue;
            width: 300px;
            height: 50px;
            margin: 20px auto;
        }
    </style>
</head>
<body>
<h2>요소 추가</h2>
<ol>
    <li>List item 1</li>
</ol>
<button id="apnd">Append</button>
<button id="ppnd">Prepend</button>
<button id="bef">Before</button>
<button id="aft">After</button>
<hr>
<h2>요소 삭제</h2>
<div class="parent">
    <b>부모 요소</b>
    <div class="c1">자식 요소 1</div>
    <div class="c2">자식 요소 2</div>
</div>
<button id="remove">Remove</button>
<button id="empty">Empty</button>
<hr>
</body>
<script>
    let i = 1;

    $("#apnd").click(function (){
       i++;
       $("ol").append("<li>List item " + i + "</li>");
    });
    $("#ppnd").click(function (){
        i++;
        $("ol").prepend("<li>List item " + i + "</li>");
    });
    $("#bef").click(function (){
        i++;
        $("ol").before("<p>문단 " + i + "</p>");
    });
    $("#aft").click(function (){
        i++;
        //$(this).after("<p>문단 " + i + "</p>");
        $("ol").after("<p>문단 " + i + "</p>");
    });

    $("#remove").click(function (){
        $(".parent").remove();
    });
    $("#empty").click(function (){
        $(".parent").empty();
    });

</script>
</html>
