<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/AdminHotel.js"></script>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
      <h1 style="text-align:center">ホテル修正</h1>
     
	<form method ="post" action="admin_hotel_modiadd.do" enctype="multipart/form-data" name="frm">
		<input type="hidden" name="code" value="${dto.hotelName}">
		<input type="hidden" name="nonmakeImg" value="${dto.pictureUrl }">
		<table>	
			<tr>
				<td>
				<c:choose>
					<c:when test="${empty admin_hotel_modify.pictureUrl }">
						<!--  <img src="images/noimage.gif"> -->
					</c:when>
					<c:otherwise>
						<img src="images/${admin_hotel_modify.pictureUrl }">
					</c:otherwise>
				</c:choose>
				</td>
				<td>
				
				 <div class="form-group">
        		<label for="usr">ホテル名 :</label>
				<!--  <input type="text" class="form-control" name="hotelName" value="${selectedHotel[0].hotelName}" size="80"> -->
				 <input class="form-control" id="disabledInput" name="hotelName" type="text" value="${selectedHotel[0].hotelName}" placeholder="${selectedHotel[0].hotelName}" size="80" >
				</div>
				<div class="form-group">
       		    <label for="usr">地域 :</label>
       			<input type="text" class="form-control" name="hotelCity" value="${selectedHotel[0].hotelCity}" size="80">
      			</div>
				<div class="form-group">
        		<label for="usr">住所 :</label>
      			<input type="text" class="form-control" name="hotelAddress"  value="${selectedHotel[0].hotelAddress }"  size="80">
      			</div>
				
				<div class="form-group">
       			<label for="usr">料金（￥） :</label>
       			<input type="text" class="form-control" name="hotelPrice" value="${selectedHotel[0].hotelPrice }">
      			</div>
				 <div class="form-group">
       			 <label for="usr">スターレート :</label>
       			 <input type="text" class="form-control" name="quality" value="${selectedHotel[0].quality }">
      			 </div>
		
				<div class="form-group">
        		<label for="usr">フォトギャラリー :</label>
      			 <input type="file"  id="pictureUrl" name = "pictureUrl" onchange="LoadFile(event)">
      			  <img id="output" src = "/TravelPlanSystem/images/${selectedHotel[0].hotelName}.jpg" height="200" width="300" />
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
</body>
</html>