package action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction implements Action{

	@Override
	public String execute() throws Exception {
		 Map session = ActionContext.getContext().getSession();
		  
		 session.remove("loginUser");
		return SUCCESS;
	}

}
