public class TimeTable{
	private String title;
	private String duration;
	private int price;
	private String start_time;
	private String end_time;
	private String mode;
	private boolean status;

	
	
	public TimeTable(String title, String duration, int price, String start_time, String end_time, String mode) {
		this.title = title;
		this.duration = duration;
		this.price = price;
		this.start_time = start_time;
		this.end_time = end_time;
		this.mode = mode;
		this.status = true;
	}



	
	public String getTitle() {
		return title;
	}




	public String getDuration() {
		return duration;
	}




	public int getPrice() {
		return price;
	}




	public String getStart_time() {
		return start_time;
	}




	public String getEnd_time() {
		return end_time;
	}




	public String getMode() {
		return mode;
	}
	
	public boolean getStatus() {
		return status;
	}




	public String showAvailability(boolean status) {
		String avail;

		if (status == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public void setDuration(String duration) {
		this.duration = duration;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}




	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}




	public void setMode(String mode) {
		this.mode = mode;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	public String toString(){
		String output = "";
		// Write your codes here
		return output;
	}
}


