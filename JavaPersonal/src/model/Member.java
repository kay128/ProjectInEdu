package model;

public class Member {
	private String id = "";
	private String pw = "";
	private String name = "";
	private String kind = "";
	private String configWord = "";
	
	public Member() {
		
	};
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;	
	};
	public Member(String name, String kind, String configWord) {
		this.name = name;
		this.kind = kind;
		this.configWord = configWord;	
	};
	public Member(String id, String pw, String name, String kind) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.kind = kind;
	};
	public Member(String id, String pw, String name, String kind, String configWord) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.kind = kind;
		this.configWord = configWord;
	};
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public String getName() {
		return this.name;
	}
	public String getKind(){
		return this.kind;
	}
	public String getConfigWord(){
		return this.configWord;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
