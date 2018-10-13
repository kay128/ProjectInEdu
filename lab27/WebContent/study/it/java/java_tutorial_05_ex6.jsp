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
 * 입력받은 도시명과 배열에 지정된 도시명이 같다면 몇번째 위치한 도시인지 인덱스 값을 출력하라
 * 그렇지 않다면 존재하지 않습니다. 라는 메시지가 출력되도록 구현하시오.
 */
import java.util.Scanner;

public class Exam_12 {
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		String[] cities = { "서울", "대전", "부산", "제주", "인천", "창원", "울산", "광주", "충주" };
		int result = 0;
		int index = 0;
		System.out.print("현주소 = ");
		String city = sc.nextLine();
		// System.out.print(city);

		// 입력받은 도시명과 배열에 지정된 도시명이 같다면 몇번째 위치한 도시인지 인덱스 값을 출력하라
		// 그렇지 않다면 존재하지 않습니다. 라는 메시지가 출력되도록 구현하시오.

		while (true) {

			if (cities[index].equals(city)) {
				System.out.println("인덱스=" + index);
				break;
			}
			index++;

			if (index == cities.length) {
				System.out.println("존재하지 않습니다.");
				break;
			}
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
