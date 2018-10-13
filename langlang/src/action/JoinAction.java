package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import model.LangDAO;
import model.Student;

public class JoinAction implements Action, ModelDriven, Preparable{
	
	private Student st;
	private Student test;
	private String msg_email="";
	private String msg_name="";
	
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
		System.out.println("Join_check: "+st.getEmail());
		LangDAO dao = LangDAO.getDAO();
		test = dao.checkEmail(st);
		if(test != null){
			msg_email="It's already used email";
		}
		test = dao.checkName(st);
		if(test != null) {
			msg_name="It's already used name";
		}
		
		if(msg_email.length()>0 || msg_name.length()>0) {
			return INPUT;
		}
		
		dao.join(st);
		return SUCCESS;
	}

	public Student getSt() {
		return st;
	}

	public void setSt(Student st) {
		this.st = st;
	}

	public Student getTest() {
		return test;
	}

	public void setTest(Student test) {
		this.test = test;
	}

	public String getMsg_email() {
		return msg_email;
	}

	public void setMsg_email(String msg_email) {
		this.msg_email = msg_email;
	}

	public String getMsg_name() {
		return msg_name;
	}

	public void setMsg_name(String msg_name) {
		this.msg_name = msg_name;
	}
	
}
