package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

import model.LangDAO;
import model.Written;

public class WrittenList implements Action{
	
	private ArrayList<Written> list = new ArrayList<Written>();
	private ArrayList<Written> en_list = new ArrayList<Written>();
	private ArrayList<Written> ko_list = new ArrayList<Written>();
	private ArrayList<Written> js_list = new ArrayList<Written>();
	private String msg;
	
	private Paging en_page;
	private Paging ko_page;
	private Paging js_page;
	
	private String en_page_html;
	private String ko_page_html;
	private String js_page_html;
	
	
	private int en_current_page;
	private int ko_current_page;
	private int js_current_page;
	private int en_total_inlist;
	private int ko_total_inlist;
	private int js_total_inlist;
	
	
	@Override
	public String execute() throws Exception {
		LangDAO dao = LangDAO.getDAO();
		list = dao.getList();
		if(list == null){
			msg = "작성 된 글이 없습니다.";
		}else{
			for(Written w : list){
				switch(w.getLang()){
				case "en":
					en_list.add(w);
					break;
				case "ko":
					ko_list.add(w);
					break;
				case "js":
					js_list.add(w);
					break;
				}
			}
			if(en_current_page == 0){
				en_current_page = 1;
			}
			if(ko_current_page == 0){
				ko_current_page = 1;
			}
			if(js_current_page == 0){
				js_current_page = 1;
			}
			System.out.println("en_list_test: "+en_list.size());
			System.out.println("ko_list_test: "+ko_list.size());
			System.out.println("js_list_test: "+js_list.size());
			
			en_total_inlist = en_list.size();
			
			en_page = new Paging(en_current_page, en_total_inlist, "en");
			
			en_page_html = en_page.getPage_html().toString();
			int en_last_inlist = en_total_inlist;
			if(en_page.getTotal_inlist() < en_last_inlist){
				en_last_inlist = en_page.getTotal_inlist()+1;
			}
			
			ko_total_inlist = ko_list.size();
			
			ko_page = new Paging(ko_current_page, ko_total_inlist, "ko");
			
			ko_page_html = ko_page.getPage_html().toString();
			int ko_last_inlist = ko_total_inlist;
			if(ko_page.getTotal_inlist() < ko_last_inlist){
				ko_last_inlist = ko_page.getTotal_inlist()+1;
			}
			
			js_total_inlist = js_list.size();
			
			js_page = new Paging(js_current_page, js_total_inlist, "js");
			
			js_page_html = js_page.getPage_html().toString();
			int js_last_inlist = js_total_inlist;
			if(js_page.getTotal_inlist() < js_last_inlist){
				js_last_inlist = js_page.getTotal_inlist()+1;
			}
			
		}		

		
		return SUCCESS;
	}


	public ArrayList<Written> getList() {
		return list;
	}


	public void setList(ArrayList<Written> list) {
		this.list = list;
	}


	public ArrayList<Written> getEn_list() {
		return en_list;
	}


	public void setEn_list(ArrayList<Written> en_list) {
		this.en_list = en_list;
	}


	public ArrayList<Written> getKo_list() {
		return ko_list;
	}


	public void setKo_list(ArrayList<Written> ko_list) {
		this.ko_list = ko_list;
	}


	public ArrayList<Written> getJs_list() {
		return js_list;
	}


	public void setJs_list(ArrayList<Written> js_list) {
		this.js_list = js_list;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Paging getEn_page() {
		return en_page;
	}


	public void setEn_page(Paging en_page) {
		this.en_page = en_page;
	}


	public Paging getKo_page() {
		return ko_page;
	}


	public void setKo_page(Paging ko_page) {
		this.ko_page = ko_page;
	}


	public Paging getJs_page() {
		return js_page;
	}


	public void setJs_page(Paging js_page) {
		this.js_page = js_page;
	}


	public String getEn_page_html() {
		return en_page_html;
	}


	public void setEn_page_html(String en_page_html) {
		this.en_page_html = en_page_html;
	}


	public String getKo_page_html() {
		return ko_page_html;
	}


	public void setKo_page_html(String ko_page_html) {
		this.ko_page_html = ko_page_html;
	}


	public String getJs_page_html() {
		return js_page_html;
	}


	public void setJs_page_html(String js_page_html) {
		this.js_page_html = js_page_html;
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


	public int getEn_total_inlist() {
		return en_total_inlist;
	}


	public void setEn_total_inlist(int en_total_inlist) {
		this.en_total_inlist = en_total_inlist;
	}


	public int getKo_total_inlist() {
		return ko_total_inlist;
	}


	public void setKo_total_inlist(int ko_total_inlist) {
		this.ko_total_inlist = ko_total_inlist;
	}


	public int getJs_total_inlist() {
		return js_total_inlist;
	}


	public void setJs_total_inlist(int js_total_inlist) {
		this.js_total_inlist = js_total_inlist;
	}

		
	
}
