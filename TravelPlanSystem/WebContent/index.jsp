<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width" initial-scale="1">
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
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
			
	</script>
	<title>メインページ</title>
	<style>
		.myslide{
			display:none;
		}
	</style>
	</head>
	<body>
		<div class="container-fluid">
			<img class="myslide" src="images/t3.jpg" width="100%" height="800px" alt="">
			<img class="myslide" src="images/t1.jpg" width="100%" height="800px" alt="">
			<img class="myslide" src="images/t2.jpg" width="100%" height="800px" alt="">
		</div>
		<div>
		<%@include file="footer.jsp" %>
		</div>
		<script language="javascript">
		var myIndex = 0;
		carousel();
		function carousel(){
			var i;
			var x = document.getElementsByClassName("myslide");
			for(i=0;i<x.length;i++){
				x[i].style.display="none";
			}
			myIndex++;
			if(myIndex > x.length){ myIndex = 1}
				x[myIndex-1].style.display="block";
			setTimeout(carousel,2000);
		}
		</script>
	</body>
</html>