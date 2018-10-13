package action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import model.LangDAO;
import model.Student;
import model.Written;

public class ModifyForm implements Action{
	private String target;
	private int res_id;
	private int en_current_page;
	private int ko_current_page;
	private int js_current_page;
	private ArrayList<Written> selected;
	private Student user_info;
	
	@Override
	public String execute() throws Exception {
		if(target.equals("written")){
		LangDAO dao = LangDAO.getDAO();
		System.out.println("modify_form check: " + res_id);
		selected = dao.getOne(res_id);		
		System.out.println("modify_form 결과 check: " + selected.size());
		return "written";
		}else if(target.equals("user")){
			Map session = ActionContext.getContext().getSession();
			user_info = (Student) session.get("loginUser");
			System.out.println("modify_User check: " + user_info.getName());			
			return "user";
		}
		return null;
	}

	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	public int getEn_current_page() {
		return en_current_page;
	}

	public void setEn_current_page(int en_current_page) {
		this.en_current_page = en_current_page;
	}

	public int getKo_current_page() {
		return ko_current_page;
	}

	public void setKo_current_page(int ko_current_page) {
		this.ko_current_page = ko_current_page;
	}

	public int getJs_current_page() {
		return js_current_page;
	}

	public void setJs_current_page(int js_current_page) {
		this.js_current_page = js_current_page;
	}

	public ArrayList<Written> getSelected() {
		return selected;
	}

	public void setSelected(ArrayList<Written> selected) {
		this.selected = selected;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Student getUser_info() {
		return user_info;
	}

	public void setUser_info(Student user_info) {
		this.user_info = user_info;
	}
	
	
}
