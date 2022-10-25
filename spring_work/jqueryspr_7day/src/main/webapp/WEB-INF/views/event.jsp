<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-25
  Time: 오후 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event</title>
    <script src="js/jquery-3.6.1.min.js"></script>
    <style>
    div{
      width:200px;
      height:200px;
      margin-right: 7px;
      text-align: center;
    }
    #mousezone{
      background-color: #59b1f6;
    }

    #overzone{
      background-color: #ffb5b4;
    }

  </style>
</head>
<body>
<p>클릭 하면 글자 색상이 바뀌어요~!</p>
<p>클릭 하면 글자 색상이 바뀌어요~!</p>
<p>클릭 하면 글자 색상이 바뀌어요~!</p>
<p>클릭 하면 글자 색상이 바뀌어요~!</p>
<div id="mousezone">마우스 존</div>
<div id="overzone">H 오버 존</div>
아이디: <input type="text" name="userid">
<br>
비밀번호: <input type="password" name="userpass">
</body>
<script>
    // p 클릭
    $("p").click(function (){
        $(this).css("color" , "pink");
    });

    // p 더블클릭
    $("p").dblclick(function (){
        $(this).css("color" , "blue");
    });

    $("#mousezone").mouseenter(function (){
        $(this).text("마우스가 들어왔다~");
        $(this).css("backgroundColor" , "green");
    });

    $("#mousezone").mouseleave(function (){
        $(this).text("마우스가 나갔다~");
        $(this).css("backgroundColor" , "lightgray");
    });

    $("#mousezone").mousedown(function (){
        $(this).text("마우스 버튼 눌림!!");
        $(this).css("color" , "red");
    });

    $("#mousezone").mouseup(function (){
        $(this).text("마우스 버튼 뗌!!");
        $(this).css("color" , "yellow");
    });

    $("#overzone").hover(function (){
        $(this).text("마우스가 들어왔다~");
        $(this).css("backgroundColor" , "green");
    }, function (){
        $(this).text("마우스가 나갔다~");
        $(this).css("backgroundColor" , "lightgray");
    });

    $("input").focus(function (){
        $(this).css("backgroundColor" , "blue");
    });

    $("input").blur(function (){
        $(this).css("backgroundColor" , "#ffffff");
    });
</script>
</html>
