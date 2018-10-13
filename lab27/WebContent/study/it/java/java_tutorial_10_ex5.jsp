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
	public static void main(String[] ar) throws Exception {
		int su1, su2, tot;
		Scanner sc = new Scanner(System.in);

		System.out.print("su1 =");
		su1 = Integer.parseInt(sc.nextLine());
		if (su1 > 100) {
			System.out.println("예외 발생: ");
			Exception ex = new Exception(">100");
			throw ex;
		}
		System.out.print("su2 =");
		su2 = Integer.parseInt(sc.nextLine());
		if (su2 == 0) {
			System.out.println("0으로 나눌수는 없습니다.");
			System.exit(0);
		}

		tot = su1 / su2;

		System.out.println("tot = " + tot);

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
