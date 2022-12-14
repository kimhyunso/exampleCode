package application;

public class Person {
	private int no;
	private String id;
	private String name;
	private int age;
	private String time;
	
	public Person(int no,String id,String name,int age,String time) {
		this.no = no;
		this.id = id;
		this.name = name;
		this.age = age;
		this.time = time;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
