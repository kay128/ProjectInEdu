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
 * 두 사람이 하는 가위바위로 게임을 구현하시오
 * <처리조건>
 * 1. 두 사람의 이름은 '철수'와 영희'이다
 * 2. 먼저 '철수' 이름을 출력하고 가위, 바위, 보 중 하나의 문자열을 입력받는다.
 * 3. 영희 이름을 출력하고 같은 방법으로 문자열을 입력받는다.
 * 4. 두 사람으로 부터 입력받은 문자열 값을 이용하여 승자가 누구인지 판별하여 출력하는 프로그램
 *
 */
import java.util.Scanner;

public class Exam_08 {
	// 멤버 필드
	// 생성자 메서드
	// 멤버 메서드
	public static void main(String[] ar) {
		// 선언문
		String chulsu, yonghee;
		String name;
		Scanner sc = new Scanner(System.in);
		// 입력문
		System.out.print("철수 =");
		chulsu = sc.nextLine();
		System.out.print("영희 =");
		yonghee = sc.nextLine();
		// 처리문
		if ((chulsu.equals("가위") && yonghee.equals("보")) 
				|| (chulsu.equals("바위") && yonghee.equals("가위"))
				|| (chulsu.equals("보") && yonghee.equals("바위"))) {
			System.out.println("철수가 이겼습니다.");

		} else if ((yonghee.equals("가위") && chulsu.equals("보")) 
				|| (yonghee.equals("바위") && chulsu.equals("가위"))
				|| (yonghee.equals("보") && chulsu.equals("바위"))) {
			System.out.println("영희가 이겼습니다.");
		} else {
			System.out.println("비겼습니다.");

		}

		// 출력문
	}
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
