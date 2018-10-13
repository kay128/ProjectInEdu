package action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import model.LangDAO;
import model.Student;

public class ModifyUser implements Action, ModelDriven, Preparable{

	Student modify;
	
	@Override
	public void prepare() throws Exception {
		modify = new Student();
		
	}

	@Override
	public Object getModel() {
		
		return modify;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("modify_user_check11: " + modify.getName());
		LangDAO dao = LangDAO.getDAO();
		dao.modifySt(modify);
		 Map session = ActionContext.getContext().getSession(); 
		 session.remove("loginUser");
		 session.put("loginUser", modify);
		return SUCCESS;
	}

	public Student getModify() {
		return modify;
	}

	public void setModify(Student modify) {
		this.modify = modify;
	}
	
	
	
}
