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
import java.util.Scanner;

public class Exam_06 {
	public static int add(int su1, int su2) {
		return su1 + su2;
	}

	public static int substract(int su1, int su2) {
		int imsi = 0;

		if (su1 > su2) {
			imsi = su1 - su2;
		} else {
			imsi = su2 - su1;
		}

		return imsi;
	}

	public static int multiply(int su1, int su2) {
		return su1 * su2;
	}

	public static int divide(int su1, int su2) {
		if (su2 == 0)
			su2 = 1;
		return su1 / su2;
	}

	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		int first = 0, second = 0, res = 0;
		char op = 0;

		System.out.print("첫번째수 = ");
		first = Integer.parseInt(sc.nextLine());
		do {
			System.out.print("연산자");
			op = sc.nextLine().charAt(0);
		} while (op != '+' && op != '-' && op != '*' && op != '/');

		do {
			System.out.print("두번째수 = ");
			second = Integer.parseInt(sc.nextLine());
		} while (op == '/' && second == 0);

		switch (op) {
		case '+':
			res = add(first, second);
			break;
		case '-':
			res = substract(first, second);
			break;
		case '*':
			res = multiply(first, second);
			break;
		case '/':
			res = divide(first, second);
			break;
		}

		System.out.println(first + "" + (char) op + "" + second + " = " + res);

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
