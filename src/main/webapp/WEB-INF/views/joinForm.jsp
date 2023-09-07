<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/join" method="POST">
		<input type="text"  name="username" placeholder="Username"/><br/>
		<input type="password"  name="password" placeholder="Password"/><br/>
		<input type="email"  name="email" placeholder="Email"/><br/>
			
		<button>로그인</button>	
		</form>

</body>
</html>