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
 * 다음 주어진 입출력 형식에 맞게 동작되도록 프로그래밍 하시오
 * <입력 및 출력형식>
 * 작업(1. 최대값 2. 사이합 3.수나열 4.계산기 5.종료
 * 선택 = 1
 * 첫번째 수 = 7
 * 두번째 수 = 11
 * 최대값
 * 
 * 선택 =2
 * 첫번째수 = 5
 * 두번째 수 = 1
 * 
 * 사이합 = 15
 * 
 * 선택 =3
 * 첫번째수 = 7
 * 두번째수 = 5 
 * 세번째수 = 10
 * 수나열 10>= 7 >= 5
 * 
 * 선택 = 4
 * 
 * 선택 = 5
 * 프로그램을 종료합니다.
 * 
 * <처리조건>
 * 1.최대값이 선택되면 두 개의 정수를 입력받아 큰 수가 출력되도록 구현한다
 * 2.사이합이 선택되면 두 개의 정수를 입력받아 두 수 사이의 자연수들의 합을 계산하여 출력되도록 구현한다.
 * 3.수나열이 선택되면 세 개의 정수를 입력받아 큰 순서대로 나열하여 출력되도록  구현한다.
 * 
 */
import java.util.Scanner;

public class Exam_09 {
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		int menu;

		while (true) {// 무한 Loop
			System.out.println();
			System.out.println("작업(1.최대값 2.사이합 3.수나열 4.계산기 5.종료)");
			System.out.print("선택 =");
			menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {

			} else if (menu == 2) {

			} else if (menu == 3) {

			} else if (menu == 4) {

			} else if (menu == 5) {
				// System.out.println("프로그램을 종료합니다.");
				break;
				// System.exit(0);
			} else {

			}

		}
		System.out.println("프로그램을 종료합니다.");
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
