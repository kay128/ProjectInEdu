<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
   <div class="row content">
      <div class="col-sm-1 sidenav" >
      <div><button type="button" class="btn btn-success" onclick="location.href='admin.do'">会員リスト</button></div>
      <br/>
      <div><button type="button" class="btn btn-warning" onclick="location.href='admin_hotel.do'">ホテル管理</button></div>
      <br/>
        <div><button type="button" class="btn btn-danger" onclick="location.href='admin_hotel_add.jsp'">ホテル登録</button></div>
      <br/>
      </div>
      
      <div class="col-sm-11">
 	
      
      <div class="container">           
  <table class="table table-striped">
    <div id="wrap" align="center">
<h1>会員リスト</h1>
</div>
    
    <thead>
      <tr>
        <th>メールアドレス</th>
        <th>ニックネーム</th>
        <th>会員ランク</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${customerlist }" var="dto">
      <tr><td>${dto.email}</td><td>${dto.nickName}</td><td>${dto.authority}</td></tr><br>
      </c:forEach>
    </tbody>
  
      </table>
      </div>
   </div>
</div>
</body>
</html>