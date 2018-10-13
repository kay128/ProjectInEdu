<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function openNav() {
	    document.getElementById("mySidenav").style.width = "300px";
	}
	
	function closeNav() {
	    document.getElementById("mySidenav").style.width = "0";
	}
</script>

<div id="mySidenav" class="sidenav">
	<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	
	
	<a href="/lab27/index.jsp">홈</a>
	<br>
	<br>
	
	<a href="#" data-toggle="collapse" data-target="#study">STUDY</a>
	
	<button data-toggle="collapse" data-target="#study" class="btn btn-outline-light btn-sm"><b>+</b></button>
	<br>
	<div id="study" class="collapse">
		&nbsp;&nbsp;<a href="/lab27/study/it/it_main.jsp">・&nbsp;IT</a> <br>
		&nbsp;&nbsp;<a href="/lab27/study/japan/japan-1-1.jsp">・&nbsp;일본어</a>
	</div>
	
	<br>
	<a href="market.lab27?command=market_list">장터</a>
	<br>
	<br>
	<a href="group.lab27?command=communityMain">모임</a>
	<br>
	<br>
	<a href="/lab27/company.lab27?command=com_list">회사정보</a>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr><a href="#"  data-toggle="collapse" data-target="#links">링크</a>
	<button data-toggle="collapse" data-target="#links" class="btn btn-outline-light btn-sm"><b>+</b></button>
	<br>
	<div id="links" class="collapse">
		&nbsp;&nbsp;<a href="https://www.w3schools.com/default.asp" target="_blank">・&nbsp;w3schools.com</a> <br>
		&nbsp;&nbsp;<a href="http://tomcat.apache.org/" target="_blank">・&nbsp;Apache. Tomcat</a> <br>
		&nbsp;&nbsp;<a href="https://www.eclipse.org/" target="_blank">・&nbsp;eclipse</a> <br>
		&nbsp;&nbsp;<a href="https://www.oracle.com/index.html" target="_blank">・&nbsp;Oracle</a> <br>
		&nbsp;&nbsp;<a href="https://www.mysql.com/" target="_blank">・&nbsp;MySql</a> <br>
		&nbsp;&nbsp;<a href="https://struts.apache.org/" target="_blank">・&nbsp;Struts</a> <br>
		&nbsp;&nbsp;<a href="http://blog.mybatis.org/" target="_blank">・&nbsp;MyBatis</a> <br>
		&nbsp;&nbsp;<a href="https://spring.io/" target="_blank">・&nbsp;Spring</a> <br>
	</div>
	<c:if test = "${!empty loginUser}">
		<button class="btn btn-outline-light closebtn btn-sm" id="logout-btn" onclick="location.href='market.lab27?command=m_logout'">로그아웃</button>
	</c:if>
</div>

<span id="side_nav_span" onclick="openNav()">&#9776;</span>