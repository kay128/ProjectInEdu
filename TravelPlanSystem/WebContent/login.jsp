<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/travelplansystem.css"> 
		<link rel="stylesheet" href="css/bootstrap.css">
		<!-- <link type = "text/css" rel = "stylesheet" href = "css/login.css"> -->
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel = "stylesheet">
		<title>ログインページ</title>
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
		
			function check(){
				if(document.frm.email.value == "" || document.frm.email.length == 0){
					alert("メールアドレスを入力してください。");
					frm.email.focus();
					return false;
				}
				if(document.frm.pass.value == "" || document.frm.pass.length == 0){
					alert("パスワードを入力してください。");
					frm.pass.focus();
					return false;
				}
				return true;
			}
		</script>
	</head>
<body>
		<h3 style="text-align:center">ログイン</h3>
		<br>
		<div class = "container">
		<form name="frm" id="frm" action="/TravelPlanSystem/login.do" method="post" style="text-align:center">
				<div class="inner left-add">
					<i class="glyphicon glyphicon-envelope"></i>
					<input type="text" name="email" class="well well-sm" placeholder="メールアドレス" /><br>
				</div>
				<div class="inner left-add">
					<i class="glyphicon glyphicon-lock"></i>
					<input type="password" name="pass" class="well well-sm" placeholder="パスワード" /><br>
				</div>
				<div class="row">
						<input type="submit" class = "btn btn-primary btn-md" value="ログイン" onclick="return check()"/>
						<input type="button" class = "btn btn-default btn-md" value="忘れた場合" onclick="location.href='/TravelPlanSystem/find.jsp'" />
				</div>
		</form>
	</div>
</body>
</html>