<%@page import="model.Customer"%>
<%@ include file="header.jsp" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type = "text/css">
				#viewForm{
					width: 640px;
					border: 2px solid darkgray;
					border-radius: 20px;
					margin: auto;
					padding: 10px;
					align: center;
				}
				
				h2{
					text-align: center;	
									
				}
				
				img{
					width: 400px;
					height: 400px;
					border: none;
					align: center;
				}
				
				#content_main{
					width: 620px;
					height: 100%;
					margin: 0 120px;
				}
				
				#content_left{
					width: 300px;
					float : left;
					
				}
				#content_right{
				width: 340px;
				float : left;
				text-align: left;
				}
			
			
			#commandCell{
				text-align: center;
			}
			
			#desc{
				height: 100px;
			}
			
			#right{
				text-align: right;
				float : right;
			}
			
			
		</style>
		<script type="text/javascript">		
			var message = '<%=request.getAttribute("message")%>';
			switch(message){
			
			case 'null':
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
					document.getElementById("checkOut").setAttribute("value", checkIn);
					document.getElementById("checkOut").setAttribute("min", checkIn);
					
				}	

			}
			

		</script>
	</head>
	<body>
	
			<form name = "frm" action = "hotel_booking.do?hotelName=${selectedHotel[0].hotelName }" method = "post">
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
				<br>
	
				<tr>
				</tr>
				<tr>
				</tr>

				<tr>
					<td colspan="5"><input type = "submit" value = "予約する" onclick = "return checkLogin(<%=(Customer)session.getAttribute("loginUser")%>)" class="btn btn-info btn-lg"/></td>
				</tr>
	
			</div>
			</form>
	
			<section id = "viewForm">
				<h2>${selectedHotel[0].hotelName }の情報</h2><br><br>
				<section id = "content_main">
					<section id = "content_left">
						<img src = "/TravelPlanSystem/images/${selectedHotel[0].hotelName }.jpg" class="img-rounded"/><br><br>
					</section>
					<section id ="content_right">
					<br>
						<font size = "5pt"><b>星 ${selectedHotel[0].quality }のホテル</b> </font><br><br>
						<font size = "3.5pt">
						<b>ホテル名 </b>&nbsp;&nbsp; ${selectedHotel[0].hotelName }<br>
						<b>地域 </b>&nbsp;&nbsp; ${selectedHotel[0].hotelCity }<br>
						<b>料金 </b>&nbsp;&nbsp; ￥${selectedHotel[0].hotelPrice }<br>
						<b>住所 </b>&nbsp;&nbsp; ${selectedHotel[0].hotelAddress } <br>
						<b>総合 </b>&nbsp;&nbsp; </font>
						<c:if test = "${selectedHotel[0].avgReviewGrade>0 }">
						<fmt:formatNumber value="${selectedHotel[0].avgReviewGrade }" pattern=".0"/>点</c:if>
						<c:if test = "${selectedHotel[0].avgReviewGrade==0 }">投稿されたクチコミがありません。</c:if>
						<br><br>
							<font size = "3.5pt"> <b>クチコミ</b></font>
							<table class="table table-striped">
								<tr>
									<td align = "center">ニックネーム</td>
									<td align = "center">評点</td>
									<td align = "center">内容</td>
								</tr>
									<c:forEach var = "h" items = "${selectedHotel }" varStatus = "status">
										<c:if test = "${h.reviewGrade > 0 }">
										<tr>
											<td align = "center">${h.nickName }</td>
											<td align = "center">${h.reviewGrade }</td>
											<td align = "center">${h.reviewContent }</td>
										</tr>
										</c:if>
									</c:forEach>
							</table>
							
					</section>
				</section>
				<br><br>
				<div style = "clear:both"></div> <!-- 전체 float 속성 없애기 위해 -->
				<div id = "commandCell">
				</div> 
			</section>
		<script type="text/javascript" src = "/TravelPlanSystem/js/loginCheck.js"></script>
	</body>
</html>