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
package test.event;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Exam_02 extends JFrame {
	// 멤버 필드
	// 생성자 메서드
	public Exam_02() {
		setTitle("MouseListener 이벤트 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 버튼 객체 생성
		JButton btn = new JButton("Mouse Event 테스트 버튼");
		btn.setBackground(Color.PINK);

		// MyEvent e = new MyEvent();
		btn.addMouseListener(new MyEvent());

		add(btn);

		setSize(300, 200);
		setVisible(true);

	}

	// 멤버 메서드
	public static void main(String[] ar) {
		new Exam_02();
	}

	// 중첩 클래스
	class MyEvent implements MouseListener {

		@Override // 마우스가 눌러졌을 때
		public void mouseClicked(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			JButton button = (JButton) arg0.getSource();
			button.setBackground(Color.yellow);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			JButton button = (JButton) arg0.getSource();
			button.setBackground(Color.PINK);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
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




