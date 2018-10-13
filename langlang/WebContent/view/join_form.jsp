<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Join in Lang</title>
		<link rel="stylesheet" href="/langlang/css/main.css" />
		<%@ include file="header.jsp" %>
		<%@ include file="footer.jsp" %>
	</head>
	<body>
		<div class="body">
			<div class="format_join">
				<div class="fo">
					<table>
						<tr>
							<form action="join.action" method="post">
							<td colspan="2" style="text-align:center;"><section class="formTitle">Join in Lang</section></td>	
							</tr>
							<tr style="height:50px;"></tr>
							<tr>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">E-Mail</td>
								<td>
									<input class="inputBox" type="email" name="email" placeholder="E-mail for Identify"/>
								</td>
							</tr>
							<s:if test="%{msg_email != null}">
								<tr>
									<td colspan="2" style="text-align:right;"><font style="color:red;" size="2pt"><s:property value="msg_email"/></font></td>
								</tr>
							</s:if>
							<tr>
								<td style="width:200px;text-align:center;">Password</td>
								<td>
									<input class="inputBox" type="password" name="pw" placeholder="Password"/>
								</td>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">Nickname</td>
								<td>
									<input class="inputBox" type="text" name="name" placeholder="Nickname"/>
								</td>
							</tr>
							<s:if test="%{msg_name != null}">
								<tr>
									<td colspan="2" style="text-align:right;"><font style="color:red;" size="2pt"><s:property value="msg_name"/></font></td>
								</tr>
							</s:if>
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
							
							<tr>
								<td colspan="2" style="text-align:right;"><input type="submit" class="button" value="Join"/></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="subMessage">
				<table>
					<tr style="height:20px;">
					</tr>
					<tr>
						<td style="width:400px; font-size:10pt; color:ffede0;">We only use your private information for login Lang.</td>
					</tr>
				</table>
				</div>
			</div>
		</div>
	
	</body>
</html>