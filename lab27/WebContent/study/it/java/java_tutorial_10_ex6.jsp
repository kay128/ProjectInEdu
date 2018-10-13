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

public class Exam_08 {
	public static void main(String[] ar) throws Exception {
		int su1, su2, tot;
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("su1 =");
			su1 = Integer.parseInt(sc.nextLine());

			System.out.print("su2 =");
			su2 = Integer.parseInt(sc.nextLine());

			tot = su1 / su2;

			System.out.println("tot = " + tot);
		} catch (NumberFormatException e) {
			System.out.println("예외 발생:" + e.getMessage());
			System.out.println("숫자만 입력이 가능합니다.");
		} catch (ArithmeticException e) {
			System.out.println("예외 발생 : " + e.getMessage());
			System.out.println("0으로 나눌 수 없습니다.");
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
