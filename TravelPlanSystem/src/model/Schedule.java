package model;

public class Schedule {
	private int placeId;
	private int logitude;
	private int latitude;
	private String placeName;
	private String placeAddres;
	
	public Schedule() {
		
	}
	
	public Schedule(int placeId, int logitude, int latitude, String placeName, String placeAddres) {
		super();
		this.placeId = placeId;
		this.logitude = logitude;
		this.latitude = latitude;
		this.placeName = placeName;
		this.placeAddres = placeAddres;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public int getLogitude() {
		return logitude;
	}

	public void setLogitude(int logitude) {
		this.logitude = logitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceAddres() {
		return placeAddres;
	}

	public void setPlaceAddres(String placeAddres) {
		this.placeAddres = placeAddres;
	}

}
