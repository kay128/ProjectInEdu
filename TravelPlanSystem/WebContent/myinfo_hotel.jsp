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
			
			function reviewCheck(){
				var reviewGrade = document.frm.reviewGrade.value;
				switch(checkIn){
				case null:
					alert("評点を入力してください。");
					return false;
				case '':
					alert("評点を入力してください。");
					return false;
				case "":
					alert("評点を入力してください。");
					return false;
				case 'null':
					alert("評点を入力してください。");
					return false;
				case "null":
					alert("評点を入力してください。");
					return false;
				case '0':
					alert("評点を入力してください。");
					return false;
				case "0":
					alert("評点を入力してください。");
					return false;
				default : 
					return true;
				}	

			}

		</script>
	</head>
	<body>
  <div class="col-sm-1 sidenav" >
  <div class="row-content">
  <div><button type="button" class="btn btn-success" onclick="location.href='myinfo.do'">マイプラン</button></div>
     <br/>
     <div><button type="button" class="btn btn-warning" onclick="location.href='myinfo_hotelbooking.do'">マイホテル</button></div>
     <br/>
     </div>	
 </div>    
			<section id = "viewForm">
				<p style = "line-height:50px;"><h2><font color = "navy" style = "weight:bold">${bookingInfo.nickName }</font>様の <br>
				<font color = "navy" style = "weight:bold">${bookingInfo.hotelName}</font> 予約内容</h2></p><br><br>
				<section id = "content_main">
					<section id = "content_left">
						<a href = "hotel_select.do?hotelName=${bookingInfo.hotelName}" ><img src = "/TravelPlanSystem/images/${bookingInfo.hotelName }.jpg" class="img-rounded"/></a><br><br>
					</section>
					<section id ="content_right">
						
						<p style = "line-height:300%;"><font size = "4pt" ><b>メールアドレス&nbsp;&nbsp; </b>&nbsp;&nbsp; ${bookingInfo.email }<br>
						<b>ホテル名&nbsp;&nbsp; </b>&nbsp;&nbsp; ${bookingInfo.hotelName }<br>
						<b>チェックイン&nbsp; </b>&nbsp;&nbsp; ${bookingInfo.checkIn }<br>
						<b>チェックアウト</b>&nbsp;&nbsp; ${bookingInfo.checkOut } <br>
						</font>
						</p>
						<form action = "hotel_review.do" method = "post">
						<table class="table table-striped">
							<c:if test = "${bookingInfo.reviewGrade == 0 || bookingInfo.reviewContent == null}">
									<tr>
										<td width="80px" align = "center">評点</td>
										<td width="250px"><input type = "radio" name = "reviewGrade" value = "1">1点&nbsp;&nbsp;
											<input type = "radio" name = "reviewGrade" value = "2">2点&nbsp;&nbsp;
											<input type = "radio" name = "reviewGrade" value = "3">3点&nbsp;&nbsp;
											<input type = "radio" name = "reviewGrade" value = "4">4点&nbsp;&nbsp;
											<input type = "radio" name = "reviewGrade" value = "5">5点&nbsp;&nbsp;
											<input type = "hidden" name = "nickName" value="${loginUser.nickName }"/>
											<input type = "hidden" name = "hotelName" value = "${bookingInfo.hotelName }"/>
											<input type = "hidden" name = "resultId" value = "${bookingInfo.resultId }"/>
										</td>
									</tr>
										<td width="80px" align = "center"style = "vertical-align: middle;">クチコミ</td>
										<td width="250px"><textarea placeholder="内容を入力してください。" rows="1" cols = "50" name = "reviewContent" class="form-control"　></textarea></td>
									</tr>
											<tr><td colspan="2"><input type = "submit" value = "投稿する" onclick = "return reviewCheck()"/></td>
									</tr>
								</c:if>
							</table>
							</form>
					</section>
				</section>
				<br><br>
				<div style = "clear:both"></div> <!-- 전체 float 속성 없애기 위해 -->
				<div id = "commandCell">
				</div> 
			</section>
	</body>
</html>