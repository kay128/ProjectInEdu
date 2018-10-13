<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User Information</title>
		<link rel="stylesheet" href="/langlang/css/main.css" />
		<%@ include file="header.jsp" %>
		<%@ include file="footer.jsp" %>
		<script type="text/javascript">		
			var message = '<c:out value="${msg}"/>';
			switch(message){
			case null:
				break;
			case "":
				break;
			case '':
				break;
			case "null":
				break;
			case 'null':
				break;
			default : 
				alert(message);
			}
		</script>
	</head>
	<body>
		<div class="body">
			<div class="format_user">
				<div class="fo">
					<s:iterator value="getInfo">
						<table class="fo_table">
							<tr>
								<td colspan="2" style="text-align:center;"><section class="formTitle">Check Your Information</section></td>
							</tr>
							<tr style="height:50px;"></tr>
							<tr>
								<td style="width:400px;text-align:center;">E-Mail</td>
								<td style="width:200px;text-align:center;">
									<s:property value="email"/>
								</td>
							</tr>
							<tr>
								<td style="width:400px;text-align:center;">Password</td>
								<td style="width:200px;text-align:center;">
									<c:forEach begin="1" end="${fn:length(pw)}">
										<c:out value="*"/>
									</c:forEach>
								</td>
							</tr>
							<tr>
								<td style="width:400px;text-align:center;">Nickname</td>
								<td style="width:200px;text-align:center;">
									<s:property value="name"/>
								</td>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">First Language</td>
								<td style="width:200px;text-align:center;">
									<s:property value="contry"/>
								</td>
							</tr>
							<tr>
								<td style="width:400px;text-align:center;">Learning Language</td>
								<td style="width:200px;text-align:center;">
									<s:property value="main_lang"/>
								<s:url id = "doURL" action = "check_form">
									<s:param name="target">
										user
									</s:param>
								</s:url>
								</td>
							</tr>
							<tr height="60px"></tr>
							<tr>
								<td colspan="2" style="text-align:center;">								
								<s:a href="%{doURL}&mod=modify"><button class="button4">Modify</button></s:a>
								&nbsp;&nbsp;
								<s:a href="%{doURL}&mod=delete"><button class="button4">WithDraw</button></s:a>
								</td>
							</tr>
						</table>
					</s:iterator>
				</div>
			</div>
		</div>
	
	</body>
</html>