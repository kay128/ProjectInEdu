<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="row content">
 <div class="col-sm-1 sidenav" >
  <div><button type="button" class="btn btn-success" onclick="location.href='myinfo.do'">マイプラン</button></div>
     <br/>
     <div><button type="button" class="btn btn-warning" onclick="location.href='myinfo_hotelbooking.do'">マイホテル</button></div>
     <br/>
     </div>		 
 <div class="col-sm-11">
	<div class="container">
	<h2 align = "center" style = "font-weight: bold">予約確認</h2>
	<br>
	<br>
	<table class="table table-striped">
	<thead>
		<tr>
			<td height = "50" align = "center" style="font-weight: bold; font-size:12pt;">予約番号</td>
			<td height = "50" align = "center" style="font-weight: bold; font-size:12pt;">ホテル名</td>
			<td height = "50" align = "center" style="font-weight: bold; font-size:12pt;">フォトギャラリー</td>
			<td height = "50" align = "center" style="font-weight: bold; font-size:12pt;">チェックイン</td>
			<td height = "50" align = "center" style="font-weight: bold; font-size:12pt;">チェックアウト</td>
			<td height = "50" align = "center" style="font-weight: bold; font-size:12pt;">キャンセル</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${hotelbookinglist }" var="dto">
		<tr>
			<td align = "center" style = "vertical-align: middle;">${dto.resultId }</td>
			<td align = "center" style = "vertical-align: middle;"><a href="bookingInfo.do?resultId=${dto.resultId }">${dto.hotelName }</a></td>
			<td align = "center" style = "vertical-align: middle;"><a href="bookingInfo.do?resultId=${dto.resultId }"><img src = "/TravelPlanSystem/images/${dto.hotelName }.jpg"  width= "150px"  height="100px" class="img-rounded"/></a></td>
			<td align = "center" style = "vertical-align: middle;">${dto.checkIn }</td>
			<td align = "center" style = "vertical-align: middle;">${dto.checkOut }</td>
			<td align = "center" style = "vertical-align: middle;"><a href="bookingCancle.do?resultId=${dto.resultId }">キャンセル</a></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	</div>
 </div>
</div>	
	<script>
	$(document).ready(function(){
		
		
	});
	</script>
</body>
</html>