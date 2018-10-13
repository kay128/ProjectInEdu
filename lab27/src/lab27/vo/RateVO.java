package lab27.vo;

public class RateVO {
	private int reply_id;
	private String user_id;
	
	public RateVO() {}
	
	public RateVO(int reply_id, String user_id) {
		super();
		this.reply_id = reply_id;
		this.user_id = user_id;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "RateVO [reply_id=" + reply_id + ", user_id=" + user_id + "]";
	}	
}
