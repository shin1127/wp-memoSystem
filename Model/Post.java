package Model;

public class Post {
//	private String author;
	private String title;
	private String content;
	private String excerpt;
	private String to_ping;
	private String pinged;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExcerpt() {
		return excerpt;
	}
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	public String getTo_ping() {
		return to_ping;
	}
	public void setTo_ping(String to_ping) {
		this.to_ping = to_ping;
	}
	public String getPinged() {
		return pinged;
	}
	public void setPinged(String pinged) {
		this.pinged = pinged;
	}
	
	
}
