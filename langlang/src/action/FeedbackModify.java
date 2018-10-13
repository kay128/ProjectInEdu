package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import model.Feedback;
import model.LangDAO;
import model.Written;

public class FeedbackModify implements Action, ModelDriven, Preparable{
	private Feedback modify;
	private int res_id;
	private int en_current_page;
	private int ko_current_page;
	private int js_current_page;
	
	@Override
	public void prepare() throws Exception {
		modify = new Feedback();		
	}

	@Override
	public Object getModel() {
		return modify;
	}
	
	@Override
	public String execute() throws Exception {
		LangDAO dao = LangDAO.getDAO();
		System.out.println("fe_modify check: "+modify.getFeedback_id()+"+" + modify.getFeedback_content());
		dao.modifyFe(modify);
		System.out.println("res_id 안넘어오나?_modify " + modify.getRes_id()+"+"+res_id);
		return SUCCESS;
	}

	public Feedback getModify() {
		return modify;
	}

	public void setModify(Feedback modify) {
		this.modify = modify;
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
