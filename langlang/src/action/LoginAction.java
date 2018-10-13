package action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import model.LangDAO;
import model.Student;

public class LoginAction implements Action, ModelDriven, Preparable{
	
	private Student st;
	ActionContext con = ActionContext.getContext();
	SessionMap session;
	private String msg;
	
	@Override
	public void prepare() throws Exception {
		st = new Student();
		
	}

	@Override
	public Object getModel() {
		
		return st;
	}

	@Override
	public String execute() throws Exception {
		LangDAO dao = LangDAO.getDAO();
		st = dao.login(st);
		if(st == null){
			msg="We can't sign into your account";
			return INPUT;
		}
		System.out.println("logincheck: "+st.getEmail());
		  Map session = ActionContext.getContext().getSession();
		  
		  session.put("loginUser", st);
		  
		return SUCCESS;
	}

	public Student getSt() {
		return st;
	}

	public void setSt(Student st) {
		this.st = st;
	}

	public ActionContext getCon() {
		return con;
	}

	public void setCon(ActionContext con) {
		this.con = con;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = (SessionMap) session;
	}

	public void setSession(SessionMap session) {
		this.session = session;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
