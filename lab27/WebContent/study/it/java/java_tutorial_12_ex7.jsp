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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 상,하,좌, 우 키를 이용하여 문자열을 이동하는 프로그램을 구현하시오.
 * 조건1. 문자열은 "Hello"
 * 문자열의 초기위치값(50,50)
 * 조건2. 방향키에 의해 해당 문자열의 위치가 10픽셀씩 이동하도록 구현한다.
 */

public class Exam_07 extends JFrame {

	static int x = 50;
	static int y = 50;

	JPanel jp = new JPanel();
	JLabel lb;

	public Exam_07() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(jp);

		jp.setLayout(null);

		lb = new JLabel("Hello");
		lb.setSize(50, 30);
		lb.setLocation(50, 50);

		jp.addKeyListener(new MyKeyClass());

		jp.add(lb);

		setSize(500, 500);
		setVisible(true);

		jp.requestFocus();

	}

	public static void main(String[] ar) {
		new Exam_07();
	}

	class MyKeyClass extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			System.out.println(e.getKeyText(e.getKeyCode()) + "키가 입력되었습니다.");

			if (e.getKeyCode() == KeyEvent.VK_UP) {

				lb.setLocation(lb.getX(), lb.getY() - 10);
				System.out.println("vk_up");

			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				lb.setLocation(lb.getX(), lb.getY() + 10);
				System.out.println("vk_down");

			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				lb.setLocation(lb.getX() - 10, lb.getY());
				System.out.println("vk_left");

			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				lb.setLocation(lb.getX() + 10, lb.getY());
				System.out.println("vk_right");
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




