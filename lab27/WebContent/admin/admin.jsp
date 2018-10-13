<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	      <!-- 네비게이션 용 css -->
      <link rel="stylesheet" href="/lab27/css/sideNavCSS.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>admin.jsp</title>
	  <!-- Bootstrap, Jquery, Poper -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
      <script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js" integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9" crossorigin="anonymous"></script>
      <link rel="stylesheet" type="text/css" href="/lab27/admin/admin.css">
       <script type="text/javascript">
       $(function() {
   	    $( ".testDatepicker1" ).datepicker({
				changeMonth: true, 
				changeYear: true,
				nextText: '다음 달',
				prevText: '이전 달', 
				showButtonPanel: true, 
				currentText: '오늘 날짜', 
				closeText: '닫기', 
				dateFormat: "yymmdd",
				dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
				dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
				monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
				monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				minDate : "-1Y",
				maxDate : 0,
	    	    onSelect : function(selected){
	    	    	$(".testDatepicker2").datepicker("option", "minDate", selected)
	    	    }
   	    });
   	    $( ".testDatepicker2" ).datepicker({
				changeMonth: true, 
				changeYear: true,
				nextText: '다음 달',
				prevText: '이전 달', 
				showButtonPanel: true, 
				currentText: '오늘 날짜', 
				closeText: '닫기', 
				dateFormat: "yymmdd",
				dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
				dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
				monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
				monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				maxDate : "+1D",
	    	    onSelect : function(selected){
	    	    	$(".testDatepicker1").datepicker("option", "maxDate", selected)
	    	    }
   	    });
   	});
	      </script>
	      <script>
	      function admin_info(){
	          var offset = $("#admin_info").offset();
	          $('html, body').animate({scrollTop : offset.top}, 400);
	      }
	      function admin_user(){
	          var offset = $("#admin_user").offset();
	          $('html, body').animate({scrollTop : offset.top}, 400);
	      }
	      function market_search(){
	          var offset = $("#market_search").offset();
	          $('html, body').animate({scrollTop : offset.top}, 400);
	      }
	      function comuunity_search(){
	          var offset = $("#comuunity_search").offset();
	          $('html, body').animate({scrollTop : offset.top}, 400);
	      }
	      </script>
	      
	      </script>
             <script type="text/javascript">
           if("${!empty check}"){
            var check = <%=session.getAttribute("check")%>
            
         }      
            $( document ).ready(function (){
               switch(check){
               case 1:
                  admin_info();
                  break;
               case 2:
                  admin_user();
                  break;
               case 3:
                  market_search();
                  break;
               case 4:
                  comuunity_search();
                  break;
                   case 0:
                default:
                   break;
            }                
            });
         </script>
	      
	</head>
	<!------------------------------------------------ header ----------------------------------------------->
	<body>
		<br>
			<div id="admin_fixed">
				<a onclick="admin_info()" class = "btn"><i class="fas fa-info-circle"></i>&nbsp;&nbsp;관리자정보</a><br>
				<a onclick="admin_user()" class = "btn"><i class="fas fa-user"></i>&nbsp;&nbsp;사용자검색</a><br>
				<a onclick="market_search()" class = "btn"><i class="fas fa-shopping-basket"></i>&nbsp;&nbsp;벼룩시장검색</a><br>
				<a onclick="comuunity_search()" class = "btn"><i class="fas fa-home"></i>&nbsp;&nbsp;모임검색</a>
			</div>
		<div id="admin_wrap">
			<div id="admin_adminIcon">
				<h1><i class="fas fa-user-cog"></i>&nbsp;관리자페이지<a href="/lab27/index.jsp" style="float: right; color: #8f3c38"><i class="fab fa-fort-awesome-alt"></i></a></h1>
				<hr>
			</div>
			<br><br>
	<!----------------------------------------------- 관리자정보 ------------------------------------->			
			<div id="admin_info">
				<h3>1) 관리자 정보</h3>
				<br>				
					<div id = "admin_search">
						<div id = "name" class="input-group mb-3a">
							<div class = "input-group-append" id = "iga" style="width: 135px; margin-left: auto; margin-right: auto;">비밀번호&nbsp;&nbsp;</div>
			               	<input type="password" class="form-control">			               	
			            </div>	            
			            <div id = "number" class="input-group mb-3">
						   <div class = "input-group-append" id = "iga" style="width: 135px;">비밀번호&nbsp;확인&nbsp;</div>
			               <input type="password" class="form-control">
			               <div class="input-group-append">
			                  <button class="btn btn-secondary" type="submit" style="background-color: #8f3c38;"><i class="fas fa-retweet"></i>변경</button> 
			               </div>
			            </div>
		            </div>		
			<br><br>
	<!----------------------------------------------- 회원관리 ------------------------------------->
			<div id="admin_user">
				<h3>2) 사용자검색</h3>
			<br><br>
			<div id = "admin_search">
				<form action="usernamesearch.lab27">
				<div id = "name" class="input-group mb-3">
					<div class = "input-group-append" id = "iga" style="width: 90px;">이름&nbsp;&nbsp;</div>
					<input type="hidden" name="command" value="a_user_search">
	               	<input type="text" class="form-control" name="name" placeholder="Search">
	               	<div class="input-group-append">
	               		<button class="btn btn-secondary" type="submit" style="background-color: #8f3c38;"><i class="fas fa-search"></i> 검색</button> 
	                </div>	               
	            </div>
	            </form>	
	            <form action="usergradeidsearch.lab27">            
	            <div id = "number" class="input-group mb-3">
				   <div class = "input-group-append" id = "iga" style="width: 90px;">기수&nbsp;&nbsp;</div>
				   <input type="hidden" name="command" value="a_user_search">
	               <input type="text" class="form-control" name="grade" placeholder="Search">
	               <div class="input-group-append">
	                  <button class="btn btn-secondary" type="submit" style="background-color: #8f3c38;" ><i class="fas fa-search"></i> 검색</button> 
	               </div>
	            </div>
	            </form>
            </div>
            <br><br><br>
	            <div>
	            	<table class="table table-hover" id="admin_table">
	            		<tr>
	            			<th>이름</th>
	            			<th>기수</th>
	            			<th>연락처</th>
	            			<th>상세보기</th>
	            			<th>삭제</th>        			
	            		</tr>
	            		<c:forEach items="${memberName }" var="m_name">
	            		<tr>

	            			<td>${m_name.name }</td>
	            			<td>${m_name.grade_id }</td>
	            			<td>${m_name.phone }</td>
	            			<td><button class="btn btn-primary" data-toggle="collapse" data-target="#collapseOne" style="background-color: #375380; border-color: #375380;">상세보기</button></td>
	            			<td><button class="btn btn-danger" style="background-color: #8f3c38; border-color: #8f3c38;" onclick = ""><i class="fas fa-user-alt-slash"></i>&nbsp;&nbsp;삭제</button></td>
	            		</tr>
	            		</c:forEach>
	            	</table>
	            	<!-- 페이징 버튼 -->
					<ul class="pagination justify-content-center" style="margin:20px 0">
						<li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
					</ul>
	            	<div id="accordion">
	            		<div class="card" id="admin_detail">
	            			<div class="card-header">
	            					<font color="black">상세보기</font>
	            			</div>
	            			<div id="collapseOne" class="collapse" data-parent="#accordion">
		            			<div class="card-body row">
									               <div id="info-left">
									                     <table id="tables">
									                     	<c:forEach items="${memberName }" var="m_name">
									                        <tr>
									                           <th>이름</th>
									                           <td>${m_name.name }</td>
									                           <th>기수</th>
									                           <td>${m_name.grade_id }</td>
									                        </tr>
									                        </c:forEach>
									                     </table>
									                     
									                     <table id="tables">
									                        <c:forEach items="${memberName }" var="m_name">
									                        <tr>
									                           <th>연수 기간</th>
									                           <c:set value = "m_name.grade_id" var = "2017.09.27 ~ 2018.07.06"/> 
									                           <c:if test = "${m_name.grade_id == 27  }">
									                           <td><c:out value  = "${m_name.grade_id }"/></td>
									                           </c:if>
									                        </tr>
									                        </c:forEach>
									                     </table>
									                     
									                     <table id="tables">
									                        <c:forEach items="${memberName }" var="m_name">
									                        <tr>
									                        	<th>연락처</th>
									                           <td>${m_name.phone }</td>
									                        </tr>
									                        </c:forEach>
									                     </table>
									                     
									                     <table id="tables">
									                   	    <c:forEach items="${memberName }" var="m_name">
									                        <tr>
									                           <th>이메일</th>
									                           <td>${m_name.email }</td>
									                        </tr>
									                        </c:forEach>
									                     </table>									                     
								                  </div>
									                  <div id="info-right">
									                     <img src="/lab27/admin/logo.png"><br><br>
									                  </div>
		            			</div>
	            			</div>
	            		</div>
	            	</div>
	            </div>
	            </div>
	            <br><br>
        <!------------------------------------------------ 벼룩시장 ------------------------------------------>
	        <div id = "market_search"></div>
	        <h3>3) 벼룩시장 검색</h3>
	        
			<br><br>						
			<div id = "admin_market" class = "input-group">
			<div class = "input-group-append" id = "iga" style="width: 90px;">키워드&nbsp;&nbsp;</div>
			<input type="text" class="form-control" placeholder="Search">
				<div class="input-group-append">
					<button class="btn btn-secondary" type="submit" style="background-color: #8f3c38;"><i class="fas fa-search"></i> 검색</button>
				</div>
			</div>
			<br><br><br>
				<div>
					<table class="table table-hover" id="admin_table">
						<tr>
							<th>제목</th>
							<th>작성일</th>
							<th>이름</th>						
							<th>삭제</th>
						</tr>
						<tr>
							<td><a href = "#">벼룩시장제목</a></td>
							<td>작성일</td>
							<td>작성자</td>
							<td><button class="btn btn-danger" onclick="" style="background-color: #8f3c38; border-color: #8f3c38;"><i class="fas fa-trash-alt"></i>&nbsp;&nbsp;삭제</button></td>
						</tr>
					</table>
					<!-- 페이징 버튼 -->
					<ul class="pagination justify-content-center" style="margin:20px 0">
						<li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
					</ul>
				</div>
			<br><br>
	<!------------------------------------------------------ 모임검색 ------------------------------------>
			<h3 id="comuunity_search">4) 모임 검색</h3>
		<br><br>
			<form action="acommunitysearch.lab27">
			<div id = "admin_calendar" style="text-align: center;vertical-align: middle;">
				<div class = "input-group">
				<div class = "input-group-append" id = "iga" style="width: 90px;">생성날짜&nbsp;&nbsp;</div>
				<input type="hidden" name="command" value="a_community_search">
				<input type="text" class="testDatepicker1 form-control" name="start_day" id = "start_date">
				<span style="padding-top: 5px;">&nbsp;~&nbsp;</span>		
				<input type="text" class="testDatepicker2 form-control" name="end_day" id = "end_date">
			    <button class="btn btn-secondary" type="submit" style="background-color: #8f3c38;"><i class="fas fa-search"></i> 검색</button>
			    </div> 
			</div>
			</form>
		<br><br><br>
				<div>
					<table class="table table-hover" id="admin_table">
						<tr>
							<th>모임명</th>
							<th>생성날짜</th>
							<th>모임설명</th>
							<th>인원수</th>
							<th>삭제</th>
						</tr>
						<c:forEach items="${allCommu }" var="commu"> 
						<tr>
						 	
							<td><a href = "#">${commu.c_name }</a></td>
							<td>${commu.c_date }</td>
							<td>${commu.c_theme }</td>
							<td>${commu.c_number }</td>
							<td><button class="btn btn-danger" onclick="" style="background-color: #8f3c38; border-color: #8f3c38;"><i class="fas fa-trash-alt"></i>&nbsp;&nbsp;삭제</button></td>	 	
						</tr>
						</c:forEach> 
					</table>
					<!-- 페이징 버튼 -->
					<ul class="pagination justify-content-center" style="margin:20px 0">
						<li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
						<li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
		<br><br><br>
		<c:import url="/footer/footer.jsp"></c:import>
	</body>
</html>
