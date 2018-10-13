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
				<h1>제어문</h1>
				<div class="row">
					<h4>
					1. 정의<br><br>
			        &nbsp;&nbsp;- 프로그램의 흐름이나 순서를 제어하는 문장<br><br>
			    		&nbsp;&nbsp;- 위에서 아래로, 좌에서 우로 진행<br><br>
			        &nbsp;&nbsp;&nbsp;1) 선택문 == 조건문 == 비교/판단문<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 주어진 주건에 따라 실행을 달리하는 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 종류 : if문, switch문<br><br>
			    		&nbsp;&nbsp;&nbsp;2) 반복문<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 반복하는 문장을 제어할 때 사용하는 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 동일한 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 유사한 문장 : 동일한 행위(메서드, 함수)를 하되 일정한 규칙을 가지고 있는 문장<br><br>
			    		&nbsp;&nbsp;&nbsp;3) 기타 제어문<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- break문 : 벗어나라<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- continue문 : 건너띄어라<br><br>
					</h4>
					</div>
					<div class="row">
					<h4>
					2. 선택문 == 조건문 == 비교/판단문<br><br>
			    		&nbsp;&nbsp;&nbsp;1) 단순 if 문<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 주어진 조건이 참일때만 실행할 문장을 제어할 대 사용한다.<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 형식<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if(논리조건문){<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주어진 조건이 참일 때 실행할 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>
			   		&nbsp;&nbsp;&nbsp;2) if~else문 : 삼항연산자(항을 세개가지고 있는 연산자)<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 단순 if문 확장한 형태로 주어진 조건이 참 또는 거짓일 때 실행할 문장을 제어한다.<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 형식<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if(논리조건문){<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주어진 조건이 참일 때 실행할 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}else{<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주어진 조건이 거짓일 때 실행할 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>    
			        &nbsp;&nbsp;&nbsp;3) 다중 if문 : if 문 안에 또 다른 if문을  담는 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 여러개의 조건문에 의해 실행결과를 제어하는 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 형식<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if(논리조건문1){<br><br>
			        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주어진 조건1이 참일 때 실핼할 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}else if(논리조건문2){<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주어진 조건<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>
			        &nbsp;&nbsp;&nbsp;4) switch - case ~ break 문<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 특정값에 결과에 따라 이동하여 처리하는 문장<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 다중 if문보다 처리속도가 빠르다<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 형식<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;switch(수치 or 문자){<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;case<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>
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
