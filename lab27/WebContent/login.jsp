<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

	#loginbox{
	padding:20px;
	margin-top:200px;
	border: 1px solid rgba(0,0,0, 0.04);
	border-radius: 3px;
	box-shadow:3px 3px 3px 3px rgba(0,0,0, 0.3);
	-webkit-box-shadow:3px 3px 3px 3px rgba(0,0,0, 0.3);
	-moz-box-shadow:3px 3px 3px 3px rgba(0,0,0, 0.3);
	
</style>

</head>
<body>
<div class="container">
<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4" id="loginbox"  style="margin-top:200px">
<h3>Sign in</h3>
<h4>with your 이칠 연구소 Account</h4>
<form action="login.lab27">
<input type="hidden" name="command" value="m_login">
<div id="form-group">
Id:
<input type="text" class="form-control" name="user_id" style="width:70%;">
</div>
<div id="form-group">
Password:
<input type="password" class="form-control" name="pass" style="width:70%">
</div>
<br/>
<button type="submit" class="btn btn-default">login</button>
</form>
<br/>
<h4 style="color:royalblue"><a href="/lab27/register.jsp">Create Account</a></h3>
</div>
<div class="col-sm-4">
</div>
</div>
</div>
</body>
</html>