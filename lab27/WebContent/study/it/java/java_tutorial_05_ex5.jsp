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
 * 배열의 재구성  
 */
import java.util.Scanner;

public class Exam_11 {
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);

		String[] names = new String[3];
		int index = 0;

		while (true) { // 무한Loop
			System.out.println();
			System.out.print("이름=");
			String name = sc.nextLine();
			if (name.equals("end"))
				break;

			// 배열의 재구성하는 작업을 수행한다
			if (index >= 3) {
				String[] imsi = new String[names.length + 1];
				System.arraycopy(names, 0, imsi, 0, names.length);
				names = imsi; // 객체 복사
			}
			names[index++] = name;
		}

		System.out.println();
		for (int i = 0; i < names.length; i++) {
			System.out.println("names[" + i + "]=" + names[i]);
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
