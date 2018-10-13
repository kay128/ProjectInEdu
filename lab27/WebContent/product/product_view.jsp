<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
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
<div id="main-wrap">
         <div class="card" id="board-info">
            <div class="card-header bg-secondary">
               
               &nbsp;&nbsp; 
               ${postReplyList.get(0).getTitle() }
                     <!-- Modal 호출 -->
   <a data-toggle="modal" data-target="#modal-admin-login" id="call-admin">
      <button style="float:right;" class="btn btn-outline-light">
                     <i class="fas fa-trash-alt"></i>&nbsp;&nbsp;삭제
                     </button>
   </a>
   <!-- Modal 내용부 -->
   <div class="modal fade" id="modal-admin-login">
      <div class="modal-dialog modal-sm">
         <div class="modal-content">
            <!-- Modal body -->
            <div class="modal-body">
               - 게시물 삭제 -<br><br>
               <form action="market.lab27">
               <div class="input-group mb-3">
                  <input type="hidden" name="command" value="p_delete">
                  <input type="hidden" name="current_page" value="${current_page}">
                  <input type="hidden" name="board_name" value="${ postReplyList.get(0).getBoard_name()}">
                  <input type="hidden" name="post_id" value="${ postReplyList.get(0).getPost_id()}">
                  <input type="password" class="form-control" name="pass" placeholder="password">
                  <div class="input-group-append">
                     <button class="btn btn-dark" type="submit">삭제</button> 
                  </div>
               </div>
               </form>
            </div>
         </div>   <!-- 모달 내용부 -->
      </div>      <!-- 모달 다이얼로그 -->
   </div>         <!-- 모달 -->
                  <button style="float:right;" class="btn btn-outline-light">
                     <i class="fas fa-retweet"></i>&nbsp;&nbsp;수정
                  </button>
                  <button style="float:right;" class="btn btn-outline-light" onClick="location.href='product/market.lab27?command=market_list'">
                     <i class="far fa-list-alt"></i>&nbsp;&nbsp;목록
                  </button>
            </div>
				<table class="table table-bordered">
					<tr>
						<th>no</th>
						<td>${postReplyList.get(0).getPost_id()}</td>
						<th>작성자</th>
						<td>${postReplyList.get(0).getP_user_id() }</td>
						<th>조회수</th>
						<td>${postReplyList.get(0).getHit() }</td>
						<th>작성일</th>
						<td>${postReplyList.get(0).getRegdate() }</td>
					</tr>
					<tr>
						<td><img src="lab27/images/${postReplyList.get(0).getImage_sa()}"/></td>
						<td colspan="8" id="content-area"> ${postReplyList.get(0).getP_content() }</td>
					</tr>
					
					<tr>
						<td colspan="8" id="comment-area">
							<div class="bg-secondary" id="comment-title">
								<strong>Comment</strong>&nbsp;&nbsp;<i class="fas fa-comment"></i>
							</div>
							<c:choose >
								<c:when test = "${postReplyList.get(0).getReply_id() == null }">
								</c:when>
								<c:otherwise>
									<c:forEach
										var = "reply"
										items = "${postReplyList }"
										begin="0"
										end = "${postReplyList.size() }"
										varStatus = "status">
										<c:choose>
											<c:when test="${reply.lev == 0 }">
												<div class="media border p-3" id="one_comment">
													<div class="media-body">
														${reply.r_user_id }
														<small><i> ${reply.reply_regdate }</i></small>
														<span id="btns-ara">
															<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-retweet"></i></button>
															<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-trash-alt"></i></button>
															<button class="btn btn-secondary btn-sm" data-toggle="collapse" data-target="#comment_${status.count }"><i class="fas fa-pen"></i></button>
														</span><br>
														<p>${reply.r_content }</p>
													</div>
												</div>
												<form action = "reply.lab27" method = "post">
													<div id="comment_${status.count }" class="collapse">
														<br>
														<div class="input-group mb-3">
															<input type="hidden" name="board_name" value="${reply.board_name }"/>
															<input type="hidden" name="command" value="r_write"/>
															<input type="hidden" name="post_id" value="${reply.post_id}"/>
															<input type="hidden" name="lev" value="1"/>
															<input type="hidden" name="sort" value="${reply.sort }"/>
															<input type="hidden" name="current_page" value="${current_page }"/>
															<input type="text" class="form-control" placeholder="Comment" name="r_content">
															<div class="input-group-append">
																<button class="btn btn-secondary" type="submit"><i class="fas fa-pen"></i>&nbsp; 작성</button> 
															</div>
														</div>
													</div> <!-- 대댓글 입력창 끝  -->
												</form>
												<br>
											</c:when>
											<c:otherwise>
												<div class="media border p-3" id="comment_re">
													<div class="media-body">
														${reply.r_user_id }
														<small><i> ${reply.reply_regdate }</i></small>
														<span id="btns-ara">
															<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-retweet"></i></button>
															<button class="btn btn-secondary btn-sm" type="submit"><i class="fas fa-trash-alt"></i></button>
														</span><br>
														<p>${reply.r_content }</p>
													</div>
												</div>									
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:otherwise>
							</c:choose>
													
							
					<!-- 댓글 입력창 ======================================================================= -->
					<form action = "reply.lab27" method = "post">
							<div class="input-group mb-3">
									<input type="hidden" name="board_name" value="${postReplyList.get(0).getBoard_name() }"/>
									<input type="hidden" name="command" value="r_write"/>
									<input type="hidden" name="post_id" value="${postReplyList.get(0).getPost_id()}"/>
									<input type="hidden" name="lev" value="0"/>
									<input type="hidden" name="sort" value="${sortMax }"/>
									<input type="hidden" name="current_page" value="${current_page }"/>
									<input type="text" class="form-control" placeholder="Comment" name="r_content"/>
									<div class="input-group-append">
										<button class="btn btn-secondary" type="submit"><i class="fas fa-pen"></i>&nbsp; 작성</button> 
									</div>
								
							</div> <!-- 댓글 입력창 끝 -->
							</form>
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