<%@page import="model.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<div class="container">
		<table class="table table-bordered table-hover" style="text-align:center; border: 1px solid #dddddd">
		<thead>
		<tr>
		<th colspan="5"><font size="5pt" style="wieght:bold">自由掲示板</font></th>
		</tr>
		<tr>
		<th width="70px">番号</th>
		<th>タイトル</th>
		<th>作成者</th>
		<th width="100px">日付</th>
		<th width="70px">閲覧数</th>
		</tr>
		</thead>
		<tbody>
		<tr>

		<c:forEach items="${boardlist}" var="dto">

     	<tr>
     	<td>${dto.boardId}</td>
     	<td style="text-align:left">
     	<c:forEach var="count" begin="1"  end="${dto.boardLevel }" step="1" >
     	<span class="glyphicon glyphicon-arrow-right">
		</c:forEach>
		<c:choose> 
		<c:when test="${dto.boardAvailable eq 1 }">
		${dto.boardTitle }
		</c:when>
		<c:otherwise>
     	<a href="boardshow.do?boardId=${dto.boardId}&type=show">${dto.boardTitle}</a>
     	</c:otherwise>
     	</c:choose>
     	</td>
     	<td>${dto.userEmail}</td>
     	<td>${dto.boardDate}</td>
     	<td>${dto.boardHit}</td>
     	</tr>
      	</c:forEach>
		</tr>
		<tr>
		<td colspan="5"><a class="btn btn-primary pull-right" type="submit" onclick = "return checkLogin(<%=(Customer)session.getAttribute("loginUser")%>)" href="boardwrite.jsp?type=new" >作成</a></td>
		</tr>
		</tbody>
		</table>
		</div>
		 <script type="text/javascript" src = "/TravelPlanSystem/js/loginCheck.js"></script>
	</body>
	</html>