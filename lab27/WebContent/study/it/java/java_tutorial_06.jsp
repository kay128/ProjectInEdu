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
				<h1>다차원 배열:2차원 배열</h1>
					<div class="row">
					<h4>
					1. 2차원 배열 선언하는 방법<br><br>
			   		&nbsp;&nbsp;- 자료형[][] 배열명;<br><br>
			   		&nbsp;&nbsp;- 자료형[] 배열명[];<br><br>
			   		&nbsp;&nbsp;- 자료형 배열명[][];<br><br>
			   		&nbsp;&nbsp;&nbsp;int[] x, y[];//int[] x int[] y[];<br><br>
					</h4>
					</div>
					<div class="row">
					<h4>
					2. 2차원 배열의 초기화<br><br>
			  		&nbsp;&nbsp;- 배열명 = new 자료형[첨자1][첨자2] //첨자1-행, 첨자2- 열<br><br>
			  		&nbsp;&nbsp;- 배열명 = new 자료형[][]{{...},{....}}<br><br>
			  		&nbsp;&nbsp;- 배열명 = new 자료형[개수][]; //동적 배열<br><br>
					</h4>
					</div>
					<div class="row">
					<h4> 
					 3. 2차원 배열의 특징<br><br>
			   		 &nbsp;&nbsp;- 다차원 배열에서 각 영역은 모두 Reference 영역이고, 마지막 배열 공간만 실제 데이터가 저장되는 공간이다.<br><br>
			   		 &nbsp;&nbsp;- 다차원 배열은 단일 차원 배열로 구성된다.(즉, 1차원의 중복이 2차원 배열이다.)<br><br>
			   		 &nbsp;&nbsp;- 다차원 배열은 다중 for문과 함께 사용된다.<br><br>
			   		 &nbsp;&nbsp;- 다차원 배열은 동적 배열이 가능하다.<br><br>
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
