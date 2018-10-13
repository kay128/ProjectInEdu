<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lang Board</title>
		<link rel="stylesheet" href="/langlang/css/main.css" />
		<%@ include file="header.jsp" %>
		<%@ include file="footer.jsp" %>
	</head>
	<body>
		<div class="body">
		<!-- English -->
			<div class="en_a">
				<h4 class="list_title">English</h4>
				<table class="ta_sty">
					<tr>
						<td>NO</td>
						<td>TITLE</td>
						<td>DATE</td>
					</tr>
					<s:if test="%{msg != null}">
						<tr>
							<td colspan="3" style="text-align:center;"><font style="color:red;" size="2pt"><s:property value="msg"/></font></td>
						</tr>
					</s:if>
					<s:else>
						<s:subset source="en_list" count="5" start="en_page.st_inlist">
							<s:iterator>
							<s:url id = "viewURL" action = "view_written">
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
							<tr>
								<td width = "100px" style = "text-align:center;"><s:property value = "res_id"/></td>
								<td width = "100px" style = "text-align:center;"><s:a href="%{viewURL}"><s:property value = "title"/></s:a></td>
								<td width = "100px" style = "text-align:center;"><s:property value = "regdate"/></td>
							</tr>
							</s:iterator>
						</s:subset>
						<tr>
							<td colspan="3" style="border-bottom:0px;"></td>
						</tr>
						<tr>
							<td colspan="3" style="border-bottom:0px;"><s:property value="en_page_html" escape="false"/></td>
						</tr>
					</s:else>
				</table>
			</div>
		<!-- Korean -->
			<div class="ko_a">
				<h4 class="list_title">Korean</h4>
				<table class="ta_sty">
					<tr>
						<td>NO</td>
						<td>TITLE</td>
						<td>DATE</td>
					</tr>
					<s:if test="%{msg != null}">
						<tr>
							<td colspan="3" style="text-align:center;"><font style="color:red;" size="2pt"><s:property value="msg"/></font></td>
						</tr>
					</s:if>
					<s:else>
						<s:subset source="ko_list" count="5" start="ko_page.st_inlist">
							<s:iterator>
							<s:url id = "viewURL" action = "view_written">
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
							<tr>
								<td width = "100px" style = "text-align:center;"><s:property value = "res_id"/></td>
								<td width = "100px" style = "text-align:center;"><s:a href="%{viewURL}"><s:property value = "title"/></s:a></td>
								<td width = "100px" style = "text-align:center;"><s:property value = "regdate"/></td>
							</tr>
							</s:iterator>
						</s:subset>
						<tr>
							<td colspan="3" style="border-bottom:0px;"></td>
						</tr>
						<tr>
							<td colspan="3" style="border-bottom:0px;"><s:property value="ko_page_html" escape="false"/></td>
						</tr>
					</s:else>
				</table>
			</div>
		<!-- Japanese -->
			<div class="js_a">
				<h4 class="list_title">Japanese</h4>
				<table class="ta_sty">
					<tr>
						<td>NO</td>
						<td>TITLE</td>
						<td>DATE</td>
					</tr>
					<s:if test="%{msg != null}">
						<tr>
							<td colspan="3" style="text-align:center;"><font style="color:red;" size="2pt"><s:property value="msg"/></font></td>
						</tr>
					</s:if>
					<s:else>
						<s:subset source="js_list" count="5" start="js_page.st_inlist">
							<s:iterator>
							<s:url id = "viewURL" action = "view_written">
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
							<tr>
								<td width = "100px" style = "text-align:center;"><s:property value = "res_id"/></td>
								<td width = "100px" style = "text-align:center;"><s:a href="%{viewURL}"><s:property value = "title"/></s:a></td>
								<td width = "100px" style = "text-align:center;"><s:property value = "regdate"/></td>
							</tr>
							</s:iterator>
						</s:subset>
						<tr>
							<td colspan="3" style="border-bottom:0px;"></td>
						</tr>
						<tr>
							<td colspan="3" style="border-bottom:0px;"><s:property value="js_page_html" escape="false"/></td>
						</tr>
					</s:else>
				</table>
		</div>
	</body>
</html>