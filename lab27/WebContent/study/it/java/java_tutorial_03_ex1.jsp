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
 * do~while문  
 *
 */
public class Exam_01 {
	// 멤버 필드
	// 생성자 메서드
	// 멤버 메서드
	public static void main(String[] ar) {
		// 선언문
		// 입력문
		// 처리문
		// 출력문

		// for(int i=1;i<=5;i++) {
		// System.out.print("#");
		// }

		int i = 1;
		do {
			System.out.print("#");
			i++;
		} while (i <= 5);
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
