<%@page import="model.Result"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<title>Insert title here</title>
<style>
*{
	box-sizing:border-box;
}

a:hover{
	text-decoration:none;
}
.column{
	float: left;
	width: 33.33%;
	padding: 5px;
}
/* Clearfix (clear floats) */
.row::after{
	content: "";
	clear: both;
	display: table;
}

.hero-image {
  background-image: url("images/myinfo.jpg");
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
  border-radius: 4px;
}

h1{
	padding:50px;
	color:white;
}
/* Closable button inside the expanded image */
.closebtn {
    position: absolute;
    top: 10px;
    right: 15px;
    color: white;
    font-size: 35px;
    cursor: pointer;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row content">
		 <div class="col-sm-1 sidenav" >
		  <div><button type="button" class="btn btn-success" onclick="location.href='myinfo.do'">マイプラン</button></div>
	      <br/>
	      <div><button type="button" class="btn btn-warning" onclick="location.href='myinfo_hotelbooking.do'">マイホテル</button></div>
	      <br/>
	      </div>		 
		 <div class="col-sm-11">
		 	<div class="row">

			<c:forEach items="${schedulelist }" var="dto">
				<div class="column">
					<div class="hero-image">
					<span onclick="location.href='myinfo_scheduledelete.do?scheduleTitle=${dto.scheduleTitle}'" class="closebtn">&times;</span>
					<a href="schedule_detail.do?scheduleTitle=${dto.scheduleTitle}">
					<h1 style="font-size:30px">${dto.scheduleTitle}</h1>
					</a>
					</div>
				</div>
				
      		</c:forEach>
      		</div>	
		 </div>
		</div>
	</div>
	<script>
	$(document).ready(function(){
		var title;
		$(document).on("click","#title",function(){
			console.log("title clicked");
			console.log($(this).text());
			title = $(this).text();

		});
		
	});
	</script>
</body>
</html>