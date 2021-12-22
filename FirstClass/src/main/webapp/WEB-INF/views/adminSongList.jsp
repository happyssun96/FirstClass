<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>음원 리스트</title>
  <style type="text/css">
     
     table, th {
        text-align: center;
        padding : 10px;
     }
     
     table, td {
        padding : 5px;
     }
     
     table {
        width: 1700px;
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
            <h1 class="m-0">관리자 페이지</h1>&emsp; >&nbsp;&nbsp;음원 정보
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <div style="font-size: 100px; color: #E5E1E1; margin-left: 450px;">
       <img src="resources/images/watermelon.png" style="height: 100px;">&nbsp;WaterMelon
    </div>
    <br>
    <br>

    <div style="margin-left: 370px;">
       <form id='pagingForm' action="./adminSongSearchPage.do" method="post">
          <input type="text" placeholder="검색할 내용을 입력하세요.&nbsp; (&nbsp;ex&nbsp;.&nbsp;음원 정보&nbsp;)"
             name="keyword" value="${keyword}" 
             style="width:730px; height:60px; background: #E5E1E1; border: none; border-radius: 2.0em; padding-inline-end: 44px; padding-inline-start: 52px; margin-left: 10px;">      
          <input type="submit" value="검색" onclick="searchFunc();" style="background: #E5E1E1; border: none; border-radius: 2.0em; height:60px; width:60px; color:#212529; margin-left: 10px;">
          <input type="hidden" id='curPage' name='curPage' 
          value="${pagingMap.songPaging.curPage}">
       </form>
    </div>
    
    <div style="margin-top: 50px; margin-left: 20px;">
                               
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
                      <th>기획사</th>
                      <th>등록일</th>
                      <th>수정일</th>   
                      <th>음원경로</th>
                      <th>앨범경로</th>                            
                   </tr>
                   
                   <c:forEach var="songVo" items="${songList}">
                        <tr>
                           <td>${songVo.songNo}</td>
                           <td><a href="./adminSongDetailInformation.do?no=${songVo.songNo}"><img style="width: 65px; height: 65px;" 
                              src="${songVo.albumImagePath}"></a></td>
                           <td>${songVo.songName}</td>
                           <td>${songVo.artist}</td>
                           <td>${songVo.albumName}</td>
                           <td>${songVo.publisher}</td>
                           <td>${songVo.releaseDate}</td>
                           <td>${songVo.modifyDate}</td>                           
                           <td>${songVo.musicResourcePath}</td>
                           <td>${songVo.albumImagePath}</td>
                        </tr>
                     </c:forEach>
                        
                  </tbody>               
            </table>
            
            <div style="margin-left:650px;">
               <br>
               <jsp:include page="./songPaging.jsp">
                  <jsp:param value="${pagingMap}" name="pagingMap" />
               </jsp:include>
            </div>       
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