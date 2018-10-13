<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h2>&nbsp;&nbsp;&nbsp;&nbsp;QnA</h2>
<hr>

<div id="accordion">
	<div class="card">
		<div class="card-header bg-secondary">
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
				
				<form action="#" method="post">
					<div class="input-group mb-3" >
						<div class="input-group-append" id="a">
							A&nbsp;:&nbsp;
						</div>
						<input type="text" class="form-control" placeholder="답변" id="answer">
						<div class="input-group-append">
							<button class="btn btn-primary" type="submit"><i class="fas fa-pen"></i> 등록</button> 
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>	<!-- question 1 end -->
	
	<div class="card">
		<div class="card-header bg-secondary">
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
<form action="#" method="post">
	<div class="input-group mb-3" >
		<div class="input-group-append" id="a">
			Q&nbsp;:&nbsp;
		</div>
		<input type="text" class="form-control" placeholder="질문" id="question">
		<div class="input-group-append">
			<button class="btn btn-primary" type="submit"><i class="fas fa-pen"></i> 등록</button> 
		</div>
	</div>
</form>