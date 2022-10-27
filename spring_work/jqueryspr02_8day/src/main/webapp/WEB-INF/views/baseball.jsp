<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>야구전광판</title>
    <%--download library 클릭 후 사용 가능--%>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
</head>
<body>
<button id="strike">Strike</button>
<button id="ball">Ball</button>
<button id="restart" style="display:none">
    재시작
</button>
<br>
B:<b id="b">0</b><br>
S:<b id="s">0</b><br>
O:<b id="o">0</b><br>
</body>
<script>
    $(function (){
    let ba = 0, st = 0, ou = 0;
    //const strike = $("#s");

    $("#strike").click(function(){
        st++;
        $("#s").html(st);
        if(st >= 3) {
            alert("스트라이크 아웃!!");
            ou++;
            $("#o").html(ou);
            init();
        }

        if(ou >= 3){
            alert("3 아웃 게임 오버!");
            $("#restart").show();
            $("#strike").attr("disabled" ,true);
            $("#ball").attr("disabled" ,true);
        }
    })

    $("#ball").click(function(){
        ba++;
        $("#b").html(ba);
        if(ba >= 4){
            alert("4 볼!!");
            init();
        }
    });

    $("#restart").click(function(){
        ou = 0;
        $("#o").html(ou);
        init();
        $("#strike").attr("disabled" , false);
        $("#ball").attr("disabled" ,false);
        $("#restart").hide();
    });

    function init(){//스트라이크, 볼 카운트 초기화 함수
        st = 0;
        ba = 0;
        $("#s").html(st);
        $("#b").html(ba);
    }
    })
</script>
</html>
