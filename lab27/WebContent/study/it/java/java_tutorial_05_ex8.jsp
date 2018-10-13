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
 * 숙박관리 프로그램을 구현하시오
 * <입력 및 출력형식>
 * 방의 개수 =
 * 작업 (1. 투숙  2.퇴실 3.객실현황 4.종료)
 * 선택 =1
 * 투숙할 방번호
 * 투숙객 이름 =
 * 
 * 작업(..)
 * 선택 = 2
 * 퇴실할 방번호 =
 * 
 * 작업(...)
 * 선택 = 3
 * 0번방 : 투숙객 이름 = xxx
 * 
 * <처리조건>
 * 1. 배열을 동적으로 할당받아 프로그램을 구현하시오.
 * 2. 배열은 이름을 저장할 공간으로 할당하고, 방번호에 해당하는 값을 배열의 각 인덱스를 활용할 것
 * 3. 투숙 및 퇴실시 존재하지 않는 방번호를 통해 작업을 수행할 경우 다시 입력받도록 구현할 것
 * 4. 사용자가 원하는 작업을 선택할 수 있도록 구현할 것
 * 5. 종료를 선택하기 전까지 해당 로직은 계속 반복할 것
 */
import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		int room = 0;
		String[] names;

		System.out.print("방의 개수 =");
		room = Integer.parseInt(sc.nextLine());

		names = new String[room];

		while (true) {
			System.out.println();
			System.out.println("1.투숙 2. 퇴실 3.객실보기 4.종료");
			System.out.print("선택 =");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				int a = 0;
				do {
					System.out.print("투숙할 방번호 = ");
					a = Integer.parseInt(sc.nextLine());
				} while (a < 0 || a >= room || names[a] != null);
				System.out.print("투숙객 이름 =");
				names[a] = sc.nextLine();
			} else if (menu == 2) {
				int a = 0;
				do {
					System.out.print("퇴실할 방번호 =");
					a = Integer.parseInt(sc.nextLine());
				} while (a < 0 || a >= room || names[a] == null);
				names[0] = null;
			} else if (menu == 3) {
				for (int i = 0; i < names.length; i++) {
					System.out.println(i + "빈방투숙객 :" + names[i]);
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
