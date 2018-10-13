<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %> 
<%@page import="model.Hotel"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
			<script type="text/javascript">
				
				var message = '<%=request.getAttribute("message")%>';
				switch(message){
				
				case null:
					/* alert("실패 _ null"); */
					break;
				case '':
					/* alert("실패 _ 홑따옴표"); */
					break;
				case "":
					/* alert("실패 _ 쌍따옴표"); */
					break;
				case 'null':
					/*alert("실패 _ null&홑따옴표"); */
					break;
				case "null":
					/* alert("실패 _ null&쌍따옴표"); */
					break;
				default : 
					alert(message);
				}	
				
				var today = new Date();
				var dd = today.getDate();
				var mm = today.getMonth()+1;
				var yyyy = today.getFullYear();
	
				if(dd<10) {
				    dd='0'+dd
				} 
	
				if(mm<10) {
				    mm='0'+mm
				} 
	
				today = yyyy+'-'+mm+'-'+dd;			
				
				function checkDate(){
					var checkIn = document.frm.checkIn.value;
					var checkOut = document.frm.checkOut.value;
					document.getElementById("checkIn").setAttribute("value", today);
					document.getElementById("checkIn").setAttribute("min", today);
					switch(checkOut){
					case null:
						break;
					case '':
						break;
					case "":
						break;
					case 'null':
						break;
					case "null":
						break;
					default :
						document.getElementById("checkIn").setAttribute("max", document.frm.checkOut.value); 
					}
				}
				
				function checkInDate(){
					var checkIn = document.frm.checkIn.value;
					var checkOut = document.frm.checkOut.value;
					document.getElementById("checkOut").setAttribute("value", today);
					switch(checkIn){
					case null:
						document.getElementById("checkOut").setAttribute("min", today);
						break;
					case '':
						document.getElementById("checkOut").setAttribute("min", today);
						break;
					case "":
						document.getElementById("checkOut").setAttribute("min", today);
						break;
					case 'null':
						document.getElementById("checkOut").setAttribute("min", today);
						break;
					case "null":
						document.getElementById("checkOut").setAttribute("min", today);
						break;
					default : 
						document.getElementById("checkOut").setAttribute("min", checkIn);  
					}	
	
				}
				
				function cityNameCheck(){
					var cityName = document.frm.cityName.value;
					switch(cityName){
					case null:
						alert("検索する地域の名前を入力してください。");
						return false;
						break;
					case '':
						alert("検索する地域の名前を入力してください。");
						return false;
						break;
					case "":
						alert("検索する地域の名前を入力してください。");
						return false;
						break;
					case 'null':
						alert("検索する地域の名前を入力してください。");
						return false;
						break;
					case "null":
						alert("検索する地域の名前を入力してください。");
						return false;
						break;
					default :
						return true;
					}
					
				}
				
			</script>
			<style type = "text/css">
				img{
					margin: 10px;
				}
			</style>
	</head>
	<body>
		<form action="hotel_search.do" method="post" name="frm">
			<div class="col-sm-2 sidenav">
				<tr>
					<td>チェックイン</td>
					<td><input id="checkIn" type="date" name="checkIn" id="checkIn"
						value="" min="" max="" onclick="checkDate()" style="height: 35px;" class="form-control"></td>
				</tr>
				<br>
				<br>
				<tr>
					<td>チェックアウト</td>
					<td><input id="checkOut" type="date" name="checkOut"
						id="checkOut" value="" min="" onclick="checkInDate()"
						oninput="checkOutDate()" style="height: 35px;" class="form-control"></td>
				</tr>
				<br>
				<br>

				<tr>
					<td>地域</td>
					<td><input type="text" name="cityName" style="height: 35px;" class="form-control"></td>
				</tr>
				<br>
				<br>
				<br>
	
				<tr>
				</tr>
				<tr>
				</tr>

				<tr>
					<td colspan="5"><input type="submit" value="検索する"
						onclick="return cityNameCheck()" class="btn btn-info btn-lg"></td>
				</tr>
	
			</div>
	
	
			<div id="wrap" align="center">
				<c:if test="${! empty randomList }">
	
					<h2>遊ぼうのオススメ</h2>
					<br>
					<table>
						<tr>
							<c:forEach var="h" items="${randomList }" varStatus="i">
								<td height="300" width = "300"><a href="hotel_select.do?hotelName=${h.hotelName }">
										<img src="/TravelPlanSystem/images/${h.hotelName }.jpg"
										height="200" width="200" class="img-rounded"/></a>
								 <br><br><div style="width:180px"><b>ホテル名:</b> ${h.hotelName }</div><b>料金:</b>
									￥${h.hotelPrice }<br> <b>評点:</b> <fmt:formatNumber value="${h.avgReviewGrade }" pattern="0.0"/>点<br><br></td>
								<td>
								<c:if test="${((i.index + 1) mod 3) == 0 }">
							</tr>
							<tr >
							</c:if>
							</c:forEach>
						</tr>
					</table>
				</c:if>
			</div>
			<br>
			<br>
			<br>
	</body>
</html>