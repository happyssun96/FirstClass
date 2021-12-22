<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WaterMelon🍉</title>
<script src="resources/js/jquery-3.1.1.min.js"></script>
<script src="resources/js/jquery.bpopup-0.10.0.min.js"></script>
<link rel="stylesheet" href="resources/css/YouTubePopUp.css">
<script src="resources/js/jquery-1.12.1.min.js"></script>
<script src="resources/js/YouTubePopUp.jquery.js"></script>
<script>
function youtubeFullscreen(url){
	window.open(url,"","fullscreen,scrollbars")
}
</script>
</head>

<body
	class="hold-transition dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
	<div class="wrapper">
		<!-- Preloader -->
		<div
			class="preloader flex-column justify-content-center align-items-center">
			<img class="animation__wobble" src="resources/images/watermelon.png"
				alt="AdminLTELogo" height="60" width="60">
		</div>

		<jsp:include page="header.jsp" />

		<jsp:include page="nav.jsp" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">음원 차트</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6"></div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header border-transparent">
					<h3 class="card-title">오늘의 Top 5</h3>
						<div class="card-tools">
							<button type="button" class="btn btn-tool"
								data-card-widget="collapse">
							<i class="fas fa-minus"></i></button>
									
							<button type="button" class="btn btn-tool"
										data-card-widget="remove">
							<i class="fas fa-times"></i></button>
					</div>
			</div>
							<!-- /.card-header -->
		<div class="card-body p-0">
			<div class="table-responsive">
				<table class="table m-0">
					<thead>
						<tr>
							<th>RANK</th>
							<th>COVER</th>
							<th>NAME</th>
							<th>ARTIST</th>
							<th>ALBUM</th>
							<th>YOUTUBE</th>
						</tr>
					</thead>
					<c:forEach var="songVo" items="${songList}">
						<tr>
							<td>${songVo.songNo}</td>
							<td><a href="userSongDetailInformation.do?no=${songVo.songNo}">
								<img style="width: 65px; height: 65px;"
									src="${songVo.albumImagePath}"></a></td>
							<td>${songVo.songName}</td>
							<td>${songVo.artist}</td>
							<td>${songVo.albumName}</td>
							<td>
								<i class="fab fa-youtube" style="cursor: pointer;" 
								onclick="youtubeFullscreen('https://www.youtube.com/watch?v=mLCsbacHxA8')">
						<input type="button" 
						onclick="youtubeFullscreen('https://www.youtube.com/watch?v=mLCsbacHxA8')" 
						value=" 창 열기 "></i>
							</td>
						</tr>
						</c:forEach>
					</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
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
