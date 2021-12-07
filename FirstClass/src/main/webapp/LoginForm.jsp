<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>

	<h1>사용자 로그인</h1>
	
	<form action="loginCtr.do" method="post">

		
		이메일<input type="text" name="email"><br/>
		
		
		암호<input type="password" name="password"><br/>
		
		
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" 
					onclick ="location.href='./member/add.do'">

	</form>


</body>
</html>