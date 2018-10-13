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
class Circle {
	// 멤버필드
	int radius; // 반지름을 지정하는 변수

	public Circle() {
		radius = 1;
	}

	// 생성자 메서드
	public Circle(int radius) {
		this.radius = radius;
	}

	// 멤버 메서드
	public void setRadius(int r) {
		this.radius = r;
	}

	public int getRadius() {
		return radius;
	}

	public double getArea() {
		return radius * radius * 3.14;
	}

	// 중첩 클래스
}

public class Exam_01 {
	public static void main(String[] ar) {
		Circle ap = new Circle();
		Circle bp;
		Circle cp;

		Circle[] xp = new Circle[3];

		xp[0] = new Circle();
		xp[1] = new Circle(5);
		xp[2] = new Circle();

		// c1.setRadius(5);
		for (int i = 0; i < xp.length; i++) {
			System.out.println("xp[" + i + "]객체의 반지름 : " + xp[i].getRadius());
		}

		// System.out.println("ap 객체의 원의 면적 : "+ap.getArea());
	}

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
