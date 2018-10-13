package lab27.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab27.svc.RReplyRateService;

public class RReplyRateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = "reply_rate";
		
		String reply_id = request.getParameter("reply_id");
		
		RReplyRateService service = new RReplyRateService();
		
		service.replyRate(type, reply_id);
		
		
	}

}
