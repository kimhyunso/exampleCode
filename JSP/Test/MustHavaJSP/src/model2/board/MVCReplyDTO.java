package model2.board;

import java.util.Date;

public class MVCReplyDTO {
	private String ridx;
	private String id;
	private String content;
	private String nick;
	private Date rdate;
	private int rgroup;
	private int cl;
	
	public String getRidx() {
		return ridx;
	}
	public void setRidx(String ridx) {
		this.ridx = ridx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public int getRgroup() {
		return rgroup;
	}
	public void setRgroup(int rgroup) {
		this.rgroup = rgroup;
	}
	public int getCl() {
		return cl;
	}
	public void setCl(int cl) {
		this.cl = cl;
	}
}
