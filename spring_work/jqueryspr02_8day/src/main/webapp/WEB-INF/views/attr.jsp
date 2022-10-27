<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery 속성 처리</title>
    <%--download library 클릭 후 사용 가능--%>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
</head>
<body>
<a href="baseball">야구전광판 이동</a>
<h2>속성 읽기 (내용은 콘솔에서 확인)</h2>
<p>문자가 쓰여진 <b>강조된</b> 영역</p>
<span id="text"></span><br>
<span id="html"></span><br>
<input id="intag" type="text" value="text">
<button id="inbtn">값 읽기</button>
<button id="chbtn">속성 변경</button>
<hr>
<fieldset>
    <legend>숫자 입력</legend>
    범위(0~100) : <input id="point" type="range" min="0" max="100" value="30" step="1">
    <br>
    현재 값 : <span id="msg"></span><br>
    <button id="inc">증가</button>
    <button id="dec">감소</button>
</fieldset>
</body>
<script>
    $(function (){
        let txt = $("p").text();
        let html = $("p").html();
        console.log(txt);
        console.log(html);
        $("#text").text("<h2>text 와 html 의 차이</h2>")
        $("#html").html("<h2>text 와 html 의 차이</h2>")

        let type = $("#intag").attr("type");
        console.log(type);

        $("#inbtn").click(function (){
           let indata = $("#intag").val();
           console.log(indata);
        });
        $("#chbtn").click(function (){
           $("#intag").attr("type" , "button");
           $("#intag").val("버튼이닷!");
        });

        // 범위 입력 처리
        let i = $("#point").val();
        $("#point").change(function (){
        // on("click" , function(){}) = click(function(){})
        // input 은 별도로 메소드가 없기에 on("input: , function(){}) 형태로 작성
        //$("#point").on("input", function (){ // on: 모든 이벤트 처리 가능
           let val = $(this).val();
           i = val;
           console.log(i);
           $("#msg").html(val);
        });

        // 증가 감소 버튼
        $("#inc").click(function (){
            i++; // 현재 범위 입력 태그의 값을 하나 증가
            $("#point").val(i);
            $("#msg").html(i);
            });
        $("#dec").click(function (){
            i--;
            $("#point").val(i);
            $("#msg").html(i);
        });
    });
</script>
</html>
