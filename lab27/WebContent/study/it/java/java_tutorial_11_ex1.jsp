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

package frame.sample;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class Exam_01 {
	public static void main(String[] ar) {
		// Frame 객체를 생성한다.
		Frame frm = new Frame();

		// Frame 제목 설정
		frm.setTitle("자바 프레임");

		// Frame 크기를 조정한다.
		frm.setSize(300, 300);

		// 화면 정중앙에 프레임을 배치시키기 위해
		// step1. 모니터크기 확인
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm_size = frm.getSize();

		int xpos = (int) (screen.getWidth() / 2 - frm_size.getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - frm_size.getHeight() / 2);
		frm.setLocation(xpos, ypos);

		// Frame의 크기 재설정 방지
		frm.setResizable(false);
		// Frame 객체를 화면에 표시한다.
		frm.show();

		frm.setVisible(true);
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
