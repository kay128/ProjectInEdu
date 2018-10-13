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
 *
 */
public class Exam_06 {
	public static void main(String[] ar) {
		int[] x[] = new int[3][2];

		int[] y[] = new int[][] { { 1, 2, 3 }, { 4, 5 } };

		int[] z[] = new int[3][];

		z[0] = new int[4];
		z[1] = new int[6];
		z[2] = new int[2];

		System.out.println("x.length=" + x.length);// 3
		System.out.println("x[0].length =" + x[0].length);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.println("x[" + i + "][" + j + "]=" + x[i][j]);
			}
		}

		System.out.println();

		for (int i = 0; i < z.length; i++) {
			for (int j = 0; j < z[i].length; j++) {
				System.out.println("z[" + i + "][" + j + "]=" + z[i][j]);
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
