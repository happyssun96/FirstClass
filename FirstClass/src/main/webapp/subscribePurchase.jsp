<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>이용권 구매</title>
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
            <h1 class="m-0">이용권 구매</h1>
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
    	<button type="button" class="btn btn-outline-secondary" style="width: 300px; font-size: 30px; margin-left: 250px; padding-top: 20px;"
    		onclick="location.href='./purchaseDecision.jsp';"><h1>1개월 구독</h1>   	
    		<p style="font-size: 20px;"><img src="resources/images/watermelon.png" style="height: 20px;">WaterMelon에서 1개월간<br>음원 무제한 스트리밍 및 <br>음원 업로드 가능</p>
    	</button>
    	<button type="button" class="btn btn-outline-secondary" style="width: 300px; font-size: 30px; margin-left: 50px; padding-top: 20px;"><h1>3개월 구독</h1>   	
    		<p style="font-size: 20px;"><img src="resources/images/watermelon.png" style="height: 20px;">WaterMelon에서 3개월간<br>음원 무제한 스트리밍 및 <br>음원 업로드 가능</p>
    	</button>	
    	<button type="button" class="btn btn-outline-secondary" style="width: 300px; font-size: 30px; margin-left: 50px; padding-top: 20px;"><h1>정기 구독</h1>   	
    		<p style="font-size: 20px;"><img src="resources/images/watermelon.png" style="height: 20px;">WaterMelon에서 매달<br>음원 무제한 스트리밍 및 <br>음원 업로드 가능</p>
    	</button>	    	
    </div>
    
    <div style="margin-top: 100px; margin-left: 350px;">
	    <div style="width: 300px; float: left;">	
		    	<img src="resources/images/play.png" style="height:70px; color: #E5E1E1; margin-left: 100px;">
		    	<br>
		    	<br>
		    	<h1>무제한 스트리밍</h1>
		    	<br>
		    	<p>인기 차트의 음원을 무제한으로 스트리밍 해보세요.</p>
	    </div> 		    		    	
	    <div style="width: 300px; float: left; margin-left: 200px;">
	    	<img src="resources/images/upload.png" style="height:70px; color: #E5E1E1; margin-left: 100px;">
	    	<br>
	    	<br>
	    	<h1>&nbsp;&nbsp;&nbsp;&nbsp;음원 업로드</h1>
	    	<br>
	    	<p>나도 가수다! 나만의 음원을 자유롭게 업로드 해보세요.</p>		    
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
