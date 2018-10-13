package model;

public class Result {
	private int resultId;
	private String email;
	private String nickName;
	private String writeDate;
	private String scheduleTitle;
	private int scheduleLastDay;
	private String placeName;
	private int visitDate;
	private String hotelName;
	private String checkIn;
	private String checkOut;
	private int reviewGrade;		//평점(해당 호텔을 저장한 사용자 만 작성 가능)
	private String reviewContent;	//후기_댓글(해당 호텔을 저장한 사용자 만_1회에 한해서 작성 가능)
	
	public Result() {
		
	}
	
	public Result(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}
	
	//select visitDate, placeName, scheduleTitle
	public Result(int visitDate, String placeName, String scheduleTitle, int scheduleLastDay) {
		this.visitDate = visitDate;
		this.placeName = placeName;
		this.scheduleTitle = scheduleTitle;
		this.scheduleLastDay = scheduleLastDay;
		
	}
	
	public Result(int resultId, String hotelName, String checkIn, String checkOut) {
		this.resultId = resultId;
		this.hotelName = hotelName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	//schedule 생성자
	public Result(int resultId, String email, String nickName, String writeDate, String scheduleTitle, String placeName,
			int visitDate) {
		this.resultId = resultId;
		this.email = email;
		this.nickName = nickName;
		this.writeDate = writeDate;
		this.scheduleTitle = scheduleTitle;
		this.placeName = placeName;
		this.visitDate = visitDate;
	}
	
	//hotel 생성자 _ 원래는 reviewGrade 가 없는 생성자여야해요.
	//스케줄 생성자와 매개변수 수가 겹쳐 사용이 불가능하여 삽입한것 입니다.
	//생성시 마지막 변수  reviewGrade에 0을 넣어주세요!
	public Result(int resultId, String email, String nickName, String writeDate, String hotelName, String checkIn, String checkOut, int reviewGrade
			) {
		this.resultId = resultId;
		this.email = email;
		this.nickName = nickName;
		this.writeDate = writeDate;
		this.hotelName = hotelName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reviewGrade = reviewGrade;
	}
	
	
	//후기 업데이트 용 생성자 입니다.
	public Result(int resultId, String hotelName, int reviewGrade,
			String reviewContent) {
		this.resultId = resultId;
		this.hotelName = hotelName;
		this.reviewGrade = reviewGrade;
		this.reviewContent = reviewContent;
	}
	
	//전체 변수 포함 생성자 입니다.
	public Result(int resultId, String email, String nickName, String writeDate, String scheduleTitle, String placeName,
			int visitDate, String hotelName, String checkIn, String checkOut, int reviewGrade,
			String reviewContent) {
		super();
		this.resultId = resultId;
		this.email = email;
		this.nickName = nickName;
		this.writeDate = writeDate;
		this.scheduleTitle = scheduleTitle;
		this.placeName = placeName;
		this.visitDate = visitDate;
		this.hotelName = hotelName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reviewGrade = reviewGrade;
		this.reviewContent = reviewContent;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}
	
	public int getScheduleLastDay() {
		return scheduleLastDay;
	}
	
	public void setScheduleLastDay(int scheduleLastDay) {
		this.scheduleLastDay = scheduleLastDay;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public int getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(int visitDate) {
		this.visitDate = visitDate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getReviewGrade() {
		return reviewGrade;
	}

	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

}
