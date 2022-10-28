<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CSS 변경</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
    <style>
      .basic{
        width: 200px;
        height: 150px;
        border: 1px solid;
        text-align: center;
        line-height: 150px;
        margin-top: 20px;
      }
      .change {
          background-color: blue;
          color: yellow;
      }
    </style>
</head>
<body>
<button id="add">클래스 추가</button>
<button id="remove">클래스 삭제</button>
<button id="toggle">클래스 토글</button>
<div class="basic">DIV</div>
<hr>
<h2>오늘은?</h2>
<button id="date">Date</button>
<p id="np"></p>
<a href="addremove">추가/삭제로 이동</a>
<br>
<a href="guest">방명록 이동</a>
<br>
<a href="relation">계층-상위관계(이동)</a>
<br>
<a href="relation_ch">계층-하위관계(이동)</a>
<br>
<a href="sibling">계층-형제관계(이동)</a>
<br>
<a href="filtering">계층-필터링(이동)</a>
<br>
<a href="hacksa">학점 등록 page</a>
</body>
<script>
    $(function (){
       $("#add").click(function (){
          $("div").addClass("change");
       });
       $("#remove").click(function (){
           $("div").removeClass("change");
       });
       $("#toggle").click(function (){
           $("div").toggleClass("change");
        });

       const week = ["일" , "월" , "화" , "수" , "목" , "금" , "토"]


       $("#date").click(function (){
           const now = new Date();
           let d = now.getFullYear() + "년 "
               + (now.getMonth() + 1) + "월 "
               + now.getDate() + "일 "
               + week[now.getDay()] + "요일 " // 요일: 0(일)~6(토)
               + now.getHours() + ":"
               + now.getMinutes() + ":"
               + now.getSeconds();
           //$("#np").html(now);
           $("#np").html(d);
       })
    });
</script>
</html>
