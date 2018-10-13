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

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;

class Exam_12_Sub extends JFrame {
	// 멤버 필드
	Container c;

	private JButton bt1 = new JButton("OK");
	private JButton bt2 = new JButton("CANCEL");
	private JButton bt3 = new JButton("IGNORE");

	private FlowLayout fl = new FlowLayout();

	// 생성자 메서드
	public Exam_12_Sub() {
		// 제목 설정
		this.setTitle("자바 프레임");

		// Frame이 닫히면 응용프로그램도 종료되도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame 크기 설정
		setSize(500, 300);

		// 화면을 구성(디자인)
		init();

		// Event나 Thread처리
		start();

		// 화면의 정중앙에 배치
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = getSize();

		int x = (int) (screen.getWidth() / 2 - frm.getWidth() / 2);
		int y = (int) (screen.getHeight() / 2 - frm.getHeight() / 2);
		setLocation(x, y);

		// Frame 크기 재설정 방지
		this.setResizable(false);

		// Frame 화면에 표시
		setVisible(true);

	}

	// 멤버 메서드
	public void init() {// Frame 화면을 디자인할 목적으로 구현하는 메서드
		// 사용하는 컨텐트펜을 얻어온다.
		c = getContentPane();

		// Frame 배경을 설정
		c.setBackground(Color.ORANGE);

		// 배치관리자 설정
		c.setLayout(fl);

		bt1.setBackground(Color.BLUE);
		bt1.setForeground(Color.WHITE);

		bt2.setFont(new Font("고딕체", Font.ITALIC, 20));

		bt3.setEnabled(false);

		c.add(bt1);
		c.add(bt2);
		c.add(bt3);
	}

	public void start() {// Event 처리를 목적으로 구현하는 메서드

	}
	// 중첨 메서드

}

public class Exam_12 {

	public static void main(String[] args) {
		Exam_12_Sub ex = new Exam_12_Sub();

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




