package model;

public class Board {
	private int boardId;
	private String userEmail;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private int boardHit;
	private int boardGroup;
	private int boardSequence;
	private int boardLevel;
	private int boardAvailable;


public Board() {
	
}

public Board(int boardId, String userEmail, String boardTitle, String boardContent, String boardDate) {
	this.boardId = boardId;
	this.userEmail = userEmail;
	this.boardTitle = boardTitle;
	this.boardContent = boardContent;
	this.boardDate = boardDate;
}

public Board(int boardId, String userEmail, String boardTitle, String boardContent, String boardDate, int boardHit) {
	this.boardId = boardId;
	this.userEmail = userEmail;
	this.boardTitle = boardTitle;
	this.boardContent = boardContent;
	this.boardDate = boardDate;
	this.boardHit = boardHit;
}


public Board(String userEmail, String boardTitle, String boardContent, String boardDate, int boardHit) {
	this.userEmail = userEmail;
	this.boardTitle = boardTitle;
	this.boardContent = boardContent;
	this.boardDate = boardDate;
	this.boardHit = boardHit;
}

public Board(String userEmail, String boardTitle, String boardContent, String boardDate, int boardHit, int boardGroup) {
	this.userEmail = userEmail;
	this.boardTitle = boardTitle;
	this.boardContent = boardContent;
	this.boardDate = boardDate;
	this.boardHit = boardHit;
	this.boardGroup = boardGroup;
	
}



public Board(int boardId, String userEmail, String boardTitle, String boardContent, String boardDate, int boardHit,
		int boardGroup, int boardSequence, int boardLevel, int boardAvailable) {
	super();
	this.boardId = boardId;
	this.userEmail = userEmail;
	this.boardTitle = boardTitle;
	this.boardContent = boardContent;
	this.boardDate = boardDate;
	this.boardHit = boardHit;
	this.boardGroup = boardGroup;
	this.boardSequence = boardSequence;
	this.boardLevel = boardLevel;
	this.boardAvailable = boardAvailable;
}

public int getboardId() {
	return boardId;
}

public void setPlaceId(int boardId) {
	this.boardId = boardId;
}

public String getuserEmail() {
	return userEmail;
}

public void setLogitude(String userEmail) {
	this.userEmail = userEmail;
}

public String getboardTitle() {
	return boardTitle;
}

public void setLatitude(String boardTitle) {
	this.boardTitle = boardTitle;
}

public String getboardContent() {
	return boardContent;
}

public void setPlaceName(String boardContent) {
	this.boardContent = boardContent;
}

public String getboardDate() {
	return boardDate;
}

public void setboardDate(String boardDate) {
	this.boardDate = boardDate;
}

public int getboardHit() {
	return boardHit;
}

public void setboardHit(int boardHit) {
	this.boardHit = boardHit;
}

public int getBoardGroup() {
	return boardGroup;
}

public void setBoardGroup(int boardGroup) {
	this.boardGroup = boardGroup;
}

public int getBoardSequence() {
	return boardSequence;
}

public void setBoardSequence(int boardSequence) {
	this.boardSequence = boardSequence;
}

public int getBoardLevel() {
	return boardLevel;
}

public void setBoardLevel(int boardLevel) {
	this.boardLevel = boardLevel;
}

public int getBoardAvailable() {
	return boardAvailable;
}

public void setBoardAvailable(int boardAvailable) {
	this.boardAvailable = boardAvailable;
}





}

