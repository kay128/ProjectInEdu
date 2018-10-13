package lab27.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LabCompanyDAO {
	//페이징 작업을 위한 총  count수를 가져오는 쿼리
	public int getTotalCount(String sql, Connection conn) throws Exception{
		int totalCount = 0;
		
		ResultSet rs = null;
		PreparedStatement pstmt=null;
	
		String fullsql = "select count(*) from company";
		
		if(sql!=null && sql.length()>0) {
			fullsql += " "+sql;
		}
		/*
		if(search.is_searchable()) {
			sql += "where ";
		}
		//개인 정보가 아닌데 preparedstatement일 필요가 있을까?

		
		if(search.getCompany_year()>0) {
			sql += "company_year >= "+search.getCompany_year()+" and ";
		}
		
		if(search.getLimit_year()>0) {
			sql += "company_year <= "+search.getLimit_year()+" and "; 
		}
		
		if(search.getCompany_emp()>0) {
			sql += "company_emp >= "+search.getCompany_emp()+" and ";
		}
		
		if(search.getCompany_money() >0) {
			sql += "company_money >= "+search.getCompany_money() + " and ";
		}
		
		if(search.getCompany_cap()>0) {
			sql += "company_cap >= " + search.getCompany_cap() + " and ";
		}
		

		
		if(search.getIs_korea_ceo() != 0) {
			sql += "is_korea_ceo = "+search.getIs_korea_ceo() + " and ";
		}
		
		if(search.getCompany_loc() != null) {
			sql += "company_loc like " + search.getCompany_loc() + " and ";
		}
		
		if(search.getCompany_name()!=null) {
			sql += "company_name like "+search.getCompany_name();
		}
		
		if(sql.endsWith(" and ")) {
			sql = sql.substring(0, sql.length()-5);
		}
		*/
		try {
			pstmt = conn.prepareStatement(fullsql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("sql = "+fullsql);
		
		return totalCount;
	}
	
	//리스트를 가져오는 쿼리
	public ArrayList<CompanyVO> getCompanyList(String whilesql, String user_id, Paging2 paging, Connection conn) { 
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		ArrayList<CompanyVO> companyList = null;
		
		
		String sql = "select * from (select company_record.*, rownum as rn from (select company.company_id, company.company_logo, avg(rating.rating_star) as star_avg, company.read_count, count(rating.company_id) as rating_count, nvl2(favorite_company.company_id, 1, 0) as is_pavorite, nvl2(recruit.company_id, 1, 0) as recruit_now from company left outer join rating on company.company_id = rating.company_id left outer join favorite_company on company.company_id = favorite_company.company_id ";
		
		if(user_id!=null && user_id.length()>=1) {
			sql += "and favorite_company.user_id='" + user_id + "' "; 
		}
		
		sql += "left outer join recruit on company.company_id = recruit.company_id and recruit.end_day >= sysdate ";
		
		if(whilesql!=null && whilesql.length()>=1) {
			sql+=whilesql+" ";
		}
	/*
		if(search.is_searchable()) {
			sql += "where ";
		}
		//개인 정보가 아닌데 preparedstatement일 필요가 있을까?

		
		if(search.getCompany_year()>0) {
			sql += "company_year >= "+search.getCompany_year()+" and ";
		}
		
		if(search.getLimit_year()>0) {
			sql += "company_year <= "+search.getLimit_year()+" and "; 
		}
		
		if(search.getCompany_emp()>0) {
			sql += "company_emp >= "+search.getCompany_emp()+" and ";
		}
		
		if(search.getCompany_money() >0) {
			sql += "company_money >= "+search.getCompany_money() + " and ";
		}
		
		if(search.getCompany_cap()>0) {
			sql += "company_cap >= " + search.getCompany_cap() + " and ";
		}
		

		
		if(search.getIs_korea_ceo() != 0) {
			sql += "is_korea_ceo = "+search.getIs_korea_ceo() + " and ";
		}
		
		if(search.getCompany_loc() != null) {
			sql += "company_loc like " + search.getCompany_loc() + " and ";
		}
		
		if(search.getCompany_name()!=null) {
			sql += "company_name like "+search.getCompany_name()+" ";
		}
		
		if(sql.endsWith(" and ")) {
			sql = sql.substring(0, sql.length()-5);
		}
		*/
		sql += "group by company.company_id, company.company_logo, company.read_count, favorite_company.company_id, recruit.company_id order by recruit_now desc, is_pavorite desc, star_avg desc nulls last)company_record) where rn between "+paging.getStartCount() + " and " + paging.getEndCount();
		 
		System.out.println("sql : "+sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				companyList = new ArrayList<CompanyVO>();
				
				do{
					CompanyVO vo = new CompanyVO();
					vo.setCompany_id(rs.getInt(1));
					vo.setCompany_logo(rs.getString(2));
					vo.setStar_avg(rs.getDouble(3));
					vo.setRead_count(rs.getInt(4));
					vo.setRating_count(rs.getInt(5));
					vo.setIs_pavorite(rs.getInt(6));
					vo.setRecruit_now(rs.getInt(7));
				
					
					companyList.add(vo);
				}while(rs.next());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		return companyList;
	}

	public int deletePavorite(String user_id, int company_id, Connection conn) {
		String sql = "delete from favorite_company where user_id = ? and company_id = ?";
		PreparedStatement pstmt=null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, company_id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return result;
	}

	public int addPavorite(String user_id, int company_id, Connection conn) {
		String sql = "insert into favorite_company values(?, ?)";
		PreparedStatement pstmt=null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, company_id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return result;
	}

	public void readCountUpdate(int company_id, Connection conn) {
		String sql = "update company set read_count = read_count+1 where company_id=?";
		PreparedStatement pstmt=null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, company_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public CompanyVO getOneCompany(int company_id, Connection conn) {
		
		String sql = "select * from company where company_id =?";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		CompanyVO company = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, company_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				company=new CompanyVO();
				company.setCompany_id(rs.getInt(1));
				company.setCompany_name(rs.getString(2));
				company.setRead_count(rs.getInt(3));
				company.setCompany_logo(rs.getString(4));
				company.setCompany_type(rs.getString(5));
				company.setCompany_area(rs.getString(6));
				company.setCompany_ceo(rs.getString(7));
				company.setCompany_year(rs.getInt(8));
				company.setCompany_page(rs.getString(9));
				company.setCompany_info(rs.getString(10));
				company.setCompany_emp(rs.getInt(11));
				company.setCompany_money(rs.getInt(12));
				company.setCompany_cap(rs.getInt(13));
				company.setCompany_loc(rs.getString(14));
				company.setIs_korea_ceo(rs.getInt(15));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return company;
	}

	public ArrayList<RecruitVO> getRecruitArray(int company_id, boolean recruit_now, Connection conn) {
		String sql = "select * from recruit where company_id=?";
		if(recruit_now) {
			sql+=" and end_day>sysdate";
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RecruitVO> recruitList = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, company_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				recruitList = new ArrayList<RecruitVO>();
				
				do {
					RecruitVO vo = new RecruitVO(
							rs.getInt(1), rs.getTimestamp(2), rs.getTimestamp(3),
							rs.getInt(4), rs.getString(5), rs.getString(6),
							rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12),
							rs.getString(13), rs.getString(14), rs.getString(15),
							rs.getString(16), rs.getString(17), rs.getString(18),
							rs.getString(19), rs.getString(20), rs.getString(21),
							rs.getString(22), rs.getString(23), rs.getString(24),
							rs.getString(25), rs.getString(26)
							);
					recruitList.add(vo);
				}while(rs.next());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
				
		return recruitList;
	}

	public ArrayList<RatingVO> getRatingArray(int company_id, Paging2 paging, Connection conn) {
		ArrayList<RatingVO> ratingArray = null;
		String sql = "select * from(select rating_record.*, rownum as rn from(select * from rating where company_id=? order by rating_id desc)rating_record)where rn between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, company_id);
			pstmt.setInt(2, paging.getStartCount());
			pstmt.setInt(3, paging.getEndCount());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				ratingArray = new ArrayList<RatingVO>();
				do {
					RatingVO vo =new RatingVO(rs.getString(1), rs.getInt(2), rs.getInt(3),
							rs.getString(4), rs.getString(5), rs.getInt(6), rs.getTimestamp(7));
					ratingArray.add(vo);
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ratingArray;
	}

	public int getRatingTotal(int company_id, Connection conn) {
		int totalCount = 0;
		String sql ="select count(*) from rating where company_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, company_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return totalCount;
	}

	public int addRating(RatingVO rating, Connection conn) {
		String sql = "insert into rating values(?, (select count(*)+1 from rating), ?, ?, ?, ?, sysdate)";
		int result=0;
		PreparedStatement pstmt= null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, rating.getUser_id());
			pstmt.setInt(2, rating.getCompany_id());
			pstmt.setString(3, rating.getRating_adv());
			pstmt.setString(4, rating.getRating_disadv());
			pstmt.setInt(5, rating.getRating_star());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	

}
