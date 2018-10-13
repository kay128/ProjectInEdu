<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
		<!-- 네비게이션 용 css -->
		<link rel="stylesheet" href="/lab27/css/sideNavCSS.css">
		<!-- study 페이지용 css -->
		<link rel="stylesheet" href="/lab27/css/study.css">
		
		<!-- Bootstrap, Jquery, Poper -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	</head>
	<body>
	
		<div id="main-wrap" class="row"> <!-- wrap -->

		<!-- 스터디 목차 ================================================================== -->
			<div id="study-side-nav"  class="rounded idf">
				<h3>IT 목차</h3>
				
				<a data-toggle="collapse" href="#part1">
					1. Java
				</a>
				<div id="part1" class="collapse">
					&nbsp;&nbsp;&nbsp;<a href="#">1-1. java란</a><br>
					&nbsp;&nbsp;&nbsp;<a href="#">1-2. java란</a><br>
					&nbsp;&nbsp;&nbsp;<a href="#">1-3. java란</a>
				</div>
				<br>
				
				<a data-toggle="collapse" href="#part2">
					2. Java
				</a>
				<div id="part2" class="collapse">
					&nbsp;&nbsp;&nbsp;<a href="#">2-1. java란</a><br>
					&nbsp;&nbsp;&nbsp;<a href="#">2-2. java란</a><br>
					&nbsp;&nbsp;&nbsp;<a href="#">2-3. java란</a>
				</div>
				<br>
				
				<a data-toggle="collapse" href="#part3">
					3. Java
				</a>
				<div id="part3" class="collapse">
					&nbsp;&nbsp;&nbsp;<a href="#">3-1. java란</a><br>
					&nbsp;&nbsp;&nbsp;<a href="#">3-2. java란</a><br>
					&nbsp;&nbsp;&nbsp;<a href="#">3-3. java란</a>
				</div>
				<br>
			</div>	<!--  end -->
			
			
		<!-- 본문 ============================================================================= -->
			<div id="wrap"  class="rounded idf">
				<h1>TITLE</h1>
				<br><hr><br>
				본문 본문
				<br><br>
				<br><br>
				<br><br>
				<br><br>
				<br><br>
				<br><br>
				<br><br>
				
		<!-- QnA =========================================================================== -->
				<h2>&nbsp;&nbsp;&nbsp;&nbsp;QnA</h2>
				<hr><br>
				
				<div id="accordion">
					<div class="card">
						<div class="card-header">
							<a class="card-link" data-toggle="collapse" href="#question1">
								Q : 질문 1
							</a>
						</div>
						<div id="question1" class="collapse" data-parent="#accordion">
							<div class="card-body">		<!-- 답변 내용 -->
							
								<div class="media border p-3">
									<div class="media-body">
										<h4>홍길동<small><i> 작성일 : 2018/06/20</i></small><button class="btn btn-primary btn-sm">추천 5</button></h4>
										<p>답변 1</p>
									</div>
								</div>	<!-- 답변 하나 끝 -->
							
								<div class="media border p-3">
									<div class="media-body">
										<h4>장보고 <small><i> 작성일 : 2018/06/20</i></small><button class="btn btn-primary btn-sm">추천 3</button></h4>
										<p>답변 2</p>
									</div>
								</div>	<!-- 답변 하나 끝 -->
								
	<!-- 더미 =====================================================================================  -->
								<br>
								<form class="form-inline" action="#">
									<label for="answer">A&nbsp;:&nbsp;</label>
									<input type="text" class="form-control col" id="answer">
									<button type="submit" class="btn btn-primary">등록</button>
								</form>
							</div>
						</div>
					</div>	<!-- question 1 end -->
					
					<div class="card">
						<div class="card-header">
							<a class="card-link" data-toggle="collapse" href="#question2">
								Q : 질문 2
							</a>
						</div>
						<div id="question2" class="collapse" data-parent="#accordion">
							<div class="card-body">
							
								<div class="media border p-3">
									<div class="media-body">
										<h4>장보고 <small><i> 작성일 : 2018/06/20</i></small><button class="btn btn-primary btn-sm">추천 5</button></h4>
										<p>답변 1</p>
									</div>
								</div>	<!-- 답변 하나 끝 -->
								
	<!-- 더미 2 ======================================================================================== -->
								<br>
								<form class="form-inline" action="#">
									<label for="answer">&nbsp;&nbsp;A&nbsp;:&nbsp;</label>
									<input type="text" class="form-control col" id="answer">
									<button type="submit" class="btn btn-primary">등록</button>
								</form>
							</div>
						</div>
					</div>
				</div>	<!-- question 2 end -->
				<br>
				<form class="form-inline" action="#">
					<label for="answer">&nbsp;&nbsp;Q&nbsp;:&nbsp;</label>
					<input type="text" class="form-control col" id="answer">
					<button type="submit" class="btn btn-primary">등록</button>
				</form>
				
			</div>	<!-- 본문 end -->
			
		</div> <!-- wrap end -->
		
		<!-- 글로벌 네비게이션 -->
		<c:import url="/nav/global_nav.jsp"/>
		<c:import url="/footer/footer.jsp"/>
	</body>
</html>