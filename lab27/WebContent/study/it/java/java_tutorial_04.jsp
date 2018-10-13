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
				<h1>자바 메서드</h1>
				<div class="row">
				<h4>
				1. 메서드의 정의 및 형식<br><br>
		  		&nbsp;&nbsp;1) 정의 : 자주 반복적으로 수행하는 명령이나 기능을 특정 이름으로 묶어서 사용하는 기능<br><br>
		     	&nbsp;&nbsp;&nbsp;- 사용자 정의 메서드 : 호출래서 동작시킨다.<br><br>
		     	&nbsp;&nbsp;&nbsp;- 시스템 메서드(callback 메서드) : 사용자가 호출하는 것이 아니라 시스템이 자동으로 호출하는 메서드<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;main()<br><br>
		  		&nbsp;&nbsp;2) 형식<br><br>
		     	&nbsp;&nbsp;&nbsp;public static void main(String[] ar){...}<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;접근지정자(접근제한자) [지정예약어] 결과리턴값 메서드명(매개변수 throws 예외클래스들 {내용정의부;}<br><br>
		        &nbsp;&nbsp;&nbsp;- 간결화된 형태<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;결과형리턴값 메서드명(매개변수들...){내용정의부...}<br><br>
				</h4>
				</div>
				<div class="row">
				<h4>
				2. 메서드의 종류<br><br>
		   		&nbsp;&nbsp;1) Call By Name : 이름에 의한 호출<br><br>
		     	&nbsp;&nbsp;&nbsp; - 메서드의 이름에 의해 호출되는 메서드로 특정 매개변수 없이 실행된다.<br><br>
		   		&nbsp;&nbsp;2) Call By Value : 값에 의한 호출<br><br>
		        &nbsp;&nbsp;&nbsp;- 메서드를 이름으로 호출할 때 특정 매개변수를 전달하여 그 값을 기초로 실행하는 메소드<br><br>
		   		&nbsp;&nbsp;3) Call By Reference : 참조(주소)에 의한 호출<br><br>
		     	&nbsp;&nbsp;&nbsp;- 메서드 호출 시 매개변수로 사용되는 변수의 값이 아니라 그 값을 담고 있는 주소를 참조하여 실행하는 메서드<br><br>
		     	&nbsp;&nbsp;&nbsp;- reference 변수를 사용한다.<br><br>
				</h4>
				</div>
				<div class="row">
				<h4> 
		 		3. 결과형 리턴값<br><br>
		    		&nbsp;&nbsp;- 메서드를 실행한 후 결과로 되돌려 주는 값을 뜻한다.<br><br>
		    		&nbsp;&nbsp;- return 예약어를 사용한다<br><br>
		    		&nbsp;&nbsp;- 종류<br><br>
		        &nbsp;&nbsp;&nbsp;자바의 8대 자료형 : boolean, byte, char, short, int, long, float, double<br><br>
		      	&nbsp;&nbsp;&nbsp;void : 실행 후 되돌려 줄 값이 없을 때<br><br>
		        &nbsp;&nbsp;&nbsp;참조형 : 클래스형 또는 인터페이스형<br><br>
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
