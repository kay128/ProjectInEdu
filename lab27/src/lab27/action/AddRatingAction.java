package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.AddRatingService;
import lab27.vo.MemberVO;
import lab27.vo.RatingVO;

public class AddRatingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		String user_id = loginUser.getUser_id();
		int company_id=Integer.parseInt(request.getParameter("company_id"));
		int rating_star = Integer.parseInt(request.getParameter("rating_star"));
		String rating_adv = request.getParameter("rating_adv");
		String rating_disadv = request.getParameter("rating_disadv");
		
		RatingVO rating = new RatingVO();
		
		rating.setUser_id(user_id);
		rating.setCompany_id(company_id);
		rating.setRating_star(rating_star);
		rating.setRating_adv(rating_adv);
		rating.setRating_disadv(rating_disadv);
		
		//서비스생성하자
		
		AddRatingService svc = new AddRatingService();
		boolean result = svc.addRating(rating);
		
		if(result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./oneCompany.lab27?command=oneCompany&&company_id="+company_id);
			dispatcher.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('평점등록에 실패하였습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		}
	}

}
