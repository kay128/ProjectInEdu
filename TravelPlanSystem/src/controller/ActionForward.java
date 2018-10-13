package controller;

public class ActionForward {
	private String resUrl = null;
	private boolean isRedirect = false;
	
	public ActionForward() {
		
	}
	
	public ActionForward(String resUrl, boolean isRedirect) {
		this.resUrl = resUrl;
		this.isRedirect = isRedirect;
	}
	
	public String getResUrl() {
		return resUrl;
	}
	
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	

}
