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
				<h1>연산자</h1>
				<div class="row">
					<h4>
					1. 개념정리<br><br>
			    		&nbsp;&nbsp;- 피연산자(상수, 변수 등) 사이에서 계산을 수행하기 위해 사용되는 예약어 또는 기호들<br><br>
					</h4>
					</div>
					<div class="row">
					<h4>
					 2. 최우선 연산자<br><br>
			    		 &nbsp;&nbsp;- [], (), .<direct 연산자><br><br>
			    		 &nbsp;&nbsp;- 단항연산자 : 피연산자 1개 가지고 있는 연산자<br><br>
			         &nbsp;&nbsp;&nsp;논리부정(!, NOT), 비트부정(~, NOT)<br><br>
			         &nbsp;&nbsp;&nbsp;증감연산자(++/--):전위연산자(++a, --b)<br><br>
			         &nbsp;&nbsp;&nbsp;부호연산자(+/-) : -10+5<br><br>
					</h4>
					</div>
					<div class="row">
					<h4> 
					3.산술연산자 : 사칙연산을 수행하는 연산자<br><br>
			 		&nbsp; - + ,-, *,/(몫), %(나머지)<br><br>
			  		&nbsp;&nbsp;- 주의!!!<br><br>
			  		&nbsp;&nbsp;&nbsp;int형보다 적은 크기의 정수형은 연산의 결과를 반드시 int형에 담아야 한다<br><br><br><br>
			  
			  		&nbsp;&nbsp;&nbsp;정수와 정수 = 정수<br><br>
			  		&nbsp;&nbsp;&nbsp;실수와 실수 = 실수<br><br>
			  		&nbsp;&nbsp;&nbsp;정수와 실수 = 실수<br><br>
					</h4>
					</div>
					<div class="row">
					<h4>
					 4. 쉬프트 연산자 : 자료이동과 산술연산<br><br>
			    		&nbsp;&nbsp;- left shift : 원값*2^(이동한 비트수)<br><br>
			    		&nbsp;&nbsp;- right shift : 원값/2^(이동한 비트수)<br><br>
			   		&nbsp;&nbsp;- unsigned right shift(>>>)<br><br>
					</h4>
					</div>
					<div class="row">
					<h4>
					5.관계, 비트&논리 연산자<br><br>
			   		&nbsp;&nbsp;1) 관계 연산자<br><br>
			      	&nbsp;&nbsp;&nbsp;- 비교 : >,<,>=,<=<br><br>
			      	&nbsp;&nbsp;&nbsp;- 항등 : ==, !=<br><br>
			      
			   		&nbsp;&nbsp;2)비트 연산자<br><br>
			     	&nbsp;&nbsp;&nbsp;- ~:NOT<br><br>
			     	&nbsp;&nbsp;&nbsp;- & : AND<br><br>
			     	&nbsp;&nbsp;&nbsp;- | : OR
			     
			   		&nbsp;&nbsp;3)논리 연산자<br><br>
			     	&nbsp;&nbsp;&nbsp;- !: NOT(논리부정)<br><br>
			     	&nbsp;&nbsp;&nbsp;- && : AND(논리곱), 두 논리값이 모두 참이여야 결과가 참이된다<br><br>
			     	&nbsp;&nbsp;&nbsp;- || : OR(논리합), 두 논리값이 어느 거 하나라도 참이면 결과가 참이된다<br><br>
			     	&nbsp;&nbsp;&nbsp;- ^  : XOR(배타적 논리합), 논리값이 서로 다를때만 참이 된다<br><br>
					</h4>
					</div>
					<div class="row">
					<h4>
					6. 삼항 연산자<br><br>
			    		&nbsp;&nbsp;- 항을 세개 가지고 있는 연산자<br><br>
			    		&nbsp;&nbsp;- if ~ else 제어문의 모체가 된다.<br><br>
			    		&nbsp;&nbsp;- 형식<br><br>
			       	&nbsp;&nbsp;&nbsp;변수 = 조건항? 항1 : 항2;<br><br>
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
