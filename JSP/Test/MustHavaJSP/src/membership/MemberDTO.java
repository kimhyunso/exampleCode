package membership;

public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String regidate;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
	public String getRegidate() {
		return regidate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}
	
}

