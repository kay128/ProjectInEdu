<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View Post</title>
		<link rel="stylesheet" href="/langlang/css/main.css" />
		<%@ include file="header.jsp" %>
		<%@ include file="footer.jsp" %>
	</head>
	<body>
		<div class="body">
			<div class="format_view">
				<div class="fo">
						<table>
							<s:subset source="selected" count="1" start="0">
							<s:iterator>
							<form action="modify_load.action" method="post">
							<tr>
								<td>Title</td>
								<td style="text-align:center;"><section class="formTitle">
								<input type="text" class="inputBox" name="title" value="<s:property value="title"/>"/></section></td>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">Writter</td>
								<td>
									<input type="text" class="inputBox" name="name" value="<s:property value="name"/>" readonly/>
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
							<tr height="20px;">
								<td colspan="2" style="text-align:center;background-color:rgba(255, 255, 255, 0.50);">Content</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align:center;">
								<textarea class="inputBox" name="content" placeholder="Please tell us your story" style="height:300px; width:400px">
									<s:property value="content"/>
								</textarea>
								<input type="hidden" name="res_id" value="<s:property value="res_id"/>"/>
								<input type="hidden" name="en_current_page" value="<s:property value="en_current_page"/>"/>
								<input type="hidden" name="ko_current_page" value="<s:property value="ko_current_page"/>"/>
								<input type="hidden" name="js_current_page" value="<s:property value="ko_current_page"/>"/>
								</td>
							</tr>
							<tr style="height:25px;">
							</tr>
							<tr>
								<td colspan="2" style="text-align:right;">
									<input type="reset" class="button3" value="Reset"/>
									<input type="submit" class="button3" value="Load"/>
								</td>
							</tr>
							</form>
							</s:iterator>
							</s:subset>
						</table>
				</div>
			</div>
		</div>
	
	</body>
</html>