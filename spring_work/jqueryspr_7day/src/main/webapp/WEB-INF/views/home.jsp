<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-25
  Time: 오전 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.6.1.min.js"></script>
    <script>
        $(document).ready(function (){
            $("button").click(function (){
                alert("버튼 눌림~");
                $("#out").html("버튼으로 추가한 문장")
            });
            $("#btn1").click(function (){
                location.href = "jquery01";
            })
            $("#btn2").click(function (){
                location.href = "event";
            })
        });
    </script>
</head>
<body>
<h1>jQuery first~~</h1>
<button>실행</button>
<p id="out"></p>
<input type="button" id="btn1" value="이동">
<br>
<input type="button" id="btn2" value="이벤트">
<br>
<a href="hideshow">이동</a>

</body>

</html>

