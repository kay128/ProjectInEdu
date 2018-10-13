package action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import model.Student;

public class Check implements Action{
	private String target;
	private String mod;
	private int res_id;
	private int en_current_page;
	private int ko_current_page;
	private int js_current_page;
	private String pw;
	private String msg;
	
	public String form() throws Exception{
		System.out.println("check_form _ target: "+ target);
		System.out.println("check_form _ mod: "+mod);
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		 Map session = ActionContext.getContext().getSession();
		 Student st = (Student) session.get("loginUser");
		 System.out.println("check에 들어왔나? " + st.getName()+ " pw "+st.getPw());
		 System.out.println("target은 뭔가?" + target);
		 System.out.println("mod는 뭔가? " + mod);		 
		 if(pw.equals(st.getPw())){
			 if(target.equals("written")){
				 if(mod.equals("modify")){
					 return "modify_wr";
				 }else if(mod.equals("delete")){
					 return "delete_wr";
				 }
			 }else if(target.equals("user")){
				 if(mod.equals("modify")){
					 return "modify_st";
				 }else if(mod.equals("delete")){
					 return "delete_st";
				 }
			 }
			 
		 }else{
			 System.out.println("msg setted");
			 msg="We can not match your password with your id.";
			 if(target.equals("written")){
				 return "input_wr";
			 }else if(target.equals("user")){
				 return "input_st";
			 }
		 }
		 return INPUT;
	}
	public String getMod() {
		return mod;
	}
	public void setMod(String mod) {
		this.mod = mod;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}	
	
	
	
}
