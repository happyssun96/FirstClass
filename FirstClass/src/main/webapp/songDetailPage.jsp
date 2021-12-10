<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"/>

	<jsp:include page="nav.jsp" />
	
	 <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>E-commerce</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">E-commerce</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card card-solid">
        <div class="card-body">
          <div class="row">
            <div class="col-12 col-sm-6">
              
              <div class="col-12 product-image-thumbs">
                <div class="product-image-thumb active" 
                	style="max-width: 20rem; margin-top: 50px; margin-left: 60px;">
                	<img src="resources/images/covers/showme10_1.jpeg" 
                		alt="Product Image">
                </div>
              </div>
            </div>
            <div class="col-12 col-sm-6">
              <h3 class="my-3">쇼미더머니 10 Episode 3</h3>
              <hr>
            
             <div class="card card-primary">

              <div class="card-body">
                <strong><i class="fas fa-book mr-1"></i>아티스트</strong>

                <p class="text-muted">
                Various Artists
                </p>
                
                <hr>
                
                <strong><i class="fas fa-map-marker-alt mr-1"></i>장르/스타일</strong>

                <p class="text-muted">랩/힙합/가요</p>

                <hr>

                <strong><i class="fas fa-pencil-alt mr-1"></i>기획사</strong>

                <p class="text-muted">
                  Stone Music Entertainment
                </p>

                <hr>

                <strong><i class="far fa-file-alt mr-1"></i>발매일</strong>

                <p class="text-muted">2021.11.13</p>
              </div>
              <!-- /.card-body -->
            </div>
              <div class="mt-4 product-share">
                <a href="#" class="text-gray">
                  <i class="fab fa-facebook-square fa-2x"></i>
                </a>
                <a href="#" class="text-gray">
                  <i class="fab fa-twitter-square fa-2x"></i>
                </a>
                <a href="#" class="text-gray">
                  <i class="fas fa-envelope-square fa-2x"></i>
                </a>
                <a href="#" class="text-gray">
                  <i class="fas fa-rss-square fa-2x"></i>
                </a>
              </div>

            </div>
          </div>
        
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->

    </section>
    <!-- /.content -->
    
  </div>
	

</body>
</html>