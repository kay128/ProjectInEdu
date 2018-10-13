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
			<div class="row">
			<pre>

class Person {
	// 멤버 필드
	String name;

	// 생성자 메서드

	// 멤버 메서드
	public void walk(int speed) {
		System.out.println(name + " 이/가" + speed + " 속도로 걸어갑니다.");
	}

	public void run(int speed) {
		System.out.println(name + " 이/가" + speed + " 속도로 뛰어갑니다.");
	}

	// 중첩 클래스

}

public class Exam_01 {
	// 멤버 필드

	// 생성자 메서드

	// 멤버 메서드
	public static void main(String[] ar) {
		// 객체 생성
		// Person people;
		// people = new Person();
		Person people = new Person();

		people.name = "영희";
		people.walk(10);
		people.run(30);

		Person boy = new Person();
		boy.name = "철수";
		boy.walk(20);
		boy.run(40);

		Person girl = new Person();
		girl.name = "꽃순";
		girl.walk(5);
		girl.run(30);

	}

	// 중첩 클래스

}
			</pre>
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
