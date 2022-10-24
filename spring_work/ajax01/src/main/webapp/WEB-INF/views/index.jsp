<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- JQuery 연동 -->
    <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
<h1>index.html</h1>
<input type="button" id="btn" value="AjaxTest" />
<input type="button" id="btn2" value="AjaxTest2" />

<div id="ajaxDiv"
     style="border: 1px red solid; width: 300px; height: 200px"></div>
<hr>
동해물과 백두산이 마르고 닳도록
<br>
하나님이 보우하사

<!--가능하면 body 안 쪽에 넣기-->
<script>
    // ajax : 비동기 통신 기술
    // $.get $.load ... $.ajax
$('#btn').click(function (){
   $.ajax({
       type:'get', // 통신 방식. 자주쓰는 타입은 get 과 post
       url:'ajaxTest',
       data: {id: 'icia' , pw: '1111'},
       // dataType : 'html', // or 'json'
       success: function (data){ //main.jsp 전체코드가 돌아옴
           //console.log(JSON.parse(data)) //json 객체로 변환. 여기선 자동변환 해줌
           console.log(data) // json 문자열? js 객체?
           // for(let key in data){ //for in 사용
           //     $('#ajaxDiv').append(key + ": " + data[key] + "<br>")
           // }
           let str = '';
           for(let key in data){
               str += key + ": " + data[key] + "<br>";
           }
           $('#ajaxDiv').html(str);
       }, error : function (err){
           console.log(err);
       }
   })
}); //ajax end


    let obj1 = {id: 'aaa' , pw:'2222'};
    let obj2 = {id: 'bbb' , pw:'3333'};
    let arr = []; // 회원정보를 담을 배열
    arr.push(obj1); // [0]
    arr.push(obj2); // [1]

    let obj = {};
    obj.members = arr;
    console.log(obj);

    for(let key in obj) {
        console.log(key, obj[key]);
        if(key == 'members'){
            for(let elem of obj[key]){
                console.log(elem);
            }
        }
    }
    console.log(JSON.stringify(obj));// js 객체 -> json 객체로 변환
    console.log(JSON.stringify(obj.members));

    $('#btn2').click(function (){
        $.ajax({
            type:'post', //json 형태 전송 시 반드시 post
            url:'ajaxTest2',
            data: JSON.stringify(obj.members),
            contentType : 'application/json; charset=UTF-8', //json 형태로 서버로 전송
            //dataType: 'json'
            success:function (data){
                console.log(data);
                // ajaxDiv 에 추가해볼 것

            }, error:function (err){
                console.log(err)
            }
        })
    });
</script>
</body>
</html>
