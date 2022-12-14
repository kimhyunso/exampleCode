package application;

public class UserData {
	private int no;
	private int id;
	private int seq;
	private float temp;
	private float hum;
	private String time;
	
	public UserData(int no, int id, int seq, float temp, float hum, String time) {
		this.no = no;
		this.id = id;
		this.seq = seq;
		this.temp = temp;
		this.hum = hum;
		this.time = time;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getHum() {
		return hum;
	}

	public void setHum(float hum) {
		this.hum = hum;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
