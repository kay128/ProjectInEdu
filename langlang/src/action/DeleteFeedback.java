package action;

import com.opensymphony.xwork2.Action;

import model.LangDAO;

public class DeleteFeedback implements Action{
	private int feedback_id;
	private int res_id;
	private int en_current_page;
	private int ko_current_page;
	private int js_current_page;
	
	@Override
	public String execute() throws Exception {
		System.out.println("delete_feedback check: " + feedback_id);
		LangDAO dao = LangDAO.getDAO();
		dao.deleteFeedback(feedback_id);
		
		return SUCCESS;
	}
	
	
	
	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
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
	
}
