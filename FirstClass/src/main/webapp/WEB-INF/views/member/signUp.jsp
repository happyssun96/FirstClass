<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<div class="container">	
	<div class="row">
	<form role="form" method="post" id="signUp">
		<legend>회원가입 </legend>
		<p><label>아이디  </label><input type="text" name="id" required/></p>
		<p><label>비밀번호 </label><input type="password" name="password" required/></p>
		<p><label>이 름  </label><input type="text" name="name" required/></p>
		<p><label>이메일  </label><input type="email" name="email" placeholder="test@test.com" required/></p>
		<p><label>휴대폰  </label><input type="text" name="phone" placeholder="010-2222-1111" required/></p>
		<p><label>주 소  </label><input type="text" name="address" /></p>
		
		<p><label>이메일 수신여부  </label>
		<input type="radio" name="infoEmail" value="1" checked>수신함</input>
		<input type="radio" name="infoEmail" value="0">수신안함</input></p>
		
		<p><label>문자메시지 수신여부  </label>
		<input type="radio" name="infoSMS" value="1" checked>수신함</input>
		<input type="radio" name="infoSMS" value="0">수신안함</input></p>
		
		<p><input type="submit" value="가입" /></p>
	</form>
	</div>
	</div><!-- .container -->
<script>
doc = document;
doc.title = '회원가입 -메인';
</script>	
<%@ include file="/WEB-INF/views/footer.jsp" %>
</html>