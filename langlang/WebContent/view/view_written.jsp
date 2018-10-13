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
			<div class="format_view">
				<div class="fo">
					
						<table>
							<s:subset source="selected" count="1" start="0">
							<s:iterator>
							<tr>
								<td colspan="4" style="text-align:center;"><section class="formTitle"><s:property value="title"/></section></td>
							</tr>
							<tr style="height:30px;"></tr>
							<tr>
								<td style="width:200px;text-align:center;">Writter</td>
								<td>
									<s:property value="name"/>
								</td>
								<td style="width:200px;text-align:center;">Read Hit</td>
								<td>
									<s:property value="hit"/>
								</td>
							</tr>
							<tr>
								<td style="width:200px;text-align:center;">Date</td>
								<td>
									<s:property value="regdate"/>
								</td>
								<td style="width:200px;text-align:center;">In lang</td>
								<td>
									<s:property value="lang"/>
								</td>
							</tr>
							<tr height="20px;">
								<td colspan="4" style="text-align:center;background-color:rgba(255, 255, 255, 0.50);">Content</td>
							</tr>
							<tr height="10px;"></tr>
							<tr>
								<td colspan="4" style="text-align:center;"><s:property value="content"/></td>
							</tr>
							<tr style="height:10px;">
							</tr>
							<s:if test="#session.loginUser.name == name">
							<tr>
								<s:url id = "doURL" action = "check_form">
									<s:param name = "target">
										written
									</s:param>
									<s:param name = "res_id">
										<s:property value = "res_id"/>
									</s:param>
									<s:param name = "en_current_page">
										<s:property value = "en_current_page"/>
									</s:param>
									<s:param name = "ko_current_page">
										<s:property value = "ko_current_page"/>
									</s:param>
									<s:param name = "js_current_page">
										<s:property value = "js_current_page"/>
									</s:param>
								</s:url>
								<td colspan="4" style="text-align:right;">
								<s:a href="%{doURL}&mod=modify"><button class="button3">Modify</button></s:a>
								<s:a href="%{doURL}&mod=delete"><button class="button3">Delete</button></s:a>
								</td>
							</tr>
							</s:if>
							</s:iterator>
							</s:subset>
						</table>
					
				</div>
				<div class="feedback">
				<table class="fe_table">
					<tr>
						<td colspan="2">writter</td>
						<td>date</td>
						<td>rate</td>
						<td width="100px" colspan="2">content</td>
					</tr>
					<s:iterator value="selected">
						<s:iterator value="feedbacks">
							<s:if test="lev>0">
									<tr>										
										<td colspan="2"><s:property value="feedback_name"/></td>
										<td><s:property value="feedback_regdate"/></td>
										<s:if test="feedback_id == fe_modify_id">
											<form action="feedback_modify.action">
											<td colspan="3">
												<input type="hidden" name="feedback_id" value="<s:property value="feedback_id"/>"/>
												<input type="hidden" name="res_id" value="<s:property value="res_id"/>"/>
												<input type="hidden" name="en_current_page" value="<s:property value="en_current_page"/>"/>
												<input type="hidden" name="ko_current_page" value="<s:property value="ko_current_page"/>"/>
												<input type="hidden" name="js_current_page" value="<s:property value="ko_current_page"/>"/>
												<select name = "feedback_rate" class="inputBox4" >
													<option value = "5">5</option>
													<option value = "4">4</option>
													<option value = "3">3</option>
													<option value = "2">2</option>
													<option value = "1">1</option>
												</select>
											<textarea class="inputBox5" name="feedback_content"><s:property value="feedback_content"/></textarea>
											<input type="submit" class="minibutton2" value="load"/></td>
											</form>
										</s:if>
										<s:elseif test="#session.loginUser.name == feedback_name">
											<td><s:property value="feedback_rate"/></td>
											<td width="100px"><s:property value="feedback_content"/>
											<s:url id = "fe_doURL" action = "feedback_do">
												<s:param name = "feedback_id">
													<s:property value="feedback_id"/>
												</s:param>
												<s:param name = "res_id">
													<s:property value = "res_id"/>
												</s:param>
												<s:param name = "en_current_page">
													<s:property value = "en_current_page"/>
												</s:param>
												<s:param name = "ko_current_page">
													<s:property value = "ko_current_page"/>
												</s:param>
												<s:param name = "js_current_page">
													<s:property value = "js_current_page"/>
												</s:param>
											</s:url>
											</td>
											<td>
											<s:a href="%{fe_doURL}&fe_mod=modify"><img src="/langlang/img/edit_icon.jpg" alt="edit" height="20px" width="20px"></s:a>
											<s:a href="%{fe_doURL}&fe_mod=delete"><img src="/langlang/img/delete_icon.jpg" alt="delet" height="20px" width="20px"></s:a>
											</td>
										</s:elseif>
										<s:else>
										<td><s:property value="feedback_rate"/></td>
										<td width="100px" colspan="2"><s:property value="feedback_content"/></td>
										</s:else>
									</tr>
								</s:if>
							</s:iterator>
					</s:iterator>
					<tr>
					</tr>
					<form action="feedback_load.action" method = "post">
						<s:subset source="selected" count="1" start="0">
							<s:iterator>
						<tr>
							<td colspan="5" style="border-bottom:0px;"></td>
						</tr>
						<tr>
							<td colspan="2" style="border-bottom:0px;">
							<s:property value="#session.loginUser.name"/></td>
							<jsp:useBean id="now" class="java.util.Date" />
							<td style="border-bottom:0px;">
							<fmt:formatDate value="${now}" pattern="yy.M.d" /></td>
							<td colspan="3" style="border-bottom:0px;">
								<select name = "feedback_rate" class="inputBox2">
									<option value = "5">5</option>
									<option value = "4">4</option>
									<option value = "3">3</option>
									<option value = "2">2</option>
									<option value = "1">1</option>
								</select>
								<input type="hidden" name="res_id" value="<s:property value="res_id"/>"/>
								<input type="hidden" name="en_current_page" value="<s:property value="en_current_page"/>"/>
								<input type="hidden" name="ko_current_page" value="<s:property value="ko_current_page"/>"/>
								<input type="hidden" name="js_current_page" value="<s:property value="ko_current_page"/>"/>
							</td>
						</tr>
						<tr>
							<td colspan="5" width="100px" style="border-bottom:0px;"><textarea class="inputBox3" name="feedback_content" placeholder="Feedback about post"></textarea></td>
							<td style="border-bottom:0px;"><input type="submit" class="minibutton" value="load"/></td>
						</tr>
						</s:iterator>
						</s:subset>
					</form>
				</table>
				</div>
			</div>
		</div>
	
	</body>
</html>