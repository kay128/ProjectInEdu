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
class AA extends Thread{
	public void run() {
		System.out.println("\n AA start!!!");
		System.out.println("count = " + Thread.activeCount());
		System.out.println("AA end!!!");
	}
}
public class Exam_02 {

	public static void main(String[] args) {
		System.out.println("Main start!!!");
		int x = Thread.activeCount();
		System.out.println("count = "+x);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		AA ap =  new AA();
		ap.setPriority(5);
		ap.setDaemon(true); //종속 Thread
		ap.start();
		
		for(int i=1 ; i <= 100 ; i++) {
			System.out.print(i);
			if(i%10 == 0) System.out.println();
			else System.out.print("\t");
		}
		
		System.out.println("Main end!!");

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
