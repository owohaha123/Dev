<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 양식</title>
    <style>
     input {
       background-color: lightblue;
     }
    </style>
</head>
<body>
<h1>회원 가입</h1>
<form action="joinProc" method="post"> <%--post 는 생략 불가--%>
  <table>

    <tr>
      <th width = "100">ID</th>
      <td width = "200">
        <input type="text" name="id" placeholder="아이디를 입력하세요">
      </td>
    </tr>

    <tr>
      <th>PASS</th>
      <td>
        <input type="password" name="pwd" placeholder="비밀번호를 입력하세요">
      </td>
    </tr>

    <tr>
      <th>NAME</th>
      <td>
        <input type="text" name="name" placeholder="이름을 입력하세요">
      </td>
    </tr>

    <tr>
      <th>AGE</th>
      <td>
        <input type="number" name="age" placeholder="나이를 입력하세요">
      </td>
    </tr>

    <tr>
      <td colspan="2">
        <input type="submit" value="가입">
      </td>
    </tr>

  </table>
</form>
</body>
</html>
