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
				<h1>배열(Array)</h1>
				<div class="row">
				<h4>
				1. 개념정리<br><br>
		   		&nbsp;&nbsp;1) 자료구조 : 컴퓨터가 처리할 수 있는 형태의 값(data, 자료)을 효율적으로 관리하는 기능<br><br>
		       	&nbsp;&nbsp;&nbsp;- 변수 (Variable) : 하나의 데이터를 저장하는 기억공간<br><br>
		       	&nbsp;&nbsp;&nbsp;- 배열 (Array) :  동일한 자료형을 하나의 이름으로 묶어서 관리하는 자료구조<br><br>
		       	&nbsp;&nbsp;&nbsp;- 구조체 (struct) : 서로 다른 자료형을 하나의 이름으로 묶어서 관리하는 자료구조<br><br>
		       	&nbsp;&nbsp;&nbsp;- 클래스 (class) : 구조체를 확장한 개념<br><br>
		   		&nbsp;&nbsp;2) 배열의 정의<br><br>
		      	&nbsp;&nbsp;&nbsp;- 기억공간의 낭비를 줄인다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- 연속된 공간에 데이터를 저장하기 때문에 처리속도가 빠르다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- 유사문구가 생성되어 반복처리가(for문) 가능하다<br><br>
				</h4>
				</div>
				<div class="row">
				<h4>
		 		2. 단일차원 재열(1차원 배열)<br><br>
		   		&nbsp;&nbsp;1) 선언하는 방법<br><br>
		      	&nbsp;&nbsp;&nbsp;- 자료형[] 배열명;<br><br>
		      	&nbsp;&nbsp;&nbsp;- 자료형 배열명[]; //c-스타일<br><br>
		   		&nbsp;&nbsp;2) 초기화 또는 할당<br><br>
		      	&nbsp;&nbsp;&nbsp;- 배열명 = new 자료형[배열의 크기];<br><br>
		      	&nbsp;&nbsp;&nbsp;- 배열명 = new 자료형[]{초기값, 초기값,...};<br><br>
		      	&nbsp;&nbsp;&nbsp;- 배열명 = {초기값, 초기값,....}<br><br>
		   		&nbsp;&nbsp;3) 단일 차원 배열의 특징<br><br>
		      	&nbsp;&nbsp;&nbsp;- 배열명은 4byte Reference 객체이다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- 배열의 길이는 length 속성을 이용할 수 있다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- 배열의 실제 데이터는 Heap 영역에 저장된다.<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;new연산자의 의미 : 동적할당 하라는 의미다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- Garbage Collection에 의해 소멸된다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- 각 공간은 첨자로 구분된다.<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;첨자의 시작은 0부터이다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- 공간의 값은 자동으로 default 초기화 된다.<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;일반적으로 지역변수는 초기값을 주어야 하지만 배열은 초기값을 주지 않아도 자동으로 할당된다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- 동적으로 공간 할당이 가능하다<br><br>
				</h4>
				</div>
				<div class="row">
				<h4> 
		 		3. main Method의 String 배열의 의미<br><br>
		     	&nbsp;public static void main(String[] ar){..}<br><br>
		     	&nbsp;&nbsp;- 용도 : 프로그램 시작시 초기값을 전달하기 위해<br><br>
		     	&nbsp;&nbsp;- 형식 : java 클래스명 초기값, 초기값<br><br>
		     	&nbsp;&nbsp;- 배열의 길이 : ar.length<br><br>
		     	&nbsp;&nbsp;- 종료 Method : System.exit(처리수);<br><br>
		       	&nbsp;&nbsp;&nbsp;System.exit(0);<br><br>
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
