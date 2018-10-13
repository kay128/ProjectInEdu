package action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import model.Feedback;
import model.LangDAO;
import model.Student;

public class FeedbackLoad implements Action, ModelDriven, Preparable{

	SessionMap session;
	private Feedback fe;
	private int res_id;
	private int en_current_page;
	private int ko_current_page;
	private int js_current_page;
	
	@Override
	public void prepare() throws Exception {
		fe=new Feedback();
	}

	@Override
	public Object getModel() {
		return fe;
	}

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Student st = (Student) session.get("loginUser");
		System.out.println("name check: "+st.getName());
		fe.setFeedback_name(st.getName());
		LangDAO dao = LangDAO.getDAO();
		int last_feed = dao.getLastFeedId();
		int feedback_id = last_feed+1;
		fe.setFeedback_id(feedback_id);		
		System.out.println("feedback_res_id check: " + res_id);
		dao.loadFe(fe);
		return SUCCESS;
	}

	public Feedback getFe() {
		return fe;
	}

	public void setFe(Feedback fe) {
		this.fe = fe;
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
