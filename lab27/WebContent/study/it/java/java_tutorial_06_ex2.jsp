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
 * 3명의 국어, 영어 수학 점수를 입력받아 총점과 평균을 계산하여 출력하는 프로그램을 구현하시오.
 */
import java.util.Scanner;

public class Exam_01 {
	public static void main(String[] ar) {

		int[] sub[] = new int[3][4];

		float[] avg = new float[3];

		String[] subject = { "국어", "영어", "수학" };
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + "번째사람");
			for (int j = 0; j < 3; j++) {
				System.out.print(subject[j] + "=");
				sub[i][j] = Integer.parseInt(sc.nextLine());
				sub[i][3] += sub[i][j];
			}
			avg[i] = sub[i][3] / 3.0f;
		}

		for (int i = 0; i < 3; i++) {
			System.out.println();
			System.out.println("총점 = " + sub[i][3]);
			System.out.println("평균 =" + avg[i]);
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
