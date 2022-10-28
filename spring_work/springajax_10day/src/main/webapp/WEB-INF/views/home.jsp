<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
</head>
<body>
<h2>일반 컨트롤러와 데이터 주고 받기</h2>
<p>ID : <input id="inId" type="text" placeholder="아이디를 입력하세요">
<button id="idcheck">중복확인</button>
<button id="restcheck">중복확인(REST)</button>
</p>
<p>PWD : <input id="inPwd" type="password" placeholder="비밀번호를 입력하세요"></p>
<p>NAME : <input id="inName" type="text" placeholder="이름을 입력하세요"></p>
<p><button id="send1">가입 1</button></p>
<hr>
<h2>다시 만든 가입 양식</h2>
<form id="joinFrm">
    <p>ID : <input type="text" name="m_id" placeholder="아이디를 입력하세요"></p>
    <p>PWD : <input type="password" name="m_pwd" placeholder="비밀번호를 입력하세요"></p>
    <p>NAME : <input type="text" name="m_name" placeholder="이름을 입력하세요"></p>
    <p><button type="button" id="send2">가입 2</button></p>
</form>
</body>
<script>
    $("#idcheck").click(function (){
        let idvalue = $("#inId").val();

        let sendObj = {"data":idvalue}; // json

        // controller 와 통신
        $.ajax({
            url : "idcheck",
            type : "get",
            data: sendObj,
            success : function (result){
                if(result == "ok"){
                    alert("사용 가능한 아이디입니다.");
                }else{
                    alert("사용 중인 아이디입니다.");
                }
            },
            error: function (error){
                alert("전송 실패");
                console.log(error);
            }
        });
    });

    $("#restcheck").click(function (){
       let idval = $("#inId").val();
       let sObj = {"idv":idval};

       $.ajax({
           url : "restcheck",
           type: "post",
           data: sObj,
           success : function (result){
               alert(result);
           },
           error: function (error){
               alert("전송 실패");
               console.log(error);
           }
       });
    });

    $("#send1").click(function (){
       let id = $("#inId").val();
       let pwd = $("#inPwd").val();
       let name = $("#inName").val();

       let sData = {
           "m_id" : id,
           "m_pwd" : pwd,
           "m_name" : name
       }

       $.ajax({
           url : "joinProc",
           type : "post",
           data : sData,
           success : function (r){
               alert(r);
           },
           error : function (e){
               alert("전송 실패");
               console.log(e);
           }
       });
    });

    $("#send2").click(function (){
        // form 데이터를 가져와 직렬화 한 후 전송
        // serialize() : form 데이터 직렬화 함수 (한 번에 전송 가능한 data 화)
        const formData = $("#joinFrm").serialize();
        console.log(formData);

        $.ajax({
            url : "joinProc",
            type : "post",
            data : formData,
            success : function (result){
                alert(result);
            },
            error : function (error){
                alert("전송 실패");
                console.log(error);
            }
        })
    });
</script>
</html>
