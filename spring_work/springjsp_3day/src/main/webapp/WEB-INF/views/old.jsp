<%--
  Created by IntelliJ IDEA.
  User: owo
  Date: 2022-10-19
  Time: 오후 1:32
  To change this template use File | Settings | File Templates.
--%>

<!--HTML 용-->
<%--page 지시자 용--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <!--지시자-->
<%! // 선언부(declaration)
  // 자바의 주석
  public int add(int a , int b){
    int c = a + b;
    return c;
  }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% // Scriptlet 영역(자바코드를 작성하는 영역)
  int num1 = 100;
  int num2 = 200;

  int res = add(num1, num2);
%>
<p> <%=num1%>과 <%=num2%>의 합은 <%=res%> 입니다. </p>
<p> <%=num1%>과 <%=num2%>의 차는 <%=num1 - num2%> 입니다. </p>
<p> <%=add(15, 20)%> 입니다. </p>
<%
  for(int i = 0; i < 5; i++){ // 이건 자바코드
%>
    <p><%=i%>번째 문장<p> <!-- 이건 html 코드-->
<%
  } // 이건 자바코드
%>

<hr>

<%@include file="jspbasic.jsp"%>
</body>
</html>
