<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="row content">
		<div class="col-sm-1 sidenav">
		  <div class="col-sm-1 sidenav" >
		  <div><button type="button" class="btn btn-success" onclick="location.href='myinfo.do'">マイプラン</button></div>
	      <br/>
	      <div><button type="button" class="btn btn-warning" onclick="location.href='myinfo_hotelbooking.do'">マイホテル</button></div>
	      <br/>
	      </div>	
		</div>
		<div class="col-sm-11">
		<div class="container">
		<h2>${title }</h2>
			<c:forEach items="${day_list}" var="dto" begin="0" varStatus="status">
			<div class="panel panel-default">
    		<div class="panel-heading">${status.count }日目</div>
    		<div class="panel-body">${dto }</div>
  		  </div>
			</c:forEach>
		</div>
		</div>
	</div>
</div>
</body>
</html>