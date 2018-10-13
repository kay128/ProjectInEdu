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
		<!-- mypage 용 css -->
		<link rel="stylesheet" href="/lab27/css/mypage.css">
		
		<!-- Bootstrap, Jquery, Poper -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
		<script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js" integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9" crossorigin="anonymous"></script>
		
		</head>
	<body>
		<div id="main-wrap"> <!-- wrap -->
			<div class="card" id="order-div-fir" data-order=1>
				<div class="card-header bg-secondary">
					&nbsp;<i class="fas fa-user"></i>&nbsp;&nbsp;개인정보
				</div>
				<div class="card-body row">
					<div id="info-left">
							<table id="tables">
								<tr>
									<th>이름</th>
									<td>${loginUser.name }</td>
									<th>기수</th>
									<td>${loginUser.grade_id }</td>
								</tr>
							</table>
							
							<table id="tables">
								<tr>
									<th>연수 기간</th>
									<td>2018.00.00 ~ 2018.00.00</td>
								</tr>
							</table>
							
							<table id="tables">
								<tr>
									<th>연락처</th>
									<td>${loginUser.phone }</td>
								</tr>
							</table>
							
							<table id="tables">
								<tr>
									<th>이메일</th>
									<td>${loginUser.email }</td>
								</tr>
							</table>
							
							<br><hr>
							<h4>・&nbsp;최근 수업 페이지</h4>
								<table id="tables">
									<tr>
										<th>&nbsp;IT</th>
										<td><a href="#">5-2 Collection</a></td>
									</tr>
									<tr>
										<th>&nbsp;일본어</th>
										<td><a href="#">3-1 동사의 활용</a></td>
									</tr>
								</table>
						</div>
						<div id="info-right">
							<img src="/lab27/images/place.png"><br><br>
							<a class="btn btn-outline-secondary" href="/mypage.lab27?command=m_modify_form">개인정보 수정</a>
						</div>
					</div> 
				</div> <!-- fir-div end -->
			
			<div id="order-div" data-order=2 class="row">
				<div class="card" id="group-left">
					<div class="card-header bg-secondary">
						&nbsp;<i class="fab fa-font-awesome-flag"></i>&nbsp;&nbsp;내가 개설한 모임
					</div>
					<div class="card-body">
						<c:choose>
							<c:when test="${empty myCommu}">
								<br><br>
								&nbsp;&nbsp;아직 개설한 커뮤니티가 존재하지 않습니다.
							</c:when>
							
							<c:otherwise>
								<br>
								<table id="tables">
									<tr>
										<th>모임 명</th>
										<td>${myCommu.c_name }</td>
										<th>맴버 수</th>
										<td>${myCommu.count }&nbsp;명</td>
									</tr>
								</table>
									
								<table id="tables">
									<tr>
										<th>모임 소개</th>
										<td>${myCommu.c_theme }</td>
									</tr>
								</table>
								
								<c:if test="${!empty myCommuNotice }">
									<div class="alert alert-info">
										<strong>공지</strong>&nbsp;&nbsp;&nbsp;${myCommuNotice.title } <a href="/mypage.lab27?command=viewOnePost&post_id=${myCommuNotice.post_id }&board_name=${myCommu.c_name }" class="alert-link">[자세히]</a>
									</div>
								</c:if>

								<hr>
								
								<table id="tables">
									<tr>
										<th>최신 글</th>
										<td> </td>
									</tr>
								</table>
								<c:if test="${!empty myCommuPost }">
									<div class="alert alert-info">
										<strong>${myCommuPost.post_id }</strong>&nbsp;&nbsp;&nbsp;${myCommuPost.title } <a href="/mypage.lab27?command=viewOnePost&post_id=${myCommuPost.post_id }&board_name=${myCommu.c_name }" class="alert-link">[자세히]</a>
									</div>
								</c:if>
								<br>
								<a class="btn btn-secondary btn-sm" href="/community_page.lab27?command=communityPage?c_name=${myCommu.c_name }">상세보기</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div> <!-- group-left end -->
				
				<div class="card" id="group-right">
					<div class="card-header bg-secondary">
						&nbsp;<i class="fas fa-home"></i>&nbsp;&nbsp;가입한 모임
						<button style="float:right;" class="btn btn-outline-light" data-toggle="modal" data-target="#modal-change-fav"><i class="fas fa-star"></i>&nbsp;&nbsp;즐겨찾기 변경</button>
					</div>
					<div class="card-body">
						<ul class="nav nav-tabs">
							<c:choose>
								<c:when test="${empty favList }">
									<li class="nav-item">
										<a class="nav-link active" data-toggle="tab" href="#home">가입된 모임이 없습니다.</a>
									</li>
								</c:when>
								<c:otherwise>
									<c:forEach items="${favList }" var="list" varStatus="status">
									
										<li class="nav-item">
											<a class="nav-link" data-toggle="tab" href="#menu${status.index }" id="menu1-a">망한 모임</a>
										</li>
										<c:if test="${status.index == 1 }">
											<script>
												$('#menu1-a').addClass(" active");
											</script>
										</c:if>
										
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</ul>
						
						<!-- Tab panes -->
						<div class="tab-content">
							<c:choose>
								<c:when test="${empty favList }">
									<div class="tab-pane container active" id="home">
										<br>
										가입한 모임이 존재하지 않습니다.
									</div>
								</c:when>
								<c:otherwise>
									<c:forEach items="${favList }" var="list" varStatus="status">
									
										<div class="tab-pane container" id="menu${status.index }">
										<br>
										<table id="tables">
											<tr>
												<th>모임 명</th>
												<td>${list.c_name }</td>
												<th>맴버 수</th>
												<td>${list.count }&nbsp;명</td>
											</tr>
										</table>
											
										<table id="tables">
											<tr>
												<th>모임 소개</th>
												<td>${list.c_theme }</td>
											</tr>
										</table>
										
										<c:if test="${favNoticeList[status.count] ne null }">
											<div class="alert alert-info">
												<strong>공지</strong>&nbsp;&nbsp;&nbsp;${favNoticeList[status.count].title } <a href="/mypage.lab27?command=viewOnePost&post_id=${favNoticeList[status.count].post_id }&board_name=${list.c_name }" class="alert-link">[자세히]</a>
											</div>
										</c:if>
										<hr>
										
										<table id="tables">
											<tr>
												<th>최신 글</th>
												<td> </td>
											</tr>
										</table>
										
										<c:if test="${favPostList[status.count] ne null }">
											<div class="alert alert-info">
												<strong>${favPostList[status.count].post_id }</strong>&nbsp;&nbsp;&nbsp;${favPostList[status.count].title } <a href="/mypage.lab27?command=viewOnePost&post_id=${favPostList[status.count].post_id }&board_name=${list.c_name }" class="alert-link">[자세히]</a>
											</div>
										</c:if>
									</div>
										<c:if test="${status.index == 1 }">
											<script>
												var num = ${status.index};
												$('#menu'+num).addClass(" active");
											</script>
										</c:if>
										
										<c:if test="${status.index ne 1 }">
											<script>
												$('#menu'+num).addClass(" fade");
											</script>
										</c:if>
										<br>
										<a class="btn btn-secondary btn-sm" href="/community_page.lab27?command=communityPage?c_name=${list.c_name }">상세보기</a>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>  <!-- group-right end -->
			</div> <!-- sec-div end -->
			
		<div class="card" id="order-div-fir" data-order=3>
			<div class="card-header bg-secondary">
				&nbsp;<i class="fas fa-shopping-basket"></i>&nbsp;&nbsp;장터
			</div>
			<div class="card-body" id="body-content">
				내가 쓴 글 [물물교환] &nbsp;&nbsp; <span class="badge badge-pill badge-danger">${freePostCount }</span>
				<hr>
				<c:choose>
					<c:when test="${empty freePostList }">
						<div class="alert alert-secondary">
							<strong>등록한 물물교환글이 존재하지 않습니다.</strong>
						</div>
					</c:when>
					<c:otherwise>
						<c:forEach items="${freePostList }" var="list" varStatus="status">
							<div class="alert alert-info">
								<strong>물물교환 </strong>&nbsp;&nbsp;&nbsp;${list.title } <a href="/mypage.lab27?command=viewOnePost&post_id=${list.post_id }&board_name=freePost" class="alert-link">[자세히]</a>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<br><hr><br>
				
				내가 쓴 글 [나눔] &nbsp;&nbsp; <span class="badge badge-pill badge-danger">${exchangePostCount }</span>
				<hr>
				
				<c:choose>
					<c:when test="${empty exchangePostList }">
						<div class="alert alert-secondary">
							<strong>등록한 나눔글이 존재하지 않습니다.</strong>
						</div>
					</c:when>
					<c:otherwise>
						<c:forEach items="${exchangePostList }" var="list" varStatus="status">
							<div class="alert alert-info">
								<strong>나눔 </strong>&nbsp;&nbsp;&nbsp;${list.title } <a href="/mypage.lab27?command=viewOnePost&post_id=${list.post_id }&board_name=freePost" class="alert-link">[자세히]</a>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div> <!-- tri-div end -->
			
		<div class="card" id="order-div-fir" data-order=4>
			<div class="card-header bg-secondary">
				&nbsp;<i class="fas fa-question-circle"></i>&nbsp;&nbsp;QnA
			</div>
			<div class="card-body" id="body-content">
				내가 쓴 질문 &nbsp;&nbsp; <span class="badge badge-pill badge-danger">0</span>
				<hr>
				
				<div class="alert alert-secondary">
					<strong>등록한 질문이 존재하지 않습니다.</strong>
				</div>
				
				<br><hr><br>
				
				내가 쓴 답변 &nbsp;&nbsp; <span class="badge badge-pill badge-danger">0</span>
				<hr>
				
				<div class="alert alert-secondary">
					<strong>등록한 답변이 존재하지 않습니다.</strong>
				</div>
			</div>
		</div> <!-- tri-div end -->
			
		</div> <!-- main-wrap end -->
		
		
		<!-- Modal 내용부 -->
		<div class="modal fade" id="modal-change-fav">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal body -->
					<div class="modal-body">
						- 즐겨찾기 변경 -<br><br>
						<form action="/change-fav.lab27" class="form-inline" id="change-form">
							<input type="hidden" value="updateFav" id="command"/>
							<input type="hidden" value="community" id="rts"/>
								<div class="form-group">
									<select class="form-control" id="sel1">
										<option selected="selected" value="">선택안함</option>
										<c:forEach items="${joinList }" var="list">
											<option value="${list.c_name }">${list.c_name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<select class="form-control" id="sel2">
										<option selected="selected" value="">선택안함</option>
										<c:forEach items="${joinList }" var="list">
											<option value="${list.c_name }">${list.c_name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<select class="form-control" id="sel3">
										<option selected="selected" value="">선택안함</option>
										<c:forEach items="${joinList }" var="list">
											<option value="${list.c_name }">${list.c_name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="input-group-append">
									<button class="btn btn-dark" type="submit">변경하기</button> 
								</div>
						</form>
					</div>
				</div>	<!-- 모달 내용부 -->
			</div>		<!-- 모달 다이얼로그 -->
		</div>			<!-- 모달 -->

	<script>
		var sw = true;
		function switchingOrder(){
			$("#main-wrap").sortable({
				axis: "y",
				containment: "parent",
				update: function (event, ui) {
					var order = $(this).sortable('toArray', {
						attribute: 'data-order'
					});
					console.log(order);
				}
			});
		}
	</script>
		
		<!-- 글로벌 네비게이션 -->
		<c:import url="/nav/global_nav.jsp"/>
		<c:import url="/footer/footer.jsp"/>
	</body>
</html>