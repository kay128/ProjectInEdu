package lab27.vo;

import java.util.Date;

public class RecruitVO {
	int company_id;		//회사id
	Date start_day;		//모집 시작일
	Date end_day;		//모집 마감일
	int recruit_id;		//채용id
	String recuruit_type; //직종
	String recuruit_info; //업무내용
	String recuruit_rtype; //채용형태
	String recuruit_visa; //비자
	String recuruit_pbt; //수습기간
	String recruit_tr; // --연수기간
	String recruit_roc; //근무지
	String recruit_time; //근무시간
	String recruit_pay; //급여
	String recruit_bonus;	//상여금
	String recruit_benefit;	//수당
	String recruit_tray;	//교통비
	String recruit_ins;	//보험
	String recruit_vac;	//휴가
	String recruit_dom;	//기숙사
	String recruit_plane;	//항공임
	String recruit_domp;	//본인부담금
	String recruit_etc;	//기타
	String interview_1;	//1차전형
	String interview_2;	//2차전형
	String interview_3;	//3차전형
	String interview_4;	//4차전형
	
	
	public RecruitVO() {}


	public RecruitVO(int company_id, Date start_day, Date end_day, int recruit_id, String recuruit_type,
			String recuruit_info, String recuruit_rtype, String recuruit_visa, String recuruit_pbt, String recruit_tr,
			String recruit_roc, String recruit_time, String recruit_pay, String recruit_bonus, String recruit_benefit,
			String recruit_tray, String recruit_ins, String recruit_vac, String recruit_dom, String recruit_plane,
			String recruit_domp, String recruit_etc, String interview_1, String interview_2, String interview_3,
			String interview_4) {
		super();
		this.company_id = company_id;
		this.start_day = start_day;
		this.end_day = end_day;
		this.recruit_id = recruit_id;
		this.recuruit_type = recuruit_type;
		this.recuruit_info = recuruit_info;
		this.recuruit_rtype = recuruit_rtype;
		this.recuruit_visa = recuruit_visa;
		this.recuruit_pbt = recuruit_pbt;
		this.recruit_tr = recruit_tr;
		this.recruit_roc = recruit_roc;
		this.recruit_time = recruit_time;
		this.recruit_pay = recruit_pay;
		this.recruit_bonus = recruit_bonus;
		this.recruit_benefit = recruit_benefit;
		this.recruit_tray = recruit_tray;
		this.recruit_ins = recruit_ins;
		this.recruit_vac = recruit_vac;
		this.recruit_dom = recruit_dom;
		this.recruit_plane = recruit_plane;
		this.recruit_domp = recruit_domp;
		this.recruit_etc = recruit_etc;
		this.interview_1 = interview_1;
		this.interview_2 = interview_2;
		this.interview_3 = interview_3;
		this.interview_4 = interview_4;
	}


	public int getCompany_id() {
		return company_id;
	}


	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}


	public Date getStart_day() {
		return start_day;
	}


	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}


	public Date getEnd_day() {
		return end_day;
	}


	public void setEnd_day(Date end_day) {
		this.end_day = end_day;
	}


	public int getRecruit_id() {
		return recruit_id;
	}


	public void setRecruit_id(int recruit_id) {
		this.recruit_id = recruit_id;
	}


	public String getRecuruit_type() {
		return recuruit_type;
	}


	public void setRecuruit_type(String recuruit_type) {
		this.recuruit_type = recuruit_type;
	}


	public String getRecuruit_info() {
		return recuruit_info;
	}


	public void setRecuruit_info(String recuruit_info) {
		this.recuruit_info = recuruit_info;
	}


	public String getRecuruit_rtype() {
		return recuruit_rtype;
	}


	public void setRecuruit_rtype(String recuruit_rtype) {
		this.recuruit_rtype = recuruit_rtype;
	}


	public String getRecuruit_visa() {
		return recuruit_visa;
	}


	public void setRecuruit_visa(String recuruit_visa) {
		this.recuruit_visa = recuruit_visa;
	}


	public String getRecuruit_pbt() {
		return recuruit_pbt;
	}


	public void setRecuruit_pbt(String recuruit_pbt) {
		this.recuruit_pbt = recuruit_pbt;
	}


	public String getRecruit_tr() {
		return recruit_tr;
	}


	public void setRecruit_tr(String recruit_tr) {
		this.recruit_tr = recruit_tr;
	}


	public String getRecruit_roc() {
		return recruit_roc;
	}


	public void setRecruit_roc(String recruit_roc) {
		this.recruit_roc = recruit_roc;
	}


	public String getRecruit_time() {
		return recruit_time;
	}


	public void setRecruit_time(String recruit_time) {
		this.recruit_time = recruit_time;
	}


	public String getRecruit_pay() {
		return recruit_pay;
	}


	public void setRecruit_pay(String recruit_pay) {
		this.recruit_pay = recruit_pay;
	}


	public String getRecruit_bonus() {
		return recruit_bonus;
	}


	public void setRecruit_bonus(String recruit_bonus) {
		this.recruit_bonus = recruit_bonus;
	}


	public String getRecruit_benefit() {
		return recruit_benefit;
	}


	public void setRecruit_benefit(String recruit_benefit) {
		this.recruit_benefit = recruit_benefit;
	}


	public String getRecruit_tray() {
		return recruit_tray;
	}


	public void setRecruit_tray(String recruit_tray) {
		this.recruit_tray = recruit_tray;
	}


	public String getRecruit_ins() {
		return recruit_ins;
	}


	public void setRecruit_ins(String recruit_ins) {
		this.recruit_ins = recruit_ins;
	}


	public String getRecruit_vac() {
		return recruit_vac;
	}


	public void setRecruit_vac(String recruit_vac) {
		this.recruit_vac = recruit_vac;
	}


	public String getRecruit_dom() {
		return recruit_dom;
	}


	public void setRecruit_dom(String recruit_dom) {
		this.recruit_dom = recruit_dom;
	}


	public String getRecruit_plane() {
		return recruit_plane;
	}


	public void setRecruit_plane(String recruit_plane) {
		this.recruit_plane = recruit_plane;
	}


	public String getRecruit_domp() {
		return recruit_domp;
	}


	public void setRecruit_domp(String recruit_domp) {
		this.recruit_domp = recruit_domp;
	}


	public String getRecruit_etc() {
		return recruit_etc;
	}


	public void setRecruit_etc(String recruit_etc) {
		this.recruit_etc = recruit_etc;
	}


	public String getInterview_1() {
		return interview_1;
	}


	public void setInterview_1(String interview_1) {
		this.interview_1 = interview_1;
	}


	public String getInterview_2() {
		return interview_2;
	}


	public void setInterview_2(String interview_2) {
		this.interview_2 = interview_2;
	}


	public String getInterview_3() {
		return interview_3;
	}


	public void setInterview_3(String interview_3) {
		this.interview_3 = interview_3;
	}


	public String getInterview_4() {
		return interview_4;
	}


	public void setInterview_4(String interview_4) {
		this.interview_4 = interview_4;
	}
	
	
	
}
