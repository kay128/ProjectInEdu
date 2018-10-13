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
				<h1>반복문(Loop)</h1>
				<div class="row">
				<h4>
				&nbsp;- 동일하거나 유사한 문장을 반복할 때 사용한다<br><br>
				&nbsp;- 주어진 조건이 참일 때 반복한다.
				</h4>
				</div>
				<div class="row">
				<h4>
				1. for : ~부터 ~까지<br><br>
		    		&nbsp;&nbsp;- 횟수를 통해 반복문을 제어한다.<br><br>
		    		&nbsp;&nbsp;&nbsp;1) 단일 for문 형식 <br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;for(초기식구문 : 조건식구문 ; 증감식구문){<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;반복할 문장;<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>
		        &nbsp;&nbsp;- 초기식 구문 : 반복횟수의 시작값<br><br>
		        &nbsp;&nbsp;- 조건식 구문 : 반복횟수의 마지막값<br><br>
		        &nbsp;&nbsp;- 증감식 구문 : 증가와 감소를 위한 식, 간격<br><br>
		        &nbsp;&nbsp;&nbsp;2) 다중 for문<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- 형식<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for(초기식구문1 ; 조건식구문1  ; 증감식구문1){<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문장1;<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for(초기식구문2 ; 조건식구문2 ; 증감식구문2){<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문장2;<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- 실행순서<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;초1=> 조1 => 거짓 : 프로그램 종료<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=> 문1 => 초2 => 조2<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- 바깥쪽 for문이 한 번 동작할 때  마다 안쪽 for문은 주어진 횟수만큼 반복한다.<br><br>  
				</h4>
				</div>
				<div class="row">
				<h4>
				 2. while : ~하는 동안<br><br>
		    		&nbsp;&nbsp;- 사용자의 행위에 의해 반복을 제어한다.<br><br>
		        &nbsp;&nbsp;- 무한 Loop<br><br>
		    		&nbsp;&nbsp;- 형식<br><br>
		     	&nbsp;&nbsp;&nbsp;while(조건식 구문 or true){<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;반복할 문장<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;//반복을 제어할 문장을 사용한다.<br><br>
		     	&nbsp;&nbsp;&nbsp;}<br><br>
				</h4>
				</div>
				<div class="row">
				<h4> 
		 		3. do~ while : ~할때까지<br><br>
		    		&nbsp;&nbsp;- 조건이 거짓이라도 딱 한번은 수행된다.<br><br>
		    		&nbsp;&nbsp;- 선실행후 조건비교<br><br>
		    		&nbsp;&nbsp;- 형식<br><br>
		     	&nbsp;&nbsp;&nbsp;do {<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;반복문<br><br>
		     	&nbsp;&nbsp;&nbsp;}while(조건식 구문 or true);<br><br>
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
