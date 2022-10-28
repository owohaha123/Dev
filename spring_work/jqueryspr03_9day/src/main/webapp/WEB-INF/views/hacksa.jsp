<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학점 등록</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
    <style>
        table {
            width: 100%;
        }
        table, th, td {
            border: 1px solid;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px 20px;
        }
    </style>
</head>
<body>
<h1>학점 등록</h1>
<table>
    <tr>
        <th>학번</th>
        <th>이름</th>
        <th>과목</th>
        <th>점수</th>
        <th>학점</th>
    </tr>
</table>
<br>
<fieldset>
    <legend>점수 입력</legend>
    학번 : <input id="i1" type="text"><br>
    이름 : <input id="i2" type="text"><br>
    과목 : <input id="i3" type="text"><br>
    점수 : <input id="i4" type="text"><br>
    학점 : <input id="i5" type="text"><br>
    <button>입력</button>
</fieldset>
</body>
<script>
    $("button").click(function (){
        // let num = $("#i1").val();
        // let name = $("#i2").val();
        // let cls = $("#i3").val();
        // let score = $("#i4").val();
        // let grade = $("#i5").val();
        let inputs = $("input")
        console.log(inputs)

        // let tagStr = "<tr>"
        //     + "<td>" + num + "</td>"
        //     + "<td>" + name + "</td>"
        //     + "<td>" + cls + "</td>"
        //     + "<td>" + score + "</td>"
        //     + "<td>" + grade + "</td>"
        //     + "</tr>";
        let tagStr = "<tr>";
        // 입력 개수에 맞게 반복처리
        for(let i = 0; i < inputs.length; i++){
            tagStr += "<td>" + $(inputs[i]).val() + "</td>"
        }
        tagStr += "</tr>";

        $("table").append(tagStr);
    });

</script>
</html>
