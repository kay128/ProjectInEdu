package model;

public class Hotel {	
	private int hotelId;			//sequence 값
	private String hotelName;		//중복불가
	private String hotelCity;		//호텔 지역
	private String hotelAddress;	//호텔 주소
	private int hotelPrice;
	private int quality;			//몇성급?
	private float avgReviewGrade;		//후기 평균 _ only update
	private String nickName;		//후기 작성자 별명
	private int reviewGrade;		//후기 작성자 평점
	private String reviewContent;	//후기 작성 내용
	
	public Hotel() {
		
	}
	
	public Hotel(int hotelId, String hotelName, String hotelCity, int hotelPrice, int quality,
			float avgReviewGrade) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
		this.hotelPrice = hotelPrice;
		this.quality = quality;
		this.avgReviewGrade = avgReviewGrade;
	}

	public Hotel(String hotelName, String hotelCity, String hotelAddress, int hotelPrice, int quality) {
		super();
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
		this.hotelAddress = hotelAddress;
		this.hotelPrice = hotelPrice;
		this.quality = quality;
	}
	
	public Hotel(String hotelName, String hotelCity, String hotelAddress, int hotelPrice, int quality,
			float avgReviewGrade, String nickName, int reviewGrade, String reviewContent) {
		super();
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
		this.hotelAddress = hotelAddress;
		this.hotelPrice = hotelPrice;
		this.quality = quality;
		this.avgReviewGrade = avgReviewGrade;
		this.nickName = nickName;
		this.reviewGrade = reviewGrade;
		this.reviewContent = reviewContent;
	}
	
	public Hotel(int hotelId, String hotelName, String hotelCity, String hotelAddress, int hotelPrice, int quality,
			float avgReviewGrade, String nickName, int reviewGrade, String reviewContent) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
		this.hotelAddress = hotelAddress;
		this.hotelPrice = hotelPrice;
		this.quality = quality;
		this.avgReviewGrade = avgReviewGrade;
		this.nickName = nickName;
		this.reviewGrade = reviewGrade;
		this.reviewContent = reviewContent;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public float getAvgReviewGrade() {
		return avgReviewGrade;
	}

	public void setAvgReviewGrade(float avgReviewGrade) {
		this.avgReviewGrade = avgReviewGrade;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

   public void setPictureUrl(String pictureUrl) {
   
      
   }
}
