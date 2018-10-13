
package model;

public class Student {
	private String email;
	private String pw;
	private String name;
	private String contry;
	private String main_lang;
	
	public Student() {}
	
	public Student(String email, String pw) {
		this.email = email;
		this.pw = pw;
	}
	
	
	public Student(String email, String pw, String name, String contry, String main_lang) {
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.contry = contry;
		this.main_lang = main_lang;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public String getMain_lang() {
		return main_lang;
	}
	public void setMain_lang(String main_lang) {
		this.main_lang = main_lang;
	}	
	
}
