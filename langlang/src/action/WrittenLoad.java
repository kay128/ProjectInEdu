package action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import model.LangDAO;
import model.Student;
import model.Written;

public class WrittenLoad implements Action, ModelDriven, Preparable {

	SessionMap session;
	private Written load;
	private int res_id;
	private int en_current_page;
	private int ko_current_page;
	private int js_current_page;
	
	@Override
	public void prepare() throws Exception {
		load = new Written();		
	}

	@Override
	public Object getModel() {
		return load;
	}

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Student st = (Student) session.get("loginUser");
		System.out.println("name check: "+st.getName());
		load.setName(st.getName());
		LangDAO dao = LangDAO.getDAO();
		int last = dao.getLastId();
		System.out.println("마지막 id check: " + last);
		res_id = last+1;
		System.out.println("id check: " + res_id);
		load.setRes_id(res_id);
		
		dao.loadWr(load);
		return SUCCESS;
	}

	public SessionMap getSession() {
		return session;
	}

	public void setSession(SessionMap session) {
		this.session = session;
	}

	public Written getLoad() {
		return load;
	}

	public void setLoad(Written load) {
		this.load = load;
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
