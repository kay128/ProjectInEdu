<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type = "text/css" href="css/AdminHotel.css">
<script type="text/javascript" src="script/AdminHotel.js"></script>
<script src ="/TravelPlanSystem/js/jquer-1.7.2.min.js"></script>
<script>
	window.onload = function(){
		document.getElementById("pictureUrl").onchange = preview;
	}
	function preview() {
		var output = document.getElementById('output');
		output.src = URL.createObjectURL(event.target.files[0]);
	}
</script>
</head>
<body>
<div class="container-fluid">
   <div class="row content">
      <div class="col-sm-1 sidenav" >
      <div><button type="button" class="btn btn-success" onclick="location.href='admin.do'">会員リスト</button></div>
      <br/>
      <div><button type="button" class="btn btn-warning" onclick="location.href='admin_hotel.do'">ホテル管理</button></div>
      <br/>
      <div><button type="button" class="btn btn-danger" onclick="location.href='admin_hotel_add.jsp'">ホテル登録</button></div>
      <br/>
      </div>
      <div class="col-sm-2">
      </div>
      <div class="col-sm-7">
      <h1 style="text-align:center">ホテル登録</h1>
      <form method="post" action="admin_hotel_add.do" enctype="multipart/form-data" name="frm">
         <div class="form-group">
        <label for="usr">ホテル名 :</label>
       <input type="text" class="form-control" name="hotelName">
      </div>
      <div class="form-group">
        <label for="usr">地域 :</label>
       <input type="text" class="form-control" name="hotelCity">
      </div>
      <div class="form-group">
        <label for="usr">住所 :</label>
       <input type="text" class="form-control" name="hotelAddress">
      </div>
      <div class="form-group">
        <label for="usr">料金（￥） :</label>
       <input type="text" class="form-control" name="hotelPrice">
      </div>
      <div class="form-group">
        <label for="usr">スターレート :</label>
       <input type="text" class="form-control" name="quality">
      </div>
      <div class="form-group">
        <label for="usr">フォトギャラリー :</label>
       <input type="file"  id="pictureUrl" name ="pictureUrl" onchange="LoadFile(event)">
       <img id="output" src = "/TravelPlanSystem/images/image.png" height="200" width="300" />
      </div>
      <div class="form-group" style="text-align:center">
      <input type="submit" class="btn btn-default" value="登録" >
      <input type="reset"  class="btn btn-default" value="取り消す">
      <input type="button" class="btn btn-default" value="リスト" onclick="location.href='admin_hotel.do'">
      </div>
      </form>
      </div>
     <div class="col-sm-2">
     </div>
   </div>
</div>
</body>
</html>