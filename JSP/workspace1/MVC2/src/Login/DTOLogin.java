package Login;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DTOLogin {
	private String user_id;
	private String user_pw;
	private String nickname;
	private Date current;
	private int delable;
	
	public int getDelable() {
		return delable;
	}

	public void setDelable(int delable) {
		this.delable = delable;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCurrent() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(current);
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	
	
}
