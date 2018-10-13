package lab27.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab27.svc.OneCompanyService;
import lab27.vo.CompanyVO;
import lab27.vo.Paging2;
import lab27.vo.RatingVO;
import lab27.vo.RecruitVO;

public class OneCompanyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CompanyVO company = null;
		ArrayList<RecruitVO> recruitList = null;
		ArrayList<RatingVO>  ratingList = null;
		boolean recruit_now = true;
		//1. company_id를 받아온다.
		int company_id=Integer.parseInt(request.getParameter("company_id"));
		OneCompanyService svc= new OneCompanyService();
		//2. company의 read_count를 하나 올린다.
		svc.readCountUpdate(company_id);
		
		//3. logo, name, type, area, ceo, year, page, info, emp, mony, cap, loc를 가져와서 뿌려준다.	company_id number not null,	--회사 id
		//mony나 cap은 적절한 형식으로 바꾸고, 홈페이지에는 링크를 걸어준다.
		company=svc.getOneCompany(company_id);
		company.formatting();
		
		
		
		//recruit의 vo를 만든다. 
		//가져올때 sysdate보다 enddate가 크며, 회사id가 일치하는 걸 list로 받아온다.
		//일단 가져와야 할 것은 recruit_id, start_day, end_day, recuruit_type, recruit_rtype, recruit_pay, recruit_time 이다
		//일단 vo는 전부 만들고 생성자를 위의 항목으로 두기로 하자.
		recruitList = svc.getRecruitVO(company_id, recruit_now);
		
		
		//rating과 관련된 vo를 생성한다.
		//company_id가 일치하는 rating을 전부 가져온다.
		//페이징 항상 염두에 둘것
		int totalCount = svc.getTotalRating(company_id);
		String current_s = request.getParameter("currentPage");
		int currentPage=0;
		if(current_s!=null && current_s.length()>0) {
			currentPage = Integer.parseInt(current_s);
		}
		
		Paging2 paging = new Paging2(totalCount, 4, currentPage, 4);
		paging.pagingAction();
		ratingList = svc.getRatingList(company_id, paging);
		

		
		request.setAttribute("company", company);
		request.setAttribute("paging", paging);
		request.setAttribute("recruit_list", recruitList);
		request.setAttribute("rating_list", ratingList);
		//jsp에서 커런트 페이지 가져올 때 회사 번호도 같이 들고와야한다. 
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./company/one_company.jsp");
		dispatcher.forward(request, response);
	}

}
