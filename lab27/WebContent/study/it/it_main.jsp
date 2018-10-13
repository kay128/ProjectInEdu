<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
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
				<h1>변수 상수 그리고 자료형</h1>
				<div class="row">
					<h4>
					1. 변수(Variable)<br><br>
			   		&nbsp;&nbsp;-상수가 저장되는 메모리의 기억공간(기억장소)<br><br>
					</h4>
					</div>
					<div class="row">
					<h4>
					2. 상수(Constant)<br><br>
					   &nbsp;&nbsp;- 컴퓨터가 처리할 수 있는 형태의 데이터, 값<br><br>
					   &nbsp;&nbsp;&nbsp;1) 수치형 데이터(숫자) : 10진수, 2진수, 8진수, 16진수(0-9, A, B, C, D, E, F)<br><br>
					   &nbsp;&nbsp;&nbsp;&nbsp;-정수형 : 10, 010, 0x10, 100(int), 100L(long)<br><br>
					   &nbsp;&nbsp;&nbsp;&nbsp;-실수형 : 12.345(double-8byte), 12,345f(float-4byte), 1.12345678912, 100.23<br><br>
					   &nbsp;&nbsp;&nbsp;2) 비수치형 데이터(문자)<br><br>
				       &nbsp;&nbsp;&nbsp;&nbsp;- 문자형 상수 : ' ', '1'<br><br>
				       &nbsp;&nbsp;&nbsp;&nbsp;- 문자열형 상수 : "", 'K', "k"<br><br>
					</h4>
					</div>
					<div class="row">
					<h4>
					 3.자료형(Data Type)<br><br>
			   		&nbsp;&nbsp;- 변수와 상수의 크기를 규정해 놓은 것<br><br>
			   		&nbsp;&nbsp;- 기본자료형과 참조형 자료형이 있다.<br><br>
			   		&nbsp;&nbsp;&nbsp;1) 자바의 8대 자료형 : 기본 자료형, 값을 저장하는 공간<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- boolean : 1byte(8bits), -128-127<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- short : 2byte, -32768 - 32767<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- char : 2byte, 0 ~ 65535, 양의 정수만 저장 가능<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- int : 4byte, ,기본자료형<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- long : 8byte<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- float : 4byte<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- double : 8byte, 기본자료형<br><br>                       
			 		&nbsp;&nbsp;&nbsp;2) 참조형 자료형 : 주소를 저장하는 공간, 4Byte 객체<br><br>
			       	&nbsp;&nbsp;&nbsp;&nbsp;- 클래스명, 인터페이스명(유일하게 다중 상속)<br><br>
					</h4>
					</div>
					<div class="row">
					<h4 class="row">
					&nbsp;&nbsp;4.형변환<br><br>
				    &nbsp;&nbsp;&nbsp;1) casting : 강제 형변환, 명시적 형변환<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- 큰 데이터를 작은 크기에 담는다.<br><br>
			        &nbsp;&nbsp;&nbsp;2) 자료형의 크기순<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- boolean : 불가능<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- byte < short < int < long < float < double : => promotion / <= casting<br><br>
			        &nbsp;&nbsp;&nbsp;&nbsp;- char : 반드시 casting이 필요한 자료형이다.
			        &nbsp;&nbsp;&nbsp;&nbsp;왜? 음수를 담을 수 없다.
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
