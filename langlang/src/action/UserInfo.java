package action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import model.LangDAO;
import model.Student;

public class UserInfo implements Action{
	Student loginUser;
	Student getInfo;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		loginUser = (Student) session.get("loginUser");
		LangDAO dao = LangDAO.getDAO();
		getInfo = dao.login(loginUser);
		System.out.println("user_info_check: " + getInfo.getName());
		return SUCCESS;
	}
	public Student getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(Student loginUser) {
		this.loginUser = loginUser;
	}
	public Student getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(Student getInfo) {
		this.getInfo = getInfo;
	}
	
	

}
