<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세보기</title>
</head>
<body>
<h1>데이터 상세보기</h1>
<table border="1">
  <tr>
    <th width="50">CODE</th>
    <td width="150">${data.m_code}</td>
  </tr>
  <tr>
    <th>STR</th>
    <td>${data.m_str}</td>
  </tr>
  <tr>
    <th>INT</th>
    <td>${data.m_int}</td>
  </tr>
  <tr>
    <th>DATE</th>
    <td>${data.m_date}</td>
  </tr>
  <tr>
    <td colspan="2">
      <button id="ubtn">수정</button>
      <button id="dbtn">삭제</button>
    </td>
  </tr>
</table>
</body>
<script>
  const ub = document.getElementsByTagName("button")

  // 수정
  ub[0].addEventListener("click", function (){
    location.href = "updateFrm?code=${data.m_code}";
  })
  // 삭제
  ub[1].addEventListener("click", function (){
    let q = confirm("삭제하시겠습니까?");
    if (q == true){
      location.href = "deleteProc?code=${data.m_code}";
    }else {
      alert("삭제를 취소합니다.");
    }
  })

  let m = "${msg}";
  if(m != ""){
    alert(m);
  }
</script>
</html>
