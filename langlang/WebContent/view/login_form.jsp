<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login to Lang</title>
		<link rel="stylesheet" href="/langlang/css/main.css" />
		<%@ include file="header.jsp" %>
		<%@ include file="footer.jsp" %>
	</head>
	<body>
		<div class="body">
			<div class="format_login">
				<div class="fo">
					<form action="login.action" method="post">
						<table>
							<tr>
								<td colspan="2" style="text-align:center;"><section class="formTitle">Login to Lang</section></td>
							</tr>
							<tr style="height:50px;"></tr>
							<tr>
							</tr>
							<tr>
								<td style="width:120px;text-align:center;">E-Mail</td>
								<td>
									<input class="inputBox" type="email" name="email" placeholder="Please enter your E-mail"/>
								</td>
							</tr>
							<tr>
								<td style="width:120px;text-align:center;">Password</td>
								<td>
									<input class="inputBox" type="password" name="pw" placeholder="Please enter your Password"/>
								</td>
							</tr>
							<s:if test="%{msg != null}">
								<tr>
									<td colspan="2" style="text-align:center;"><font style="color:red;" size="2pt"><s:property value="msg"/></font></td>
								</tr>
							</s:if>
							<tr>
								<td colspan="2" style="text-align:right;"><input type="submit" class="button" value="Login"/></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="subMessage">
				<table>
					<tr style="height:20px;">
					</tr>
					<tr>
						<td style="width:200px;">Don't have an Account?</td>
						<td><button class="button" onclick="location.href='join_form.action'">Join</button></td>
					</tr>
				</table>
				</div>
			</div>
		</div>
	
	</body>
</html>