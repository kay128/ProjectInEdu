<%@page import ="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
      
      <div class="col-sm-11">
      <div class="container">
     
<div id="wrap" align="center">
<h1>ホテルリスト</h1>
</div>


 <table class="table table-striped">
    <thead>
      <tr>
        <th>ホテル名</th>
        <th>フォトギャラリー</th>
        <th>地域</th>
        <th>住所</th>
        <th>料金</th>
        <th>スターレート</th>
        <th>修正</th>
        <th>削除</th>
      
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${hotellist }" var="dto">
      <tr><td>${dto.hotelName}</td><td><img id="output" src = "/TravelPlanSystem/images/${dto.hotelName }.jpg" height="100" width="150" class="img-rounded"/></td><td>${dto.hotelCity}</td><td>${dto.hotelAddress}</td><td>￥${dto.hotelPrice}</td><td>${dto.quality}</td>
      <td><a href ="admin_hotel_modify.do?hotelName=${dto.hotelName }">修正</a></td>
      <td><a href ="admin_hotel_delete.do?hotelName=${dto.hotelName}">削除</a></td>
      </tr><br>
      </c:forEach>
    </tbody>
      </table>
      </div>
      </div>
      </div>
      </div>
<br>
<div id="wrap" align="center">
<!--<button type="button" class="btn btn-warning" onclick="location.href='admin_hotel_add.jsp'">호텔등록</button> -->
</div>
</body>
</html>