package model2.board;

import java.sql.Date;

public class MVCMemberDTO {
	private String midx;
	private String id;
	private String pass;
	private String nick;
	private Date rdate;
	
	public String getMidx() {
		return midx;
	}
	public void setMidx(String midx) {
		this.midx = midx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	
}
