<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>
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
<body>
   <div id="main-wrap">
      <div class="card" id="group-info">
         <div class="card-header bg-secondary">
            <i class="fas fa-shopping-cart"></i>&nbsp;&nbsp;장터
            
            <a class="btn btn-outline-light" href="/lab27/product/product_form.jsp" style="float: right;"><i class="fas fa-edit"></i>&nbsp;&nbsp;글쓰기</a>
         </div>
      </div>

      <div id="group-board">
         <table class="table table-hover">
            <tr>
               <th>no</th>
               <th>분류</th>
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
               <td>
               <c:choose>
                  <c:when test="${post.board_name eq 'free' }">
                     무료나눔
                  </c:when>
                  <c:otherwise>
                     물물교환
                  </c:otherwise>
               </c:choose>
               </td>
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
   <c:import url="/nav/global_nav.jsp" />
   <c:import url="/footer/footer.jsp" />
</body>
</html>