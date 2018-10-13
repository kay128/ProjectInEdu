package lab27.svc;

import static lab27.db.JdbcUtils.*;


import java.sql.Connection;
import java.util.ArrayList;

import lab27.vo.CompanyVO;
import lab27.vo.LabCompanyDAO;
import lab27.vo.Paging2;
import lab27.vo.RatingVO;
import lab27.vo.RecruitVO;

public class OneCompanyService {



	public void readCountUpdate(int company_id) {
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		
		try {
			dao.readCountUpdate(company_id, conn);
			commit(conn);
		}catch(Exception e){
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(conn, null, null);
		}
		
	}

	public CompanyVO getOneCompany(int company_id) {
		CompanyVO company = null;
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		
		try {
			company = dao.getOneCompany(company_id, conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(conn, null, null);
		}
		
		return company;
	}

	public ArrayList<RecruitVO> getRecruitVO(int company_id, boolean recruit_now) {
		ArrayList<RecruitVO> rcruitArray = null;
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		
		try {
			rcruitArray = dao.getRecruitArray(company_id, recruit_now, conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(conn, null, null);
		}
		
		return rcruitArray;
		
	}

	public ArrayList<RatingVO> getRatingList(int company_id, Paging2 paging) {
		ArrayList<RatingVO> ratingArray = null;
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		
		try {
			ratingArray = dao.getRatingArray(company_id, paging, conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(conn, null, null);
		}
		
		return ratingArray;
	}

	public int getTotalRating(int company_id) {
		int totalCount = 0;
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		
		try {
			totalCount = dao.getRatingTotal(company_id, conn);
		}catch(Exception e) {
			
		}finally {
			close(conn, null, null);
		}
		
		return totalCount;
	}

}
