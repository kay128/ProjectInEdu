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
 * 세 개의 정수를 입력받아 크기 순으로 출력하시오  
 */
import java.util.Scanner;

public class Exam_03 {
	// 멤버 필드

	// 생성자 메서드
	public static void main(String[] ar) {

		// 선언문
		int num1, num2, num3, max = 0, min = 0, mid = 0;
		int imsi;
		Scanner sc = new Scanner(System.in);

		// 입력문
		System.out.print("첫번째 수 =");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 수 =");
		num2 = Integer.parseInt(sc.nextLine());
		System.out.print("세번째 수 =");
		num3 = Integer.parseInt(sc.nextLine());
		// 처리문
	

		if (num2 >= num1 && num2 >= num3) {
			imsi = num1;
			num1 = num2;
			num2 = imsi;
		} else if (num3 >= num1 && num3 >= num2) {
			imsi = num1;
			num1 = num3;
			num3 = imsi;
		}
		if (num3 >= num2) {
			imsi = num2;
			num2 = num3;
			num3 = imsi;
		}

		// 출력문
		System.out.println(num1 + ">>" + num2 + ">>" + num3);
		System.out.println("프로그램을 종료합니다.");

	}

	// 멤버 메서드

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
