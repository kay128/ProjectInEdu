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

/*
 * 하나의 숫자를 입력받아 양수인지 판단하는 문장을 구현하시오
 */
import java.util.Scanner;

public class Exam_01 {
	// 멤버 필드

	// 생성자 메서드

	// 멤버 메서드
	public static void main(String[] ar) {
		// 선언문
		Scanner sc = new Scanner(System.in);
		int num;
		// 입력문
		System.out.print("숫자 = ");
		num = Integer.parseInt(sc.nextLine());

		// 처리문
		if (num > 0) {
			System.out.println("입력받은" + num + "은 양수입니다.");
		} // if end
		else if (num < 0) {
			System.out.println("입력받은" + num + "은 음수입니다.");
		} else {
			System.out.println("입력받은" + num + "은 0입니다.");
		}

		// 처리문
		System.out.println("프로그램을 종료합니다.");
	}// main end

	// 중첩 클래스

}// class end		
		
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
