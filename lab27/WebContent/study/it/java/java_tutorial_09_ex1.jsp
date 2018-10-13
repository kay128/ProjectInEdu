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
package collection;

import java.util.ArrayList;

public class Exam_01 {
	public static void main(String[] ar) {
		int[] x = new int[3];
		ArrayList<Integer> list = new ArrayList<Integer>(); // 가변길이 배열
		/**
		 * add() : 추가 get() : 추출 size() : 크기
		 */
		x[0] = 10;
		x[1] = 20;
		x[2] = 30;
		// x[3] = 40;

		list.add(1);
		// list.add("KOREA");
		// list.add(10.1);
		// list.add(new Integer(100));
		// list.add('A');
		// list.add(false);
		// list.add(2, "OK");

		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
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
