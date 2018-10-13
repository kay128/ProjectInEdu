package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Query {
	
	Member member = null;
	String id = null;
	String day = null;
	String keyWord = null;
	String query = null;
	String structure = null;
	String explain = null;
	
	public Query() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Query(Member member, String keyWord, String query, String structure, String explain) {
		Date date = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E HH:mm:ss"); 
		this.day = sdf.format(date);
		this.keyWord = keyWord;
		this.member = member;
		this.query = query;
		this.structure = structure;
		this.explain = explain;
	}
	
	public Query(Member member, String day, String keyWord, String query, String structure, String explain) {
		this.day = day;
		this.keyWord = keyWord;
		this.id = member.getId();
		this.query = query;
		this.structure = structure;
		this.explain = explain;
	}
	
	public Query(String id, String day, String keyWord, String query, String structure, String explain) {
		this.day = day;
		this.keyWord = keyWord;
		this.id = id;
		this.query = query;
		this.structure = structure;
		this.explain = explain;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getDay() {
		return day;
	}
	

	public void setDay(String day) {
		this.day = day;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
}
