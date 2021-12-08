<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" 
  	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>로그인</title>
<link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
<div class="login-form">
    <form action="loginCtr.do" method="post">
      <h1>Login</h1>
      <div class="form-group">
        <input type="email" name="email" placeholder="이메일 주소">
        <span class="input-icon"><i class="fa fa-envelope"></i></span>
      </div>
      <div class="form-group">
        <input type="password" name="password" placeholder="비밀번호">
        <span class="input-icon"><i class="fa fa-lock"></i></span>
      </div>      
      <button class="login-btn">Login</button>      
      <a class="reset-psw" href="#">비밀번호를 잊었나요?</a>
      
      <div class="seperator"><br/>
      	<p style="color: #666">계정이 없나요?</p>	
      <button class="register-btn">회원가입</button> 	
      </div>
      
      <div class="seperator"><b>or</b></div>
      <p>Sign in with your social media account</p>
      <!-- Social login buttons -->
      <div class="social-icon">
        <button type="button" class="twitter"><i class="fa fa-twitter"></i></button>
         <button type="button" class="facebook"><i class="fa fa-facebook"></i></button>
      </div>
    </form>
  </div>

</body>
</html>