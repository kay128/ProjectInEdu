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

import java.util.*;

public class Exam_02 {
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		// String[] names = new String[3];
		ArrayList<String> names = new ArrayList<String>();
		// int index = 0;

		while (true) {
			System.out.print("이름 = ");
			String name = sc.nextLine();
			if (name.equals("") || name.equals(null))
				break;
			// if(index >=3) {
			// String[] imsi = new String[names.length+1];
			// System.arraycopy(names, 0, imsi, 0, names.length);
			// names = imsi;
			// }
			// names[index++] = name;
			names.add(name);
		}

		System.out.println();
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
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
