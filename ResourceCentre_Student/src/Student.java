
public class Student {
	private String name;
	private String gender;
	private int mobile;
	private String email;
	private String dob;
	private String residence;
	private String interest;
	public Student(String name, String gender, int mobile, String email, String dob, String residence,
			String interest) {
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.residence = residence;
		this.interest = interest;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getDob() {
		return dob;
	}
	public String getResidence() {
		return residence;
	}
	public String getInterest() {
		return interest;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	

}
