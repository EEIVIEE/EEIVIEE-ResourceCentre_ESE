
public class TimeTable{
	private String tuition;
	private String duration;
	private int price;
	private int start_time;
	private int end_time;
	private String mode;

	public TimeTable(String tuition, String duration, int price, int start_time, int end_time, String mode) {
		this.tuition = tuition;
		this.duration = duration;
		this.price = price;
		this.start_time = start_time;
		this.end_time = end_time;
		this.mode = mode;
	}

	
	
	public String getTuition() {
		return tuition;
	}



	public String getDuration() {
		return duration;
	}



	public int getPrice() {
		return price;
	}



	public int getStart_time() {
		return start_time;
	}



	public int getEnd_time() {
		return end_time;
	}



	public String getMode() {
		return mode;
	}



	public void setTuition(String tuition) {
		this.tuition = tuition;
	}



	public void setDuration(String duration) {
		this.duration = duration;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}



	public void setEnd_time(int end_time) {
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


