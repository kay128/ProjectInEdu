<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="/langlang/css/header.css" />
		<script type="text/javascript">
		
		</script>
</head>
<body>
		<!-- Header -->
 			<header class="head_icon">
				<a><img id="menu_icon" src="/langlang/img/menu.jpg" alt="menu" height="100px" width="100px" onclick="openNav()">
				</a>
			</header> 
			
		<!-- nav -->
			<div id="mySidenav" class="sidenav">
			  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			  <div class="blank"></div>
			  <div class="blank"></div>
			  <s:if test = "#session.loginUser!=null">
			      <a href="main.action">Home</a>
			      <br>
			  	  <a href="written_list.action?en_current_page=1&ko_current_page=1&js_current_page=1">Lang Board</a>
			  	  <a href="written_form.action">Write Post</a>
				<!--   <a href="#">My Post</a>
				  <a href="#">My Feedback</a> -->
				  <br>
				  <a href="user_info.action">User Info</a>
				  <a href="logout.action">Logout</a>
				<!--    <br>
				  <a href="send_message.action">Contact Us</a> -->
			  </s:if>
			  <s:else>
			  	  <a href="main.jsp">Home</a>
			  	  <br>
			  	  <a href="login_form.action">Login</a>
				  <a href="join_form.action">Join</a>
				  <br>
<!-- 				  <a href="about_site.action">What is Lang?</a>
				  <a href="how_site.action">How to use Lang?</a> 
				  <a href="send_message.action">Contact Us</a>-->
			  </s:else>
			</div>		
		<script src="/langlang/js/nav.js"></script>
</body>
</html>