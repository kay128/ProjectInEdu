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
//공유자원을 관리하는 클래스
class Bathroom {
	public synchronized void open(String name) {
		System.out.println(name + " 화장실 입장");
		for (int i = 1; i < 10000000; i++) {
			if (i == 10000) {
				System.out.println(name + "사용중");
			}
		}

		System.out.println(name + " 화장실 퇴장");

	}
}

// 스레드로 구현될 가족 클래스
class Family extends Thread {
	Bathroom br;
	String name;

	public Family(Bathroom br, String name) {
		this.br = br;
		this.name = name;
	}

	public void run() {
		br.open(name);
	}
}

public class Exam_05 {
	public static void main(String[] ar) {
		Bathroom br = new Bathroom();

		Family father = new Family(br, "father");
		Family mother = new Family(br, "mother");
		Family brother = new Family(br, "brother");
		Family sister = new Family(br, "sister");
		Family me = new Family(br, "me");

		father.start();
		mother.start();
		brother.start();
		sister.start();
		me.start();
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
