<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
/*파일 업로드 디자인*/
.btn-file{
	position: relative;
	overflow: hidden;
}
.btn-file input[type=file]{
	position: absolute;
	top: 0;
	rigth: 0;
	min-width: 100%;
	min-height: 100%;
	font-size: 100px;
	text-align: right;
	filter: alpha(opacity=0);
	opacity: 0;
	outline: none;
	background: white;
	cursor: inherit;
	display: block;
}
</style>
</head>
<body>
	<%
		String boardId = request.getParameter("boardId");

	%>
	<div class="container">
		<form action="board_reply.do">
		<table class="table table-bordered table-hover" style="border:1px, solid, #dddddd">
		<thead>
			<tr>
			<th colspan="5"><font size="5pt" style="wieght:bold">返信を作成</font></th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td style="width:110px"><h5>email</h5></td>
			<td><h5>${loginUser.getEmail()}</h5></td>
			<input type="hidden" name="userEmail" value="${loginUser.getEmail()}"/>
			<input type="hidden" name="parentId" value="<%=boardId %>"/>
			</tr>
			<tr>
			<td style="width:110px"><h5>タイトル</h5></td>		
            <td><input class="form-control" type="text" maxlength="50" name="boardTitle" placeholder="タイトルを入力してください。"/></td>
            </tr>
            <tr>
            <td style="width: 110px">内容</td>
            <td><textarea class="form-control" rows="10" maxlength="2048" name="boardContent" placeholder="内容を入力してください。"></textarea></td>
            </tr>
            <tr>
            <td colspan="5"><input class="btn btn-primary pull-right" type="submit" value="投稿" ></a></td>
            </tr>
           </tbody>
           </table>
           </form>
     </div>
</body>
</html>