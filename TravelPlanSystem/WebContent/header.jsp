<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/travelplansystem.css"> 
<link rel="stylesheet" href="css/bootstrap.css">
<title>Insert title here</title>
<style>
   #header{
	  font-color: #000000;
      background: #008CBA;
   }
   
   .navbar-default{
    color:#000000;
   }
   
</style>
</head>
<body >
   <nav class="navbar navbar-default">
      <div class="container-fluid">
         <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">遊びに行こう</a>
         </div>
         <ul class="nav navbar-nav" style="color:#ffffff">
            <li><a href="create_schedule.jsp">プランを立てる</a></li>
            <li><a href="hotel.do">ホテル</a></li>
            <li><a href="boardview.do">掲示板</a></li>
         </ul>
         <c:if test="${ empty loginUser }">
         <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">メニュー<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li><a href="login.jsp">ログイン</a></li>
                  <li><a href="register.jsp">新規登録</a></li>
               </ul>
            </li>
         </ul>
         </c:if>
         <c:if test="${! empty loginUser }">
            <ul class="nav navbar-nav navbar-right">
               <c:choose>
               <c:when test="${loginUser.authority eq 'manager'}">
               <li><a href="admin.do">${loginUser.nickName }様いらっしゃいませ</a></li>
               <li><a href="logout.do">logout</a></li>
               </c:when>
               <c:when test="${loginUser.authority eq 'customer'}">
                   <li><a href="myinfo.do">${loginUser.nickName }様いらっしゃいませ</a></li>
                   <li class="dropdown">
               		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">会員メニュー<span class="caret"></span></a>
               		<ul class="dropdown-menu">
                  	<li><a href="logout.do">ログアウト</a></li>
                  	<li><a href="remove.jsp">会員退会</a></li>
               		</ul>
            		</li>
                </c:when>
               </c:choose>
            </ul>
         </c:if>
      </div>
   </nav>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="js/bootstrap.js"></script>
</body>
</html>