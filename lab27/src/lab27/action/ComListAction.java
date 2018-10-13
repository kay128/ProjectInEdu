package lab27.action;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.action.Action;
import lab27.svc.ComListService;
import lab27.vo.CompanyVO;
import lab27.vo.MemberVO;
import lab27.vo.Paging2;



public class ComListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//1. 검색 내용을 받아온다.
		CompanyVO search = null;
		ArrayList<CompanyVO> company_list = null;
		ComListService svc = new ComListService();
		
		String company_name = null; int company_year = 0; int limit_year=0; int company_emp=0; int company_money=0; int company_cap=0;
		String company_loc = null; int is_korea_ceo=0;
		
		company_name=request.getParameter("company_name");
		String year_s = request.getParameter("company_year");		
		if(year_s !=null && year_s.length()>0) {
		company_year=Integer.parseInt(year_s);
		}
		
		String limit_s=request.getParameter("limit_year");
		if(limit_s !=null && limit_s.length()>0) {
		limit_year = Integer.parseInt(limit_s);
		}
		
		String emp_s = request.getParameter("company_emp");
		if(emp_s !=null && emp_s.length()>0 ) {
		company_emp = Integer.parseInt(emp_s);
		}
		
		String money_s=request.getParameter("company_money");
		if(money_s !=null && money_s.length()>0 ) {
		company_money = Integer.parseInt(money_s);
		}
		
		
		String cap_s=request.getParameter("company_cap");
		
		if(cap_s !=null && cap_s.length()>0 ) {
		company_cap = cap_s==null? 0:Integer.parseInt(cap_s);
		}
		company_loc = request.getParameter("company_loc");
		String ceo_s = request.getParameter("is_korea_ceo");
		if(ceo_s !=null && ceo_s.length()>0 ) {
		is_korea_ceo = Integer.parseInt(ceo_s);
		}
		search = new CompanyVO(company_name, company_year, limit_year, company_emp, company_money, company_cap,
				company_loc, is_korea_ceo);
		
		//원래는 CompanyVO를 직접 넘겨줄 생각이었으나, 페이징 처리시 너무 많은 어트리뷰트 정보가 교환되는 단점이 있다.
		//그러므로 search에 관련된 sql문을 String 형식으로 교환하여  주고 받기로 한다.
		
		String sql = "";
		
		if(request.getParameter("sql")!=null && request.getParameter("sql").length()>0){
			sql=request.getParameter("sql");
		}else {
			
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
			
			if(sql != null && sql.endsWith(" and ")) {
				sql = sql.substring(0, sql.length()-5);
			}
		}
		
		int totalCount=svc.getTotalCount(sql);
		
		
		
		//2. 세션에 로그인 되어있다면 로그인 id를 받아온다.
		HttpSession session = request.getSession();
		MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
		String user_id=null;
		if(loginUser != null) {
			user_id=loginUser.getUser_id();
		}
		

		Paging2 paging = new Paging2();
		int currentPage = 0;
		String current_s=request.getParameter("currentPage");
		currentPage=current_s==null? 0:Integer.parseInt(request.getParameter("currentPage"));
		
		paging.setCurrentPage(currentPage);
		paging.setBlockCount(6);
		paging.setBlockPage(5);
		paging.setTotalCount(totalCount);
		paging.pagingAction();
		System.out.println("페이징="+paging.toString());
		
		company_list=svc.getCompanyList(sql, user_id, paging);
		
		
		
		if(company_list!=null) {
			request.setAttribute("company_list", company_list);
			request.setAttribute("paging", paging);
			
			if(sql!=null && sql.length()>0) {
				request.setAttribute("sql", sql);
			}
		}

		
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher("./company/company_index.jsp");
		dis.forward(request, response);
		
		
	}

}
