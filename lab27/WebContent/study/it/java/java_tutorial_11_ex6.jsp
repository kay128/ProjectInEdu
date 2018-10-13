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
 * CardLayout()
 */
package frame.sample;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Frame;

class Exam_06_Sub extends Frame {
	// 멤버 필드
	private Button btn1 = new Button("1");
	private Button btn2 = new Button("2");
	private Button btn3 = new Button("3");

	private CardLayout cl = new CardLayout();

	// 생성자 메서드
	public Exam_06_Sub() {
		// 제목설정
		setTitle("CardLayout");

		// 화면 구성
		init();

		// Event나 thread 처리
		// start();

		// 크키설정
		setSize(500, 300);

		// 중앙에 배치
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = getSize();

		int x = (int) (screen.getWidth() / 2 - frm.getWidth() / 2);
		int y = (int) (screen.getHeight() / 2 - frm.getHeight() / 2);
		setLocation(x, y);

		// 최대화방지
		this.setResizable(false);

		// 화면에 표시
		this.setVisible(true);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		cl.show(this, "aa");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		cl.show(this, "bb");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		cl.show(this, "cc");

	}

	// 멤버 메서드
	public void init() {
		// 배치 관리자 설정
		setLayout(cl);

		// 컴포넌트 부착
		add("aa", btn1);
		add("bb", btn2);
		add("cc", btn3);

	}

	// 중첩 클래스
}

public class Exam_06 {

	public static void main(String[] args) {
		Exam_06_Sub ex = new Exam_06_Sub();

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




