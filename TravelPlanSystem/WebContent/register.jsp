<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/travelplansystem.css"> 
		<link rel="stylesheet" href="css/bootstrap.css">
		<link type = "text/css" rel = "stylesheet" href = "css/register.css">
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel = "stylesheet">
		<title>新規登録ページ</title>
		<script type = "text/javascript">
			var message2 = '<%=request.getAttribute("message2")%>';
			switch(message2){
			
			case 'null':
				/* alert("실패 _ null"); */
				break;
			default : 
				alert(message2);
			}	
		
			var xhr = null;

			function getXHR() {
				if (window.XMLHttpRequest) {
					//IE 7.0이상,Chrome,Firefox,Safari,....
					return new XMLHttpRequest();
				} else {
					//IE 하위버젼(6.0이하)
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
			}

			function emailCheck() {
				xhr = getXHR();
				xhr.onreadystatechange = getemailResult;
				var email = document.getElementById("email").value;
				xhr.open("get", "emailCheck.jsp?email=" + encodeURI(email), true);
				xhr.send(null);
			}

			function getemailResult() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var xml = xhr.responseXML;
					var re = xml.getElementsByTagName("result")[0].firstChild.nodeValue;

					if (re == 'true') {
						//span에 결과 출력하기
						document.getElementById("emailCheck").innerHTML = "既に使用されているメールアドレスです。";
					} else {
						document.getElementById("emailCheck").innerHTML = "使用できるメールアドレスです。";
					}
				}
			}

			function check() {
				if (document.frm.email.value == ""
						|| document.frm.email.length == 0) {
					alert("メールアドレスを入力してください。");
					frm.email.focus();
					return false;
				}
				if (document.frm.pass.value == ""
						|| document.frm.pass.length == 0) {
					alert("パスワードを入力してください。");
					frm.pass.focus();
					return false;
				}
				if (document.frm.nickName.value == ""
						|| document.frm.nickName.length == 0) {
					alert("ニックネームを入力してください。");
					frm.nickName.focus();
					return false;
				}
				return true;
			}
		</script>
		<script type = "text/javascript">

		var xhr = null;

		function getXHR() {
			if (window.XMLHttpRequest) {
				//IE 7.0이상,Chrome,Firefox,Safari,....
				return new XMLHttpRequest();
			} else {
				//IE 하위버젼(6.0이하)
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
		}

		function nickNameCheck() {
			xhr = getXHR();
			xhr.onreadystatechange = getnickNameResult;
			var nickName = document.getElementById("nickName").value;
			xhr.open("get", "nickNameCheck.jsp?nickName=" + encodeURI(nickName), true);
			xhr.send(null);
		}

		function getnickNameResult() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var xml = xhr.responseXML;
				var re = xml.getElementsByTagName("result")[0].firstChild.nodeValue;

				if (re == 'true') {
					//span에 결과 출력하기
					document.getElementById("nickNameCheck").innerHTML = "既に使用されているニックネームです。";
				} else {
					document.getElementById("nickNameCheck").innerHTML = "使用できるニックネームです。";
				}
			}
		}
		</script>
		
	</head>
	<body>	
		<div class = "body-login">
			<h3 style="text-align:center">新規登録</h3>
			<br>
			<form name = "frm" id = "frm" action = "/TravelPlanSystem/register.do" method = "post" style="text-align:center">
				<div class = "inner add">
					<i class="glyphicon glyphicon-envelope"></i>
					<input type = "text" name = "email" id = "email" class = "well well-sm" placeholder = "メールアドレス" onkeyup = "emailCheck()"/>
					<br><span id = "emailCheck"></span>
				</div>
				<br>
				<div class = "inner add">
					<i class="glyphicon glyphicon-lock"></i>
					<input type = "password" name = "pass" class = "well well-sm" placeholder = "パスワード"/><br>
				</div>
				<br>
				<div class = "inner add">
					<i class = "glyphicon glyphicon-user"></i>
					<input type = "text" name = "nickName" id = "nickName" class = "well well-sm" placeholder = "ニックネーム" onkeyup = "nickNameCheck()"/>
					<br><span id = "nickNameCheck"></span><br>
				</div>
				<br>
				<div class = "row">
					<input type = "reset" class = "btn btn-default btn-md" value = "取り消す"/>
					<input type = "submit" class = "btn btn-primary btn-md" value = "会員登録" onclick = "return check()"/>
				</div>
			</form>
		</div>
	</body>
</html>