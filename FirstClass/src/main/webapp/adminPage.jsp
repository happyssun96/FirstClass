<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>관리자 페이지</title>
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
  <jsp:include page="nav.jsp" />

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-left: 300px;">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">관리자 페이지</h1>
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
    <div style="margin-left: 300px;">
	    <form id='pagingForm' action="./list.do" method="post">
	    	 <select name='searchOption' style="background: #E5E1E1; border: none; border-radius: 2.0em; height:60px; width:60px; ">
			   <c:choose>
				  <c:when test="${searchMap.searchOption == 'all'}">
			            <option value="all"  selected='selected'>전체</option>
			            <option value="name">유저</option>
			            <option value="email">음원</option>
			      </c:when>
			      <c:when test="${searchMap.searchOption == 'name'}">
			            <option value="all">전체</option>
			            <option value="name" selected='selected'>이름</option>
			            <option value="email">이메일</option>
			      </c:when>
			      <c:when test="${searchMap.searchOption == 'email'}">
			            <option value="all">전체</option>
			            <option value="name">이름</option>
			            <option value="email" selected='selected'>이메일</option>
			      </c:when>
			   </c:choose>
	     	 </select>
	     
	    	<input type="text" placeholder="검색할 내용을 입력하세요.&nbsp; (&nbsp;ex&nbsp;.&nbsp;유저 정보, 음원 정보&nbsp;)" style="width:730px; height:60px; background: #E5E1E1; border: none; border-radius: 2.0em; padding-inline-end: 44px; padding-inline-start: 52px; margin-left: 10px;">   	
	    </form>
    </div>
    
    <div style="margin-top: 50px; margin-left: 230px;">
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
					 	<tr>
					 		<td>1</td>
					 		<td>waterM@naver.com</td>
					 		<td>수박남</td>
					 		<td>관리자</td>
					 		<td>골드회원</td>
					 		<td>10000원</td>
					 		<td>25</td>
					 		<td>M</td>
					 		<td>1개월 구독 중</td>
					 		<td>2021.12.10</td>
					 		<td>2021.12.15</td>
					 	</tr>
					 	<tr>
					 		<td>2</td>
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
	    	
	    </div> 		    		    	
	    <div style=" margin-left: 20px; margin-top : 50px;">	    	
	    	<br>
	    	<br>
	    	<h2>&nbsp;음원 데이터 ></h2>
	    	<br>
	    		<table border="1">				
					<tbody>
					 	<tr style="background: #403A3A;">
					 		<th>번호</th>
					 		<th style="width: 90px;">앨범 커버</th>
					 		<th>제목</th>
					 		<th>아티스트</th>
					 		<th>앨범 명</th>
					 		<th>음원 존재여부</th>
					 		
					 	</tr>
					 	<tr onclick="location.href='./adminSongDetailPage.jsp'" style="cursor: pointer;">
					 		<td>1</td>
					 		<td style="width: 90px;"><img src="resources/images/music-7.jpg"></td>
					 		<td>리무진 (Feat. MINO) (Prod.G...</td>
					 		<td>BE`O (비오)</td>
					 		<td>쇼미더머니 10 Episode 3</td>
					 		<td>O</td>
					 		
					 	</tr>
					 	<tr>
					 		<td>2</td>
					 		<td style="width: 90px;"><img src="resources/images/music-7.jpg" ></td>
					 		<td>회전목마 (Feat. Zion.T, 원슈타...</td>
					 		<td>sokodomo</td>
					 		<td>쇼미더머니 10 Episode 3</td>
					 		<td>X</td>
					 		
					 	</tr>		
		      		</tbody>	      		
				</table>	    
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