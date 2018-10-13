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
 * 주민등록번호
 * a : 출생년도, 성별
 *     1800년대 0-9
 *     1900년대 2-1
 *     2000년대 4-3
 *     성별 : 남(홀), 여(짝)
 * bc : 출생지역(시,도)
 * de : 출생지역(구, 군, 면)
 * f  : 출생지역(읍, 면, 리)
 * g  : 식별문자
 * 
 * 주민등록번호의 8번째 수를 입력받아 출생년도의 성별의 판정하여 출력하는 프로그램
 * <입력형식>
 * 주민번호 일부 = 
 * 
 * <출력형식>
 * 당신은 xxxx년대 출생하신 남자 or duwk 입니다.
 */
import java.util.Scanner;

public class Exam_04 {
	// 멤버 필드

	// 생성자 메서드

	// 멤버 메서드
	public static void main(String[] ar) {

		// 선언문
		String id_num;
		char ch;

		Scanner sc = new Scanner(System.in);
		// 입력문
		System.out.print("주민번호 일부");
		id_num = sc.nextLine();

		ch = id_num.charAt(8);
		System.out.println(ch);

		switch (ch) {
		case '2':
			System.out.println("당신은 1900년대에 태어난 여자입니다.");
			break;
		case '1':
			System.out.println("당신은 1900년대에 태어난 여자입니다.");
			break;
		case '4':
			System.out.println("당신은 2000년대에 태어난 여자입니다.");
			break;
		case '3':
			System.out.println("당신은 2000년대에 태어난 남자입니다.");
			break;
		default:
			System.out.println("태어난 년도와 성별 구분이 불가능합니다.");
			break;

		}

		// 처리문
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
