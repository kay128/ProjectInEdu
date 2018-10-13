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

/**
 * 
 * @author Administrator
 * 두 개의 정수와 하나의 연산자를 입력받아 계산식을 완성한 후 결과를 출력하는 프로그램을 구현하시오
 * (입력 및 출력 형식)
 *  
 */
import java.util.Scanner;

public class Exam_08 {
	public static void main(String[] ar) {

		int num1 = 0, num2 = 0, result = 0;
		char op = '\n';
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째수 =");
		num1 = Integer.parseInt(sc.nextLine());
		do {
			System.out.print("연산자 ('+','-','*','/')");
			op = sc.nextLine().charAt(0);

		} while (op != '+' && op != '-' && op != '*' && op != '/');
		// while 조건

		do {
			System.out.print("두번째수=");
			num2 = Integer.parseInt(sc.nextLine());
		} while (op == '/' && num2 == 0);

		switch (op) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		}

		System.out.println();// 계행
		System.out.println(num1 + " " + num2 + " " + " = " + result);

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
