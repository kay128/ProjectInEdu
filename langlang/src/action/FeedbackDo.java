package action;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import model.Feedback;

public class FeedbackDo implements Action, ModelDriven, Preparable{
	private Feedback fe;
	private String fe_mod;
	private int feedback_id;
	private int res_id;
	private int en_current_page;
	private int ko_current_page;
	private int js_current_page;
	private int fe_modify_id;

	@Override
	public String execute() throws Exception {
		feedback_id = fe.getFeedback_id();
		System.out.println("fe_mod는 뭔가? " + fe_mod);
		System.out.println("fe_id는 뭔가? " + feedback_id);
		System.out.println("res_id 안넘어오나?_do " + fe.getRes_id()+"+"+res_id);
		res_id = fe.getRes_id();
		if (fe_mod.equals("modify")) {
			fe_modify_id = feedback_id;
			return "modify";
		} else if (fe_mod.equals("delete")) {
			return "delete";
		}
		return null;
	}

	public String getFe_mod() {
		return fe_mod;
	}

	public void setFe_mod(String fe_mod) {
		this.fe_mod = fe_mod;
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

	
	
	public Feedback getFe() {
		return fe;
	}

	public void setFe(Feedback fe) {
		this.fe = fe;
	}

	public int getFe_modify_id() {
		return fe_modify_id;
	}

	public void setFe_modify_id(int fe_modify_id) {
		this.fe_modify_id = fe_modify_id;
	}

	@Override
	public void prepare() throws Exception {
		fe=new Feedback();
		
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return fe;
	}

}
