<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
</head>
<body>

<!-- �г���, ����, ����, �̸���, ��й�ȣ-->

	<h1>ȸ������</h1>
	
	<form action="./addCtr.do" method="post">
	
			
		�̸���<input type="text" name="EMAIL"><br/>
		
		��ȣ<input type="password" name="PASSWORD"><br/>
		
		
		�г���<input type="text" name="NICKNAME"><br/>
		
		����<input type="text" name="AGE"><br/>
		
		����<input type="radio" name="GENDER" value='M'>����
				<input type="radio" name="GENDER" value='F'>����<br/>						
				<input type="submit" value="ȸ������">							
				<input type="button" value="�α���" >				
				<input type="reset" value="���">					
						
	</form>
</body>
</html>