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
				<h1>자바 클래스와 객체</h1>
				<div class="row">
				<h4>
				1.클래스의 기본 구성<br><br>
		   		&nbsp;&nbsp;1) 객체(Object)와 객체(Instance)의 관계<br><br>
		     	&nbsp;&nbsp;&nbsp;- 객체(Object) : 현실 세계의 모든 유형, 무형의 물질, 사물, 대상<br><br>
		      	&nbsp;&nbsp;&nbsp;- 객체(Instance) : 클래스에 접근하기 위한 변수<br><br>                 
		  		&nbsp;&nbsp;2) 포함멤버(구성요소)<br><br>
		      	&nbsp;&nbsp;&nbsp;- 멤버필드: 전역변수(기억공간)<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;지역변수(메서드 안에서 선언된 변수)와 전역변수<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;클래스변수 : 객체를 생성하지 않고도 클래스명으로 접근이 허용되는 변수(static)<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;인스턴스 변수 = 객체명<br><br>
		      	&nbsp;&nbsp;&nbsp;- 생성자 메서드<br><br>
		      	&nbsp;&nbsp;&nbsp;- 멤버 메서드<br><br>
		      	&nbsp;&nbsp;&nbsp;&nbsp;(1) 형식<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] ar) throws 예외클래스들{...}<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;접근 제한자 결과형리턴값 메서드명(매개변수){...}<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;(2) 유형<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;step1. 리턴타입없고, 매개변수도 없는 형태<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;step2. 리턴타입없고, 매개변수는 있는 형태<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;step3. 리턴타입있고, 매개변수 없는 형태<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;step4. 리턴타입있고, 매개변수도 있는 형태<br><br>
		      	&nbsp;&nbsp;&nbsp;- 중첩 클래스<br><br>
		      	&nbsp;&nbsp;3) 접근 제한자    or  접근 지정자<br><br>
		      	&nbsp;&nbsp;&nbsp;- private : 전용<br><br>
		      	&nbsp;&nbsp;&nbsp;- protected : 전용 단 상속 관계일 때 접근을 허용<br><br>
		      	&nbsp;&nbsp;&nbsp;- public :  공개용, 객체가 생성되면 어디서든 접근이 허용된다.<br><br>
		     	&nbsp;&nbsp;&nbsp;- 정보은닉(캡슐화)<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;: 멤버필드 private, 멤버메서드 public 으로 선언한다.<br><br>
		        &nbsp;&nbsp;4) 지정 예약어<br><br>
		      	&nbsp;&nbsp;&nbsp;(1) 자기 자신의 객체를 참조하는 this<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- this : 클래스 내부에서 자신의 클래스를 지칭하는 객체<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- this() : 생성자 내부에서 자신 클래스의 또 다른 생성자를 지칭하는 메서드<br><br>
		      	&nbsp;&nbsp;&nbsp;(2) 공유 필드를 위한 static<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- static 필드 : 데이터 값을 공유하기 위해 선언하는 것<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;멤버필드만 가능하다.<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;객체생성없이 클래스명으로 직접접근이 가능하다.<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;객체 발생전 메모리에 할당된다<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;static 초기화 영역 : static 멤버 필드의 값을 초기화하기 위해 사용되는 영역<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;static{<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;초기화 구문<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- static 메서드 : static으로 선언된 필드를 컨트롤할 목적으로 구현된다.<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;static으로 선언된 메서드는 외부의 필드 중 static 객체만 담을 수 있다.<br><br>  
		      	&nbsp;&nbsp;&nbsp;(3) 상수 필드와 변수를 위한 final<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;final 필드 : 상수 값을 저장하기 위한 공간으로 값이 변결될 수 없음<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;지역변수나 멤버 필드 모두 지정할 수 있다.<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;final 메서드 : 상속시 오버라이딩(재정의)되지 않아야 할 메서드에 지정한다.<br><br>
		   		&nbsp;&nbsp;5) 객체 모델링 : 클래스(객체)를 만드는 과정<br><br>
		        &nbsp;&nbsp;&nbsp;step1. 여러개의 객체의 공통된 특성만 모아서 하나의 클래스를 생성한 후 재활용하여 사용한다.<br><br>
		        &nbsp;&nbsp;&nbsp;step2. 속성과 행위<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- 객체의 속성 : 멤버 필드<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;자료형 변수명: 또는 자료형 변수명 = 초기값(처음값);<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;- 객체의 행위 : 멤버 메서드<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;접근 지정자 결과형리턴값 메서드명(매개변수){...}<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;결과형 리턴값(){...}<br><br>
				</h4>
				</div>
				<div class="row">
				<h4>
				2.클래스의 사용법<br><br>
		  		&nbsp;&nbsp;1)객체(Instance) 생성<br><br>
		     	&nbsp;&nbsp;&nbsp;클래스명 객체명 = new 생성자메서드 (매개변수);<br><br>
		     	&nbsp;&nbsp;2)direct연산자 : 객체를 통해 클래스 멤버에 접근할 때 사용하는 연산자<br><br>
		     	&nbsp;&nbsp;&nbsp;객체명.멤버필드 또는 객체명.멤버메서드<br><br>
		   		&nbsp;&nbsp;3)객체명(Reference) : 4byte<br><br>
				</h4>
				</div>
				<div class="row">
				<h4>
				3.생성자 메서드 : 객체가 생성될 때 해야할 작업이 있다면 생성자에 기술<br><br>
		   		&nbsp;&nbsp;- 클래스명과 동일하게 작성한다.<br><br>
		   		&nbsp;&nbsp;- 결과형 리턴값이 없다.<br><br>
		     	&nbsp;&nbsp;&nbsp;왜? 멤버 필드를 초기화시켜줄 목적으로 구현된 메서드이므로<br><br>
		   		&nbsp;&nbsp;- 객체 생성자 반드시 하나의 생성자 메서드가 호출된다.<br><br>
		     	&nbsp;&nbsp;&nbsp;만약, 생성자가 존재하지 않을 경우 default 생성자가 생략된 걸로 간주한다.<br><br>
		     	&nbsp;&nbsp;&nbsp;default 생성자란? 매개변수를 가지고 있지 않은 생성자를 뜻한다.<br><br>
		   		&nbsp;&nbsp;- 생성자 오버로딩(Overloading)<br><br>
		     	&nbsp;&nbsp;&nbsp;: 동일한 이름을 가진 메서드를 여러개 만들어 사용할 수 있는 기능<br><br>
		        &nbsp;&nbsp;&nbsp;단, 매개변수의 개수가 다르거나 데이터 타입이 달라야 한다.<br><br>
		   		&nbsp;&nbsp;- this와 this()의 의미<br><br><br>
		     	&nbsp;&nbsp;&nbsp;this() : 클래스내에 또 다른 생성자를 호출한다.<br><br>
		     	&nbsp;&nbsp;&nbsp;this : 클래스내의 자신의 멤버 필드를 가르킨다.<br><br>
		     	&nbsp;&nbsp;&nbsp;상속 관계에서는 super, super()와 관련되어 있다.<br><br>
				</h4>
				</div>
				<div class="row">
				<h4> 
		 		4. 클래스의 유형<br><br>
		   		&nbsp;&nbsp;1) Entity Class : 단순히 데이터를 담아서 전달할 목적으로 구현하는 클래스<br><br>
		      	&nbsp;&nbsp;&nbsp;- 실제 작성되는 프로그램의 전반적인 흐름을 알 수 없다.<br><br>
		      	&nbsp;&nbsp;&nbsp;- DTO(Data Transfer Object) VO(Value Object) or Java Bean or Model<br><br>
		   		&nbsp;&nbsp;2) Controller Class or Handler Class : 실제 처리를 담당하는 클래스<br><br>
		      	&nbsp;&nbsp;&nbsp;- 처리할 기능을 중심으로 구현되는 클래스<br><br>
		      	&nbsp;&nbsp;&nbsp;- Action 클래스 or Controller<br><br>
		   		&nbsp;&nbsp;3) MVC 패턴을 이용한 프로그램 구현 => Framework(Struts2, Spring....)<br><br>
		      	&nbsp;&nbsp;&nbsp;- M : Model<br><br>
		      	&nbsp;&nbsp;&nbsp;- V : View<br><br>
		      	&nbsp;&nbsp;&nbsp;- C : Controoler<br><br> 
				</h4>
				</div>
				<div class="row">
				<h4>
				5.Garbage Collection : JVM(가상머신) 메모리<br><br>
		  		&nbsp;&nbsp;- 더 이상 참조받지 않는 Garbage Collection 영역의 메모리를 삭제한다.<br><br>
		  		&nbsp;&nbsp;- 어떤 공간이라도 해당 메모리를 참조하면 삭제하지 않는다.<br><br>
		  		&nbsp;&nbsp;- new 연산자가 필요함.<br><br>
				</h4>
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
