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
 * 로그인 layout 만들어보
 */
package frame.sample;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
//import javax.swing.Container;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Exam_13_Sub extends JFrame {
	// 멤버 필드
	Container c;

	private JLabel id = new JLabel("아이디 : ");
	private JTextField id_txt = new JTextField(10);
	private JLabel pass = new JLabel("비밀번호 : ");
	private JTextField pass_txt = new JTextField(10);

	private JPanel p = new JPanel(new GridLayout(2, 1));
	private JPanel p1 = new JPanel(new GridLayout(1, 2));
	private JPanel p2 = new JPanel(new GridLayout(1, 2));

	private BorderLayout bl = new BorderLayout();

	// 생성자 메서드
	public Exam_13_Sub() {
		// 제목 설정
		this.setTitle("자바 프레임");
		// Frame 크기 설정
		setSize(300, 100);

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
		// 사용하는 컨텐트펜 객체 얻어오기
		c = getContentPane();

		// 배치관리자 설정
		c.setLayout(bl);
		// Frame 배경을 설정
		c.setBackground(Color.ORANGE);

		p1.add(id);
		p1.add(id_txt);

		p2.add(pass);
		p2.add(pass_txt);

		p.add(p1);
		p.add(p2);

		c.add("Center", p);

	}

	public void start() {// Event 처리를 목적으로 구현하는 메서드

	}
	// 중첨 메서드

}

public class Exam_13 {

	public static void main(String[] args) {
		Exam_13_Sub ex = new Exam_13_Sub();

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




