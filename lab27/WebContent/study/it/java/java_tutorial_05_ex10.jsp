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
 * 다섯개의 정수를 입력받아 배열에 저장한 후 가장 큰 값을 출력하는 프로그램을 구현하시오
 * 입력받은 정수가 정수가 0 이면 입력을 종료하고 가장 큰 수를 출력하도록 하시오.
 *
 */
import java.util.Scanner;

public class Exam_06 {
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		int[] data = new int[5];
		int max;
		int index = 0;

		while (true) {
			System.out.print("정수=");

			int num = Integer.parseInt(sc.nextLine());
			if (num == 0) {
				break;
			}

			if (index >= 5) {
				int[] imsi = new int[data.length + 1];
				System.arraycopy(data, 0, imsi, 0, data.length);
				data = imsi;
			}

			data[index++] = num;

		}

		max = data[0];

		for (int i = 1; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}

		System.out.println("최대값 " + max);
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
