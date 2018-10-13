package lab27.vo;

import java.util.Date;

public class CommunityVO {
	private String c_name;
	private String c_theme;
	private Date c_date;
	private String c_master;
	private String c_number;

	public CommunityVO() {
	}

	public CommunityVO(String c_name, String c_theme, Date c_date, String c_master) {
		super();
		this.c_name = c_name;
		this.c_theme = c_theme;
		this.c_date = c_date;
		this.c_master = c_master;
	}
	
	public CommunityVO(String c_name, String c_theme, Date c_date, String c_master, String c_number) {
		super();
		this.c_name = c_name;
		this.c_theme = c_theme;
		this.c_date = c_date;
		this.c_master = c_master;
		this.c_number = c_number;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_theme() {
		return c_theme;
	}

	public void setC_theme(String c_theme) {
		this.c_theme = c_theme;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public String getC_master() {
		return c_master;
	}

	public void setC_master(String c_master) {
		this.c_master = c_master;
	}
	
	public String getC_number() {
		return c_number;
	}

	public void setC_number(String c_number) {
		this.c_number = c_number;
	}

	@Override
	public String toString() {
		return "CommunityVO [c_name=" + c_name + ", c_theme=" + c_theme + ", c_date=" + c_date + ", c_master="
				+ c_master + "]";
	}

}
