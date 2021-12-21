<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="resources/plugins/fontawesome-free/css/all.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="resources/dist/css/adminlte.min.css">
  
  <link rel="stylesheet" href="resources/css/footer.css">
</head>
<body>
 <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-dark">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="./clickHomeBtn.do" class="nav-link">Home</a>
      </li>
<!--       <li class="nav-item d-none d-sm-inline-block"> -->
<!--         <a href="./login.do" class="nav-link">Login</a> -->
<!--       </li> -->
      
      <c:choose>
         <c:when test="${sessionScope.member.auth eq 'admin'}">
            <li class="nav-item d-none d-sm-inline-block">
              <a href="./songUploadForm.jsp" class="nav-link">Music Upload</a>
            </li>
          </c:when>
          <c:otherwise></c:otherwise>
      </c:choose>
    </ul>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Navbar Search -->
      <li class="nav-item">
        <a class="nav-link" data-widget="navbar-search" href="#" role="button">
          <i class="fas fa-search"></i>
        </a>
        <div class="navbar-search-block">
          <form class="form-inline">
            <div class="input-group input-group-sm">
              <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
              <div class="input-group-append">
                <button class="btn btn-navbar" type="submit">
                  <i class="fas fa-search"></i>
                </button>
                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                  <i class="fas fa-times"></i>
                </button>
              </div>
            </div>
          </form>
        </div>
      </li>

      <li class="nav-item">
        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
          <i class="fas fa-expand-arrows-alt"></i>
        </a>
      </li>
      
      <c:choose>
         <c:when test="${sessionScope.member.auth eq 'admin'}">
               <li class="nav-item">
                 <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                      <i class="fas fa-th-large"></i>
                 </a>
               </li>
            </c:when>
          <c:otherwise></c:otherwise>
      </c:choose>
    </ul>
  </nav>
  <!-- /.navbar -->
</body>
</html>