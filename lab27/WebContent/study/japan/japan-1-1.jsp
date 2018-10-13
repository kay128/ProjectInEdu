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
		<script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js" integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9" crossorigin="anonymous"></script>
		
	</head>
	<body>
	
		<div id="main-wrap" class="row"> <!-- wrap -->

		<!-- 스터디 목차 ================================================================== -->
			<div id="study-side-nav">
				<c:import url="/study/japan/index.jsp"/>
			</div>	<!--  end -->
			
			
		<!-- 본문 ============================================================================= -->
			<div id="wrap">
				<h1>1.1 히라가나</h1>
				<br><hr><br><br>
				<p id="main-content">
				&nbsp;&nbsp; 일본어에서 사용하는 두 가나 중 하나. 히라가나는 외래어를 제외한 모든 일본어를 표기할 수 있는 문자로 일본어의 기본적인 문자다. 그리고 가타카나에 비해 모양이 비슷해도 긋는 방향만 미묘하게 다르지 않기 때문에 고유명사를 제외하면 히라가나로 많이 쓰인다. <br><br>
				&nbsp;&nbsp; 히라가나(平仮名)란 명칭 자체는 일반적으로 한자를 마나(真名), 즉 진짜 글이라고 이라고 부르는 것에 대하여 가나(仮名) 즉 임시로 사용하는 글, 가짜 글이라는 뜻으로 부르는 것이며 平 자를 더하여 평범한 보통의 글이라는 뜻으로 부르는 것인데 우리나라에서 한글에 대하여 한자를 진서(眞書)라고 부르던 것과 같다.
				</p>
				
				<br><br>
				<table id="kana" class="table table-bordered">
					<tr>
						<th>＼</th>
						<th>あ단</th>
						<th>い단</th>
						<th>う단</th>
						<th>え단</th>
						<th>お단</th>
					</tr>
					<tr>
						<th>あ행</th>
						<td>あ</td>
						<td>い</td>
						<td>う</td>
						<td>え</td>
						<td>お</td>
					</tr>
					<tr>
						<th>か행</th>
						<td>か</td>
						<td>き</td>
						<td>く</td>
						<td>け</td>
						<td>こ</td>
					</tr>
					<tr>
						<th>さ행</th>
						<td>さ</td>
						<td>し</td>
						<td>す</td>
						<td>せ</td>
						<td>そ</td>
					</tr>
					<tr>
						<th>た행</th>
						<td>た</td>
						<td>ち</td>
						<td>つ</td>
						<td>て</td>
						<td>と</td>
					</tr>
					<tr>
						<th>な행</th>
						<td>な</td>
						<td>に</td>
						<td>ぬ</td>
						<td>ね</td>
						<td>の</td>
					</tr>
					<tr>
						<th>は행</th>
						<td>は</td>
						<td>ひ</td>
						<td>ふ</td>
						<td>へ</td>
						<td>ほ</td>
					</tr>
					<tr>
						<th>ま행</th>
						<td>ま</td>
						<td>み</td>
						<td>む</td>
						<td>め</td>
						<td>も</td>
					</tr>
					<tr>
						<th>や행</th>
						<td>や</td>
						<td></td>
						<td>ゆ</td>
						<td></td>
						<td>よ</td>
					</tr>
					<tr>
						<th>ら행</th>
						<td>ら</td>
						<td>り</td>
						<td>る</td>
						<td>れ</td>
						<td>ろ</td>
					</tr>
					<tr>
						<th>わ행</th>
						<td>わ</td>
						<td></td>
						<td>を</td>
						<td></td>
						<td>ん</td>
					</tr>
				</table>
				<br><br>
				<br><br>
				
		<!-- QnA =========================================================================== -->
				<c:import url="/study/qna.jsp"/>
				
			</div>	<!-- 본문 end -->
			
		</div> <!-- wrap end -->
		
		<!-- 글로벌 네비게이션 -->
		<c:import url="/nav/global_nav.jsp"/>
		<c:import url="/footer/footer.jsp"/>
	</body>
</html>