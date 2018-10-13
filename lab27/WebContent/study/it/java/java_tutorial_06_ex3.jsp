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

/**
 * 
 * @author Administrator 숙박관리 프로그램을 확장해서 구현하시오 <입력 및 출력형식> 층의 개수 = 방의 개수 =
 *
 *         [1]투숙 [2]퇴실 [3]객실보기 [4]종료
 *
 *         몇층에 투숙= 몇번방에 투숙 투숙객 이름
 */
public class Exam_05 {
	public static void main(String[] ar) {

		Scanner sc = new Scanner(System.in);
		int room = 0;
		int floor = 0;
		String[] names[];

		System.out.print("층의 개수 =");
		floor = Integer.parseInt(sc.nextLine());
		System.out.print("방의 개수=");
		room = Integer.parseInt(sc.nextLine());

		names = new String[floor][room];

		while (true) {
			System.out.println();
			System.out.println("1.투숙 2. 퇴실 3.객실보기 4.종료");
			System.out.print("선택 =");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				int a = 0;
				int b = 0;

				do {
					System.out.print("투숙할 층 =");
					a = Integer.parseInt(sc.nextLine());
				} while (a < 0 || a >= floor);

				do {

					System.out.print("투숙할 방번호 = ");
					b = Integer.parseInt(sc.nextLine());
				} while (b < 0 || b >= room || names[a][b] != null);

				System.out.print("투숙객 이름 =");
				names[a][b] = sc.nextLine();
			} else if (menu == 2) {
				int a = 0;
				int b = 0;

				do {
					System.out.print("퇴실할 층");
					a = Integer.parseInt(sc.nextLine());
				} while (a < 0 || a >= floor);

				do {

					System.out.print("퇴실할 방번호 =");
					b = Integer.parseInt(sc.nextLine());
				} while (b < 0 || b >= room || names[a][b] == null);

				names[a][b] = null;
			} else if (menu == 3) {
				for (int f = 0; f < names.length; f++) {
					System.out.println(f + "층 객실 현황");
					for (int i = 0; i < names[f].length; i++) {
						System.out.println(i + "번방투숙객 :" + names[f][i]);
					}
				}
			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("선택이 올바르지 않습니다.");
			}

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
