<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-25
  Time: 오후 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="js/jquery-3.6.1.min.js"></script>
  <style>
    div {
      background-color: pink;
      width: 100px;
      padding: 10px 0;
      text-align: center;
    }
  </style>
</head>
<body>
<div>메뉴1</div>
<ul>
  <li>LIST 01</li>
  <li>LIST 02</li>
  <li>LIST 03</li>
  <li>LIST 04</li>
  <li>LIST 05</li>
</ul>
<button id="toggle">토글OFF</button>
<button id="onOff">OFF</button>
<p>LIST 01</p>
<p>LIST 02</p>
<p>LIST 03</p>
<p>LIST 04</p>
<p>LIST 05</p>
</body>
<script>
  $(function (){
    $("ul").hide();

    $("div").hover(function (){
      // 마우스가 들어갔을 때
      $("ul").show(1000)
    }, function (){
      // 마우스가 나갔을 때
      $("ul").hide(1000);
    });

    $("#onOff").click(function (){
      let view = $("p").css("display");
      if(view == "none"){ // p 태그들이 안 보인다면
        // = $("p").css("display" , "block");
        $("p").show(1000);
        $(this).text("OFF")
      }else{
        // = $("p").css("display","none");
        $("p").hide(1000);
        $(this).text("ON")
      }
    });

    $("#toggle").click(function (){
      $("p").toggle(1000, function (){
        let t = $($("#toggle")).text();
        if(t == "토글OFF"){
          $("#toggle").text("토글ON")
        }else{
          $("#toggle").text("토글OFF")
        }
      });
    });


  }); //ready end
</script>
</html>
