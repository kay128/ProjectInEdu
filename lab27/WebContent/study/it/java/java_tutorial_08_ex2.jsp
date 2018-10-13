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
package inheritance.test;

/**
 * 
 * @author Administrator
 *1. 원 2. 사각형 3. 종료 =1
 *x=
 *y=
 *r=
 *점(x,y) = (0,0)
 *반지름(r) = 3
 *1.원 2.사각형 3.종료=2
 *x=10
 *y=10
 *w=20
 *h=8
 *점(x,y) = (10, 10)
 *너비(w) = 20, 높이(h) = 8
 */
import java.util.Scanner;

class Point {
	private int x;
	private int y;
	protected Scanner sc;

	public Point() {
		sc = new Scanner(System.in);
		System.out.print("x=");
		x = Integer.parseInt(sc.nextLine());
		System.out.print("y=");
		y = Integer.parseInt(sc.nextLine());
	}

	public void show() {
		System.out.println("점(x,y)=(" + x + "," + y + ")");
	}
}

class Circle extends Point {
	private int r;

	public Circle() {
		System.out.print("r=");
		r = Integer.parseInt(sc.nextLine());
	}

	public void show() {
		// System.out.println("점(x,y)=("+x+","+y+")");
		super.show();
		System.out.println("r = " + r);
	}
}

class Rect extends Point {

	private int w;
	private int h;

	public Rect() {
		System.out.print("w=");
		w = Integer.parseInt(sc.nextLine());
		System.out.print("h=");
		h = Integer.parseInt(sc.nextLine());
	}

	public void show() {
		// System.out.println("점(x,y)=("+x+","+y+")");
		super.show();
		System.out.println("w = " + w + ", h =" + h);
	}

}

public class Exam_06 {
	public static void main(String[] ar) {
		Circle cp = new Circle();
		cp.show();

		Rect rp = new Rect();
		rp.show();
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
