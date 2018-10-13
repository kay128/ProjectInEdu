<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

	#registerbox{
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
<div class="col-sm-4" id="registerbox">
<h3>Create your 이칠연구소 Account</h3>
<form action="register.lab27">
<input type="hidden" name="command" value="m_regist">
ID:
<input type="text" class="form-control" name="user_id" style="width:70%;"/>
PASSWORD:
<input type="password" class="form-control" name="pass" style="width:70%;"/>
NAME:
<input type="text" class="form-control" name="name" style="width:70%;"/>
기수:
<input type="text" class="form-control" name="grade_id" style="width:70%;"/>
E-Mail:
<input type="email" class="form-control" name="email" style="width:70%;"/>
Phone:
<input type="text" class="form-control" name="phone" style="width:70%;"/>
출신지:
<input type="text" class="form-control" name="location" style="width:70%;"/>
<br/>
<button type="submit" class="btn btn-default">Register</button>
</form>
</div>
<div class="col-sm-4">
</div>
</div>
</div>
</body>
</html>