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
package inheritance.test;

//import java.lang.*;
class AA extends Object {
	private int x;

	public AA(int x) {
		// super(); Object() 호출
		this.x = x;
	}

	// public AA() {
	// super();
	// this.x = 0;
	// }

}

public class Exam_02 extends Object {
	public static void main(String[] ar) {
		AA ap = new AA(10);
		System.out.println("ap 문자열 : " + ap);// toString
	}

	@Override // 재정의(오버라이딩) - 부모클래스가 가지고 있는 메서드를 자식클래스가 재정의해서 사용하는 기능
	public String toString() {
		// TODO Auto-generated method stub
		return "이것은 AA 클래스의 문자열";
	}

	public void disp() {
		System.out.println("이것은 AA 클래스의 문자열");
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
