package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

import model.LangDAO;
import model.Written;

public class ViewWritten implements Action{
	private int res_id;
	private int en_current_page;
	private int ko_current_page;
	private int js_current_page;
	private ArrayList<Written> selected;
	private int fe_modify_id;
	
	@Override
	public String execute() throws Exception {
		LangDAO dao = LangDAO.getDAO();
		System.out.println("res_id check: " + res_id);
		dao.upHit(res_id);
		selected = dao.getOne(res_id);
		
		System.out.println("view 결과 check: " + selected.size());
		
		return SUCCESS;
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

	public int getFe_modify_id() {
		return fe_modify_id;
	}

	public void setFe_modify_id(int fe_modify_id) {
		this.fe_modify_id = fe_modify_id;
	}

	
	
}
