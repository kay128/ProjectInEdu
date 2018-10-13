<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
		<!-- 네비게이션 용 css -->
		<link rel="stylesheet" href="/lab27/css/sideNavCSS.css">
		<!-- community 용 css -->
		<link rel="stylesheet" href="/lab27/css/community-view.css">
		
		<!-- Bootstrap, Jquery, Poper -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js" integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9" crossorigin="anonymous"></script>
		
	</head>
	<body>
		<div id="main-wrap">
			<div class="card" id="board-info">
				<div class="card-header bg-secondary">
					&nbsp;&nbsp; 1등이다!
						<button style="float:right;" class="btn btn-outline-light"><i class="fas fa-trash-alt"></i>&nbsp;&nbsp;삭제</button>
						<button style="float:right;" class="btn btn-outline-light"><i class="fas fa-retweet"></i>&nbsp;&nbsp;수정</button>
						<button style="float:right;" class="btn btn-outline-light"><i class="far fa-list-alt"></i>&nbsp;&nbsp;목록</button>
				</div>
				<table class="table table-bordered">
					<tr>
						<th>no</th>
						<td>1</td>
						<th>작성자</th>
						<td>초딩</td>
						<th>조회수</th>
						<td>1</td>
						<th>작성일</th>
						<td>2018.06.24</td>
					</tr>
					<tr>
						<td colspan="8" id="content-area"> 내가 1등이다 ㅋㅋㅋㅋㅋ</td>
					</tr>
					<tr>
						<td colspan="8" id="comment-area">
							<div class="bg-secondary" id="comment-title">
								<strong>Comment</strong>&nbsp;&nbsp;<i class="fas fa-comment"></i>
							</div>
					
					<!-- 댓글 1 ==================================================================== -->	
							<div class="media border p-3" id="one_comment">
								<div class="media-body">
									초딩
									<small><i> 2018.07.02</i></small>
									<span id="btns-ara">
										<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-retweet"></i></button>
										<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-trash-alt"></i></button>
										<button class="btn btn-secondary btn-sm" data-toggle="collapse" data-target="#comment_1"><i class="fas fa-pen"></i></button>
									</span><br>
									<p>댓글 댓글 단다 댓글 댓글 단다</p>
								</div>
							</div>	<!-- 답변 1 끝 -->
					
					<!-- 대댓글 ============================================================================ -->
							<div class="media border p-3" id="comment_re">
								<div class="media-body">
									초딩
									<small><i> 2018.07.02</i></small>
									<span id="btns-ara">
										<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-retweet"></i></button>
										<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-trash-alt"></i></button>
									</span><br>
									<p>댓글 댓글 단다 댓글 댓글 단다</p>
								</div>
							</div>	<!-- 대댓글 끝 -->
							
					<!-- 대댓글 입력창 ====================================================================== -->
							<div id="comment_1" class="collapse">
								<br>
								<div class="input-group mb-3">
									<input type="text" class="form-control" placeholder="Comment">
									<div class="input-group-append">
										<button class="btn btn-secondary" type="submit"><i class="fas fa-pen"></i>&nbsp; 작성</button> 
									</div>
								</div>
							</div> <!-- 대댓글 입력창 끝  -->
							
							<br>
					
					<!-- 댓글 더미 ==================================================================== -->	
							<div class="media border p-3" id="one_comment">
								<div class="media-body">
									초딩
									<small><i> 2018.07.02</i></small>
									<span id="btns-ara">
										<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-retweet"></i></button>
										<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-trash-alt"></i></button>
										<button class="btn btn-secondary btn-sm" data-toggle="collapse" data-target="#comment_2"><i class="fas fa-pen"></i></button>
									</span><br>
									<p>댓글 댓글 단다 댓글 댓글 단다</p>
								</div>
							</div>	<!-- 답변 1 끝 -->
							
					<!-- 대댓글 입력창 ====================================================================== -->
							<div id="comment_2" class="collapse">
								<br>
								<div class="input-group mb-3">
									<input type="text" class="form-control" placeholder="Comment">
									<div class="input-group-append">
										<button class="btn btn-secondary" type="submit"><i class="fas fa-pen"></i>&nbsp; 작성</button> 
									</div>
								</div>
							</div> <!-- 대댓글 입력창 끝  -->
							
							<br><hr>
							
							
					<!-- 댓글 입력창 ======================================================================= -->
							<div class="input-group mb-3">
								<input type="text" class="form-control" placeholder="Comment">
								<div class="input-group-append">
									<button class="btn btn-secondary" type="submit"><i class="fas fa-pen"></i>&nbsp; 작성</button> 
								</div>
							</div> <!-- 댓글 입력창 끝 -->
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<!-- 글로벌 네비게이션 -->
		<c:import url="/nav/global_nav.jsp"/>
		<c:import url="/footer/footer.jsp"/>
	</body>
</html>