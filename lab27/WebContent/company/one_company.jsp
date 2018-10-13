<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!DOCTYPE html>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	table.type03 {
	
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-left: 3px solid #369;
  width:80%; margin:10%
}
table.type03 th {
    width: 147px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #153d73;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;

}
table.type03 td {
    width: 349px;
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
	


	#modal-table td{
	border: 1px solid white;
	}
	
</style>


</head>
<body>
<div>
	<div style="text-align:center; padding-top:20px;">
	<!-- 회사정보 -->
	<table class="type03">
	<tr>
	<td rowspan = "2" colspan="2"><img width="200px" height="150px" src="./images/logos/${company.company_logo}" alt="${company.company_logo}"></td>
	<th rowspan = "2" colspan="2">${company.company_name }</th>
	</tr>
	<tr>
	</tr>
	<tr>
	<th>업종</th> <td>${company.company_type }</td> <th>분야</th><td>${company.company_area }</td>
	</tr>
	<tr>
	<th>대표자명</th> <td>${company.company_ceo }</td> <th>설립연도</th><td>${company.company_year }</td>
	</tr>
	<tr>
	<th>홈페이지</th> <td colspan="3"> <a href="http://${company.company_page }"> http://${company.company_page } </a>  </td>
	</tr>
	<tr>
		<th>회사소개</th> <td colspan="3" rowspan="3" >${company.company_info }</td>
	</tr>
	<tr>
	</tr>
	<tr>
	</tr>
	<tr>
	<th>사원수</th> <td>${company.company_emp }명</td> <th>매출액</th><td>${company.company_money_s}</td>
	</tr>
	<tr>
	<th>자본금</th> <td>${company.company_cap_s} </td> <th>소재지</th><td>${company.company_loc }</td>
	</tr>
	</table>
	</div>
	


	<!-- 채용정보 -->
	<!-- 보완필요 -->
	<c:forEach items="${recruit_list}" var="recruit" varStatus="status">
	<table class="type03">
		<tr>
			<th colspan="4">채용정보(${status.count })</th>
		</tr>
		<tr>
			<th>직종</th><td> ${recruit.recuruit_type} </td> <th>채용형태 </th> <td>${recruit.recuruit_rtype}</td>
		</tr>
		<tr>
			<th>연봉</th><td>${recruit.recruit_pay}</td><th>근무시간</th><td>${recruit.recruit_time}</td>
		</tr>
		<tr>
		<th>모집기간</th><td colspan="3"><fmt:formatDate value="${recruit.end_day }" pattern="yyyy.MM.dd HH:mm"/></td>
		</tr>
		<tr>
		
		<td colspan="4">
							<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#modal-${status.index }"> 자세한 채용정보</button>
		</td>
		<tr>
		
	</table>
				
						<div class="modal fade" id="modal-${status.index }" style="text-align: center; vertical-align: middle;">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">

									<!-- Modal Header -->
									<div class="modal-header" style="text-align: center; vertical-align: middle; margin: auto;">

										<h4 class="modal-title" style="text-align: center; margin: auto;">채용정보</h4>

					
									</div>

									<!-- Modal body -->
									<div class="modal-body" style="vertical-align: middle; text-align: center; margin: auto; color: white;">
										<table id = "modal-table" style="text-align: center; vertical-align: middle; width:90%; margin-left:5%; color: white;">
											<tr><td>모집기간</td><td colspan="5"> <fmt:formatDate value="${recruit.start_day }" pattern="yyyy.MM.dd HH:mm"/>~<fmt:formatDate value="${recruit.end_day }" pattern="yyyy.MM.dd HH:mm"/></td><tr>
											<tr><td>업무내용</td><td colspan="5">${recruit.recuruit_info }</td>								
											<tr><td>채용형태</td><td colspan="2">${recruit.recuruit_rtype}</td> <td>비자</td><td colspan="2">${recruit.recuruit_visa}</td></tr>
											<tr><td>수습기간</td><td colspan="2">${recruit.recuruit_pbt }</td> <td>연수기간</td><td colspan="2">${recruit.recruit_tr }</td></tr>
											<tr><td>근무지</td><td colspan="2">${recruit.recruit_roc }</td> <td>근무시간</td><td colspan="2">${recruit.recruit_time}</td></tr>
											<tr><td rowspan="3">연봉</td><td rowspan="3" colspan="2">${recruit.recruit_pay} </td> <td>상여</td><td colspan="2">${recruit.recruit_bonus} </td></tr>
											<tr><td>수당</td><td colspan="2">${recruit.recruit_benefit} </td></tr>
											<tr><td>교통비</td><td colspan="2">${recruit.recruit_tray}</td></tr>
											<tr><td rowspan="4">복지</td><td>보험</td><td colspan="2">${recruit.recruit_ins} </td><td>항공임</td><td>${recruit.recruit_plane} </td></tr>
											<tr><td>휴가</td> <td colspan="4"> ${recruit.recruit_vac} </td></tr>
											<tr><td colspan="2" rowspan="2">기숙사 및 사택</td> <td>제공기간</td> <td colspan="2">${recruit.recruit_dom}</td></tr>
											<tr><td>본인 부담액</td> <td colspan="2">${recruit.recruit_domp}</td></tr>
											<tr><td rowspan="3"> 기타</td> <td rowspan="3" colspan="5">${recruit.recruit_etc}</td></tr>
											<tr></tr><tr></tr><tr></tr>
											<tr><td colspan="2">1차</td><td colspan="2">2차</td><td colspan="2">3차</td></tr>
											<tr><td colspan="2">${recruit.interview_1}</td><td colspan="2">${recruit.interview_2}</td><td colspan="2">${recruit.interview_3}</td></tr>
										</table>
									</div>

									<!-- Modal footer -->
									<div class="modal-footer"></div>
								</div>
								<!-- 모달 내용부 -->
							</div>
							<!-- 모달 다이얼로그 -->
						</div> <!-- 모달 -->
	
	</c:forEach>

	<!-- 댓글입력-->
	<c:if test="${loginUser!=null }">
		<form action="./addRating.lab27" method="post">
		<input type="hidden" name="command" value="addRating">
		<input type="hidden" name="company_id" value="${company.company_id }">
	
		<table class="type03">
			<tr>
			<th rowspan="6">${loginUser.user_id }</th>
			
			
			<td colspan="4">
				<input type="radio" name="rating_star" value="1" checked="checked">★☆☆☆☆
				<input type="radio" name="rating_star" value="2">★★☆☆☆
				<input type="radio" name="rating_star" value="3">★★★☆☆
				<input type="radio" name="rating_star" value="4">★★★★☆
				<input type="radio" name="rating_star" value="5">★★★★★
			</td>
			
			<td rowspan="6">
				<input type="submit" value="평가등록"/>
			</td>
			</tr>
			<tr>
			<th colspan="4"> 
			<font color="blue">장점</font><br>
			</th>
			
			</tr>
			<tr>
			<td>
			<textarea cols="80" rows="3" maxlength="200" name="rating_adv"></textarea>
			</td>
			<tr>
			
			<tr>
			<th colspan="4">
			<font color="red">단점</font><br>
			</th>
			</tr>
			<tr>
			<td>
			<textarea cols="80" rows="3" maxlength="200" name="rating_disadv"></textarea>
			</td>
			</tr>
			
		</table>
		
		
	
		<!-- 세션에서 받아오면된다. -->
		
		</form>
	</c:if>
		<div style="text-align:center;">
	<table class="type03">
	<!-- 댓글 -->
	<c:forEach items="${rating_list}" var="rating">

		<tr>
			<th rowspan="4"> ${rating.user_id }	
			</th>
			<th colspan="3">
				<font color="blue">장점</font> <br>
				</th>
			
	
			<td rowspan="2" >
			<c:if test="${rating.rating_star == 1 }">★☆☆☆☆</c:if>
			<c:if test="${rating.rating_star == 2 }">★★☆☆☆</c:if>
			<c:if test="${rating.rating_star == 3 }">★★★☆☆</c:if>
			<c:if test="${rating.rating_star == 4 }">★★★★☆</c:if>
			<c:if test="${rating.rating_star == 5 }">★★★★★</c:if>
			</td>
			
		</tr>
		
		<tr>
			<td colspan="3">
				<pre>${rating.rating_adv }</pre>
			</td>

		</tr
		>
		<tr>
			<th colspan="3">
			<font color="red">단점</font> </th>
		
			<td rowspan="2">
				<fmt:formatDate value="${rating.rating_regdate }" type="both" pattern="yyyy.MM.dd HH:mm"/>
			</td>

		</tr>
		<tr>
			<td colspan="3">
				<pre>${rating.rating_disadv }</pre>
			</td>
			</tr>
	<!-- 	<tr>
			<td></td>
		</tr>
		<tr>
		<td>
			<c:if test="${rating.user_id == loginUser.user_id}">
				<i class="fa fa-remove"></i>
			</c:if>
			
		</td>  <td></td>  <td></td>
		</tr> -->
	<tr><td colspan="5"></td></tr>
	</c:forEach>
	
		</table>
	</div>
	<div style="text-align:center;">
	<!-- 댓글 페이징 -->
	         <c:if test="${paging.startPage>1}">
                <a href="/lab27/oneCompany.lab27?command=oneCompany&&company_id=${company.company_id }&&currentPage=${paging.startPage-1}">&laquo</a>
              </c:if>
                	
				<c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}" step="1">
				
						<c:choose>
						<c:when test="${page == paging.currentPage}">
				 <a href="#"  onclick="return false;" class="active"> ${page} </a>
						</c:when>
						<c:otherwise>
						
				<a href="/lab27/oneCompany.lab27?command=oneCompany&&company_id=${company.company_id }&&currentPage=${page}">${page}</a>
						
						</c:otherwise>
						</c:choose>
				</c:forEach>
				
				<c:if test="${paging.endPage<paging.totalPage}">
               <a href="/lab27/oneCompany.lab27?command=oneCompany&&company_id=${company.company_id }&&currentPage=${paging.endPage+1}">&raquo;</a>
                </c:if>
                <br>
                <br>
               
          </div>
    	</div>
       <div style="text-align:center;">
        <button type="button" onclick="javascript:history.back()">돌아가기</button>
       </div>
          
        
<c:import url="/footer/footer.jsp"/>
</body>
</html>