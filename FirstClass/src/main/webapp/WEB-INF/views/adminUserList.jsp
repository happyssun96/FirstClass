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
    <div style="font-size: 100px; color: #E5E1E1; margin-left: 450px;">
    	<img src="resources/images/watermelon.png" style="height: 100px;">&nbsp;WaterMelon
    </div>
    <br>
    <br>
   
        <div style="margin-top: 50px;">
	    <div style="margin-left: 300px;">		    	
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
					 	
					 	<c:forEach var="memberVo" items="${memberList}">
					         <tr onclick="location.href='admin/adminUserDetailInformation.do?no=${memberVo.member_no}'" style="cursor: pointer;">
					            <td>${memberVo.member_no}</td>
					            <td>${memberVo.email}</td>
					            <td>${memberVo.nickName}</td>
					            <td>${memberVo.auth}</td>
					            <td>${memberVo.memberClass}</td>
					            <td>${memberVo.cash}</td>
					            <td>${memberVo.age}</td>
					            <td>${memberVo.gender}</td>
					            <td>O</td>
					            <td>${memberVo.createDate}</td>
					            <td>${memberVo.modifyDate}</td>
					         </tr>
					      </c:forEach>
					 			
		      		</tbody>	      		
			</table>
	    	
	    </div>
	    	
	    </div> 		    		    	
	    
	    <div style="margin-left:700px;">
	    	<br>
				<jsp:include page="./Paging.jsp">
      				<jsp:param value="${pagingMap}" name="pagingMap"/>
   				</jsp:include>
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