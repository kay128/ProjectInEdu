<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Modify Info</title>
		<link rel="stylesheet" href="/langlang/css/main.css" />
		<%@ include file="header.jsp" %>
		<%@ include file="footer.jsp" %>
	</head>
	<body>
		<div class="body">
			<div class="format_join">
				<div class="fo">
					<s:iterator value= "user_info">
					<table>
						<tr>
							<form action="user_modify.action" method="post">
							<td colspan="2" style="text-align:center;"><section class="formTitle">Modify your Information</section></td>	
							</tr>
							<tr style="height:50px;"></tr>
							<tr>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">E-Mail</td>
								<td>
									<s:property value="email"/>
									<input type="hidden" name="email" value="<s:property value="email"/>"/>
								</td>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">Password</td>
								<td>
									<input class="inputBox" type="password" name="pw" placeholder="Password"/>
								</td>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">Nickname</td>
								<td>
									<s:property value="name"/>
									<input type="hidden" name="name" value="<s:property value="name"/>"/>
								</td>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">First Language</td>
								<td>
									<select name = "contry" class="inputBox6">
										<option>Required</option>
										<option value = "en">English</option>
										<option value = "ko">Korean</option>
										<option value = "js">Japanese</option>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:120px;text-align:center;">Learning Language</td>
								<td>
									<select name = "main_lang" class="inputBox6">
										<option>Optional</option>
										<option value = "en">English</option>
										<option value = "ko">Korean</option>
										<option value = "js">Japanese</option>
									</select>
								</td>
							</tr>
							<tr></tr>
							<tr>
								<td colspan="2" style="text-align:right;"><input type="submit" class="button4" value="Load"/></td>
							</tr>
						</table>
					</form>
				</div>
				</s:iterator>
				</div>
			</div>
		</div>
	
	</body>
</html>