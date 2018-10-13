<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/travelplansystem.css"> 
		<link rel="stylesheet" href="css/bootstrap.css">
		<link type = "text/css" rel = "stylesheet" href = "css/find.css">
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel = "stylesheet">
		<title>探すページ</title>
		<script type = "text/javascript">
    	var message = '<%=request.getAttribute("message")%>';
			switch(message){
			
			case 'null':
				/* alert("실패 _ null"); */
				break;
			default : 
				alert(message);
			}	
			
			var message2 = '<%=request.getAttribute("message2")%>';
			switch(message2){
			
			case 'null':
				/* alert("실패 _ null"); */
				break;
			default : 
				alert(message2);
			}	
			
			var message3 = '<%=request.getAttribute("message3")%>';
			switch(message3){
			
			case 'null':
				/* alert("실패 _ null"); */
				break;
			default : 
				alert(message3);
			}	
		</script>
	</head>
	<body>
	<div class = "body-find">
		<div class = "left-box">
		<form action = "/TravelPlanSystem/findemail.do" method = "post" style="text-align:center">
			<h4>メールアドレスを探す場合</h4>
			<div class = "inner add">
					<i class="glyphicon glyphicon-user"></i>
					<input type = "text" name = "nickName" class = "well well-sm" placeholder = "ニックネーム" />
				</div>
				<div class = "row">
					<input type = "submit" class = "btn btn-primary btn-md" value = "探す"/>
				</div>
		</form>
		</div>
		
		<div class = "right-box">
		<form action = "/TravelPlanSystem/findpass.do" method = "post" style="text-align : center">
			<h4>パスワードを探す場合</h4>
			<div class = "inner add">
					<i class="glyphicon glyphicon-envelope"></i>
					<input type = "text" name = "email" class = "well well-sm" placeholder = "メールアドレス" />
				</div>
				<div class = "row">
					<input type = "submit" class = "btn btn-primary btn-md" value = "探す"/>
				</div>
		</form>
	</div>
	</div>
	</body>
</html>