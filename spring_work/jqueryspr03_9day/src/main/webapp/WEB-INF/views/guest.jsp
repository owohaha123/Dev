<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>방명록</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
    <style>
        .cont{
            height: 80px;
            line-height: 50px;
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            align-content: stretch;
            justify-content: center;
            align-items: center;
        }
        .sub{
            height: 50px;
            border: 1px solid gray;
            box-sizing: border-box;
            width: 100px;
            text-align: center;
        }
        .ct{
            width: 200px;
        }
        .date{
            width: 150px;
        }
    </style>
</head>
<body>
<h1>방명록</h1>
<h2>방문을 환영합니다</h2>
<fieldset>
    <legend>아래에 글을 남겨주세요</legend>
    <p>작성자 : <input type="text" id="name"></p>
    <p>내용 : <input type="text" id="content"></p>
    <p><button id="inbtn">작성</button></p>
    <div id="book">
        <%-- 여기에 새로운 글이 추가됩니다. --%>
        <div class="cont">
            <div class="sub">아무개</div>
            <div class="sub ct">그냥 와 봤어요</div>
            <div class="sub date">2022-10-22 11:05</div>
            <button id="del">삭제</button>
        </div>
    </div>
</fieldset>
</body>
<script>
    $("#inbtn").click(function (){
        // 입력한 작성자와 내용을 가져오기
        let name = $("#name").val();
        let content = $("#content").val();
        // 날짜와 시간 문자열 생성
        const now = new Date();
        let d = now.getFullYear() + "-"
                + (now.getMonth() + 1) + "-"
                + now.getDate() + " "
                + now.getHours() + ":"
                + now.getMinutes();
        let tag = "<div class='cont'>"
                  + "<div class='sub'>" + name + "</div>"
                  + "<div class='sub ct'>"+ content +"</div>"
                  + "<div class='sub date'>" + d +"</div>"
                  + "<button id='del'>삭제</button>"
                  + "</div>"

        $("#book").prepend(tag);
    });

    $(document).on("click" , "#del" , function (){ //시점 맞춰주기
        //alert("삭제버튼 눌렀음")
        $(this).parent().remove(); // this : 이벤트가 발생한 요소만
    });
</script>
</html>
