<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>캐시충전안내</title>
</head>
<body class="hold-transition dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
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
            <h1 class="m-0">캐시충전안내</h1>
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
    
    <div>
    	<p style="margin-left: 250px; font-size : 30px;">내 캐시 잔액 &nbsp;:&nbsp; 0원</p>
    </div>
   
    <div>
    	<p style="margin-left: 320px; margin-top: 10px;font-size : 20px; color:#B0ACAC"><img src="resources/images/watermelon.png" style="height: 20px;">&nbsp;WaterMelon을 사용하기 위한 캐시를 충전하는 곳입니다. 충전을 원하시는 금액을 눌러주세요!</p>
    </div>
    
    <br>
    <div>
    	<button type="button" class="btn btn-outline-warning" style="width: 300px; height: 200px; font-size: 60px; margin-left: 250px;"
    		onclick="location.href='./cashDecision.jsp';">₩ 10000   	
    		
    	</button>
    	<button type="button" class="btn btn-outline-warning" style="width: 300px; height: 200px; font-size: 60px; margin-left: 50px;">₩ 30000  	
    		
    	</button>	
    	<button type="button" class="btn btn-outline-warning" style="width: 300px; height: 200px; font-size: 60px; margin-left: 50px;">₩ 50000   	
    		
    	</button>	    	
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
