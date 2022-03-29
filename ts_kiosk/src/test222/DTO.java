package test222;

//데이터 전송
public class DTO {

	private String id;
	private String password;
	private String name;
	private String gender;
	private String birth;
	private String tel;
	private String email;
	
	private String aid_num;
	private String aid;
	private String apassword;
	private String aname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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
	
	//////////////////관리자
	public String getAidnum() {
		return aid_num;
	}

	public void setAidnum(String aid_num) {
		this.aid_num = aid_num;
	}
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Override
	public String toString() {
		// return "ManagementDTO [id=" + id + ", password=" + password + ", name=" +
		// name + ", gender="
		// + gender + ",birth ="+ birth + ", email="+ email +" tel=" + tel + "]";

		// "/"를 기준으로 나누기 위해서
		return "/" + id + "/" + name + "/" + email + "/" + tel + "/";

	}

}
