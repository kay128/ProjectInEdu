<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>		
	</head>
	<body>
	
		<div id="main-wrap" class="row" style="clear:both;"> <!-- wrap -->

		<!-- 스터디 목차 ================================================================== -->
			<div id="study-side-nav">
				<c:import url="/study/it/java/index.jsp"/>
			</div>	<!--  end -->
			
			
		<!-- 본문 ============================================================================= -->
			<div id="wrap">
				<h1>자바의 Collection(컬렉션)</h1>
				<div class="row">
				<h4>
				1. 자료구조<br><br>
		   		&nbsp;&nbsp;- 변수(Variable) : 하나의 상수(값, Data)를 저장하는 기억공간<br><br>
		   		&nbsp;&nbsp;- 배열(Array) : 동일한 자료형을 하나의 이름으로 관리하는 자료구조<br><br>
		   		&nbsp;&nbsp;- 구조체<br><br>
		   		&nbsp;&nbsp;- 클래스(객체)<br><br>
		   		&nbsp;&nbsp;- 컬렉션<br><br>
		   		&nbsp;&nbsp;&nbsp;1) List interface : 순서를 가지고 있다. 중복을 허용한다.<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- ArrayList, LinkedList, Vector, Stack....<br><br>
		    		&nbsp;&nbsp;&nbsp;2) Set interface : 집합, 순서를 가지고 있지 않다. 중복을 허용하지 않는다.<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- HashSet, TreeSet,<br><br>
		   		&nbsp;&nbsp;&nbsp;3) Map interface: key와 value를 쌍으로 관리하는 자료구조<br><br>
			   	&nbsp;&nbsp;&nbsp;&nbsp;- HashMap, TreeMap, MergeMap....<br><br>
				</h4>
				</div>
				
		<!-- QnA =========================================================================== -->
				<c:import url="/study/qna.jsp"/>
				
			</div>	<!-- 본문 end -->
			
		</div> <!-- wrap end -->
		
		<!-- 글로벌 네비게이션 -->
		<c:import url="/nav/global_nav.jsp"/>
		<c:import url="/footer/footer.jsp"/>
	</body>
</html>
