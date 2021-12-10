<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="./index.jsp"><i class="fas fa-home"></i></a></li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
	<div>
		<table border="1">
			
			<tbody>
			 	<tr>
         			<th>이메일</th>
         			<td>s1@test.com</td>
         		</tr>
         		
        		<tr>
         			<th>닉네임</th>
         			<td>수박남</td>				
      			</tr>
      			
      			<tr>
         			<th>등급</th>
         			<td>골드회원</td>				
      			</tr>
      			
      			<tr>
         			<th>보유 캐시</th>
         			<td>18000 캐시</td>				
      			</tr>
      			
      			<tr>
         			<th>나이</th>
         			<td>25</td>
         		</tr>
         		
         		<tr>
         			<th>성별</th>
         			<td>남자</td>
         		</tr>
         		
         		<tr>
         			<th>구독여부</th>
         			<td>1개월 구독중</td>
         		</tr>
         		
         		<tr>
         			<th>가입일</th>
         			<td>2021-12-10 14:38</td>
         		</tr>
         		
         		<tr>
         			<th>수정일</th>
         			<td>2021-12-13 15:49</td>
         		</tr>
     			      			
      		</tbody>
      		
		</table>
		
		<br>
		<button class="btn btn-primary">프로필 수정</button>
		&nbsp;&nbsp;&nbsp;
		<button class="btn btn-primary">내 플레이리스트 가기</button>				
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
