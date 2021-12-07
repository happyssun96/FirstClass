<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" 
  	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	<link rel="stylesheet" href="resources/css/register.css">

<title>회원가입</title>
</head>
<body>

<div class="register-form">
    <form action="./addCtr.do" method="post">
      <h1>Register</h1>
      <div class="form-group">
        <input type="email" name="email" placeholder="이메일 주소">
        <span class="input-icon"><i class="fa fa-envelope"></i></span>
      </div>
      <div class="form-group">
        <input type="password" name="password" placeholder="비밀번호">
        <span class="input-icon"><i class="fa fa-lock"></i></span>
      </div>
      <div class="form-group">
        <input type="text" name="nickname" placeholder="닉네임">
        <span class="input-icon"><i class="fa fa-user"></i></span>
      </div>
      <div class="form-group">
        <input type="text" name="age" placeholder="나이">
        <span class="input-icon"><i class="fa fa-sort-numeric-up-alt"></i></span>
      </div>
      <div>
        남성 <span class="input-icon"><i class="fa fa-mars"></i></span>
        <input class="gender" type="radio" name="gender" value="M">
        여성 <span class="input-icon"><i class="fa fa-venus"></i></span>
        <input class="gender" type="radio" name="gender" value="F"><br/>
       </div>
      <button class="register-btn">회원가입</button>      
      
      <div class="seperator"><b>or</b></div>
      <p>Sign up with your social media account</p>
      <!-- Social register buttons -->
      <div class="social-icon">
        <button type="button"><i class="fa fa-twitter"></i></button>
        <button type="button"><i class="fa fa-facebook"></i></button>
      </div>
    </form>
  </div>
  
</body>
</html>