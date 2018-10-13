<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="db.JdbcUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ニックネームチェック</title>
	</head>
	<body>
		<%
			//1.사용자가 입력한 아이디 얻어오기
			String nickName = request.getParameter("nickName");
			//2.해당아이디가 존재하는지 검사
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			boolean result = false;
			try {
				conn = JdbcUtils.getConnection();
				String sql = "select * from customer where nickName=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, nickName);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					result = true;
				}
			} catch (SQLException se) {
				System.out.println(se.getMessage());
	
			} finally {
				rs.close();
				pstmt.close();
				conn.close();
			}
	
			////////// 3.xml로 결과 응답하기 ///////////
			response.setContentType("text/xml;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.println("<data>");
			pw.println("<result>" + result + "</result>");
			pw.println("</data>");
			pw.close();
		%>

</body>
</html>