<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div id="footer">
	ⓒ Copyright By...<br>
	<marquee>정지현&nbsp;&nbsp;&nbsp;김아영&nbsp;&nbsp;&nbsp;채형섭&nbsp;&nbsp;&nbsp;윤정석&nbsp;&nbsp;&nbsp;서명원&nbsp;&nbsp;&nbsp;김현승&nbsp;&nbsp;&nbsp;김민수&nbsp;&nbsp;&nbsp;구슬기&nbsp;&nbsp;&nbsp;진서예&nbsp;&nbsp;&nbsp;박종석&nbsp;&nbsp;&nbsp;이지수&nbsp;&nbsp;&nbsp;이동민</marquee>
	<br><br>
	<hr>
	SITE MAP
	<br><br>
	<div id="site-map" class="row">
		<div id="site-map-sub" class="col">
			<a href="/lab27/index.jsp">Home</a>
		</div>
		<div id="site-map-sub" class="col">
			<a href="#">IT</a>
		</div>
		<div id="site-map-sub" class="col">
			<a href="#">일본어</a>
		</div>
		<div id="site-map-sub" class="col">
			<a href="market.lab27?command=market_list">장터</a>
		</div>
		<div id="site-map-sub" class="col">
			<a href="group.lab27?command=communityMain">모임</a>
		</div>
		<div id="site-map-sub" class="col">
			<a href="#">회사정보</a>
		</div>
		<div id="site-map-sub" class="col">
			<a href="/lab27/mypage.jsp">마이페이지</a>
		</div>
	</div>
	<br>
	<hr>
	<!-- Modal 호출 -->
	<a data-toggle="modal" data-target="#modal-admin-login" id="call-admin">
	&nbsp;&nbsp;&nbsp;
	</a>
	<!-- Modal 내용부 -->
	<div class="modal fade" id="modal-admin-login">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<!-- Modal body -->
				<div class="modal-body">
					- ADMIN PAGE -<br><br>
					<form action="alogin.lab27">
						<div class="input-group mb-3">
							<input type="hidden" name="command" value="a_login">
							<input type="password" class="form-control" name="pass" placeholder="password">
							<div class="input-group-append">
								<button class="btn btn-dark" type="submit">로그인</button> 
							</div>
						</div>
					</form>

				</div>
			</div>	<!-- 모달 내용부 -->
		</div>		<!-- 모달 다이얼로그 -->
	</div>			<!-- 모달 -->
</div>