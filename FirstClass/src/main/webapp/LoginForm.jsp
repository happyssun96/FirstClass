<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���</title>
</head>
<body>

	<h1>����� �α���</h1>
	
	<form action="loginCtr.do" method="post">

		
		�̸���<input type="text" name="email"><br/>
		
		
		��ȣ<input type="password" name="password"><br/>
		
		
				<input type="submit" value="�α���">
				<input type="button" value="ȸ������" 
					onclick ="location.href='./member/add.do'">

	</form>


</body>
</html>