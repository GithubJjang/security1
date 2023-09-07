<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/login" method="POST">
			<input type="text"  name="username" placeholder="Username"/><br/>
			<input type="password"  name="password" placeholder="Password"/><br/>
			<button>로그인</button>	
	</form>
<c:if test="${error}">
 <p id="valid" class="alert alert-danger">${exception}</p>
</c:if>
	
<a href="/joinForm">아직 회원가입을 하지 않으셨나요?</a>

</body>
</html>