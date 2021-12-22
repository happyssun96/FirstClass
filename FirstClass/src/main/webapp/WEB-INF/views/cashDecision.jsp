<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js">
</script>
<script type="text/javascript">
function commitbtn(){	
alert('캐시충전이 완료되었습니다!');
location.href='./userMainPage.do';
}
</script>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>캐시 충전</title>
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
          
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    	
		<h2 style="margin-top: 30px;">캐시 충전</h2>
		<div style="display: table-cell; vertical-align: middle;">	
			<div style="display: table-cell; vertical-align: middle;">	
			<div style="border:1px solid #E5E1E1; border-radius: 0.4em; padding:20px; float: left; width: 500px; margin-top: 30px;">
				<h3>선택한 충전 금액</h3>
				<p style="font-size: 25px;">-&nbsp;&nbsp;${chosenCash}&nbsp;&nbsp;원</p>
				<ul>
				<li style="font-size: 15px; color: #B0ACAC;">음원 무제한 스트리밍 및 음원 업로드를 자유롭게 할 수 있는 구독권을 구매하기 위해 캐시를 충전하세요 !					
				<br>					
				</li>
				</ul>
			</div>
			<div style="border:3px solid black; border-radius: 0.4em; padding:20px; float: left; width: 320px; margin-left: 50px; margin-top: 30px;">
				<h3>최종 충전 정보</h3>				
					<hr width =100% color="#E5E1E1" align="left" size=60 style="margin-top: 30px;"/>
						<dl style="font-size: 20px;">					
							<dt>보유 캐시<br>
								<strong style="text-align: justify;">&emsp;●&nbsp;&nbsp;${member.cash}&nbsp;&nbsp;원</strong></dt>							
							<dt style="color: #FFB16C; margin-top: 20px;">충전 금액<br><strong>&emsp;+&nbsp;&nbsp;${chosenCash}</strong>&nbsp;&nbsp;원</dt>
							<hr width =100% color="#E5E1E1" align="left" size=60/>
							<dt>충전 후 캐시 &emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;<strong>${finalCash}</strong>&nbsp;&nbsp;원</dt>
																	
						</dl>														
			</div>
		</div>
			
		</div>
		<div style="margin-top: 20px;">
			&emsp;<input type="checkbox" name="xxx" value="yyy">&emsp;상기 결제 내용을 확인하였습니다.
			<br>
			&emsp;<input type="checkbox" name="xxx" value="yyy">&emsp;이용약관을 확인하였습니다.&emsp;
			<button type="button" class="btn btn-light" style="font-size:9px; width:auto; height: auto; padding:2px;">이용약관 보기</button>
			<br>			
			<br>
			<button type="button" class="btn btn-primary" style="margin-left: 300px; font-size:20px; padding:11px;" onclick="location.href = './addCashCtr.do?chosenCash=${chosenCash}'">충전하기</button>	
			<button type="button" class="btn btn-secondary" style="margin-left: 30px; font-size:20px; padding:11px;" onclick="location.href='./userMainPage.do'">충전취소</button>	
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
