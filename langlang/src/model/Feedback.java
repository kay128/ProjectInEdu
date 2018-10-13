package model;

import java.util.Date;

public class Feedback {
	private int feedback_id;
	private int res_id;
	private String feedback_name;
	private Date feedback_regdate;
	private int super_id;
	private int lev;
	private int feedback_rate;
	private String feedback_content;
	
	public Feedback() {
	}
	
	
	public Feedback(int feedback_id, int res_id, String feedback_name, Date feedback_regdate, int super_id, int lev,
			int feedback_rate, String feedback_content) {
		super();
		this.feedback_id = feedback_id;
		this.res_id = res_id;
		this.feedback_name = feedback_name;
		this.feedback_regdate = feedback_regdate;
		this.super_id = super_id;
		this.lev = lev;
		this.feedback_rate = feedback_rate;
		this.feedback_content = feedback_content;
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


	public String getFeedback_name() {
		return feedback_name;
	}


	public void setFeedback_name(String feedback_name) {
		this.feedback_name = feedback_name;
	}


	public Date getFeedback_regdate() {
		return feedback_regdate;
	}


	public void setFeedback_regdate(Date feedback_regdate) {
		this.feedback_regdate = feedback_regdate;
	}


	public int getSuper_id() {
		return super_id;
	}


	public void setSuper_id(int super_id) {
		this.super_id = super_id;
	}


	public int getLev() {
		return lev;
	}


	public void setLev(int lev) {
		this.lev = lev;
	}


	public int getFeedback_rate() {
		return feedback_rate;
	}


	public void setFeedback_rate(int feedback_rate) {
		this.feedback_rate = feedback_rate;
	}


	public String getFeedback_content() {
		return feedback_content;
	}


	public void setFeedback_content(String feedback_content) {
		this.feedback_content = feedback_content;
	}
	
}
