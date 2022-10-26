<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fade In & Out</title>
    <%--download library 클릭 후 사용 가능--%>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>

    <style>
        div#d1, div#d2, div#d3{
            width: 80px;
            height: 80px;
            display: none;
        }
        #flip1 {
            cursor: pointer;
            padding: 5px;
            text-align: center;
            background-color: lightpink;
            border: 1px solid black;
        }
        .panel{
            padding: 50px;
            text-align: center;
            border: 1px solid black;
            background-color: lightgray;
            display: none;
        }
        #flip2 {
            cursor: pointer;
            padding: 5px;
            text-align: center;
            background-color: lightblue;
            border: 1px solid black;
        }
        #ad{
            background-color: #98bf21;
            height: 100px;
            width: 100px;
            position: absolute;
        }
    </style>
</head>
<body>
<a href="attr">속성으로 이동</a>
<h1>Fade 효과</h1>
<button id="vs">Fade In</button>
<button id="iv">Fade Out</button>
<button id="to">Fade Toggle</button>
<button id="ft">Fade To</button>
<div id="d1" style="background-color: orange"></div>
<div id="d2" style="background-color: pink"></div>
<div id="d3" style="background-color: lightblue"></div>
<hr>
<h2>Slide 효과</h2>
<div id="flip1">여기를 눌러 주세요(토글)</div>
<div class="panel">여기에 서브메뉴가 있어요~</div>
<div id="flip2">여기를 눌러 주세요(닫힘)</div>
<hr>
<h2>Animate 효과</h2>
<button id="ani">Animate</button>
<div id="ad"></div>
</body>
<script>
    $(function (){ // 소스코드는 이 안에다 작성
        $("#vs").click(function (){
            $("div").first().fadeIn("slow", function (){
                $(this).next("div").fadeIn("slow", function (){
                    $(this).next("div").fadeIn("slow")
                });
            });
        });
        $("#iv").click(function (){
            $("div").first().fadeOut("slow", function (){
                $(this).next("div").fadeOut("slow", function (){
                    $(this).next("div").fadeOut("slow")
                });
            });
        });
        $("#to").click(function (){
            $("div").first().fadeToggle("slow", function (){
                $(this).next("div").fadeToggle("slow", function (){
                    $(this).next("div").fadeToggle("slow")
                });
            });
        });
        $("#ft").click(function (){
            $("#d1").fadeTo("slow", 0.15);
            $("#d2").fadeTo("slow", 0.4);
            $("#d3").fadeTo("slow", 0.7);
        });
        $("#flip1").click(function (){
            //$(this).next().slideDown("slow"); // 열림
            $(this).next().slideToggle("slow");

        });
        $("#flip2").click(function (){
            $(this).prev().slideUp("slow");
        });

        // animate
        $("#ani").click(function (){
            $("#ad").animate({
                left: "250px",
                opacity: "0.5",
                height: "150px",
                width:"150px"
                //backgroundColor: "red" // 색상은 안되는 듯?
            }, "slow" , function (){
                alert("애니메이션 완료")
            });
        });
    });
</script>
</html>
