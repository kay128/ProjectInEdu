package lab27.vo;

public class CMemberVO {
	private String c_name;
	private String user_id;
	private int c_favorite;
	private int c_grade;

	public CMemberVO() {
	}

	public CMemberVO(String c_name, String user_id, int c_favorite, int c_grade) {
		super();
		this.c_name = c_name;
		this.user_id = user_id;
		this.c_favorite = c_favorite;
		this.c_grade = c_grade;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getC_favorite() {
		return c_favorite;
	}

	public void setC_favorite(int c_favorite) {
		this.c_favorite = c_favorite;
	}

	public int getC_grade() {
		return c_grade;
	}

	public void setC_grade(int c_grade) {
		this.c_grade = c_grade;
	}

	@Override
	public String toString() {
		return "CMemberVO [c_name=" + c_name + ", user_id=" + user_id + ", c_favorite=" + c_favorite + ", c_grade="
				+ c_grade + "]";
	}

}
