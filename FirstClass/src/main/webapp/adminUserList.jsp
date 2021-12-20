<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>유저 리스트</title>
  <style type="text/css">
  	
  	table, th {
  		text-align: center;
  		padding : 10px;
  	}
  	
  	table, td {
  		padding : 5px;
  	}
  	
  	table {
  		width: 900px;
  	}
  	
  	img {
  		width: 75px;
  		height: 75px;
  		object-fit : cover;
  	}

  </style>
</head>
<body class="hold-transition dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__wobble" src="resources/images/watermelon.png" alt="AdminLTELogo" height="60" width="60">
  </div>
  
  <jsp:include page="header.jsp" /> 
  <jsp:include page="adminNav.jsp" />

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-left: 300px;">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">관리자 페이지</h1>&emsp; >&nbsp;&nbsp; 유저 정보
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="./index.jsp"><i class="fas fa-home"></i></a></li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <div style="font-size: 100px; color: #E5E1E1; margin-left: 400px;">
    	<img src="resources/images/watermelon.png" style="height: 100px;">&nbsp;WaterMelon
    </div>
    <br>
    <br>

    
    <div style="margin-top: 10px; margin-left: 230px;">
	    <div style="margin-left: 20px;">		    	
	    	<br>
	    	<br>
	    	<h2>&nbsp;회원 데이터 ></h2>
	    	<br>
		    	<table border="1">				
					<tbody>
					
					 	<tr style="background: #403A3A;">
					 		<th>번호</th>
					 		<th>이메일</th>
					 		<th>닉네임</th>
					 		<th>권한</th>
					 		<th>등급</th>
					 		<th>보유 캐시</th>
					 		<th>나이</th>
					 		<th>성별</th>
					 		<th>구독여부</th>
					 		<th>가입일</th>
					 		<th>수정일</th>
					 	</tr>
					 	<tr onclick="location.href='./adminDetailPage.jsp'" style="cursor: pointer;">
					 		<td>${member.member_no}</td>
					 		<td>${member.email}</td>
					 		<td>${member.nickName}</td>
					 		<td>${member.auth}</td>
					 		<td>골드회원</td>
					 		<td>10000원</td>
					 		<td>25</td>
					 		<td>M</td>
					 		<td>1개월 구독 중</td>
					 		<td>2021.12.10</td>
					 		<td>2021.12.15</td>
					 	</tr>
					 	<tr>
					 		<td>3</td>
					 		<td>Melon@naver.com</td>
					 		<td>멜론녀</td>
					 		<td>일반</td>
					 		<td>실버회원</td>
					 		<td>5000원</td>
					 		<td>20</td>
					 		<td>F</td>
					 		<td>1개월 구독 중</td>
					 		<td>2021.12.10</td>
					 		<td>2021.12.15</td>
					 	</tr>
					 			
		      		</tbody>	      		
			</table>
	    	<div style="margin-left:360px;">
				<br>
				<jsp:include page="paging.jsp" />
			</div>
	    </div> 		    		    	
	    
    </div>        	    	
    </div>			
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->

	<jsp:include page="footer.jsp" />
	<!-- ./wrapper -->	
</body>
</html>