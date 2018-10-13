<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/travelplansystem.css"> 
		<link rel="stylesheet" href="css/bootstrap.css">
		<link type = "text/css" rel = "stylesheet" href = "css/remove.css">
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel = "stylesheet">
		<title>会員退会ページ</title>
    
    <script type="text/javascript">
			var message2 = '<%=request.getAttribute("message2")%>';
			switch(message2){
			
			case 'null':
				/* alert("실패 _ null"); */
				break;
			default : 
				alert(message2);
			}	
    
        // 비밀번호 미입력시 경고창
        function checkValue(){
            if(!document.deleteform.pass.value){
                alert("パスワードを入力してください。");
                return false;
            }
        }
    </script>
    
</head>
<body>
	<div class = "body-remove">
	<br>
 	<h3 style="text-align:center">会員退会</h3>
 	<br>
    <div class = "container">
    <form name="deleteform" method="post" action="/TravelPlanSystem/remove.do" onsubmit="return checkValue()" style="text-align:center">
 
               <div class = "inner add">
					<i class="glyphicon glyphicon-lock"></i>
					<input type = "password" name = "pass" class = "well well-sm" placeholder = "パスワード"/><br>
				</div>
				<div class = "row">
					<input type = "reset" class = "btn btn-default btn-md" value = "取り消す" onclick = "location.href = '/TravelPlanSystem/index.jsp'"/>
					<input type = "submit" class = "btn btn-primary btn-md" value = "退会" />
				</div> 
    </form>
    </div>
    </div>
</body>
</html>