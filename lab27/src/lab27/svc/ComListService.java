package lab27.svc;

import static lab27.db.JdbcUtils.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import lab27.vo.CompanyVO;
import lab27.vo.LabCompanyDAO;
import lab27.vo.MemberVO;
import lab27.vo.Paging2;

public class ComListService {

/*	public ArrayList<CompanyVO> getCompanyList(CompanyVO search, Paging paging) {
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		ArrayList<CompanyVO> company_list = null;
		
		try {
		paging.setTotalCount(totalCount);
		paging.pagingAction();
		company_list = dao.getCompanyList(search, paging, conn);
		conn.commit();
		}catch(Exception e){
			rollback(conn);
		}finally {
			close(conn, null, null);
		}
		
		return company_list;
	}*/

	public int getTotalCount(String sql) {
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		int totalCount = 0;
		try {
		totalCount = dao.getTotalCount(sql, conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(conn, null, null);
		}
		return totalCount;
	}

	public ArrayList<CompanyVO> getCompanyList(String sql, String user_id, Paging2 paging) {
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		ArrayList<CompanyVO> company_list = null;
		
		try {
		company_list = dao.getCompanyList(sql, user_id, paging, conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(conn, null, null);
		}
		
		return company_list;
	}

}
