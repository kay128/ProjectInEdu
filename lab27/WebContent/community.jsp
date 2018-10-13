<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html class="no-js">
	<head>
		<title>null</title>
		<link rel="stylesheet" type="text/css" href="css/default.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="js/modernizr.custom.js"></script>
		
		<!-- 네비게이션 용 css -->
		<link rel="stylesheet" href="/lab27/css/sideNavCSS.css">
		<!-- community 용 css -->
		<link rel="stylesheet" href="/lab27/css/community.css">
		
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
		<div id="main-wrap" class="row"> <!-- wrap -->
			<div id="lefty">
				<c:if test="${!empty myCommu }">
					<div id="lefty-title">
						<h4><i class="fab fa-font-awesome-flag"></i>&nbsp;개설한 모임</h4>
					</div>
					
					<div class="card" id="lefty-in">
						<div class="card-body">
							<table>
								<tr>
									<th>${myCommu.c_name }</th>
									<td>${myCommu.count }&nbsp;명</td>
								</tr>
							</table>
							<hr>
							${myCommu.c_theme }
						</div> 
						<div class="card-footer bg-secondary">
							<a class="btn btn-outline-light btn-sm" href="community_page.lab27?command=communityPage&c_name=${myCommu.c_name }">상세보기</a>
						</div>
					</div>
				</c:if>
			
				<div id="lefty-title">
					<h5><i class="fas fa-home"></i>&nbsp;가입한 모임 
						<button class="btn btn-outline-light btn-sm" data-toggle="modal" data-target="#modal-change-fav" id="change-fav">
							<i class="fas fa-star"></i>&nbsp;&nbsp;즐겨찾기 변경
						</button>
					</h5>
				</div>
				
				<c:if test="${!empty joinList }">
					<c:forEach items="${joinList }" var="list">
						<div class="card" id="lefty-in">
							<div class="card-body">
								<table>
									<tr>
										<th>${list.c_name }</th>
										<td>${list.count }&nbsp;명</td>
									</tr>
								</table>
								<hr>
								${list.c_theme }
							</div> 
							<div class="card-footer bg-secondary">
								<a class="btn btn-outline-light btn-sm" href="community_page.lab27?command=communityPage&c_name=${list.c_name }">상세보기</a>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
			
		<!-- 전체 모임 ============================================================================= -->
			<div id="righty">
				<h2>전체 모임 
					<c:if test="${empty myCommu }">
						<button class="btn btn-outline-secondary btn-sm" data-toggle="modal" data-target="#modal-new-commu" style="float:right;">
							<i class="fas fa-star"></i>&nbsp;&nbsp;신규 모임 생성
						</button>
					</c:if>
				</h2>
				<br>
				<form action="searchPage.lab27" method="post">
					<input type="hidden" value="searchPage" id="command"/>
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Search" id="param"/>
						<div class="input-group-append">
							<button class="btn btn-secondary" type="submit"><i class="fas fa-search"></i> 검색</button> 
						</div>
					</div>
				</form>
				<hr>
			
				<div class="container">
				<ul class="grid effect-5" id="grid">
					<c:forEach items="${allCommu }" var="list">
						<li>
							<div class="card" id="lefty-in">
								<div class="card-body">
									<table>
										<tr>
											<th>${list.c_name }</th>
											<td></td>
										</tr>
									</table>
									<hr>
									${list.c_theme }
								</div> 
								<div class="card-footer bg-secondary">
									<a class="btn btn-outline-light btn-sm" href="community_page.lab27?command=communityPage&c_name=${list.c_name }">상세보기</a>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
				</div>
			</div>
		</div>
		<!-- 즐겨찾기 추가 -->
		<!-- Modal 내용부 -->
		<div class="modal fade" id="modal-change-fav">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal body -->
					<div class="modal-body">
						- 즐겨찾기 변경 -<br><br>
						<form action="change-fav.lab27" class="form-inline" id="change-form">
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
		
		<!-- 신규 모임 생성 -->
		<!-- Modal 내용부 -->
		<div class="modal fade" id="modal-new-commu">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<!-- Modal body -->
					<div class="modal-body col">
						- 신규 모임 생성 -<br><br>
						<form action="new_Commu.lab27" class="form-inline" id="change-form" method="post">
							<input type="hidden" value="makeCommunity" id="command"/>
							<input type="text" placeholder="모임 명" id="c_name" class="form-control col"/>
							<input type="text" placeholder="모임 설명" id="c_theme" class="form-control col"/>
							<input class="btn btn-dark" type="submit" value="모임 생성"/> 
						</form>
					</div>
				</div>	<!-- 모달 내용부 -->
			</div>		<!-- 모달 다이얼로그 -->
		</div>			<!-- 모달 -->
		
		<!-- 글로벌 네비게이션 -->
		<c:import url="/nav/global_nav.jsp"/>
		<c:import url="/footer/footer.jsp"/>
		
		<script src="js/masonry.pkgd.min.js"></script>
		<script src="js/imagesloaded.js"></script>
		<script src="js/classie.js"></script>
		<script src="js/AnimOnScroll.js"></script>
		<script>
			new AnimOnScroll( document.getElementById( 'grid' ), {
				minDuration : 0.4,
				maxDuration : 0.7,
				viewportFactor : 0.2
			} );
		</script>

</body>
</html>