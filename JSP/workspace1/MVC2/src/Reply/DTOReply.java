package Reply;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DTOReply {
	private int num;
	private String img;
	private String content;
	private Date date;
	private String user_id;
	private String user_pw;
	private String nickname;
	private int kind;
	private int view_count;
	
	
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(date);
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
