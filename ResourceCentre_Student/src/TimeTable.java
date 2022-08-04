public class TimeTable{
	private String title;
	private String duration;
	private int price;
	private String start_time;
	private String end_time;
	private String mode;

	public TimeTable(String title, String duration, int price, String start_time, String end_time, String mode) {
		this.title = title;
		this.duration = duration;
		this.price = price;
		this.start_time = start_time;
		this.end_time = end_time;
		this.mode = mode;
	}

	
	
	public String getTuition() {
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



	public void setTuition(String title) {
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



	public String toString(){
		String output = "";
		// Write your codes here
		return output;
	}
}


