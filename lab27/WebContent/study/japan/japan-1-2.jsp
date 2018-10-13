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
				<h1>1.2 가타가나</h1>
				<br><hr><br><br>
				<p id="main-content">
				&nbsp;&nbsp; 가타카나는 일본어에서 사용하는 두 가지 문자(가나) 중 하나다. <br><br>
				&nbsp;&nbsp; 헤이안 시대 승려들이 불경을 훈독하기 위하여 한자 옆에 한자의 일부분에서 딴 기호를 붙여 일종의 발음기호로 활용했는데 이것이 가타카나라는 문자로 발전하였다. 각지고 딱딱한 느낌 때문에 남성적이고 강한 느낌을 주는 문자란 인식이 강했다. 메이지 유신 이후부터 2차대전 패전 전까지는 공문서 등에서 한자와 함께 쓰는 주된 문자로 취급되었으나 2차대전 이후 현재와 같은 형태로 가나 표기법을 바꾸면서 보조 문자로 위상이 뒤집어졌다. <br><br>
				&nbsp;&nbsp; '가타가나'로 잘못 표기되는 경우가 있는데 히라가나의 경우 ひらがな이므로 이를 '히라가나'로 표기하지만 가타카나의 경우에는 かたかな이기 때문에 이를 '가타카나'로 표기한다. 국립국어원의 외래어 표기법이 아닌 통용 표기에 따라 카타카나로 표기하는 경우도 있다. <br><br>
				&nbsp;&nbsp; 일본어를 배울 때는 보통 히라가나에 어느 정도 익숙해지고 나서 배우지만, 아예 처음부터 히라가나와 가타카나를 짝지어 가면서 가르치는 경우도 있다. 어느 쪽으로 배우든 한자 표기를 최소화하는 입문 단계에서는 아무래도 히라가나가 가타카나보다 더 광범위하게 쓰이기 때문에 대부분의 일본어 학습자들은 히라가나보다 가타카나를 조금 더 어려워하는 편이다. 그래서 일본어를 배운 사람들은 가타카나의 경우 50음도를 한 번에 외우기보다는, 해당 가타카나가 포함된 단어(특히 외래어)를 공부하면서 자연스럽게 머리속에 넣는 것을 추천하기도 한다. <br><br>
				&nbsp;&nbsp; 가타카나를 히라가나에 비해 좀 더 어렵다고 인식하는 것은 일본인들도 다를 바 없어서 유아들을 위한 글에서는 가타카나로 쓴 단어에 히라가나를 후리가나로 덧붙이기도 한다. <br><br>
				&nbsp;&nbsp; 히라가나(平仮名)란 명칭 자체는 일반적으로 한자를 마나(真名), 즉 진짜 글이라고 이라고 부르는 것에 대하여 가나(仮名) 즉 임시로 사용하는 글, 가짜 글이라는 뜻으로 부르는 것이며 平 자를 더하여 평범한 보통의 글이라는 뜻으로 부르는 것인데 우리나라에서 한글에 대하여 한자를 진서(眞書)라고 부르던 것과 같다.
				</p>
				
				<br><br>
				<table id="kana" class="table table-bordered">
					<tr>
						<th>＼</th>
						<th>ア단</th>
						<th>イ단</th>
						<th>ウ단</th>
						<th>エ단</th>
						<th>オ단</th>
					</tr>
					<tr>
						<th>ア행</th>
						<td>ア</td>
						<td>イ</td>
						<td>ウ</td>
						<td>エ</td>
						<td>オ</td>
					</tr>
					<tr>
						<th>カ행</th>
						<td>カ</td>
						<td>キ</td>
						<td>ク</td>
						<td>ケ</td>
						<td>コ</td>
					</tr>
					<tr>
						<th>サ행</th>
						<td>サ</td>
						<td>シ</td>
						<td>ス</td>
						<td>セ</td>
						<td>ソ</td>
					</tr>
					<tr>
						<th>タ행</th>
						<td>タ</td>
						<td>チ</td>
						<td>ツ</td>
						<td>テ</td>
						<td>ト</td>
					</tr>
					<tr>
						<th>ナ행</th>
						<td>ナ</td>
						<td>ニ</td>
						<td>ヌ</td>
						<td>ネ</td>
						<td>ノ</td>
					</tr>
					<tr>
						<th>ハ행</th>
						<td>ハ</td>
						<td>ヒ</td>
						<td>フ</td>
						<td>ヘ</td>
						<td>ホ</td>
					</tr>
					<tr>
						<th>マ행</th>
						<td>マ</td>
						<td>ミ</td>
						<td>ム</td>
						<td>メ</td>
						<td>モ</td>
					</tr>
					<tr>
						<th>ヤ행</th>
						<td>ヤ</td>
						<td></td>
						<td>ユ</td>
						<td></td>
						<td>ヨ</td>
					</tr>
					<tr>
						<th>ラ행</th>
						<td>ラ</td>
						<td>リ</td>
						<td>ル</td>
						<td>レ</td>
						<td>ロ</td>
					</tr>
					<tr>
						<th>ワ행</th>
						<td>ワ</td>
						<td></td>
						<td>ヲ</td>
						<td></td>
						<td>ン</td>
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