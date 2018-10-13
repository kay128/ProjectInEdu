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
 * 입력받은 문자열을 문자로 분류하여 해당 알파벳을 출력  
 *
 */
import java.util.Scanner;

public class Exam_05 {
	public static void main(String[] ar) throws java.io.IOException {
		int count = 0;
		char[] ch = null;
		int[] alpha = new int[26];

		Scanner sc = new Scanner(System.in);

		System.out.print("몇 개의 문자를 입력 받으시겠습니까?(대문자만 가능합니다.)");
		System.out.print("문자개수 =");
		count = Integer.parseInt(sc.nextLine());

		ch = new char[count];
		System.out.print("문자입력: ");
		for (int i = 0; i < count; i++) {
			// ch[i]=sc.nextLine().charAt(i);
			ch[i] = (char) System.in.read();
		}

		/**
		 * Tip A: 65 Z:90
		 */

		for (int i = 0; i < ch.length; i++) {
			alpha[ch[i] - 65]++;
		}

		for (int i = 0; i < alpha.length; i++) {
			System.out.println((char) (65 + i) + "=" + alpha[i]);
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
