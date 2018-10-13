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
				<h1>자바의 이벤트 처리</h1>
				<div class="row">
				<h3>자바의 이벤트 처리</h3>
				<h4>
				1. Event : 이벤트<br><br>
		   		&nbsp;&nbsp;- 어떤 행위에 의한 결과(동작)을 기술하는 것<br><br>
		   		&nbsp;&nbsp;&nbsp;1) 구성요소<br><br>
		      	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트 소스<br><br>
		      	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트 객체<br><br>
		      	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트 리스너<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트 핸들러<br><br>
		   		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ex> 버튼을 클릭하면 안녕이라고 출력한다.<br><br>
		      	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트 소스 : 버튼<br><br>
		      	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트 핸들러 (메서드) : 안녕이라는 출력을<br><br>
		      	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트 객체 : 클릭<br><br>
		   		&nbsp;&nbsp;&nbsp;2) 이벤트 처리 위해 사용되는 객체<br><br> 
		      	&nbsp;&nbsp;&nbsp;&nbsp;Event => Adapter<br><br>
		      	&nbsp;&nbsp;&nbsp;&nbsp;Listener<br><br>
		      	&nbsp;&nbsp;&nbsp;3) 이벤트 객체 정보<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트 종류<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트 소스<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 이벤트가 발생한 좌표값<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 버튼이나 메뉴 아이템 등의 문자열<br><br>
		    	 	&nbsp;&nbsp;&nbsp;&nbsp;- 클릭한 마우스 버튼 번호<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 마우스 클릭 횟수<br><br>
		    	 	&nbsp;&nbsp;&nbsp;&nbsp;- 눌러진 키의 코드값과 문자값<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 체크박스, 라디오버튼등의 체크 상태<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;등등<br><br>
		     	&nbsp;&nbsp;&nbsp;4) 중요메서드<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;- getSource() : Object<br><br>
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
