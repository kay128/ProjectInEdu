package lab27.vo;

import java.util.Date;

public class CAllVO {
	private String c_name;
	private String c_theme;
	private Date c_date;
	private String c_master;
	private int count;
	private String user_id;
	private int c_favorit;
	
	public CAllVO() {}

	public CAllVO(String c_name, String c_theme, Date c_date, String c_master, int count, String user_id,
			int c_favorit) {
		super();
		this.c_name = c_name;
		this.c_theme = c_theme;
		this.c_date = c_date;
		this.c_master = c_master;
		this.count = count;
		this.user_id = user_id;
		this.c_favorit = c_favorit;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getC_favorit() {
		return c_favorit;
	}

	public void setC_favorit(int c_favorit) {
		this.c_favorit = c_favorit;
	}

	@Override
	public String toString() {
		return "CAllVO [c_name=" + c_name + ", c_theme=" + c_theme + ", c_date=" + c_date + ", c_master=" + c_master
				+ ", count=" + count + ", user_id=" + user_id + ", c_favorit=" + c_favorit + "]";
	}
	
	
}
