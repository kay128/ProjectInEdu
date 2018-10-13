package model;

public class Customer {
	private String email;
	private String pass;
	private String nickName;
	private String authority;
	
	public Customer() {
		
	}
	public Customer(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}

	public Customer(String email, String pass, String nickName) {
		super();
		this.email = email;
		this.pass = pass;
		this.nickName = nickName;
	}
	
	public Customer(String email, String pass, String nickName, String authority) {
		super();
		this.email = email;
		this.pass = pass;
		this.nickName = nickName;
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
