<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="resources/plugins/fontawesome-free/css/all.min.css">
  
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/songUpload.css">

<!-- datepicker 달력 표시하기 위한 jquery -->
<link rel="stylesheet"
   href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<title>음원 업로드</title>

<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger {
   cursor: pointer;
}

/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker {
   cursor: pointer;
}
</style>

<script>
//    $(function() {
//       $("#datepicker").datepicker(
//             {
//                changeMonth : true,
//                changeYear : true,
//                minDate : '-50y',
//                nextText : '다음 달',
//                prevText : '이전 달',
//                yearRange : 'c-50:c+20',
//                showButtonPanel : true,
//                currentText : '오늘 날짜',
//                closeText : '닫기',
//                dateFormat : "yy-mm-dd",
//                showAnim : "slide",
//                showMonthAfterYear : true,
//                dayNamesMin : [ '월', '화', '수', '목', '금', '토', '일' ],
//                monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
//                      '7월', '8월', '9월', '10월', '11월', '12월' ]
//             });
//    });
</script>

</head>
<body>

   <div class="songUpload-form">
      <form action="./uploadMusicCtr.do" method="post" enctype="multipart/form-data">
         <h1>
            <a href="./clickHomeBtn.do" class="brand-link"> <img
               src="resources/images/watermelon.png" alt="AdminLTE Logo"
               class="brand-image img-circle elevation-3"
               style="opacity: .8; height: 80px;">
            </a>
         </h1>
         <h2 style="text-align: center;">당신의 노래를 뽐내보세요!</h2>
         <div class="form-group">
            <input type="text" name="songName" placeholder="곡 이름"> <span
               class="input-icon"><i class="fas fa-music"></i></span>
         </div>
         <div class="form-group">
            <input type="text" name="artist" id="artist" placeholder="아티스트"> <span
               class="input-icon"><i class="fas fa-user"></i></span>
         </div>
         <div class="form-group">
            <input type="text" name="albumName" id="albumName" placeholder="앨범명"> <span
               class="input-icon"><i class="fas fa-record-vinyl"></i></span>
         </div>
                  <div class="form-group">
            <input type="text" name="publisher" id="publisher" placeholder="소속사"> <span
               class="input-icon"><i class="fas fa-building"></i></span>
         </div>
<!--          <div class="form-group"> -->
<!--             <input type="text" name="release_date" id="datepicker" placeholder="발매일"> -->
<!--             <span class="input-icon"><i class="fas fa-clock"></i></span> -->
<!--          </div> -->
         <div class="form-group">
            <input type="file" id="songItem" name="uploadSongFile" placeholder="음원(업로드)">
            <span class="input-icon"><i class="fas fa-headphones"></i></span>
         </div>
         <div class="form-group">
            <input type="file" id="coverItem" name="uploadSongImageFile" placeholder="앨범표지(업로드)">
            <span class="input-icon"><i class="fas fa-file-audio"></i></span>
         </div>
         <button class="songUpload-btn">Upload</button>
      </form>

   </div>
   
<script src="http://code.jquery.com/jquery-3.5.1.min.js">
</script>

<script type="text/javascript">
$("input[name='uploadSongFile']").on("change", function(e){
	
// 	alert("동작");
	let formData = new FormData();
	let fileInput = $('input[name="uploadSongFile"]');
	let fileList = fileInput[0].files;
	let fileObj = fileList[0];
	
	if(!songFileCheck(fileObj.name, fileObj.size))
		{
		$("#songItem").val("");
		return false;
		}
	
});

$("input[name='uploadSongImageFile']").on("change", function(e){
	
// 	alert("동작");
	let formData = new FormData();
	let fileInput = $('input[name="uploadSongImageFile"]');
	let fileList = fileInput[0].files;
	let fileObj = fileList[0];
	
	if(!coverFileCheck(fileObj.name, fileObj.size))
		{
		$("#coverItem").val("");
		return false;
		}
});

function songFileCheck(fileName, fileSize)
{
	let regex = new RegExp("(.*?)\.(mp3)$");
	let maxSize = 10485760;
	if(fileSize >= maxSize)
		{
		alert("파일 용량이 초과되었습니다.");
		return false;
		}
	if(!regex.test(fileName)){
		alert("음원은 mp3 파일만 업로드할 수 있습니다.");
		return false;
	}
	return true;
}

function coverFileCheck(fileName, fileSize)
{
	let regex = new RegExp("(.*?)\.(jpg|.png)$");
	let maxSize = 10485760;
	if(fileSize >= maxSize)
		{
		alert("파일 용량이 초과되었습니다.");
		return false;
		}
	if(!regex.test(fileName)){
		alert("앨범 이미지는 jpg 파일만 업로드 할 수 있습니다..");
		return false;
	}
	return true;
	}
</script>

</body>
</html>