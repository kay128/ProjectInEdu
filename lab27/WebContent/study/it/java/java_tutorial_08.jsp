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
				<h1>자바의 상속과 다형성</h1>
				<div class="row">
				<h4>
				1. 자바의 상속(Inheritance)p310<br><br>
		   		&nbsp;&nbsp;1) Object와 super<br><br>
		      	&nbsp;&nbsp;&nbsp;- 포함 Object(객체안에 또 다른 클래스의 객체를 포함하고 있는 형태)의 단점을 보완하기 위해<br><br>
		      	&nbsp;&nbsp;&nbsp;&nbsp;모든 클래스의 객체를 통해 멤버에 접근한다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- 키워드 : extends<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;class 자녀클래스 extends 부모클래스{...}<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;자녀 클래스 = 하위 클래스 = 파생 클래스<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;부모 클래스 = 상위 클래스 = 기반 클래스<br><br>
		    		&nbsp;&nbsp;&nbsp;- 최상위 클래스 : java.lang.Object<br><br>
		  		&nbsp;&nbsp;2) 자바에서 생략된 개념으로 사용되는 것들<br><br>
		     	&nbsp;&nbsp;&nbsp;- import java.lang.*;<br><br>
		      	&nbsp;&nbsp;&nbsp;- default 생성자<br><br>
		     	&nbsp;&nbsp;&nbsp;- this<br><br>
		      	&nbsp;&nbsp;&nbsp;- extends Object<br><br>
		      	&nbsp;&nbsp;&nbsp;- toString()<br><br>
		      	&nbsp;&nbsp;&nbsp;- super()<br><br>  
		 		&nbsp;&nbsp; 3) this()와 super()
		     	&nbsp;&nbsp;&nbsp;- this() : 자신의 클래스의 또 다른 생성자를 호출하는 메서드
		     	&nbsp;&nbsp;&nbsp;- super() : 상위 클래스의 생성자를 호출하는 메서드
		     	&nbsp;&nbsp;&nbsp;- this : 자신의 객체를 가르키는 키워드
		     	&nbsp;&nbsp;&nbsp;- super : 상위 객체를 가르키는 키워드
				</h4>
				</div>
				<div class="row">
				<h4>
				2. 멤버필드와 멤버메서드의 상속<br><br>
		   		&nbsp;&nbsp;1) 필드의 상속과 접근제한자 : protected<br><br>
		     	&nbsp;&nbsp;&nbsp;- super와 this 예약어를 통한 접근<생략하면 this로 간주한다.><br><br>
		      	&nbsp;&nbsp;2) 메서드의 상속과 메서드 재정의<br><br>
		      	&nbsp;&nbsp;&nbsp;- 메서드 오버라이딩(재정의)<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;: 부모가 가지고 있는 메서드와 형태와 이름이 일치하는 메서드를 자식이 재정의해서 사용하는 기능<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;단, 부모보다 접근제한자가 크거나 같아야 하고, 예외문구 주의해야 한다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- 메서드 오버로딩(다중함수, 다중매서드)<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;: 같은 이름을 가진 메서드를 여러개 만들어 사용하는 기능<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;단, 매개변수의 개수가 다르거나 데이터타입이 달라야 한다.<br><br> 
		        &nbsp;&nbsp;&nbsp;- final 메서드의 제약 : 재정의 불가<br><br>  
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
