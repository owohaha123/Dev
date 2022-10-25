<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>JQuery</title>
    <script src="js/jquery-3.6.1.min.js"></script>
</head>
<body>
<h1>jQuery Selector</h1>
<hr>
<h2> 클래스가 없는 요소 </h2>
<h2 class="cls">클래스가 있는 요소</h2>
<h3> 클래스가 없는 요소 </h3>
<h3 class="cls">클래스가 있는 요소</h3>
<button id="classSel">클래스 선택</button>
</body>
<script>
    $("#classSel").click(function (){
        $(".cls").css("backgroundColor","red");
        $(".cls").css("color","yellow");
        $(this).hide();
        setTimeout(function (){
            turnBack();
        },3000);
    });

    function turnBack(){
        $("*").show();
    }
</script>
</html>
