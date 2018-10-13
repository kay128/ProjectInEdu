<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<div id="search" style="margin-top:200px;clear:both;">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8">
 <div class="input-group">
    <input type="search" value="search" class="form-control border-secondary py-2" placeholder="Search">
    <div class="input-group-append">
      <button class="btn btn-outline-secondary" type="submit">
      <i class="fa fa-search"></i>
      </button>
    </div>
  </div>
</div>
<div class="col-sm-2"></div>
</div>
<div class="container mt-3">
  <h2>Search Result</h2>
  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#market">장터</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#community">모임</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#company">회사정보</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#member">멤버</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="market" class="container tab-pane active"><br>
      <h3>장터</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div id="community" class="container tab-pane fade"><br>
      <h3>모임</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="company" class="container tab-pane fade"><br>
      <h3>회사정보</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div id="member" class="container tab-pane fade"><br>
      <h3>멤버</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
  </div>
</div>
</div>
</body>
</html>