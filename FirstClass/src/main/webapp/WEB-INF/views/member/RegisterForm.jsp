<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" 
  	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="../resources/css/register.css">
﻿<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>﻿
<title>회원가입</title>

<script type="text/javascript">

var emailCk = false;
var pwdCk = false;
var nameCk = false;
var ageCk = false;
$(document).ready(function(){
$(".register-btn").click(function(){
	
	
	var pattern1 = /[0-9]/;
	var pattern2 = /[a-zA-Z]/;
	var pattern3 = /[~!@\#$%<>^&*]/;
	
	if($(".email_input").val() == "") {
		alert("이메일을 입력해주세요.");
		$(".email_input").focus();
		emailCk = false;
		} else {
			emailCk = true;
		}
	
	
	if($(".password_input").val() == "") {
		alert("비밀번호를 입력해주세요");
		$(".password_input").focus();
		pwdCk = false;
			} else if (!pattern1.test($(".password_input").val()) || 
					!pattern2.test($(".password_input").val())|| 
					!pattern3.test($(".password_input").val()) || 
					$(".password_input").val().length < 8) {
				alert("영문+숫자+특수기호 8자리 이상으로 구성하여야합니다.");
				$(".password_input").focus();
				pwdCk = false;
				}	
	else{
				pwdCk = true;
			}

	if($(".nickName_input").val() == "") {
		alert("닉네임을 입력해주세요");
		$(".nickName_input").focus();
		nameCk = false;
		} else{
		nameCk = true;
	}
	
	if($(".age_input").val() == "") {
		alert("나이를 입력해주세요");
		$(".age_input").focus();
		ageCk = false;
		} else{
			ageCk = true;
		}
	
	
	
	/* 최종 유효성 검사 */
	if(emailCk&&pwdCk&&nameCk&&ageCk) {
		
		$("#RegisterForm").attr("action", "./addCtr.do");
	    $("#RegisterForm").submit();		
	}	
    return false;
});
});

		

</script>
</head>
<body>

<div class="register-form">
    <form action="./addCtr.do" method="post" name="RegisterForm" id="RegisterForm">
      <h1><a href="../clickHomeBtn.do" class="brand-link">
      <img src="../resources/images/watermelon.png" alt="AdminLTE Logo" 
      	class="brand-image img-circle elevation-3" style="opacity: .8; height: 80px;">
      </a>
      </h1>
      <div class="form-group">
        <input type="email" class="email_input" name="email" placeholder="이메일 주소">
        <span class="input-icon"><i class="fa fa-envelope"></i></span>
      </div>
      <div class="form-group">
        <input type="password" class="password_input" name="password" placeholder="비밀번호">
        <span class="input-icon"><i class="fa fa-lock"></i></span>
      </div>
      
      <div class="form-group">
        
       </div>
      
      <div class="form-group">
        <input type="text" class="nickName_input" name="nickName" placeholder="닉네임">
        <span class="input-icon"><i class="fa fa-user"></i></span>
      </div>
      <div class="form-group">
        <input type="text" class="age_input" name="age" placeholder="나이">
        <span class="input-icon"><i class="fa fa-list-ol"></i></span>
      </div>
      <div class="form-group">
        
        <select id="gender" name="gender" class="fa" required>
        
        	<option value='' selected>성별</option>
  			<option value='M'>&#xf222;남성</option>
 			<option value='F'>&#xf221;여성</option>
 			
 			</select>
        
       </div>
      <button type="button" class="register-btn">회원가입</button>      
      </form>
      
      <div class="seperator"><br/>
      	<p style="color: #666">계정이 있나요?</p>	
      <button class="login-btn" onclick="location.href='../login.do'">로그인</button> 	
      </div>
      
      <div class="seperator"><b>or</b></div>
      <p>Sign up with your social media account</p>
      <!-- Social register buttons -->
      <div class="social-icon">
        <button type="button" class="twitter"><i class="fa fa-twitter"></i></button>
        <button type="button" class="facebook"><i class="fa fa-facebook"></i></button>
      </div>
    
  </div>
  
</body>
</html>