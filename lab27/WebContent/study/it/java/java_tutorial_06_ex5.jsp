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

public class Exam_07 {
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		int[] num[] = null;// 배열명은 Reference 객체이다.

		System.out.print("몇행 =");
		int row = Integer.parseInt(sc.nextLine());

		num = new int[row][];

		for (int i = 0; i < num.length; i++) {
			System.out.print(i + "번째 행의 열=");
			int column = Integer.parseInt(sc.nextLine());

			num[i] = new int[column];
		}

		System.out.println();

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				System.out.println("num[" + i + "][" + j + "]=" + num[i][j]);
			}
			System.out.println();
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
