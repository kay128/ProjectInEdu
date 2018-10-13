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
		<link rel="stylesheet" href="/lab27/css/community-page.css">
		
		<!-- Bootstrap, Jquery, Poper -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js" integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9" crossorigin="anonymous"></script>
		
	</head>
	<body>
		<script>
			$( document ).ready(function (){
				if(${is_join == "true"}){
					if(confirm("모임에 가입되어 있지 않습니다. 가입하시겠습니까?")){
						location.replace("group.lab27?command=communityJoin&c_name=${c_name}");
					}else{
						location.replace("group.lab27?command=communityMain");
					}
				}else{
					
				}
		    });
			
			function check(){
				if(confirm("정말로 탈퇴하시겠습니까?")){
					location.replace("group.lab27?command=communityDrop&c_name=${cAll[0].c_name}");
					return true;
				}else{
					return false;
				}
			}
		</script>
	
		<div id="main-wrap">
			<div class="card" id="group-info">
				<div class="card-header bg-secondary">
					<i class="fas fa-home"></i>&nbsp;&nbsp;${cAll[0].c_name }
				
				<a class="btn btn-outline-light" href="product/product_form.jsp" style="float: right; margin-left:10px;"><i class="fas fa-edit"></i>&nbsp;&nbsp;글쓰기</a>
				
				<a class="btn btn-outline-light" onclick="return check()" style="float: right; margin-left:10px;"><i class="fas fa-sign-in-alt"></i>&nbsp;&nbsp;탈퇴</a>
				</div>
				<table class="table table-bordered">
					<tr>
						<th rowspan="3">${cAll[0].c_name }</th>
						<th>인원</th>
						<th>생성날짜</th>
					</tr>
					<tr>
						<td>${cAll[0].count }&nbsp;명</td>
						<td>${cAll[0].c_date }</td>
					</tr>
					<tr>
						<td colspan="2">
							${cAll[0].c_theme }
						</td>
					</tr>
				</table>
			</div>
			
			<div id="group-board">
				<table class="table table-hover">
					<tr>
						<th>no</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<c:if test="${empty postList }">
						<tr>
							<td colspan="6">아직 작성된 게시글이 존재하지 않습니다.</td>
						</tr>
					</c:if>
					<c:forEach 
						var = "post"
						items ="${ postList}"
						begin = "${paging.st_inlist }"
						end = "${paging.ed_inlist }"
						step="1"
						varStatus="status">
						<tr>
						<td>${post.post_id }</td>
						<td><a href="market.lab27?command=p_select_one_post&post_id=${post.post_id }
						&board_name=${post.board_name}&current_page=${paging.current_page}">${post.title }</a></td>
						<td>${post.user_id }</td>
						<td>${post.regdate }</td>
						<td>${post.hit }</td>
						</tr>
					</c:forEach>
	
				</table>
				${paging.page_html }
	
			</div>
		</div>
		
		<!-- 글로벌 네비게이션 -->
		<c:import url="/nav/global_nav.jsp"/>
		<c:import url="/footer/footer.jsp"/>
	</body>
</html>