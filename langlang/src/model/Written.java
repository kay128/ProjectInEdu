package model;

import java.util.ArrayList;
import java.util.Date;

public class Written {
	private int res_id;
	private String name;
	private String lang;
	private Date regdate;
	private int hit;
	private String title;
	private String content;
	private ArrayList<Feedback> feedbacks;
	
	public Written() {

	}

	public Written(int res_id, String name, String lang, Date regdate, int hit, String title, String content,
			ArrayList<Feedback> feedbacks) {
		super();
		this.res_id = res_id;
		this.name = name;
		this.lang = lang;
		this.regdate = regdate;
		this.hit = hit;
		this.title = title;
		this.content = content;
		this.feedbacks = feedbacks;
	}

	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(ArrayList<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
}
