<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>결제 창</title>
<script type="text/javascript">
</script>
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
  <div class="content-wrapper" style="margin-left: 550px;">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0"></h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="./index.jsp"><i class="fas fa-home"></i></a></li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    	
		<h2 style="margin-top: 30px;">이용권 정보</h2>
		<div style="display: table-cell; vertical-align: middle;">	
			<div style="border:1px solid #E5E1E1; border-radius: 0.4em; padding:20px; float: left; width: 500px; margin-top: 30px;">
				<h3>1개월 구독</h3>
				<p>음원 무제한 스트리밍 및 음원 업로드를 자유롭게 해보세요!</p>
				<ul>
				<li>1개월 구독권
					<strong style="font-size: 15px;">월 5,000원</strong>
					<br>
					<span>
						<em style="font-size: 7px; color: #B0ACAC;">
							&nbsp;&nbsp;-&nbsp;&nbsp; 1개월간 실시간 스트리밍, 음원 업로드가 가능한 이용권
						</em>
					</span>
					
				</li>
				</ul>
			</div>
			<div style="border:3px solid black; border-radius: 0.4em; padding:20px; float: left; width: 320px; margin-left: 50px; margin-top: 30px;">
				<h3>최종 결제 정보</h3>				
					<hr width =100% color="#E5E1E1" align="left" size=60 style="margin-top: 30px;"/>
						<dl style="font-size: 20px;">					
							<dt>보유 캐시 &emsp;&emsp;&emsp;&emsp;&nbsp;<strong>${currentCash}</strong>&nbsp;&nbsp;원</dt>							
							<dt style="color: #FFB16C; margin-top: 20px;">상품 금액 &emsp;&emsp;&emsp;&emsp;-&nbsp;&nbsp;<strong>${subscribePrice}</strong>&nbsp;&nbsp;원</dt>
							<hr width =100% color="#E5E1E1" align="left" size=60/>
							<dt>잔여 캐시 &emsp;&emsp;&emsp;&emsp;&nbsp;<strong>${remainCash}</strong>&nbsp;&nbsp;원</dt>
							<p style="font-size: 13px; color: #B0ACAC; text-align: center;">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(VAT 별도)</p>										
						</dl>														
			</div>
		</div>
		<div>
			<input type="checkbox" name="xxx" value="yyy">&emsp;본 이용권은 30일동안 유지되며, 30일 약정 이용에 동의합니다.
			<br>
			<input type="checkbox" name="xxx" value="yyy">&emsp;상기 내용 및 사은품 할인 반환금에 대한 유의사항을 확인하였습니다.
			<br>
			<input type="checkbox" name="xxx" value="yyy">&emsp;이용약관을 확인하였습니다.&emsp;
			<button type="button" class="btn btn-light" style="font-size:7px; width:auto; height: auto;">이용약관 보기</button>
			<br>
			<br>
			<br>
			<button type="button" class="btn btn-primary" style="margin-left: 350px; font-size:30px;" onclick="location.href='./subscribePurchaseDecision.do?subscribePrice=${subscribePrice}'">결제하기</button>
			<button type="button" class="btn btn-secondary" style="margin-left: 30px; font-size:20px; padding:11px;" onclick="history.back()">뒤로가기</button>
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
</body>
</html>
