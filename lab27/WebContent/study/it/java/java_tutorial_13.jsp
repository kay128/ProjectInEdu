<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>		
	</head>
	<body>
	
		<div id="main-wrap" class="row" style="clear:both;"> <!-- wrap -->

		<!-- 스터디 목차 ================================================================== -->
			<div id="study-side-nav">
				<c:import url="/study/it/java/index.jsp"/>
			</div>	<!--  end -->
			
			
		<!-- 본문 ============================================================================= -->
			<div id="wrap">
				<h1>JDBC 프로그래밍</h1>
				<div class="row">
				<h4>
				1.Java Database Connection : 자바와 데이터베이스의 연동을 위한 프로그램<br><br>
				&nbsp;&nbsp;1) DataBases : 데이터베이스<br><br>
		     	&nbsp;&nbsp;&nbsp;- 서로 연관된 데이터를 하나의 통합된 객체로 만든 후 운영하고 관리하는 것<br><br>
		     	&nbsp;&nbsp;&nbsp;- DBMS : DataBase Management System<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;Oracle, MySQL, MSSQL, MariaDB, MongoDB....<br><br>
		     	&nbsp;&nbsp;&nbsp;- 관계형 데이터베이스 : 표(table) - 행(record, tuple) 열(attribute, field)<br><br>
		  		&nbsp;&nbsp;2) SQL : 질의어, 명령어<br><br>
		     	&nbsp;&nbsp;&nbsp;- DDL : 정의어<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;CREATE - 구조(테이블, 뷰, 시스템카탈로그...)를 생성<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;ALTER - 구조를 변경<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;DROP - 구조를 삭제<br><br>
		       	&nbsp;&nbsp;&nbsp;- DML : 조작어, 실제 레코드 단위로 작업을 수행하는 질의어<br><br>
		       	&nbsp;&nbsp;&nbsp;&nbsp;SELECT - 추출(검색)<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SELECT 필드명1, 필드명2, ...<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM 테이블명;<br><br><br><br>
		         
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SELECT *<br><br>
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM 테이블명;<br><br><br><br>
		         
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SELECT *<br><br>
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM 테이블명<br><br>
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHERE 조건식;<br><br><br><br>
		         
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SELECT *<br><br>
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM 테이블명<br><br>
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHERE name like '김%';<br><br><br><br>
		         
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SELECT *<br><br>
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM 테이블명<br><br>
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHERE major = "컴공" ; WHERE grade = 3 and major="컴공"<br><br><br><br>
		         
		       	&nbsp;&nbsp;&nbsp;&nbsp;INSERT - 추가(삽입)<br><br>
		       
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INSERT INTO 테이블명(필드명1, 필드명2, ...) VALUES(값1, 값2,,,);<br><br>
		         
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;insert into student values(1, '홍길동');<br><br>
		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;insert into student(id) values(100);<br><br><br><br>
		         
		         
		        &nbsp;&nbsp;&nbsp;&nbsp;UPDATE - 수정(갱신)<br><br>
		       
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UPDATE 테이블명 SET 필드명1 = 값1, 필드명 = 값2 where=조건식;<br><br><br><br>
		         
		        &nbsp;&nbsp;&nbsp;&nbsp;DELETE - 제거(삭제)<br><br>
		       
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DELETE 필드명....<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FROM 테이블명<br><br>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHERE 조건식;<br><br><br><br>
		         
		         
		       
		       &nbsp;&nbsp;&nbsp;- DCL : 제어어, 무결성과 병행수행을 위한 제어어<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;GRANT : 권한을 부여<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;REVOKE : 부여된 권한을 빼앗는 역할<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;COMMIT : 트랜잭션의 처리가 성공정이었음을 알려주는 것<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;ROLLBACK : 트랜잭션을 수행하는 도중에 문제가 발생하여 원상태로 되돌리는 것<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;※트랜잭션 : 데이터베이스를 통해 처리되는 일련의 작업단위<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ACID<br><br>
		       
		   	   &nbsp;&nbsp;3) sqlplus 명령어<br><br>
		       &nbsp;&nbsp;&nbsp;※ sql 명령어는 종결자(;)을 붙여야 한다.<br><br>
		       &nbsp;&nbsp;&nbsp;- 접속명령 : sqlplus 계정/비밀번호<br><br> 
		       &nbsp;&nbsp;&nbsp;- 관리자권한 : sys, system<br><br>
		       &nbsp;&nbsp;&nbsp;- 새로운 계정생성하는 방법<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;CEREATE USER jsl27 IDENTIFIED by 1234;<br><br> 
		       &nbsp;&nbsp;&nbsp;- 계정접속 : conn 계정/비밀번호<br><br>
		       &nbsp;&nbsp;&nbsp;- 현재 어떤 계정에 접속중인지 확인하는 명령 : show user<br><br>
		       &nbsp;&nbsp;&nbsp;- 권한 부여<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;GRANT connect, resource, dba to jsl27;<br><br><br><br>
		      
		       &nbsp;&nbsp;&nbsp;- 로그인 없이 계정접속<br><br>
		       &nbsp;&nbsp;&nbsp;c:\> conn /as sysdba<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;sql> conn /as sysdba<br><br>
		       &nbsp;&nbsp;&nbsp;- 관리자 비밀번호 변경작업(sys, system)<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;sql> alter user system identified by 새로운 암호(1234)<br><br>
		       &nbsp;&nbsp;&nbsp;&nbsp;sql> alter user sys identified by 새로운 암호(1234)<br><br>
				</h4>
				</div>
				
		<!-- QnA =========================================================================== -->
				<c:import url="/study/qna.jsp"/>
				
			</div>	<!-- 본문 end -->
			
		</div> <!-- wrap end -->
		
		<!-- 글로벌 네비게이션 -->
		<c:import url="/nav/global_nav.jsp"/>
		<c:import url="/footer/footer.jsp"/>
	</body>
</html>
