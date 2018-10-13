<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.jsp" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<title>Insert title here</title>
<!-- 네비게이션 용 css -->
<link rel="stylesheet" href="/lab27/css/sideNavCSS.css">
<!-- community 용 css -->
<link rel="stylesheet" href="/lab27/css/community-page.css">

<!-- Bootstrap, Jquery, Poper -->
<link rel="stylesheet" href="/lab27/css/product.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"
	integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9"
	crossorigin="anonymous"></script>

</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">
		<div id="main">
			<section class="post">

				<!-- Form -->
				<h2><i class="fas fa-shopping-cart"></i>&nbsp;&nbsp;장터 등록</h2>
				<br><br>
				<form method="post" action="market.lab27?command=p_write" enctype="multipart/form-data">
					<div class="row gtr-uniform">
						<div class="col-6 col-12-xsmall">
							
							<input type="text" name="title" id="title" value=""
								placeholder="제목" />
						</div>
						<!-- Break -->
						<div class="col-9">
							<select name="board_name" id="board_name">
								<option value="">- Category -</option>
								<option value="free">무료나눔</option>
								<option value="exchange">물물교환</option>
							</select>
						</div>
						<div class="col-6">
							<input type="file" name="photo_or"/>
						</div>
						<!-- Break -->
						<div class="col-12">
							<textarea name="content" id="content"
								placeholder="내용을 입력하세요" rows="6"></textarea>
						</div>
						<!-- Break -->
						<div class="col-12">
							<ul class="actions">
							
								<li><input type="submit" value="Submit"
									class="primary" /></li>
								<li><input type="reset" value="Reset" /></li>
							</ul>
						</div>
					</div>
				</form>


			</section>
		</div>
	</div>
	<!-- 글로벌 네비게이션 -->
	<c:import url="/nav/global_nav.jsp" />
	<c:import url="/footer/footer.jsp" />
	<!-- Scripts -->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.scrollex.min.js"></script>
	<script src="js/jquery.scrolly.min.js"></script>
	<script src="js/browser.min.js"></script>
	<script src="js/breakpoints.min.js"></script>
	<script src="js/util.js"></script>
	<script src="js/main.js"></script>

</body>
</html>