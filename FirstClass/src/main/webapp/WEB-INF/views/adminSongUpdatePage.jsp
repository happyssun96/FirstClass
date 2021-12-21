<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음원정보 수정</title>
<style type="text/css">
	input {
		background-color: #3F474E;
		border: 1px solid #BDBDBD;
		border-radius: 0.8em;
		color: white;
	}
</style>
</head>
<body class="hold-transition dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">

<div class="wrapper">
	<jsp:include page="header.jsp"/>

	<jsp:include page="nav.jsp" />
	
	 <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      
      <!-- /.container-fluid -->
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
                	<img src="${songVo.albumImagePath}" 
                		alt="Product Image">
                </div>
              </div>
              <div class="mt-4 product-share" style="padding-left: 13rem;">
                <a href="#" class="text-gray">
                  <i class="fas fa-play-circle fa-2x"></i>
                </a>
                
              </div>
            </div>
            <div class="col-12 col-sm-6">
              <h3 class="my-3">${songVo.songName}</h3>
              <hr>
            
             <div class="card card-primary">

              <div class="card-body">
              	<form action="./adminSongUpdateCtr.do" method="post" enctype="multipart/form-data">
	              	<strong><i class="fa fa-list-ol"></i> &nbsp;음원번호</strong> <br>
	                <input type="text" value='${songVo.songNo}' name='songNo' readonly="readonly">	                
	                <hr>

	                <strong><i class="fa fa-user mr-1"></i> &nbsp;곡명</strong> <br>	
	                <input type="text" value='${songVo.songName}' name='songName'>	                
	                <hr>
	              	
	                <strong><i class="fa fa-user mr-1"></i> &nbsp;아티스트</strong> <br>	
	                <input type="text" value='${songVo.artist}' name='artist'>	                
	                <hr>
	                
	                <strong><i class="fas fa-guitar mr-1"></i> &nbsp;앨범 명</strong> <br>	
	               	<input type="text" value='${songVo.albumName}' name='albumName'>	
	                <hr>
	
	                <strong><i class="fas fa-building mr-1"></i> &nbsp;기획사</strong> <br>	
	                <input type="text" value='${songVo.publisher}' name='publisher'>
	                <hr>
	                
	                <strong><i class="fas fa-route"></i> &nbsp;음원경로</strong> <br>
	                <input type="file" id="songItem" name='uploadSongFile'>                
	                <hr>
	                
	                <strong><i class="fas fa-route"></i> &nbsp;앨범커버경로</strong> <br>
	                <input type="file" id="coverItem" name='uploadSongImageFile'>
	                <hr>
	
	                <strong><i class="fas fa-record-vinyl mr-1"></i> &nbsp;등록일</strong> <br>
	                <p class="text-muted">${songVo.releaseDate}</p>
	                <hr>
	                
	                <strong><i class="fas fa-record-vinyl mr-1"></i> &nbsp;수정일</strong> <br>
	                <p class="text-muted">${songVo.modifyDate}</p>
	                
	                <input type="submit" class="btn btn-secondary" value="수정하기">
	                <input type="button" class="btn btn-secondary" value="삭제하기" onclick="pageMoveDeleteFnc(${songVo.songNo});" style="margin-left: 10px;">
					<input type="button" class="btn btn-secondary" value="뒤로가기" onclick="history.back(-1)" style="margin-left: 10px;">
					
	             </form>   
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
    
    </div>
    <!-- /.content -->
    <!-- Control Sidebar -->
    
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
  
    <jsp:include page="footer.jsp" />
  
  </div>
	

</body>
</html>