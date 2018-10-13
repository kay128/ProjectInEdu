package action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import model.LangDAO;
import model.Student;

public class DeleteUser implements Action{
		Student st;
	
		@Override
		public String execute() throws Exception {
			Map session = ActionContext.getContext().getSession();
			  
			st = (Student) session.get("loginUser");
			System.out.println("delete_User check: " + st.getName());
			LangDAO dao = LangDAO.getDAO();
			dao.deleteUser(st);
			
			return SUCCESS;
		}

		public Student getSt() {
			return st;
		}

		public void setSt(Student st) {
			this.st = st;
		}
		
		

}
