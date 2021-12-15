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
		<div class="form_section_content">
			음원 제목 : <input type="text" name = "songName"><br>
			아티스트 : <input type = "text" name = "Artist"><br>
			앨범 제목 : <input type = "text" name = "albumName"><br>
			소속사 : <input type = "text" name = "publisher"><br>
			음원 파일 : <br>
			<input type="file" id ="songItem" name='uploadSongFile' style="height: 30px;"><br>
			앨범커버 파일 : <br>
			<input type="file" id ="coverItem" name='uploadSongImageFile' style="height: 30px;"><br>								
		</div>
	</div>
	<input type="submit" value="등록"> 
</form>


<script src="http://code.jquery.com/jquery-3.5.1.min.js">
</script>

<script type="text/javascript">
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
// 	console.log("fileList : " + fileList);
	
// 	console.log("fileObj" +fileObj);
	
// 	console.log("fileName : " + fileObj.name);
// 	console.log("fileSize : " + fileObj.size);
// 	console.log("fileType(MimeType) : " + fileObj.type);	
	
// 	formData.append("uploadSongFile", fileObj);
	
// 	$.ajax({
// 		url: '/WaterMelon/song/uploadSongAjaxAction.do',
//     	processData : false,
//     	contentType : false,
//     	data : formData,
//     	type : 'POST',
//     	dataType : 'json'
// 	});
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
</script>

</body>
</html>