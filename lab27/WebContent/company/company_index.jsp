<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/lab27/css/community.css">
<script>
$(document).ready(function(){
	$("#goDetail").click(function(){
		
	    $("#simple").hide();
	    $("#detail").show();
	});

	$("#goSimple").click(function(){
		$("#detail").hide();
	    $("#simple").show();
	    
	});
	
	

});

function hate(company_id, index){

$.ajax({
	url:"/lab27/ajax.lab27?command=delete_pavorite",
	type:"post",
	data: {company_id:company_id},
success: function(result){
	//성공했다면
	if(result == "success"){
		$("#pavorite"+index).hide();
		$("#hate"+index).show();

	}else{	//실패했다면 에러메세지
		alert(result);
	}
}
})

}

function pavorite(company_id, index){

	$.ajax({
		url:"/lab27/ajax.lab27?command=add_pavorite",
		type:"post",
		data: {company_id:company_id},
	success: function(result){
		//성공했다면
		if(result == "success"){
			$("#pavorite"+index).show();
			$("#hate"+index).hide();
			
		}else{	//실패했다면 에러메세지
			alert(result);
		}
	}
	})

	}
</script>

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

.comon{width:80%; background-color: #be3b26; border-color: #be3b26; -webkit-box-shadow: 0 3px 0 #842719; box-shadow: 0 3px 0 #842719;}

.company_wrap {
    position: absolute;
    top: 50%;
    left: 50%;
    margin-top: -86px;
    margin-left: -89px;
    text-align: center;
    cursor:pointer;
}

a.button {
	    -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    display: block;
    margin: 5px auto;
    max-width: 180px;
    text-decoration: none;
    border-radius: 4px;
    padding: 5px 5px;
	text-color: blcack;
    color: rgba(30, 22, 54, 0.6);
    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
}

a.button:hover {
	text-color: white;
    color: rgba(255, 255, 255, 0.85);
    box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
}


a.button2 {
	    -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    display: block;
    margin: 5px auto;
    max-width: 180px;
    text-decoration: none;
    border-radius: 4px;
    padding: 5px 5px;
	    color: rgba(255, 255, 255, 0.85);
    box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
 
}

a.button2:hover {

   color: rgba(30, 22, 54, 0.6);
    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
}



.company-card {
	padding-top:3%;
	padding-bottom:3%;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    display: inline-block; 
    margint-left:5%; 
    margin-bottom:5%;
    width:25%;
}

.company-card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
    padding: 2px 16px;
}
</style>

</head>
<body>
<div style="align:center; margin-top:20px; padding-top:20px">
	<!-- 단순검색 -->
	<div id="simple" style="text-align:center">
	<button id="goDetail">상세 검색</button><br>
		<form action="./search.lab27" method="post">
		<input type="hidden" value="com_list" name="command">
		<table class="type03">
			<tr><th>회사명</th><td><input type="text" name="company_name"></td><td><input type="submit" value="검색"></td></tr>
		</table>
		</form>
	</div>
	<!-- 상세검색 -->
<div id="detail" style="display:none; text-align:center">
<button id="goSimple">단순 검색</button><br>
		<form action="./search.lab27" method="post">
		<input type="hidden" value="com_list" name="command">
		<table class="type03">
			<tr>
				<th> 회사명:</th>
				<td colspan="2"><input type="text" name="company_name"></td>
				<th>설립년도:</th>
				<td colspan="3"> <input type="number" name="company_year" width="4"> ~ <input type="number" name="limit_year" width="4"> </td>
			</tr>
			
			<tr>
				<th> 소재지:</th>
				<td colspan="2"><input type="text" name="company_loc"></td>
				<th>사원수:</th>
				<td colspan="3"> <input type="number" name="company_emp">명 이상 </td>
			</tr>
			
			<tr>
				<th> 자본금:</th>
				<td colspan="2"><input type="number" name="company_cap">만엔 이상</td>
				<th>매출액:</th>
				<td colspan="3"> <input type="number" name="company_money">억엔 이상 </td>
			</tr>
			
						<tr>
				
				<td colspan="3"><input type="radio" name="is_korea_ceo" value="1">한국계 <input type="radio" name="is_korea_ceo" value="-1">일본계 <br></td>
				
				<td colspan="4"><input type="submit" value="검색"></td>
			</tr>
		</table>
	</form>
</div>
</div>
		<c:if test="${company_list == null }"> 
		데이터가 존재하지 않습니다.
		
		</c:if>
		<div style="text-align:center;">
		<c:forEach items="${company_list}" var="company" varStatus="status">
		<div class="company-card" >
			<a href="./oneCompany.lab27?command=oneCompany&&company_id=${company.company_id }">
			<img style="width:100%; height:150px" src="./images/logos/${company.company_logo}" alt="${company.company_logo}"><br>
			</a>
			
			<div class="container">
			<i class="fa fa-star"></i> &nbsp; ${company.star_avg} &nbsp;&nbsp;
			<i class="fa fa-eye"></i>&nbsp; ${company.read_count }	&nbsp;&nbsp;
			<i class="fa fa-comment"></i>&nbsp; ${company.rating_count }<br>
			
			<c:if test="${loginUser != null}">
				<c:if test="${company.is_pavorite == 1}">
				    <div class="wrap" id="hate${status.index}" style="display:none;">
        				<a id="hate${status.index}" class="button" onclick="pavorite(${company.company_id}, ${status.index})">♡관심기업등록</a>
    				</div>
				
				
					    <div class="wrap" id="pavorite${status.index}">
        				<a  class="button2" onclick="hate(${company.company_id}, ${status.index})">♥관심기업</a>
    				</div>

				</c:if>
				<c:if test="${company.is_pavorite == 0}">
					 <div class="wrap" id="hate${status.index}" >
        				<a  class="button" onclick="pavorite(${company.company_id}, ${status.index})">♡관심기업등록</a>
    				</div>
    				
    			 <div class="wrap" id="pavorite${status.index}" style="display:none;">
        				<a  class="button2" onclick="hate(${company.company_id}, ${status.index})">♥관심기업</a>
    				</div>
					
				</c:if>
			
			</c:if>
			
			<br>
			
			<c:if test="${company.recruit_now == 1}">
					        
            <a class="comon" style="color:white; font-size: 20px; margin:5px; padding:5px;">모집중</a> 
       
			</c:if>
			</div>
		
		</div>
		
		<c:if test="${status.count%3==0 }">
			<br>
		</c:if>
		</c:forEach>
	
	</div>
</div>
		<br>
		<br>
		<div style="text-align:center;">
                <c:if test="${paging.startPage>1}">
                <a href="/lab27/company.lab27?command=com_list&&sql=${sql }&&currentPage=${paging.startPage-1}">&laquo</a>
                </c:if>
                	
				<c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}" step="1">
				
						<c:choose>
						<c:when test="${page == paging.currentPage}">
				 <a href="#"  onclick="return false;" class="active"> ${page} </a>
						</c:when>
						<c:otherwise>
						
				<a href="/lab27/company.lab27?command=com_list&&sql=${sql }&&currentPage=${page}">${page}</a>
						
						</c:otherwise>
						</c:choose>
				</c:forEach>
				
				<c:if test="${paging.endPage<paging.totalPage}">
               <a href="/lab27/company.lab27?command=com_list&&sql=${sql }&&currentPage=${paging.endPage+1}">&raquo;</a>
                </c:if>
                
                <br>
                <br>
             </div>

<c:import url="/footer/footer.jsp"/>
</body>
</html>