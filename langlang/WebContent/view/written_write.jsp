<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Write Post</title>
		<link rel="stylesheet" href="/langlang/css/main.css" />
		<%@ include file="header.jsp" %>
		<%@ include file="footer.jsp" %>
	</head>
	<body>
		<div class="body">
			<div class="format_write">
				<div class="fo">
					<table>
							<tr>
						<form action="written_load.action" method="post">
						<td colspan="2" style="text-align:center;"><section class="formTitle">Write your story</section></td>
							</tr>
							<tr style="height:50px;"></tr>
							<tr>
								<td style="width:200px;text-align:center;">Title</td>
								<td>
									<input class="inputBox" type="text" name="title" placeholder="Present your post"/>
								</td>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">Language</td>
								<td>
									<select name = "lang" class="inputBox6">
										<option value = "en">English</option>
										<option value = "ko">Korean</option>
										<option value = "js">Japanese</option>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">content</td>
								<td>
									<textarea class="inputBox" name="content" placeholder="Please tell us your story" style="height:300px;"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align:right;"><input type="submit" class="button2" value="Post"/></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	
	</body>
</html>