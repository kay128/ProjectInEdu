<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="container">
		<form action="boardview.do">
		<table class="table table-bordered table-hover" style="border:1px, solid, #dddddd">
		<thead>
			<tr>
			<th colspan="5"><font size="5pt" style="wieght:bold">詳細を見る</font></th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td style="width:110px"><h5>タイトル</h5></td>		
            <td colspan="3">${boardshow.getboardTitle()}</td>
            </tr>
			<tr>
			<td style="width:110px"><h5>email</h5></td>
			<td colspan="3">${boardshow.getuserEmail()}</td>
			</tr>
			<tr>
			<td>日付</td><td>${boardshow.getboardDate() }</td>
			<td>閲覧数</td><td>${boardshow.getboardHit() }</td>
			</tr>
            <tr>
            <td style="width: 110px">内容</td>
            <td colspan="3">${boardshow.getboardContent()}</td>
            </tr>
            <tr>
            <td colspan="5" style="text-align:center">
            <input class="btn btn-primary" type="button"  onclick="location.href='boardshow.do?boardId=${boardshow.boardId}&type=modify'" value="修正">
            <input class="btn btn-primary" type="button" onclick="location.href='boarddelete.do?boardId=${boardshow.boardId}'" value="削除">
            <input class="btn btn-primary" type="button" onclick="location.href='boardReply.jsp?boardId=${boardshow.boardId}'" value="返信">
            <input class="btn btn-primary" type="submit" value="リストに戻る">
            </td>
            </tr>
           </tbody>
           </table>
           </form>
     </div>
     <script>
     function boardCheck(loginUser ){
    	 
    	 var userEmail = loginUser.getEmail();
    	 
    	 console.log(userEmail);
    	 
    	 if(userEmail.equals("${boardshow.getuserEmail()}")){
    		 alert('글을 작성한 고객이 아닙니다.');
    		 return false;
    	 }
    	 location.href= "boardshow.do?boardId=${boardshow.boardId}&type=modify";
    	 return true;
     }
     </script>
</body>
</html>