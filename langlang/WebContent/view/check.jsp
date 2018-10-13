<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Password Check</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/langlang/css/main.css" />
		<%@ include file="header.jsp" %>
		<%@ include file="footer.jsp" %>
	</head>
	<body>
			<section>
					<div class="body">
						<div class = "format_check">
						 <s:form action = "check" method="post">
							<table>
								<tr><td colspan="2"><section class="check_title">Please put in the password<br> for
							<s:if test="target.equals('written')">
							<s:if test="mod.equals('modify')">
								modify your post
							</s:if>
							<s:else>
								delete your post
							</s:else>
								<s:hidden name="target" value="%{target}"/>
								<s:hidden name="res_id" value="%{res_id}"/>
								<s:hidden name="mod" value="%{mod}"/>
								<s:hidden name="en_current_page" value="%{en_current_page}"/>
								<s:hidden name="ko_current_page" value="%{ko_current_page}"/>
								<s:hidden name="js_current_page" value="%{js_current_page}"/>
							</s:if>
							<s:if test="target.equals('user')">
							<s:if test="mod.equals('modify')">
								modify your information
							</s:if>
							<s:else>
								withdraw your account</section>
							</s:else>
								<s:hidden name="target" value="%{target}"/>
								<s:hidden name="mod" value="%{mod}"/>
							</s:if>
								</td>
								</tr>
								<tr height="50px"></tr>
								<tr>
									<td style="text-align:right;"><input type="password" class="inputBox" name="pw"/></td>
									<td style="text-align:left;">
									<input type="submit" class="button2" value="Check"/>
									</td>
								</tr>
							</s:form> 
						</table>
						</div>
					</div>
			</section>
	</body>
</html>