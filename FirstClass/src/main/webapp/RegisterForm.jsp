<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>

<!-- 닉네임, 나이, 성별, 이메일, 비밀번호-->

	<h1>회원가입</h1>
	
	<form action="./addCtr.do" method="post">
	
			
		이메일<input type="text" name="EMAIL"><br/>
		
		암호<input type="password" name="PASSWORD"><br/>
		
		
		닉네임<input type="text" name="NICKNAME"><br/>
		
		나이<input type="text" name="AGE"><br/>
		
		성별<input type="radio" name="GENDER" value='M'>남성
				<input type="radio" name="GENDER" value='F'>여성<br/>						
				<input type="submit" value="회원가입">							
				<input type="button" value="로그인" >				
				<input type="reset" value="취소">					
						
	</form>
</body>
</html>