package demo7.vo;

public class User {

	private String id;
	private String name;
	private String email;
	private String tel;
	private int point;
	
	public User() {}
	
	public User(String id, String name, String email, String tel, int point) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.point = point;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}