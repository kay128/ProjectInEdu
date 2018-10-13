package lab27.vo;

import java.util.Date;

public class RatingVO {
	String user_id; //유저 id
	int rating_id; //평점 id
	int company_id; //회사 id
	String rating_adv; //회사 장점
	String rating_disadv; //회사 단점
	int rating_star; //평점 
	Date rating_regdate; //등록 날짜
	
	
	
	public RatingVO() {
		super();
	}
	
	
	public RatingVO(String user_id, int rating_id, int company_id, String rating_adv, String rating_disadv,
			int rating_star, Date rating_regdate) {
		super();
		this.user_id = user_id;
		this.rating_id = rating_id;
		this.company_id = company_id;
		this.rating_adv = rating_adv;
		this.rating_disadv = rating_disadv;
		this.rating_star = rating_star;
		this.rating_regdate = rating_regdate;
	}


	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getRating_adv() {
		return rating_adv;
	}
	public void setRating_adv(String rating_adv) {
		this.rating_adv = rating_adv;
	}
	public String getRating_disadv() {
		return rating_disadv;
	}
	public void setRating_disadv(String rating_disadv) {
		this.rating_disadv = rating_disadv;
	}
	public int getRating_star() {
		return rating_star;
	}
	public void setRating_star(int rating_star) {
		this.rating_star = rating_star;
	}
	public Date getRating_regdate() {
		return rating_regdate;
	}
	public void setRating_regdate(Date rating_regdate) {
		this.rating_regdate = rating_regdate;
	}
	
	
}
