<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/WaterMelon/song/uploadMusicCtr.do" method="post" enctype="multipart/form-data">
	<div class="form_section">
		<div class="form_section_title">
			<label>상품 이미지</label>
		</div>
		<div class="form_section_content">낙성대역 2호선
			음원 제목 : <input type="text" name = "songName"><br>
			아티스트 : <input type = "text" name = "songArtist"><br>
			앨범 제목 : <input type = "text" name = "albumName"><br>
			소속사 : <input type = "text" name = "publisher"><br>
			음원 파일 : <br>
			<input type="file" id ="fileItem" name='uploadSongFile' style="height: 30px;"><br>
			앨범커버 파일 : <br>
			<input type="file" id ="fileItem" name='uploadSongImageFile' style="height: 30px;"><br>								
		</div>
	</div>
	<input type="submit" value="등록"> 
</form>


<script src="http://code.jquery.com/jquery-3.5.1.min.js">
</script>

<script type="text/javascript">
$("input[name='uploadSongFile']").on("change", function(e){
	
	alert("동작");
	let formData = new FormData();
	let fileInput = $('input[name="uploadSongFile"]');
	let fileList = fileInput[0].files;
	
	console.log("fileList : " + fileList);
	
	let fileObj = fileList[0];
	console.log("fileObj" +fileObj);
	
	console.log("fileName : " + fileObj.name);
	console.log("fileSize : " + fileObj.size);
	console.log("fileType(MimeType) : " + fileObj.type);	
	
	formData.append("uploadSongFile", fileObj);
	
	$.ajax({
		url: '/WaterMelon/song/uploadSongAjaxAction.do',
    	processData : false,
    	contentType : false,
    	data : formData,
    	type : 'POST',
    	dataType : 'json'
	});
});
</script>

</body>
</html>