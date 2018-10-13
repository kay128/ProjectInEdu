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
				<h1>자바의 GUI 프로그래밍 : javax.swt.*;</h1>
				<div class="row">
				<h4>
				1. GUI : Graphics User Interface<br><br>
		  		&nbsp;&nbsp;- 그래픽 화면을 통해 사용자와 시스템간의 커뮤니케이션을 도와주는 프로그램 기술<br><br>
		  		&nbsp;&nbsp;- AWT과 Swing(JFC) 기술을 이용한다.<br><br>
		  		&nbsp;&nbsp;&nbsp;1) Frame : 프레임<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- GUI 작업환경에서의 Base Form<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 생성<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Frame 객체를 생성하는 방법<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Frame 상속받아 구현하는 방법(권장)<br><br>
		  		&nbsp;&nbsp;&nbsp;2)배치 관리자(Layout Manager)<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 프레임에 컴포넌트를 배치할 때 사용하는 객체<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- FlowLayout : 물 흐르듯 순서대로(차례차례) 컴포넌트 배치하는 관리자<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- GridLayout : 행과 열의 값을 주고 배치하는 관리자<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- BorderLayout : 다섯개의 방향을 가지고 있는 배치관리자<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;North, South, West, East, Center<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- CardLayout : 여러개의 컴포넌트를 겹쳐놓고 하나씩 보여주는 배치관리자<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- GridBagLayout : 전문적인 배치를 도와주는 배치관리자<br><br>
		     	&nbsp;&nbsp;&nbsp;3) Panel : Container의 일종<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 여러개의 컴포넌트를 담아서 관리하는 객체<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- 독립적인 배치관리자를 적용할 수 있다.<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- Panel 안에 또 다른 Panel을 담을 수 있다.<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- Frame안에서 독립적으로 관리한다.<br><br>
		  		&nbsp;&nbsp;&nbsp;4) 주변 컴포넌트<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- java.awt.Label 클래스<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- java.awt.TextField & TextArea 클래스<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- java.awt.Button 클래스<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- java.CheckBox 클래스<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- java.awt.CheckboxGroup 클래스<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- java.awt.Choice 클래스<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- java.awt.List 클래스<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- java.awt.Dialog & FileDialog<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- java.awt.Menu & MenuItem 클래스<br><br>
		     	&nbsp;&nbsp;&nbsp;5) 모든 컴포넌트에 사용되는 공통 메서드<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- setBackground(Color) 배경색<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- setForeground(Color) 전경색<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- setFont(Font) 글꼴, getFont()<br><br>
		    		&nbsp;&nbsp;&nbsp;&nbsp;- setOpaque(boolean) 불투명성 설정<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- setEnable(boolean) 활성화와/비활성화<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- setVisible(boolean) 보이기/숨기기<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- setSize(int, int) 크기 지정<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- setLocation (int, int) 위치 지정<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- getWidth() 폭 리턴<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- getHeigh() 높이 리턴<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- getX() x좌표 리턴<br><br>
		     	&nbsp;&nbsp;&nbsp;&nbsp;- getY() y좌표 리턴<br><br>
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
