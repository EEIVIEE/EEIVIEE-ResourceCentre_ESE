
public class Registration {

	private int num;
	private int regid;
	private int tuitionid;
	private String email;
	private String status;
	private String datetime;

	public Registration(int num, int regid, int tuitionid, String email, String status, String datetime) {
		super();
		this.num = num;
		this.regid = regid;
		this.tuitionid = tuitionid;
		this.email = email;
		this.status = status;
		this.datetime = datetime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getRegid() {
		return regid;
	}

	public void setRegid(int regid) {
		this.regid = regid;
	}

	public int getTuitionid() {
		return tuitionid;
	}

	public void setTuitionid(int tuitionid) {
		this.tuitionid = tuitionid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
