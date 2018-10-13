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
 * 컴포넌트 위치 변경  
 */
package test.event;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Exam_03 extends JFrame {
	// 멤버필드
	JPanel jp = new JPanel();
	JLabel lb;

	// 생성자메서드
	public Exam_03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 패널을 프레임으로 사용하기 위한 설정
		setContentPane(jp);

		// 컴포넌트의 크기와 위치를 변경하기 위해서는 배치관리자를 제거해야 한다.
		jp.setLayout(null);

		lb = new JLabel("Hello");
		lb.setSize(50, 30);
		lb.setLocation(30, 30);

		jp.add(lb);

		setSize(500, 500);
		setVisible(true);

		jp.addMouseListener(new MyMouseAdapter());
	}

	// 멤버메서드
	public static void main(String[] ar) {
		new Exam_03();
	}

	// 중첩 클래스
	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();

			lb.setLocation(x, y);

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




