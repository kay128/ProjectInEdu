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
class A extends Thread {// 단일상속
	public void run() { // Thread에서 main() 메서드 역할을 수행하는 메서드
		System.out.println("A");
	}

}

class B extends Object implements Runnable {

	@Override
	public void run() {
		System.out.println("B");

	}// 다중 상속

}

public class Exam_01 {

	public static void main(String[] args) {
		// System.out.println("활동중인 쓰레드 ="+Thread.activeCount());
		// System.out.println("현재 진행중인 스레드 이름 = " + Thread.currentThread().getName());

		A ap = new A();
		B bp = new B();

		// ap.run();
		// bp.run();

		ap.start(); // 시스템의 영역
		// bp.start();
		Thread th = new Thread(bp);
		th.start();

		for (int i = 1; i <= 100; i++) {
			System.out.print(i);
			if (i % 10 == 0)
				System.out.println();
			else
				System.out.print("\t");
		}

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
