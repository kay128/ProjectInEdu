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

import javax.swing.JFrame; //다중 프레임 지원

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

class Exam_01_Sub extends JFrame implements MouseListener {
	// 멤버 필드
	Container c;

	JButton action = new JButton("ACTION");

	FlowLayout fl = new FlowLayout();

	// 생성자 메서드
	public Exam_01_Sub() {
		setTitle("마우스 이벤트 처리 : MouseListener");

		// 프레임이 닫히면 응용프로그램도 종료되도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임의 크기 설정
		setSize(300, 200);

		// 화면을 디자인 할 목적으로 호출되는 메서드
		init();

		// Event나 Thread를 처리할 목적의 메서드
		start();

		// 화면의 정중앙에 배치하는 작업
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = getSize();

		int x = (int) (screen.getWidth() / 2 - frm.getWidth() / 2);
		int y = (int) (screen.getHeight() / 2 - frm.getHeight() / 2);
		setLocation(x, y);

		// 사이즈 조정을 불가
		this.setResizable(false);

		this.setVisible(true);

	}

	// 멤버 메서드
	private void init() {
		// 사용하는 컨텐트펜을 얻어오는 작업
		c = getContentPane();

		// 배치관리자 설정
		c.setLayout(fl);

		// 컴포넌트 부착
		c.add(action);
	}

	private void start() {
		// 이벤트 등록 : 대상객체.add~Listener(이벤트 핸들러);
		// MyListener listener = new MyListener();
		// action.addMouseListener(listener);

		// action.addMouseListener(this);

		action.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();

				if (b.getText().equals("ACTION")) {
					b.setText("액션");
				} else {
					b.setText("ACTION");
				}

			}
		});

	}

	// 중첩 클래스
	// Listener 클래스 구현
	class MyListener extends MouseAdapter/* implements MouseListener */ {

		@Override
		public void mouseClicked(MouseEvent e) { // callback method
			// 마우스가 클릭되는 순간
			JButton b = (JButton) e.getSource();

			if (b.getText().equals("ACTION")) {
				b.setText("액션");
			} else {
				b.setText("ACTION");
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// 마우스 버튼이 눌러지는 순간
			JButton b = (JButton) e.getSource();

			b.setBackground(Color.YELLOW);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// 마우스가 해당 컴포넌트에서 내려오는 순간
			JButton b = (JButton) e.getSource();

			b.setBackground(Color.GRAY);

		}

		// @Override
		// public void mousePressed(MouseEvent e) {
		// // 마우스 버튼이 눌러지는 순간
		//
		// }
		//
		// @Override
		// public void mouseReleased(MouseEvent e) {
		// // 눌러진 마우스 버튼이 떼어지는 순간
		//
		// }

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// 마우스가 클릭되는 순간
		JButton b = (JButton) arg0.getSource();

		if (b.getText().equals("ACTION")) {
			b.setText("액션");
		} else {
			b.setText("ACTION");
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}

public class Exam_01 {
	public static void main(String[] ar) {
		Exam_01_Sub ex = new Exam_01_Sub();
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




