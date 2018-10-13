<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/lab27/css/header.css">


<!-- 네비게이션 용 css -->
<link rel="stylesheet" href="/lab27/css/sideNavCSS.css">
<!-- study 페이지용 css -->
<link rel="stylesheet" href="/lab27/css/study.css">

<!-- Bootstrap, Jquery, Poper -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js" integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9" crossorigin="anonymous"></script>

<title>Insert title here</title>
<style>
#id_area{
	background-color:royalblue;
	color: white;
    padding: 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    border: none;
    border-radius:50%;
}
</style>
</head>
<body>
<c:import url="/nav/global_nav.jsp"/>
<div id="i_header">
<a href="/lab27/index.jsp"><img height="25px" width="25px" src="/lab27/images/home.png"></a>
<c:if test="${empty loginUser}">
<button type="button" class="btn" onclick="location.href='/lab27/login.jsp'">Sign in</button>
</c:if>
<c:if test="${! empty loginUser}">
<button id="id_area" onclick="location.href='/lab27/mypage.jsp'">${loginUser.name }</button>
</c:if>
</div>
<div id="i_header_end">
</div>
</body>
</html>