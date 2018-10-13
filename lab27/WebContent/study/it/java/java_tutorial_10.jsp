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
				<h1>자바의 Thread와 Exception</h1>
				<div class="row">
				<h4>
				1. Thread & Multi-Thread<br><br>
		   		&nbsp;&nbsp;1) Thread의 정의<br><br>
		      	&nbsp;&nbsp;&nbsp;- Multi-tasking == Multi-programming(다중 프로그래밍)== Multi-Processing(다중 처리)<br><br>
		      	&nbsp;&nbsp;&nbsp;- 시작점과 진행 그리고 종료점을 가지고 있는 하나의 작업 단위(흐름)<br><br> 
		   		&nbsp;&nbsp;2) 단일스레드와 다중스레드<br><br>
		      	&nbsp;&nbsp;&nbsp;- TSS(RR) : Time sharing System(시분할 처리)<br><br>
		        &nbsp;&nbsp;3) Thread를 생성하는 클래스 : Thread class, Runnable interface<br><br>
		   		&nbsp;&nbsp;4) Thread 우선순위<br><br>
		   		&nbsp;&nbsp;5) 독립 Thread 데몬 Thread<br><br>
		   		&nbsp;&nbsp;&nbsp;- 독립 Thread : main 쓰레드의 동작이 끝나도 자신의 Thread 작업이 남아있다면 진행한다.<br><br>
		   		&nbsp;&nbsp;&nbsp;- 데몬 Thread = 종속 Thread : main Thread의 동작이 끝나면 자신의 Thread의 작업이 남아있어도 끝난다.<br><br>
		   		&nbsp;&nbsp;6) 동기화 : 멀티스레드를 구현할 때 공유자원에 대한 lock을 걸어야 된다.<br><br>
				</h4>
				</div>
				<div class="row">
				<h4>
				2. 예외(Exception)와 에러(Error)<br><br>
		    		&nbsp;&nbsp;1) 예외란? : 개발자가 예측할 수 있는 문제<br><br>
		       	&nbsp;&nbsp;&nbsp;- 프로그램을 실행하는 도중에 예상치 못한 문제가 발생하는 현상<br><br>
		    		&nbsp;&nbsp;2) 예외처리와 관련된 예약어<br><br>
		        &nbsp;&nbsp;&nbsp;- throw : 예외 강제발생(개발자)<br><br>
		        &nbsp;&nbsp;&nbsp;- throws : 예외전가<br><br>
		       	&nbsp;&nbsp;&nbsp;- try ~ catch ~ finally : 예외 처리<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;try{<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//예외가 발생할 문구<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;}catch(예외클래스){<br><br>
		        &nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;//예외처리문구<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;}finally{<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//예외 발생 유무와 상관없이 실행할 문구<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;}<br><br>
		    		&nbsp;&nbsp;3) 예외처리를 사용하는 용도<br><br>
		       	&nbsp;&nbsp;&nbsp;- 정상종료<br><br>
		        &nbsp;&nbsp;&nbsp;- 예외보고<br><br>
		        &nbsp;&nbsp;&nbsp;- 계속<br><br>
		        &nbsp;&nbsp;&nbsp;- 대안적 결과<br><br>
		    		&nbsp;&nbsp;4) 사용자 정의 예외 : customer(사용자에 의해 생성되는)<br><br>
		        &nbsp;&nbsp;&nbsp;- Exception 클래스 상속받아 구현<br><br>
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
