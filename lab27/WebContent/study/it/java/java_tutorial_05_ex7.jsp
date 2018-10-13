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
 * 성적 처리  프로그램
 * 국어, 영어, 수학점수를 입력받아 총점과 평균을 계산하여 출력하는 프로그램을 구현하시오.
 * 1단계 : 총점과 평균이 출력되도록 구현하되, 평균은 소숫점이하 둘재자리까지만 표현할 것
 * 2단계 : 평균을 히용하여 학점을 계산하도록 구현하시오
 *        단, 평균이 90점 이상이면 'A', 80점 이상이면 'B' 70점 이상이면'C' 60점 이상이면 'D' 이외에는 'F'(switch case)
 * 3단계 : 각 과목의 점수는 0 ~ 100 사이의 자연수만 입력되도록 구현하되, 범위를 벗어나면 다시 입력받록 구현하시오.
 * 4단계 : 배열을 이용할 것
 * 5단계 : 3명의 성적을 받아서 처리하도록 확장하시오.
 * <입력형식>
 * 국어 = 
 * 영어 = 
 * 수학 =
 * 
 * <출력형식>
 * 총점 =
 * 평균 = 
 * 학점 = 
 */
import java.util.Scanner;

public class Exam_13 {

	public static void main(String[] ar) {

		int[][] sub = new int[3][4];
		char[] grade = new char[3];
		float[] avg = new float[3];
		String[] title = { "국어", "수학", "영어" };

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + "번째사람 점수 입력");
			for (int j = 0; j < title.length; j++) {
				do {
					System.out.print(title[j] + "=");
					sub[i][j] = Integer.parseInt(sc.nextLine());
				} while (sub[i][j] < 0 || sub[i][j] > 100);
				sub[i][3] = sub[i][3] + sub[i][j];
			}

		}

		for (int i = 0; i < 3; i++) {
			avg[i] = sub[i][3] / 3.0f;
		}

		for (int i = 0; i < 3; i++) {
			switch ((int) (avg[i] / 10)) {
			case 10:
			case 9:
				grade[i] = 'A';
				break;
			case 8:
				grade[i] = 'B';
				break;
			case 7:
				grade[i] = 'C';
				break;
			case 6:
				grade[i] = 'D';
				break;
			default:
				grade[i] = 'F';
				break;

			}

		}

		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + "번째 사람");
			System.out.println("총점=" + sub[i][3]);
			System.out.print("평균=");
			System.out.printf("%.2f", avg[i]);
			System.out.println();
			System.out.println("학점=" + (char) grade[i]);
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
