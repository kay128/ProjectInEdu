package lab27.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.CFavoriteService;
import lab27.svc.MGetMyCommuService;
import lab27.svc.POnePostService;
import lab27.svc.PSelectPostService;
import lab27.svc.RSelctRnBService;
import lab27.vo.CAllVO;
import lab27.vo.MemberVO;
import lab27.vo.PostVO;
import lab27.vo.ReplyVO;

public class MMyPageFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		
		HashMap map = new HashMap();
		map.put("type", "c_master");
		map.put("param", vo.getUser_id());
		
		MGetMyCommuService myCommuSvc = new MGetMyCommuService();
		
		ArrayList<CAllVO> myCommuList = myCommuSvc.getMyCommunity(map);
		CAllVO myCommu = myCommuList.get(0);
		
		map.put("type", "recent");
		map.put("board_name", myCommu.getC_name());
		
		POnePostService postService = new POnePostService();
		PostVO myCommuPost = postService.onePost(map);
		
		map.put("type", "my_notice");
		PostVO myCommuNotice = postService.onePost(map);
		
		
		map.put("type", "favorite");
		map.put("param", vo.getUser_id());
		
		CFavoriteService faSVC = new CFavoriteService();
		ArrayList<CAllVO> favList = faSVC.selectFavorite(map);
		ArrayList<PostVO> favPostList = new ArrayList<PostVO>();
		map.put("type", "recent");
		
		if(favPostList.size() != 0) {
			for(int i = 0; i < favList.size(); i++) {
				map.put("param", favPostList.get(i));
				favPostList.add(postService.onePost(map));	
			}	
		}
		
		
		map.put("type", "my_notice");
		ArrayList<PostVO> favNoticeList = new ArrayList<PostVO>();
		
		if(favNoticeList.size() != 0) {
			for(int i = 0; i < favList.size(); i++) {
				map.put("param", favPostList.get(i));
				favNoticeList.add(postService.onePost(map));	
			}	
		}
		
		
		
		map.put("type", "my_post");
		map.put("param", "free");
		map.put("param2", vo.getUser_id());
		PSelectPostService postSVC = new PSelectPostService();
		ArrayList<PostVO> freePostList = postSVC.selectPost(map);
		
		map.put("param", "exchange");
		ArrayList<PostVO> exchangePostList = postSVC.selectPost(map);
		
		RSelctRnBService rnb = new RSelctRnBService();
		ReplyVO myReply = rnb.selectRnB(map);
		
		map.put("type", "user_id");
		map.put("param", vo.getUser_id());
		
		CFavoriteService service = new CFavoriteService();
		ArrayList<CAllVO> joinList = service.selectFavorite(map);
		
		request.setAttribute("joinList", joinList);
		request.setAttribute("myCommu",myCommu);
		request.setAttribute("myCommuPost", myCommuPost);
		request.setAttribute("myCommuNotice", myCommuNotice);
		request.setAttribute("favList", favList);
		request.setAttribute("favPostList", favPostList);
		request.setAttribute("favNoticeList", favNoticeList);
		request.setAttribute("freePostList", freePostList);
		request.setAttribute("exchangePostList", exchangePostList);
		request.setAttribute("freePostCount", freePostList.size());
		request.setAttribute("exchangePostCount", exchangePostList.size());
		
		RequestDispatcher rdp = request.getRequestDispatcher("");
		rdp.forward(request, response);
	}

}
