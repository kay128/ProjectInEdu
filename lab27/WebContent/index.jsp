<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.row > .column {
    padding: 8px;
}

/* Create four equal columns that floats next to each other */
.column {
    float: left;
    width: 25%;
}

/* Clear floats after rows */ 
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* Content */
.content {
    background-color: white;
    padding: 10px;
}

.logo {
	padding-left : 255px;
	width : 65%; 
	height : 52%;
}
</style>
</head>
<body>
<div id="i_body">
<div class="container">
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-10" style="margin-top:100px;">
<!--   <h1 style="text-align:center;padding-bottom:20px;">JSL Community</h1> -->
  <img class="logo" src="images/logo.png">
  <form action="search.lab27">
  <div class="input-group">
  	<input type="hidden" name="command" value="search"/>
    <input type="search"  class="form-control border-secondary py-2" name="search" placeholder="Search">
    <div class="input-group-append">
      <button class="btn btn-outline-secondary" type="submit">
      <i class="fa fa-search"></i>
      </button>
    </div>
   </form>   
  </div>  
<div class="row">
  <div class="column">
    <div class="content">
      <a href="https://www.w3schools.com/" target="_blank">
      <img src="/lab27/images/w3schools_icon.png" alt="Mountains" style="width:100%;height:120px;">
      </a>
    </div>
  </div>
  <div class="column">
    <div class="content">
    <a href="http://tomcat.apache.org/" target="_blank">
    <img src="/lab27/images/apache_icon.png" alt="Lights" style="width:100%;height:120px;">
    </a>
    </div>
  </div>
  <div class="column">
    <div class="content">
    <a href="https://www.eclipse.org/" target="_blank">
    <img src="/lab27/images/eclipse_icon.png" alt="Lights" style="width:100%;height:120px;">
    </a>
    </div>
  </div>
  <div class="column">
    <div class="content">
    <a href="https://www.oracle.com/index.html" target="_blank">
    <img src="/lab27/images/oracle_icon.png" alt="Lights" style="width:100%;height:120px;">
    </a>
  </div> 
</div>	
<div class="row">
  <div class="column">
    <div class="content">
    <a href="https://www.mysql.com/" target="_blank">
    <img src="/lab27/images/mysql_icon.png" alt="Lights" style="width:100%;height:120px;">
    </a>
    </div>
  </div>
  <div class="column">
    <div class="content">
    <a href="https://struts.apache.org/" target="_blank">
    <img src="/lab27/images/struts_icon.png" alt="Lights" style="width:100%;height:120px;">
    </a>
    </div>
  </div>
  <div class="column">
    <div class="content">
    <a href="http://blog.mybatis.org/" target="_blank">
    <img src="/lab27/images/mybatis_icon.png" alt="Lights" style="width:100%;height:120px;">
    </a>
    </div>
  </div>
  <div class="column">
    <div class="content">
    <a href="https://spring.io/" target="_blank">
    <img src="/lab27/images/spring_icon.png" alt="Mountains" style="width:100%;height:120px;">
    </a>
    </div>
  </div> 
  </div>
</div>	
<div class="col-sm-1"></div>
</div>
</div>
</div>

<div style="padding-top:100px;">
</div>
<c:import url="/footer/footer.jsp"/>
<script>
function search(){
	location.href="''";
}
</script>
</body>
</html>