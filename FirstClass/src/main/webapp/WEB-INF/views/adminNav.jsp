<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="./adminUserSearchPage.do" class="brand-link">
      <img src="resources/images/watermelon.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">WaterMelon</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
       
       <c:if test="${sessionScope.member.email == null}">
         <div class="user-panel mt-3 pb-3 mb-3 d-flex">
      
        <div class="image">
          <img src="resources/dist/img/user0-160x160.png" 
          	class="img-circle elevation-2" alt="User Image">
        </div> 
        <div class="info">
                <a href="./login.do" class="d-block" style="padding-left: 45px;">      
               <span>로그인</span>
       </a>
        </div>
        
        </div>
        
        </c:if>

          <c:if test="${sessionScope.member.email ne null}">
          
          <div class="user-panel mt-3 pb-3 mb-3 d-flex">
      
        <div class="image">
          <img src="resources/dist/img/user2-160x160.jpg" 
          	class="img-circle elevation-2" alt="User Image">
        </div> 
        <div class="info">
           <a href="./userDetailPage.jsp" class="d-block">
        
		<span>
			${member.nickName}님 어서오세요!			
		</span>
          </a>
          <br/>
          <a href="<%=request.getContextPath()%>/logout.do"
			style="color: white;">
			<span>
			로그아웃
			</span>
		</a>
        </div>
        
        </div>
          
		</c:if>
          <hr>
<%--         <c:if test="${sessionScope.member.email ne null}"> --%>
        
<%--         <a href="<%=request.getContextPath()%>/logout.do" --%>
<!-- 			style="color: white;"> -->
<!-- 			<span> -->
<!-- 			로그아웃 -->
<!-- 			</span> -->
<!-- 		</a> -->
			
<%--         </c:if> --%>
          
        

      <!-- SidebarSearch Form -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          
          
          <li class="nav-header">관리자 메뉴</li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-user"></i>
              <p>
                유저 정보
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">                                          
              <li class="nav-item">
                <a href="./adminUserSearchPage.do" class="nav-link">
                  &emsp;<i class="far fa-circle nav-icon"></i>
                  <p>조회 및 수정</p>
                </a>
              </li>
            </ul>
          </li>
          
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-music"></i>
              <p>
                음원 정보
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="./adminSongSearchPage.do" class="nav-link">
                  &emsp;<i class="far fa-circle nav-icon"></i>
                  <p>조회 및 수정</p>
                </a>
              </li>                            
            </ul>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="./songUploadForm.jsp" class="nav-link">
                  &emsp;<i class="far fa-circle nav-icon"></i>
                  <p>음원 업로드</p>
                </a>
              </li>                            
            </ul>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
</body>
</html>