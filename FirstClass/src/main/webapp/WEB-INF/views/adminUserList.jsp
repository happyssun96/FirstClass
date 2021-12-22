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
  		width: 1000px;
  	}
  	
  	img {
  		width: 75px;
  		height: 75px;
  		object-fit : cover;
  	}

  </style>
   <script type="text/javascript">
     function searchFunc(){
        var curPage = document.getElementById('curPage');
        curPage.setAttribute('value', 1);   
        var selectedOption = document.getElementById("searchOption");
        var form = document.getElementById('pagingForm');
        location.href = './adminSongSearchPage.do?curPage='+curPage.value
               +'&keyword='+form.keyword.value
               +'&searchOption='+selectedOption.options[selectedOption.selectedIndex].value;

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
  <div class="content-wrapper" style="margin-left: 300px;">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">관리자 페이지</h1>&emsp; >&nbsp;&nbsp; 유저 정보
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <div style="font-size: 100px; color: #E5E1E1; margin-left: 470px;">
    	<img src="resources/images/watermelon.png" style="height: 100px;">&nbsp;WaterMelon
    </div>
    <br>
    <br>
   	<div style="margin-left: 400px;">
	    <form id='pagingForm' action="./adminUserSearchPage.do" method="post">
	    	<input type="text" placeholder="검색할 내용을 입력하세요.&nbsp; (&nbsp;ex&nbsp;.&nbsp;유저 정보&nbsp;)"
	    		name="keyword" value="${keyword}" 
	    		style="width:730px; height:60px; background: #E5E1E1; border: none; border-radius: 2.0em; padding-inline-end: 44px; padding-inline-start: 52px; margin-left: 10px;">   	
	    	<input type="submit" value="검색" onclick="searchFunc();" style="background: #E5E1E1; border: none; border-radius: 2.0em; height:60px; width:60px; color:#212529; margin-left: 10px;">
	    	<input type="hidden" id='curPage' name='curPage' 
	    	value="${pagingMap.memberPaging.curPage}">
	    </form>
    </div>
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
					         <tr onclick="location.href='./adminUserDetailInformation.do?no=${memberVo.member_no}'" style="cursor: pointer;">
					            <td>${memberVo.member_no}</td>
					            <td>${memberVo.email}</td>
					            <td>${memberVo.nickName}</td>
					            <td>${memberVo.auth}</td>
					            <td>
					            	<c:if test="${memberVo.memberClass == 0}">
			                  			관리자
			                  		</c:if>
			                  		<c:if test="${memberVo.memberClass == 1}">
			                  			브론즈
			                  		</c:if>
			                  		<c:if test="${memberVo.memberClass == 2}">
			                  			실버
			                  		</c:if>
			                  		<c:if test="${memberVo.memberClass == 3}">
			                  			골드
			                  		</c:if>
			                  		<c:if test="${memberVo.memberClass == 4}">
			                  			플레티넘
			                  		</c:if>
								</td>
					            <td>${memberVo.cash}</td>
					            <td>${memberVo.age}</td>
					            <td>
									<c:if test="${memberVo.gender eq 'M'}">
         							남성
				         			</c:if>
				         			<c:if test="${memberVo.gender eq 'F'}">
				         			여성
         							</c:if>
								</td>
					            <td>
					            	<c:if test="${memberVo.memberClass == 0}">
			                  			-
			                  		</c:if>
					            </td>
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
				<jsp:include page="./userPaging.jsp">
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