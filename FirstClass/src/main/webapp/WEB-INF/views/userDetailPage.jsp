<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>회원상세정보</title>
  <link rel="stylesheet" href="resources/css/userDetailPage.css">

</head>
<body class="hold-transition dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
<div class="user-detail-page">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__wobble" src="resources/images/watermelon.png" alt="AdminLTELogo" height="60" width="60">
  </div>
  
  <jsp:include page="header.jsp" />
  
  <jsp:include page="nav.jsp" />

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-left: 300px;">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">내 정보</h1>
          </div><!-- /.col -->
       
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
	<div>
		<table border="1">
			
			<tbody>
			 	<tr>
         			<th>이메일</th>
         			<td>${member.email}</td>
         		</tr>
         		
        		<tr>
         			<th>닉네임</th>
         			<td>${member.nickName}</td>				
      			</tr>
      			
      			<tr>
         			<th>등급</th>
         			<td>
						<c:if test="${member.memberClass == 0}">
                  			관리자
                  		</c:if>
                  		<c:if test="${member.memberClass == 1}">
                  			브론즈
                  		</c:if>
                  		<c:if test="${member.memberClass == 2}">
                  			실버
                  		</c:if>
                  		<c:if test="${member.memberClass == 3}">
                  			골드
                  		</c:if>
                  		<c:if test="${member.memberClass == 4}">
                  			챌린저
                  		</c:if>
					</td>				
      			</tr>
      			
      			<tr>
         			<th>보유 캐시</th>
         			<td>${member.cash}</td>				
      			</tr>
      			
      			<tr>
         			<th>나이</th>
         			<td>${member.age}</td>
         		</tr>
         		
         		<tr>
         			<th>성별</th>
         			<td>
         			<c:if test="${member.gender eq 'M'}">
         				남성
         			</c:if>
         			<c:if test="${member.gender eq 'F'}">
         				여성
         			</c:if>
         			</td>
         		</tr>
         		
         		<tr>
         			<th>구독여부</th>
         			<td>1개월 구독중</td>
         		</tr>
         		
         		<tr>
         			<th>가입일</th>
         			<td>${member.createDate}</td>
         		</tr>
         		
         		<tr>
         			<th>수정일</th>
         			<td>${member.modifyDate}</td>
         		</tr>
     			      			
      		</tbody>
      		
		</table>
		
		<br>
		<button class="btn btn-secondary" onclick="location.href='userUpdateInformation.do?no=${member.member_no}'">프로필 수정</button>
		&nbsp;&nbsp;&nbsp;
		<button class="btn btn-secondary">내 플레이리스트 가기</button>				
	</div>
	
	
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->

	<jsp:include page="footer.jsp" />

</div>
	<!-- ./wrapper -->	
</div>
</body>
</html>
