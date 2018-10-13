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
 *  대문자는 소문자로, 소문자는 대문자로 변환하여 출력하는 프로그램 
 */
import java.util.Scanner;

public class Exam5 {

	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("문자 =");
			char ch = sc.nextLine().charAt(0);

			// 입력받은 문자의 대소문자를 판단한 후 출력하는 작업
			/*
			 * A : 65 Z : 90 a : 97 z : 122
			 */

			if (ch >= 'A' && ch <= 'Z') {
				System.out.println(ch + " == " + (char) (ch + 32));
			} else {
				System.out.println(ch + " == " + (char) (ch - 32));
			}

			System.out.println();
			System.out.print("계속(Y/N)=");
			char check = sc.nextLine().charAt(0);
			if (check == 'n' || check == 'N')
				break;
			System.out.println();

		}

		System.out.println("프로그램을 종료합니다.");
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
